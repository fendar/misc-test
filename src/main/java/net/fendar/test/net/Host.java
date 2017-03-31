package net.fendar.test.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhongchao on 17/2/27.
 */
public class Host {
    @Test
    public void testHostName() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
        System.out.println(InetAddress.getLocalHost().getHostName());
    }
}
