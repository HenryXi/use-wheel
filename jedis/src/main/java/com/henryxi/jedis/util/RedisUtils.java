package com.henryxi.jedis.util;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisUtils {

    private static JedisCluster jedisCluster;

    private RedisUtils() {

    }

    public static JedisCluster getJedisCluster() {
        try {
            if (jedisCluster == null) {
                Set<HostAndPort> jedisClusterNodes = new HashSet<>();
                jedisClusterNodes.add(new HostAndPort("192.168.104.48", 6379));
                jedisClusterNodes.add(new HostAndPort("192.168.104.48", 6380));
                jedisClusterNodes.add(new HostAndPort("192.168.104.48", 6381));
                jedisClusterNodes.add(new HostAndPort("192.168.104.48", 6382));
                jedisClusterNodes.add(new HostAndPort("192.168.104.48", 6383));
                jedisCluster = new JedisCluster(jedisClusterNodes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jedisCluster;
    }

}
