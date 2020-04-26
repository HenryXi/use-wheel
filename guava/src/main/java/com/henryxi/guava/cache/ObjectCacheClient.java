package com.henryxi.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ObjectCacheClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long timestamp = System.currentTimeMillis();
        Cache<String, User> localCache = CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.SECONDS).build();
        User firstGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("firstGet:" + firstGet + ",time cost:" + (System.currentTimeMillis() - timestamp));
        timestamp = System.currentTimeMillis();
        firstGet.setName("change new name");
        User secondGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("secondGet:" + secondGet + ",time cost:" + (System.currentTimeMillis() - timestamp));
        Thread.sleep(3000);
        timestamp = System.currentTimeMillis();
        User thirdGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("thirdGet:" + thirdGet + ",time cost:" + (System.currentTimeMillis() - timestamp));

    }

    private static User getDataFromDB(String key) throws InterruptedException {
        System.out.println("get data from database...");
        Thread.sleep(2000);
        if (StringUtils.equals(key, "key")) {
            User user = new User();
            user.setName("henry");
            user.setAge(32);
            return user;
        }
        return null;
    }
}
