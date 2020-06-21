package com.henryxi.guava.iterators;

import com.google.common.collect.Iterators;

import java.util.Arrays;
import java.util.Iterator;

public class RoundRobinClient {
    public static void main(String[] args) {
        Iterator<String> cycleIterator = Iterators.cycle(Arrays.asList("A", "B", "C", "D"));
        for (int i = 0; i < 10; i++) {
            System.out.println(cycleIterator.next());
        }
    }
}
