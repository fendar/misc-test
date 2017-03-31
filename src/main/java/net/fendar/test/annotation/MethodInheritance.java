package net.fendar.test.annotation;

import org.junit.Test;

/**
 * Created by zhongchao on 16/9/27.
 */
public class MethodInheritance {
    class Super {
        @Exam
        public void normal() {

        }
        @InheritExam
        public void inherit() {

        }
    }

    class Sub extends Super {

    }

    class SubOveride extends Super {
        @Override
        public void normal() {
            super.normal();
        }

        @Override
        public void inherit() {
            super.inherit();
        }
    }

    /**
     * 方法重写了之后不再有相关的annotation
     * 但是没有重写父类的方法，是有相关的annotation的
     * @throws NoSuchMethodException
     */
    @Test
    public void test() throws NoSuchMethodException {
        Class<Sub> subClass = Sub.class;
        Class<SubOveride> subOverideClass = SubOveride.class;

        System.out.printf("%s normal has annotation %s\t, has inherit %s\n", subClass,
                subClass.getMethod("normal").getAnnotation(Exam.class), subClass.getMethod("inherit").getAnnotation(InheritExam.class));

        System.out.printf("%s normal has annotation %s\t, has inherit %s\n", subOverideClass,
                subOverideClass.getMethod("normal").getAnnotation(Exam.class), subOverideClass.getMethod("inherit").getAnnotation(InheritExam.class));
    }


}
