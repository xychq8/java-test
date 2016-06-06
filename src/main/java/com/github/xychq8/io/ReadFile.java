package com.github.xychq8.io;

import java.io.*;

/**
 * Created by zhangxu on 16/5/10.
 */
public class ReadFile {

    public static void readFileByBytes(String fileName) {
        InputStream in = null;

        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        readFileByBytes("/Users/zhangxu/testfilelog.log");
    }

}
