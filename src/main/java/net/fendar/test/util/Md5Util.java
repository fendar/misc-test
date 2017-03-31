package net.fendar.test.util;

import java.security.MessageDigest;

public class Md5Util {
    public static String md5(String source) {
        return md5(source.getBytes());
    }

    public static String md5(byte[] source) {
        String s = null;
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(source);
            byte[] tmp = e.digest();
            char[] str = new char[32];
            int k = 0;

            for(int i = 0; i < 16; ++i) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            s = new String(str);
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return s;
    }

    public static long md5int(String str) {
        String tmp = md5(str);
        return Long.valueOf(tmp.substring(8, 16), 16).longValue();
    }
}