package com.github.xychq8.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangxu on 16/5/11.
 */
public class Test {

    public static void writeLog(String str){
        try {
            File file = new File("/Users/zhangxu/testfilelog.log");
            if(!file.exists()){
                file.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(file, true); //如果追加方式用true
            StringBuffer sb = new StringBuffer();
            sb.append("-----------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "------------/r/n");
            sb.append(str + "/r/n");
            out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
            out.close();
        } catch(IOException ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public static String readLog(){
        StringBuffer sb = new StringBuffer();
        String tempstr = null;

        try {
            File file = new File("/Users/zhangxu/testfilelog.log");
            if(!file.exists()){
                throw new FileNotFoundException();
            }
//            BufferedReader br=new BufferedReader(new FileReader(file));
//            while((tempstr=br.readLine())!=null){
//                sb.append(tempstr);
//            }
            //另一种读取方式
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while((tempstr = br.readLine()) != null){
                sb.append(tempstr);
            }
        } catch(IOException ex){
            System.out.println(ex.getStackTrace());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        writeLog("this is a test log");
        writeLog("中文测试看看");
        System.out.println(readLog());
    }

}
