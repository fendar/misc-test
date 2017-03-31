package net.fendar.test.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;

/**
 * Created by zhongchao on 17/2/18.
 */
public class IOUtil {
    public static BufferedReader getConsoleReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static DataInputStream getConsoleDataInputStream() {
        return new DataInputStream(System.in);
    }
}
