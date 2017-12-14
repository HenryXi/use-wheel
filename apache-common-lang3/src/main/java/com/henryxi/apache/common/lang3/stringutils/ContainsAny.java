package com.henryxi.apache.common.lang3.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsAny {
    public static void main(String[] args) {
        String tobeDetected = "qazxswedcvfrtgbnhyujm,ii";
        String zx = "zx";
        String tg = "tg";
        System.out.println(StringUtils.containsAny(tobeDetected, zx, "aaa"));
    }
}
