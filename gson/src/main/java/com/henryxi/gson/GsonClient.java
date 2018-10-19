package com.henryxi.gson;

import com.google.gson.Gson;

public class GsonClient {
    public static void main(String[] args) {
        String usersJson = "[ { \"name\": \"henry\" }, { \"name\": \"justin\" } ]";
        Gson gson = new Gson();
        User[] users = gson.fromJson(usersJson, User[].class);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
