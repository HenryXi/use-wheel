package com.henryxi.log4j.pk2;


import org.apache.log4j.Logger;

public class LogClient2 {
    final static Logger logger = Logger.getLogger(LogClient2.class);

    public void showLog() {
        logger.info("this is log from client2");

    }
}
