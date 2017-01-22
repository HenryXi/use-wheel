package com.henryxi.zookeeper;

import org.apache.zookeeper.*;

public class ZkUtil {
    private static ZooKeeper zk;

    private ZkUtil() {
    }

    static {
        try {
            //my host and port is :10.232.56.19:2181 , change host and port to yours
            zk = new ZooKeeper("10.232.56.19:2181", 3000, new Watcher() {
                public void process(WatchedEvent event) {
                    switch (event.getType()) {
                        case NodeDeleted:
                            System.out.println("node delete");// do your logic here
                            break;
                        case NodeCreated:
                            System.out.println("node created");// do your logic here
                            break;
                        case NodeDataChanged:
                            System.out.println("node changed");// do your logic here
                            break;
                        case NodeChildrenChanged:
                            System.out.println("node children changed");// do your logic here
                            break;
                        default:
                            break;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getData(String path) throws Exception {
        byte[] data = zk.getData(path, true, zk.exists(path, true));
        return new String(data);
    }

    public static void createData(String path, String value) throws Exception {
        if (zk.exists(path, true) != null) {
            return;
        }
        zk.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void updateDate(String path, String value) throws Exception {
        zk.setData(path, value.getBytes(), zk.exists(path, true).getVersion());
    }
}
