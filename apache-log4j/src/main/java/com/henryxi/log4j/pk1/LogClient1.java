package com.henryxi.log4j.pk1;


import org.apache.log4j.Logger;

public class LogClient1 {
    final static Logger logger = Logger.getLogger(LogClient1.class);

    public void showLog() {
        logger.info("this is log from client1");
    }
}
