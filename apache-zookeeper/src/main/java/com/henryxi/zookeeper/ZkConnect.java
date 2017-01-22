package com.henryxi.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZkConnect {
    private ZooKeeper zk;
    private CountDownLatch connSignal = new CountDownLatch(0);

    //host should be 127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002
    public ZooKeeper connect(String host) throws Exception {
        zk = new ZooKeeper(host, 2081, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getState() == KeeperState.SyncConnected) {
                    connSignal.countDown();
                }
            }
        });
        connSignal.await();
        return zk;
    }

    public void close() throws InterruptedException {
        zk.close();
    }

    public void createNode(String path, byte[] data) throws Exception {
        zk.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public void updateNode(String path, byte[] data) throws Exception {
        zk.setData(path, data, zk.exists(path, true).getVersion());
    }

    public void deleteNode(String path) throws Exception {
        zk.delete(path, zk.exists(path, true).getVersion());
    }

    public static void main(String args[]) throws Exception {
        ZkConnect connector = new ZkConnect();
        ZooKeeper zk = connector.connect("10.232.56.19:2181");
        do {
            String newNode = "/test";
            byte[] data = zk.getData(newNode, true, zk.exists(newNode, true));
            String str = new String(data);
            System.out.println(str);
            Thread.sleep(2000);
        } while (true);


//        connector.deleteNode(newNode);
    }

}
