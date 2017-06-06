import org.junit.Test;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by zhongchao on 17/3/7.
 */
public class MainTest {

    interface A {
        int a();
    }

    interface B {
        int a();
    }

    class C implements A,B {
        public int a() {
            return 1;
        }
    }

    class Apple {
        private int weight;
        public int getWeight() {
            return weight;
        }
    }

    class ObjSizeB {
        private int i;
        private Locale l = Locale.US;
        private char c;
    }

    interface T {
        void t() throws IOException;
    }

    @Test
    public void mainTest() {

        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        Comparator<Apple> comparator1 = (o1, o2) -> o1.getWeight() - o2.getWeight();
        Comparator<Apple> comparator2 = Comparator.comparing(Apple::getWeight);

        Integer a = 1;
        Comparator<Integer> c = Integer::compare;
        Comparator<Integer> t = (c1, c2) -> c1 - c2;
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 24, -123, 4);
        System.out.println(list);

    }

    /**
     * 生产勾股定理
     */
    @Test
    public void test3() {
        IntStream.range(1, 100)
                .boxed()
                .flatMap(x ->
                                IntStream.range(x, 100)
                                        .mapToObj(y -> new double[]{x, y, Math.sqrt(x * x + y * y)})
                                        .filter(arr -> arr[2] % 1 == 0)
                ).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(1, 4, 5, 9);

        System.out.println(list.stream().reduce(0, (a, b) -> a + b));
    }

    @Test
    public void testGroup() {
        List<String> list = Arrays.asList("12,", "sfdss", "212", "dsfsdfa", "sa213d", "sfdss");

        System.out.println(list.stream().collect(Collectors.groupingBy(String::length)));
    }

    @Test
    public void testObjSize() throws IOException {
        Apple apple = new Apple();

        System.out.println(apple.getWeight());

        ObjSizeB b = new ObjSizeB();

        System.in.read();
        System.out.println(b);

    }

    String t = "testaaaaaa";

    /**
     * string intern的产生方法 new String("xxx").intern();
     * @throws IOException
     */
    @Test
    public void testStringIntern() throws IOException {
        List<String> list = new ArrayList<>(10000);

        for (int i = 0; i < 9999999; i++) {
            list.add(new String(t).intern());
        }
        System.out.println(list.get(59));

        System.in.read();
    }

    @Test
    public void testTimeDiff() {
        LocalDateTime sdateTime = LocalDateTime.parse("20170330131450", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime eDateTime = LocalDateTime.parse("20170418113556", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        Duration d  = Duration.between(sdateTime, eDateTime);
        System.out.println(d.toNanos()/(double)1_000_000_000);
    }

}
