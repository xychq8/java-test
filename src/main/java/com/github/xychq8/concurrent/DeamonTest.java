package com.github.xychq8.concurrent;

/**
 * Created by zhangxu on 16/4/27.
 */
public class DeamonTest {

    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        System.out.println("123");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        System.out.println("456");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.setDaemon(true);
        t2.start();

        System.out.println(Thread.currentThread().isDaemon());
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        Thread.sleep(10000);
        System.out.println("main thread finished");
    }
}
