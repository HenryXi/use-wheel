package com.henryxi.apache.common.lang3.randomutils;

import org.apache.commons.lang3.RandomUtils;

public class RandomUtilsClient {
    public static void main(String[] args) {
        int sixLengthRandomNumber = RandomUtils.nextInt(100000, 1000000);
        System.out.println("random 6 digit number:" + sixLengthRandomNumber);
    }
}
