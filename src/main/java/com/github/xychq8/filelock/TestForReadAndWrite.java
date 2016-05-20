package com.github.xychq8.filelock;

/**
 * Created by zhangxu on 16/5/11.
 */
public class TestForReadAndWrite {

    public static void main(String[] args) throws Exception{
        new Thread_writeFile().start();
        new Thread_readFile().start();

        Thread.sleep(1000000000);
    }

}
