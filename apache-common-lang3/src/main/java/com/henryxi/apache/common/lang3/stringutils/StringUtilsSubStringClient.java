package com.henryxi.apache.common.lang3.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsSubStringClient {
    public static void main(String[] args) {
        String str="https://img1.doubanio.com/mpic/s4237197.jpg";
        String imageId = StringUtils.substringBetween(str, "/s", ".jpg");
        System.out.println(imageId);
    }
}
