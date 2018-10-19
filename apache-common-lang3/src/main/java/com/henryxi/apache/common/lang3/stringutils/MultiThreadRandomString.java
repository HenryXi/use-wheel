package com.henryxi.apache.common.lang3.stringutils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.Set;

public class MultiThreadRandomString {
    public static void main(String[] args) {
        Set<String> randomStrs = new HashSet<>();
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread4 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread5 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread6 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread7 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread8 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread9 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });
        Thread thread10 = new Thread(() -> {
            while (true) {
                if (randomStrs.add(RandomStringUtils.randomAlphanumeric(32))) {

                } else {
                    System.out.println("duplicate!");
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}
