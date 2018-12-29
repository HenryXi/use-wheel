package com.henryxi.apache.common.lang3.stopwatch;

import org.apache.commons.lang3.time.StopWatch;

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
