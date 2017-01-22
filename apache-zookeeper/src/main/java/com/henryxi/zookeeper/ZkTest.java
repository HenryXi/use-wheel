package com.henryxi.zookeeper;

public class ZkTest {
    public static void main(String[] args) throws Exception {
        ZkUtil.createData("/test","value1");
        String data = ZkUtil.getData("/test");
        System.out.println(data);
        ZkUtil.updateDate("/test","new value1");
        String newData = ZkUtil.getData("/test");
        System.out.println(newData);
    }
}
