package com.henryxi.jackson.json2object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryxi.jackson.bean.User;

import java.io.IOException;

public class ConvertJson2ObjectUnknownField {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String userJsonStr = "{\"name\": \"Henry\",\"age\": 28,\"address\": \"Beijing\"}";
        User user = objectMapper.readValue(userJsonStr, User.class);// won't throw UnrecognizedPropertyException
        System.out.println(user);
//        IgnoreFieldUser ignoreFieldUser = objectMapper.readValue(userJsonStr, IgnoreFieldUser.class);
//        System.out.println(ignoreFieldUser);
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class IgnoreFieldUser {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "IgnoreFieldUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

