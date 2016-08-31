package com.henryxi.jedis;

import com.henryxi.jedis.util.RedisUtils;
import redis.clients.jedis.JedisCluster;

public class TestRedisList {
    public static void main(String[] args) {
        JedisCluster redisClient = RedisUtils.getJedisCluster();
        String[] goods = new String[200];
        for (int i = 0; i < 200; i++) {
            goods[i] = "goods" + i;
        }
        redisClient.del("list_200");
        redisClient.lpush("list_200", goods);
        for (int j = 0; j < 500; j++) {
            new Thread("Thread" + j) {
                public void run() {
                    for (int h = 0; h < 3; h++) {
                        String goods = redisClient.lpop("list_200");
                        if (goods != null) {
                            Long rest = redisClient.llen("list_200");
                            System.out.println(this.getName() + " get:" + goods + ", rest:" + rest);
                            break;
                        } else {
                            System.out.println(this.getName() + " get nothing!");
                        }
                    }
                }
            }.start();
        }
    }
}
