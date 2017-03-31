package net.fendar.test.network.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by zhongchao on 16/11/5.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");
            System.out.println("Time time server receive order:" + req);
            String currentTIme = "QUERY TIME ORDER".equals(req) ? new Date().toString() : "BAD ORDER";
            doWrite(currentTIme);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void failed(Throwable exc, ByteBuffer attachment) {
       try {
           this.channel.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    private void doWrite(String currentTime) {
        if (currentTime != null && currentTime.length() > 0) {
            byte[] bytes = currentTime.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                public void completed(Integer result, ByteBuffer attachment) {
                    if (attachment.hasRemaining())
                        channel.write(attachment, attachment, this);
                }

                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        //
                    }
                }
            });
        }
    }
}
