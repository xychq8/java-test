package com.github.xychq8.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangxu on 16/5/29.
 */
public class Myservice {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            System.out.println("begin waitA 时间为:" + System.currentTimeMillis() + ",ThreadName=" + Thread.currentThread().getName());
//            condition.await();
            Thread.sleep(5000);
            System.out.println("end waitA 时间为:" + System.currentTimeMillis() + ",ThreadName=" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("begin waitB 时间为:" + System.currentTimeMillis() + ",ThreadName=" + Thread.currentThread().getName());
//            condition.await();
            Thread.sleep(5000);
            System.out.println("end waitB 时间为:" + System.currentTimeMillis() + ",ThreadName=" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll(){
        try {
            lock.lock();
            System.out.println("signalAll 时间为:" + System.currentTimeMillis() + ",ThreadName=" + Thread.currentThread().getName());
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
