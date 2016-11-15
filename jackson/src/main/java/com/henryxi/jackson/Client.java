package com.henryxi.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userJsonStr = "{\"name\": \"Henry\",\"age\": 28}";
        User user = objectMapper.readValue(userJsonStr, User.class);
        System.out.println(user);

        String boxJsonStr = "{\"name\":\"String box\",\"value\":\"this is string\"}";
        Box stringBox = objectMapper.readValue(boxJsonStr, new TypeReference<Box<String>>() {
        });
        System.out.println(stringBox);

        String boxJsonInt = "{\"name\":\"String box\",\"value\":66}";

//        JavaType type = objectMapper.getTypeFactory().constructGeneralizedType(Integer.class, Box.class);
//        Box intBox = objectMapper.readValue(userJsonStr, User.class);
    }
}
