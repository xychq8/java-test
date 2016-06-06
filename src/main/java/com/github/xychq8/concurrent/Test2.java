package com.github.xychq8.concurrent;

/**
 * Created by zhangxu on 16/5/29.
 */
public class Test2 {

    public static void main(String[] args) throws Exception{
        Myservice service = new Myservice();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);
        service.signalAll();
    }
}
