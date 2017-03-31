package net.fendar.test.regex;

import net.fendar.test.util.Prints;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by zhongchao on 16/4/14.
 */
public class RegexTest {
    public static void main(String[] args) throws IOException {
        Pattern datePattern = Pattern.compile("[1-9]\\d{3}\\-((0[1-9])|(1[1-2]))\\-((0[1-9])|([1-2][0-9])|(3[0-1]))");

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            Prints.print(datePattern.matcher(str).matches());
        }
    }
}
