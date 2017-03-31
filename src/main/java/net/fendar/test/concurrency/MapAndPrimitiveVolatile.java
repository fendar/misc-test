package net.fendar.test.concurrency;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongchao on 16/8/19.
 */
public class MapAndPrimitiveVolatile {
    private volatile boolean visiBool = true;

    private boolean noVisiBool = true;

    private volatile HashMap<String, Object> visiMap = new HashMap<String, Object>();

    private  Map<String, Object> noVisiMap = new HashMap<String, Object>();

    /**
     * 这是可见的 安全的，程序大约1s后会退出
     * @throws InterruptedException
     */
    @Test
    public void testVisiPrimitive() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (visiBool) {

                }
                System.out.println("visi primitive out...");
            }
        });

        thread.start();
        Thread.sleep(1000);
        visiBool = false;
    }

    /**
     * 线程不安全，变量不可以见
     * @throws InterruptedException
     */
    @Test
    public void testNoVisiPrimitive() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (noVisiBool) {

                }
                System.out.println("no visi primitive out...");
            }
        });

        thread.start();
        Thread.sleep(1000);
        noVisiBool = false;
    }

    /**
     * 对于map是volatile的，我们不同步的进行put，看是否可见
     * 结论是可见的！！！！！
     * @throws InterruptedException
     */
    @Test
    public void testVisiMapPut() throws InterruptedException {
        final String key = "123";
        visiMap.put("2312", 1231);
        visiMap.put("12321", 123123);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!visiMap.containsKey(key)) {

                }
                System.out.println("visi map out...");
            }
        });
        visiMap.remove(key);

        thread.start();
        Thread.sleep(1000);
//        visiMap.put(key, 1);
    }

    /**
     * 对于map不是volatile的，我们不同步的进行put，看是否可见
     * 结论是可见的！！！！！
     * @throws InterruptedException
     */
    @Test
    public void testNoVisiMapPut() throws InterruptedException {
        final String key = "123";
        final Integer one = 1;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (one.equals(noVisiMap.get(key))) {

                }
                System.out.println("no visi map out...");
            }
        });

        thread.start();
        Thread.sleep(1000);
        noVisiMap.put(key, 1);
    }

    /**
     * no volatile的map，即使是替换map也是可见的
     * @throws InterruptedException
     */
    @Test
    public void testNoVisiMapReplace() throws InterruptedException {
        final String key = "123";

        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!noVisiMap.containsKey(key)) {

                }
                System.out.println("No visi map replace out...");
            }
        });

        thread.start();
        Thread.sleep(1000);

        Map<String, Object> newMap = new HashMap<String, Object>();
        newMap.put(key, 1);
        noVisiMap = newMap;
    }



    public static void main(String[] args) throws InterruptedException {
        MapAndPrimitiveVolatile mapAndPrimitiveVolatile = new MapAndPrimitiveVolatile();

//        mapAndPrimitiveVolatile.testVisiMap();
    }
}
