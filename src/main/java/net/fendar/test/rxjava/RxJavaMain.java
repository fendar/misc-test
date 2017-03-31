package net.fendar.test.rxjava;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by zhongchao on 16/6/12.
 */
public class RxJavaMain {
    public static void main(String[] args) {
        RxJavaMain main = new RxJavaMain();

        main.firstTest();
    }


    public void firstTest() {
        Observable<String> observable = Observable.just("first", "rxjava", "example");

        observable.subscribe(new Action1<String>() {
            public void call(String s) {
                System.out.print(s + "\t");
            }
        });

    }

}
