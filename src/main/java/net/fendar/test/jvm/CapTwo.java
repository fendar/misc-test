package net.fendar.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongchao on 16/3/6.
 */
public class CapTwo {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
     }

    static class OOMObject {}
}
