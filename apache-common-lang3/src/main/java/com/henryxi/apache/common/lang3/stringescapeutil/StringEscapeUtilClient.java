package com.henryxi.apache.common.lang3.stringescapeutil;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;

public class StringEscapeUtilClient {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = StringEscapeUtils.unescapeJava("\u0048\u0065\u006C\u006C\u006F");
        System.out.println(s);
        byte[] bytes = "H".getBytes("UTF-8");
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b));
        }
    }
}

