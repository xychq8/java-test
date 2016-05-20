package com.github.xychq8.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongyan on 16/5/11.
 */
public class SendMain {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        for(int i = 1; i <= 10000; i++){
            list.add("" + i);
        }

        SendCouponRunnble runnble = new SendCouponRunnble(list);
        new Thread(runnble).start();
        new Thread(runnble).start();
        new Thread(runnble).start();
    }
}
