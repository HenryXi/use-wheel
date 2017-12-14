package com.henryxi.apache.common.lang3.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StringUtilEqualTest {
    public static void main(String[] args) {
        String str1 = "q";
        String str2 = "e";
        System.out.println("illegal:" + (StringUtils.isNotEmpty(str1) && !StringUtils.equals(str1, str2)));
    }
}
