package net.fendar.test.effective;

/**
 * Created by zhongchao on 16/5/7.
 */
class Test {
    private int iprivate;

    class Inner {
        int i;
        Inner() {
            i = iprivate;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.genericVarArgs(1, 2 ,3);
    }

    public <T> void genericVarArgs(T... args) {
        //do nothing
    }
}
