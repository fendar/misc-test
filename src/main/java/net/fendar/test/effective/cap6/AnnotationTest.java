package net.fendar.test.effective.cap6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongchao on 16/5/21.
 */
public class AnnotationTest {
    public static void main(String[] args) {

    }

    public void testAdd() {
        List<String> list = new ArrayList<String>();

        list.addAll(5, null);
    }
}
