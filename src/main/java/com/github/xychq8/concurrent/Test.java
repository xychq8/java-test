package com.github.xychq8.concurrent;

/**
 * Created by zhangxu on 16/5/18.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new DeamonTest2());
        thread.setDaemon(true);
        thread.start();
    }

}
