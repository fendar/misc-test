package net.fendar.test.network.aio;

/**
 * Created by zhongchao on 16/11/5.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);

            } catch (NumberFormatException e) {
                //ignore
            }
        }
        new Thread(new AsyncTimeServerHandler(port), "AIO-timeServer-001").start();

    }
}
