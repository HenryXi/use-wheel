package com.henryxi.dozer;

import org.dozer.DozerBeanMapper;

public class DozerTest {
    public static void main(String[] args) {
        DozerBeanMapper dozer = new DozerBeanMapper();
        User user = new User();
        user.setName("Henry");
        user.setAge(28);
        System.out.println(user.toString());
        UserWrapper userWrapper = dozer.map(user, UserWrapper.class);
        System.out.println(userWrapper.toString());
    }
}
