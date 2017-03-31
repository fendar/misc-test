package net.fendar.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongchao on 16/7/7.
 */
public class HeapOutOfMemory {
    /**
     * VM ARGS:-Xms20m -Xmx20m
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {

    }
}
