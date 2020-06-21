package com.henryxi.guava.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomClient {
    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 2, 0.1);
        filter.put(1);
        filter.put(3);
        filter.put(4);
        boolean exist = filter.mightContain(3);
        System.out.println("3 might contain:" + exist);
        exist = filter.mightContain(5);
        System.out.println("5 might contain:" + exist);
    }
}
