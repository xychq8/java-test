package com.github.xychq8;

/**
 * Created by zhangxu on 16/5/13.
 */
public class Test {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("aaaaaaaaaaaaaaaaaaaa");
            }
        }, "DistributedLockShutdownHook"));
    }


    public static void main(String[] args) throws Exception{
        Thread.sleep(100000);
    }
}
