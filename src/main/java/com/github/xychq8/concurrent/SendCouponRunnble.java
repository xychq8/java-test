package com.github.xychq8.concurrent;
import java.util.List;

/**
 * Created by gongyan on 16/5/11.
 */
public class SendCouponRunnble implements Runnable{

    private List<String> list;

    private int index = 0;

    private volatile int [] bucket = new int[10000];

    public SendCouponRunnble(List<String> list) {
        this.list = list;
    }

    // 不能设置参数!!!!!因为你设置了String index参数,所以传进来的时候创建了参数变量,即使这个方法是同步的,index确实不会重,但参数变量还是一样的
    private synchronized String getValue(){
        String s = list.get(index);
        index++;
        return s;
    }

    private synchronized void setArray(int index){
        bucket[index] = 1;
    }

    @Override
    public void run() {
        while (index < list.size()) {
            setArray(index);//有可能重复set,假如第一个线程执行完这个方法index=0,这时第二个线程进来了index还是0
            System.out.println(Thread.currentThread().getName() + "获取到了 " + index + "= " + getValue());
            if(index > list.size()){
                try {
                    Thread.sleep(2000);
                    for(int i = 0; i< bucket.length; i++){
                        if(bucket[i] != 1){
                            System.out.println(i);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
