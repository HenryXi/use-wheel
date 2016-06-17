package com.henryxi.joda.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class JodaTimeExamples {
    public static void main(String[] args) {
        DateTime thisMonth1 = new DateTime().withDayOfMonth(1);
        DateTime thisMonth11 = new DateTime().withDayOfMonth(11);
        DateTime thisMonth21 = new DateTime().withDayOfMonth(21);
        System.out.println(thisMonth1);
        DateTime now = DateTime.now();
        LocalDateTime localDateTime = new LocalDateTime(now);
        thisMonth1.isBefore(now);
    }
}
