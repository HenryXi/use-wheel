package com.henryxi.guava.caseformat;

import com.google.common.base.CaseFormat;

public class CaseFormatClient {
    public static void main(String[] args) {
        String lowerCamel = "lowerCamel";
        String lowerHyphen = "lower-hyphen";
        String lowerUnderscore = "lower_underscore";
        String upperCamel = "UpperCamel";
        String upperUnderscore = "UPPER_UNDERSCORE";
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, lowerCamel));
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_UNDERSCORE, lowerHyphen));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, lowerUnderscore));
        System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, upperCamel));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, upperUnderscore));
    }
}
