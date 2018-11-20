package com.henryxi.apache.common.lang3.randomutils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomClient {
    public static void main(String[] args) {
        int sixLengthRandomNumber = RandomUtils.nextInt(100000, 1000000);
        System.out.println("random 6 digit number:" + sixLengthRandomNumber);
        String sixRandomNumber = RandomStringUtils.randomNumeric(6);
        System.out.println("random 6 digit number:" + sixRandomNumber);
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomStringUtils.randomAlphanumeric(32));
        }
    }
}
