package net.fendar.test.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongchao on 16/4/19.
 */
public class PutAll {
    public static void main(String[] args) {
        List<PutAll> putAlls = new ArrayList<PutAll>();

        for (int i = 0; i < 3; ++i) {
            putAlls.add(new PutAll());
        }

        List<PutAll> putAlls1 = new ArrayList<PutAll>();
        putAlls1.addAll(putAlls);

        for (int i = 0; i < 3; ++i) {
            System.out.println(putAlls.get(i).equals(putAlls1.get(i)));
        }
    }

}
