package com.github.xychq8.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangxu on 16/6/2.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(100);

        for(int i = 0; i < 100; i++){
            new TestThread(latch).start();
        }

        latch.await();
        System.out.println("都执行完毕,皆大欢喜!");
    }

    private static class TestThread extends Thread{
        private CountDownLatch latch = null;

        public TestThread(CountDownLatch latch){
            this.latch = latch;
        }

        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                synchronized (latch){
                    latch.countDown();
                    System.out.println("thread:" + Thread.currentThread().getName() + "执行完毕,latch - 1后:" + latch.getCount());
//                }
            }
        }

    }
}
