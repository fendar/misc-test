import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

    @Test
    public void mainTest() {
        Integer a = 1;
        Comparator<Integer> c = Integer::compare;
        Comparator<Integer> t = (c1, c2) -> c1 - c2;
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 24, -123, 4);
        list.sort(c);
        System.out.println(list);

    }

    @Test
    public void test2() {
        System.out.println(FileUtils.getTempDirectoryPath());
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
}
