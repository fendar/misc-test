import org.junit.Test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by zhongchao on 17/3/12.
 */
public class ParallelSum_7_1 {
    @Test
    public void test1() {
//        System.out.println("sequentialSum :" + measureSumPerf(ParallelStreams::sequentialSum, 10_000_000));
//        System.out.println("iterativeSum :" +measureSumPerf(ParallelStreams::iterativeSum, 10_000_000));
//        System.out.println("parallelSum :" +measureSumPerf(ParallelStreams::parallelSum, 10_000_000));
//        System.out.println("rangeSum :" +measureSumPerf(ParallelStreams::rangeSum, 10_000_000));
//        System.out.println("parallel rangeSum :" +measureSumPerf(ParallelStreams::parallelRangeSum, 10_000_000));
        System.out.println("iterative foreach:" + measureSumPerf(ParallelStreams::iterativeForeach, 10_000_000));
    }

    private long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; ++i) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;

            System.out.println("sum result:" + sum);

            if (duration < fastest)
                fastest = duration;
        }

        return fastest;
    }

   static class ParallelStreams {
        public static long sequentialSum(long n) {
            return Stream.iterate(1L, i -> i + 1)
                    .limit(n)
                    .reduce(0L, Long::sum);
        }

       public static long iterativeSum(long n) {
           long r = 0L;

           for (long i = 1L; i <= n; ++i) {
               r += i;
           }

           return r;
       }

       public static long parallelSum(long n) {
           return Stream.iterate(1L, i -> i + 1)
                        .limit(n)
                        .parallel()
                        .reduce(0L, Long::sum);
       }

       public static long rangeSum(long n) {
           return LongStream.rangeClosed(1L, n)
                            .reduce(0L, Long::sum);
       }

       public static long parallelRangeSum(long n) {
           return LongStream.rangeClosed(1L, n)
                            .parallel()
                            .reduce(0L, Long::sum);
       }

       public static long iterativeForeach(long n) {

           for (long i = 1; i < n; ++i) {
               System.out.println(i);
           }
           return System.currentTimeMillis()/100;
       }

       public static long parallelForeach(long n) {
           LongStream.range(1, n)
                   .parallel()
                   .forEach(System.out::println);
           return System.currentTimeMillis()/100;
       }
    }
}
