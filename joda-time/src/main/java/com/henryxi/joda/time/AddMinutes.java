package com.henryxi.joda.time;

import org.joda.time.DateTime;

import java.util.Date;

public class AddMinutes {
    public static void main(String[] args) {
        DateTime date = new DateTime(new Date());
        //plus time 
        System.out.println("now: " + date);
        DateTime after10Seconds = date.plusSeconds(10);
        System.out.println("after 10 seconds: " + after10Seconds);
        DateTime after10Minutes = date.plusMinutes(10);
        System.out.println("after 10 minutes: " + after10Minutes);
        DateTime after10Hours = date.plusHours(10);
        System.out.println("after 10 hours: " + after10Hours);
        DateTime after10Days = date.plusDays(10);
        System.out.println("after 10 days: " + after10Days);
        DateTime after10Months = date.plusMonths(10);
        System.out.println("after 10 months: " + after10Months);
        //minus time
        DateTime before10Seconds = date.minusSeconds(10);
        System.out.println("before 10 seconds: " + before10Seconds);
        DateTime before10Minutes = date.plusMinutes(10);
        System.out.println("before 10 minutes: " + before10Minutes);
        DateTime before10Hours = date.plusHours(10);
        System.out.println("before 10 hours: " + before10Hours);
        DateTime before10Days = date.plusDays(10);
        System.out.println("before 10 days: " + before10Days);
        DateTime before10Months = date.plusMonths(10);
        System.out.println("before 10 months: " + before10Months);
    }
}
