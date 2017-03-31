package net.fendar.test.effective;

import java.util.*;

/**
 * Created by zhongchao on 16/5/15.
 */
public class Generic {
    public static void main(String[] args) {
        Generic generic = new Generic();

        generic.rawType();
    }

    public void rawType() {
        List list = new ArrayList();

        list.add("test");

        list.add(1);


        System.out.println(list);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public void cast() {
        Object generic = new Generic();
        String test = (String) generic;


    }

    //use raw type can not ensure type safe
    void rawType2() {
        Set set = new HashSet<Integer>();
        set.add("string");
    }

    //unchecked cast warning because compile can not ensure type safe
    <T> T generic(T obj) {
        Object o = obj;
        return (T)o;
    }
}
