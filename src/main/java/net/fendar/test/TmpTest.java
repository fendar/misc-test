package net.fendar.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by zhongchao on 16/12/20.
 */
public class TmpTest {

    public static void main(String[] args) throws IOException {
        TmpTest t = new TmpTest();
        t.test();
    }
    @Test
    public void test() throws IOException {

//        System.out.println(reverse(110100));
//        System.out.println(reverse(1));
//        System.out.println(reverse(123456));
//        System.out.println(reverse(510100));
//        System.out.println(reverse(340200));

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String line ;
        while (!(line = read.readLine()).equals("end")) {
            System.out.println(reverse(Integer.parseInt(line)));
        }
    }

    public int reverse(int i) {
        int res = 0;
        int a = i / 10;
        int b = i % 10;
        while (a > 0) {
            res = res * 10 + b;
            b = a % 10;
            a = a/10;
        }
        return res*10 + b;
    }

    @Test
    public void shiftTest() {
        int b = 0x00fffff0;
        System.out.println(b);
        System.out.println(b << 8 >> 24);
    }

    @Test
    public void testReturnFinally() {
        System.out.println(tt());
    }

    public long tt() {
        try {
            return ss();
        } finally {
            System.out.println("finally");
        }
    }

    public long ss() {
        System.out.println("try");
        return System.currentTimeMillis()/1000;
    }
}
