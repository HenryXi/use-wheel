package com.henryxi.httpclient.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class ServerController {
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String get() {
        UserBean userBean = new UserBean();
        userBean.setAge(27);
        userBean.setName("Henry");
        return "This is Get response: " + userBean.toString();
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String post(@RequestBody UserBean userBean) {
        return "This is Post response:" + userBean.toString();
    }

    @RequestMapping(path = "/post-form", method = RequestMethod.POST)
    public String postForm(@RequestParam String name) {
        return "This is Post response:" + name;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerController.class, args);
    }
}
