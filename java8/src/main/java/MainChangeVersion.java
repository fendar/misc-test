import java.util.function.UnaryOperator;

/**
 * Created by zhongchao on 17/3/14.
 */
public class MainChangeVersion {
    public static void main(String[] args) {
        UnaryOperator<String> op = (s) -> "hello " + s;

        System.out.println(op.apply("java8"));
    }
}
