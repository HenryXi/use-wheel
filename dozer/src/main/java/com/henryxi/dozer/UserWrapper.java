package com.henryxi.dozer;

public class UserWrapper {
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
        return "UserWrapper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
