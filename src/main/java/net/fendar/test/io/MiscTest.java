package net.fendar.test.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * Created by zhongchao on 17/5/24.
 */
public class MiscTest {
    @Test
    public void getTmpPath() {
        System.out.println(FileUtils.getTempDirectoryPath());
    }
}
