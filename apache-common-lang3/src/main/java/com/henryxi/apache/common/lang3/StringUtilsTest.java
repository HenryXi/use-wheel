package com.henryxi.apache.common.lang3;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        String target = "this is a target string";
        System.out.println(StringUtils.removeEnd(target,"g"));
        System.out.println(StringUtils.removeEndIgnoreCase(target,"String"));
    }
}
