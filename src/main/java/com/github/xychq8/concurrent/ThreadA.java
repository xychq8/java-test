package com.github.xychq8.concurrent;

/**
 * Created by zhangxu on 16/5/29.
 */
public class ThreadA extends Thread{

    private Myservice service;

    public ThreadA(Myservice service){
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitA();
    }

}
