package net.fendar.test.network.netty.action.cap1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhongchao on 17/5/25.
 */
public class Server1_1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9292);
        Socket accept = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        PrintWriter out = new PrintWriter(accept.getOutputStream(), true);

        String request, response;
        while ((request = in.readLine()) != null) {
            if ("done".equals(request))
                break;
            response = processRequest(request);
            out.append(response);
        }
    }

    public static String processRequest(String request) {
        return request;
    }
}
