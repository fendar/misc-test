package net.fendar.test.network.netty.cap10;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static io.netty.handler.codec.http.HttpResponseStatus.*;

/**
 * Created by zhongchao on 16/11/14.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
    }

    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        System.out.println("get request");
        if (!request.decoderResult().isSuccess()) {
            sendError(ctx, BAD_REQUEST);
            return ;
        }
        if (request.method() != HttpMethod.GET) {
            sendError(ctx, METHOD_NOT_ALLOWED);
            return ;
        }
        final String uri = request.uri();
        final String path = sanitizeUri(uri);

        if (path == null) {
            sendError(ctx, FORBIDDEN);
            return ;
        }

        File file = new File(path);
        if (file.isHidden() || !file.exists()) {
            sendError(ctx, NOT_FOUND);
            return ;
        }
        if (!file.isFile()) {
            sendError(ctx, FORBIDDEN);
            return ;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException fnfe) {
            sendError(ctx, NOT_FOUND);
            return ;
        }

        long fileLength = randomAccessFile.length();
        HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, OK);
        HttpHeaderUtil.setContentLength(response, fileLength);
        HttpHeaderUtil.setKeepAlive(response, true);
        ctx.write(response);
        ChannelFuture sendFileFuture
                = ctx.write(new ChunkedFile(randomAccessFile, 0, fileLength, 8192), ctx.newProgressivePromise());
        sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
            public void operationProgressed(ChannelProgressiveFuture channelProgressiveFuture, long l, long l1) throws Exception {

            }

            public void operationComplete(ChannelProgressiveFuture channelProgressiveFuture) throws Exception {

            }
        });
    }

    private void sendError(ChannelHandlerContext ctx, HttpResponseStatus rs) {
        HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, rs);
        ctx.write(response);
        ctx.flush();
    }

    private String sanitizeUri(String uri) {
        try {
            uri = URLDecoder.decode(uri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        uri = uri.replace('/', File.separatorChar);
        if (uri.contains(File.separator + '.')
                || uri.contains('.' + File.separator) || uri.startsWith(".")
                || uri.endsWith(".")) {
            return null;
        }
        return System.getProperty("user.dir") + File.separator + uri;
    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
    }
}
