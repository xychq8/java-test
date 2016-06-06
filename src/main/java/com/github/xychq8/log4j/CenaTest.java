package com.github.xychq8.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by zhangxu on 16/5/27.
 */
public class CenaTest {
    private static final Log logger = LogFactory.getLog("cenaLog");

    public static void main(String[] args) throws Exception{
        logger.info("I am ready.") ;
    }

}
