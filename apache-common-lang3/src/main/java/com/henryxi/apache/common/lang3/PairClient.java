package com.henryxi.apache.common.lang3;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;

public class PairClient {
    public static void main(String[] args) {
        Set<String> top = new HashSet<>();
        top.add("topCategories");
        Set<String> sub = new HashSet<>();
        sub.add("subCategories");
        Pair<Set<String>, Set<String>> pair = Pair.of(top, sub);
        System.out.println(pair);
    }
}
