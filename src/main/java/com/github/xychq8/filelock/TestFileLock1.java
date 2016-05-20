package com.github.xychq8.filelock;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by zhangxu on 16/5/11.
 */
public class TestFileLock1 {

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = null;
        FileChannel fileChannel = null;
        FileLock fileLock = null;

        try {
            // 首先得有一个锁文件,这里是text.lock文件
            File lockFile = new File("/Users/zhangxu/test.lock");
            if(!lockFile.exists()){
                lockFile.createNewFile();
            }

            // 取得filelock
            randomAccessFile = new RandomAccessFile(lockFile, "rw");
            fileChannel = randomAccessFile.getChannel();

            while(true) {
                fileLock = fileChannel.tryLock();
                if(fileLock != null){
                    break;
                }
                System.out.println("Test1方法获得文件锁失败,无法继续执行!");
                Thread.sleep(1000);
            }

            // 业务
            for(int i = 1; i <= 20; i++){
                Thread.sleep(1000);
                System.out.println("Test1过了" + i + "s了...");
            }
            System.out.println("Test1方法退出!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fileLock.release();
            fileChannel.close();
            randomAccessFile.close();
        }
    }

}
