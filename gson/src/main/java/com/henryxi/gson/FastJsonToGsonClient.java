package com.henryxi.gson;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonToGsonClient {

    public static void main(String[] args) {
        testListString();
        testStrToListString();
        testMap();
    }

    private static void testMap() {
        Map<String, String> paramMap = new HashMap<>(2);
        paramMap.put("title", "aaaa");
        System.out.println(JSON.toJSONString(paramMap));
        System.out.println(JsonUtil.toJsonString(paramMap));
    }

    private static void testStrToListString(){
        List<String> strings = Arrays.asList("1", "2", "3", "aaa", "bbb");
        String fastjsonStr = JSON.toJSONString(strings);
        List<String> gsonStringList = JsonUtil.parseObjectList(fastjsonStr, String.class);
        System.out.println(gsonStringList);
    }

    private static void testListString() {
        List<String> strings = Arrays.asList("1", "2", "3", "aaa", "bbb");
        String fastjsonStr = JSON.toJSONString(strings);
        System.out.println(fastjsonStr);
        String gsonStr = JsonUtil.toJsonString(strings);
        System.out.println(gsonStr);
    }
}
