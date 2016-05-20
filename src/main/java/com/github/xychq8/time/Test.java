package com.github.xychq8.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by zhangxu on 16/5/3.
 */
public class Test {


    public static void main(String[] args){
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2016-04-21T07:01:05.667Z"));
            cal.add(Calendar.HOUR, 8);

            System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
