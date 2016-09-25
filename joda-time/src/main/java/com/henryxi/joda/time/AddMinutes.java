package com.henryxi.joda.time;

import org.joda.time.DateTime;

import java.util.Date;

public class AddMinutes {
    public static void main(String[] args) {
        DateTime date = new DateTime(123L);
        System.out.println(date);
        DateTime target = date.plusMinutes(10);

        System.out.println(target);
    }
}
