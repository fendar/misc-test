package net.fendar.test.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhongchao on 16/6/1.
 */
enum UserType {
    PHONE, USER_ID
}

interface Type<T>{
    UserType getUserType();
}

class UserAccountType {

    public final Type<String> PHONE = newInstance(UserType.PHONE);

    public final Type<Long> USER_ID = newInstance(UserType.USER_ID);

    private static <T> Type<T> newInstance(final UserType userType) {
        return new Type<T>() {
            @Override
            public UserType getUserType() {
                return userType;
            }
        };
    }

    public <T extends Type<U>, U> void test(T type, List<U> accounts) {
        switch (type.getUserType()) {
            case PHONE:
                break;
            case USER_ID:
                break;
        }
    }

    public void zzz() {
        test(PHONE, Arrays.asList("a", "b"));
    }
}