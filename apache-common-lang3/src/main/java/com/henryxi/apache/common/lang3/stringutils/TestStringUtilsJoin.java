package com.henryxi.apache.common.lang3.stringutils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStringUtilsJoin {
    public static void main(String[] args) {

        String joinStr1 = String.join(",", "a", "b", "c");
        System.out.println(joinStr1);
        String[] array = new String[] { "d", "e", "f" };
        String joinStr2 = String.join(",", array);
        System.out.println(joinStr2);
        List<String> list = Arrays.asList(array);
        String joinStr3 = String.join(",", list);
        System.out.println(joinStr3);



        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        System.out.println(StringUtils.join(testList, ","));
    }
}
