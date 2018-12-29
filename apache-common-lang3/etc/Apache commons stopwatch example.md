# Apache commons stopwatch example
The class `StopWatch` class which in `apache-common-lang` package is a good tool for timing. It provides some useful method
to measured running time of program. Most of these methods of `StopWatch` are easy to understand. Only one method: `split()` need 
us try to understand. 

`split()` method will save current time for you. If you call `getSplitTime()` it will return the time
between start and last split. 

The sample code is as follows.

```java
public class StopWatchClient {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        timeConsumingTask();
        System.out.println("split!");
        stopWatch.split();
        System.out.println("time between start and last split:" + stopWatch.getSplitTime());

        timeConsumingTask();
        System.out.println("current time:" + stopWatch.getTime());

        timeConsumingTask();
        stopWatch.stop();
        System.out.println("after stop, time cost between start and stop:" + stopWatch.getTime());
    }

    private static void timeConsumingTask() throws InterruptedException {
        Thread.sleep(2000);
    }
}
```

EOF