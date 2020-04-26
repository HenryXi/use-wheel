package com.henryxi.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long timestamp = System.currentTimeMillis();
        Cache<String, String> localCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build();
        String firstGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("firstGet:" + firstGet + ",time cost:" + (System.currentTimeMillis() - timestamp));
        timestamp = System.currentTimeMillis();
        String secondGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("secondGet:" + secondGet + ",time cost:" + (System.currentTimeMillis() - timestamp));
        Thread.sleep(3000);
        timestamp = System.currentTimeMillis();
        String thirdGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("thirdGet:" + thirdGet + ",time cost:" + (System.currentTimeMillis() - timestamp));

    }

    private static String getDataFromDB(String key) throws InterruptedException {
        System.out.println("get data from database...");
        Thread.sleep(2000);
        if (StringUtils.equals(key, "key")) {
            return "data";
        }
        return null;
    }
}
