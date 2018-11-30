package com.henryxi.jmh.mod;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class JMHModClient {
    private int[] numbers;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHModClient.class.getSimpleName())
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void mod() {
        int i = 0;
        for (int num : numbers) {
            if (num % 10 == 1) {
                i++;
            }
        }
        System.out.println(i);
    }

    @Benchmark
    public void random() {
        int i = 0;
        for (int num : numbers) {
            if (ThreadLocalRandom.current().nextInt(10) == 1) {
                i++;
            }
        }
        System.out.println(i);
    }

    @Setup
    public void setUp() {
        numbers = IntStream.rangeClosed(1, 1000).toArray();
    }
}
