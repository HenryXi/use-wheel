package com.henryxi.log4j;

import com.henryxi.log4j.pk1.LogClient1;
import com.henryxi.log4j.pk2.LogClient2;
import com.henryxi.log4j.pk3.LogClient3;

public class Log4jClient {
    public static void main(String[] args) {
        new Thread(Log4jClient::whileLoopClient1).start();
        new Thread(Log4jClient::whileLoopClient2).start();
        new Thread(Log4jClient::whileLoopClient3).start();
    }

    private static void whileLoopClient1(){
        LogClient1 client1 = new LogClient1();
        do{
            client1.showLog();
        }while (true);
    }

    private static void whileLoopClient2(){
        LogClient2 client = new LogClient2();
        do{
            client.showLog();
        }while (true);
    }
    private static void whileLoopClient3(){
        LogClient3 client = new LogClient3();
        do{
            client.showLog();
        }while (true);
    }
}
