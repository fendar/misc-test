package net.fendar.test.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhongchao on 16/6/1.
 */
public abstract class EnumGeneric<T> implements Face<T> {
    public static final EnumGeneric<Integer> A = new EnumGeneric<Integer>() {
        @Override
        public List<Integer> get() {
            return Arrays.asList(1, 2, 3);
        }
    };

    public static final EnumGeneric<String> B = new EnumGeneric<String>() {
        @Override
        public List<String> get() {
            return Arrays.asList("a", "b", "c");
        }
    };

    public static EnumGeneric<?>[] values() {
        return new EnumGeneric<?>[]{A, B};
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EnumGeneric<String> e = (EnumGeneric<String>)EnumGeneric.values()[0];
    }
}
