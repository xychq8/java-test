package com.github.xychq8.concurrent;

/**
 * Created by zhangxu on 16/5/29.
 */
public class ThreadB extends Thread{
    private Myservice service;

    public ThreadB(Myservice service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitB();
    }
}
