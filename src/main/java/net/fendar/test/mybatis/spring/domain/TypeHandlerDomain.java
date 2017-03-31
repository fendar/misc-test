package net.fendar.test.mybatis.spring.domain;

/**
 * Created by zhongchao on 16/8/25.
 */
public class TypeHandlerDomain {
    private byte b;

    public byte getB() {
        return b;
    }

    public TypeHandlerDomain setB(byte b) {
        this.b = b;
        return this;
    }

    @Override
    public String toString() {
        return "TypeHandlerDomain{" +
                "b=" + b +
                '}';
    }
}
