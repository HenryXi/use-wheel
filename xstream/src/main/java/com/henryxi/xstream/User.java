package com.henryxi.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

@XStreamAlias("user")
public class User {
    private String name;
    private int age;
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}
