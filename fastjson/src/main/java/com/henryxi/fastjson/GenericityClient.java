package com.henryxi.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class GenericityClient {
    private static TypeReference userListType = new TypeReference<List<User>>() {
    };

    public static void main(String[] args) {
        String json = "[{\"age\":30,\"name\":\"henry\"},{\"age\":31,\"name\":\"justin\"}]";
        List<User> list = JSON.parseObject(json, userListType.getType());
        System.out.println(list);
    }
}
