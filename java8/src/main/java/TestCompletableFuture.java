import io.netty.util.concurrent.CompleteFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by zhongchao on 17/3/18.
 */
public class TestCompletableFuture {

    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
    public static Random random = new Random(47);

    static AtomicInteger ai = new AtomicInteger(0);
    static final ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
        Thread t = new Thread(r, "find-price-pool-" + ai.incrementAndGet());
        if (!t.isDaemon()) {
            t.setDaemon(true);
        }
        return t;
    });

    public static void main(String[] args) {
        long s = System.nanoTime();
        List<String> myIphone6s = findPrices("myIphone6s");
        long e = System.nanoTime();
        System.out.println(myIphone6s);
        System.out.println("cost :" + (e - s)/1_000_000);
    }

    private static List<String> findPrices(String product) {
        List<CompletableFuture<String>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> {
                            System.out.println("shop(" + shop.getName() + ")->future thread " + Thread.currentThread().getName());
                            return shop.getPrice(product);
                        }, executor
                )).map(future -> future.thenApply(str -> {
                    System.out.println("str(" + str + ")->quote thread " + Thread.currentThread().getName());
                    return Quote.parse(str);
                }))
                        //1.
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> {
                            System.out.println("quote("+quote.getShopName()+")->price" + " thread " + Thread.currentThread().getName());
                            return Discount.applyDiscount(quote);
                        }, executor
                )))
                        //2.
//                .map(future -> future.thenApply(Discount::applyDiscount))
                .collect(Collectors.toList());

        return collect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    static class Shop {
        private String name;

        public Shop(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getPrice(String product) {
            double price = calculatePrice(product);
            Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];

            return String.format("%s:%.2f:%s", name, price, code);
        }

        private double calculatePrice(String product) {
            delay();
            return random.nextDouble() * product.charAt(0) + product.charAt(1);
        }
    }

    static class Discount {
        public enum Code {
            NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

            private final int percentage;

            Code(int percentage) {
                this.percentage = percentage;
            }
        }

        public static String applyDiscount(Quote quote) {
            return quote.getShopName() + " price is " +
                    Discount.apply(quote.getPrice(), quote.getDiscountCode());
        }

        private static double apply(double price, Discount.Code code) {
            delay();
            return price * (100 - code.percentage) / 100;
        }
    }

    static class Quote {
        private final String shopName;
        private final double price;
        private final Discount.Code discountCode;

        public Quote(String shopName, double price, Discount.Code discountCode) {
            this.shopName = shopName;
            this.price = price;
            this.discountCode = discountCode;
        }

        public static Quote parse(String s) {
            String[] split = s.split(":");
            String shopName = split[0];
            double price = Double.parseDouble(split[1]);
            Discount.Code code = Discount.Code.valueOf(split[2]);

            return new Quote(shopName, price, code);
        }

        public String getShopName() {
            return shopName;
        }

        public double getPrice() {
            return price;
        }

        public Discount.Code getDiscountCode() {
            return discountCode;
        }
    }


    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
