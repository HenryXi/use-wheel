package com.henry.hystrix;

import rx.Observable;

import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) {
        String s = new CommandHelloWorld("Bob").execute();
        Future<String> s6 = new CommandHelloWorld("Bob").queue();
        Observable<String> s66 = new CommandHelloWorld("Bob").observe();
    }
}
