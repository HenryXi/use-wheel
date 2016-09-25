# Plus, minus date in java by joda time
Plus or minus date in java is boring. `joda-time` can help you finish this task easily. If you use JDK8 you may
 not need use `joda-time`, there is a new date API in JDK8. For more detail you can click [here](http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html).
In this blog I will show you how to use `joda-time` plus or minus date.
```java
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
```
The output of the code is like following.
```
now: 2016-09-25T22:44:26.274+08:00
after 10 seconds: 2016-09-25T22:44:36.274+08:00
after 10 minutes: 2016-09-25T22:54:26.274+08:00
after 10 hours: 2016-09-26T08:44:26.274+08:00
after 10 days: 2016-10-05T22:44:26.274+08:00
after 10 months: 2017-07-25T22:44:26.274+08:00
before 10 seconds: 2016-09-25T22:44:16.274+08:00
before 10 minutes: 2016-09-25T22:54:26.274+08:00
before 10 hours: 2016-09-26T08:44:26.274+08:00
before 10 days: 2016-10-05T22:44:26.274+08:00
before 10 months: 2017-07-25T22:44:26.274+08:00
```