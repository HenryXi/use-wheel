package com.henryxi.log4j.pk3;


import org.apache.log4j.Logger;

public class LogClient3 {
    final static Logger logger = Logger.getLogger(LogClient3.class);

    public void showLog() {
        logger.info("this is log from client3");

    }
}
