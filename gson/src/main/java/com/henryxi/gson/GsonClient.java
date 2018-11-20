package com.henryxi.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonClient {
    public static void main(String[] args) {
        String usersJson = "[ { \"name\": \"henry\" }, { \"name\": \"justin\",\"age\":null } ]";
        Gson gson = new GsonBuilder().create();
        User[] usersWithAge = gson.fromJson(usersJson, User[].class);
        for (User user : usersWithAge) {
            System.out.println(user);
        }
    }
}
