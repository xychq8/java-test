package com.github.xychq8.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by zhangxu on 16/5/27.
 */
public class CenaAppender extends AppenderSkeleton {

    private String account;

    @Override
    protected void append(LoggingEvent event) {
        System.out.println("Hello, " + account + " : "+ event.getMessage());
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
