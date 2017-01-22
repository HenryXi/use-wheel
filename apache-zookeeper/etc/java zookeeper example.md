# Java zookeeper example
In this page I will show you how to use zookeeper as a configuration service. I use a standalone zookeeper for the demonstration.
If you want to build a high availability configuration service click [here](http://zookeeper.apache.org/doc/trunk/zookeeperStarted.html#sc_RunningReplicatedZooKeeper) for more detail.

1. Download and install zookeeper.

    Download zookeeper from [here](http://zookeeper.apache.org/releases.html) and unzip it. For to start it you need rename
    the `zoo_sample.cfg` to `zoo.cfg`.
    ```bash
    wget http://apache.claz.org/zookeeper/zookeeper-3.4.9/zookeeper-3.4.9.tar.gz
    tar -vxf zookeeper-3.4.9.tar.gz
    cd zookeeper-3.4.9/conf
    cp zoo_sample.cfg zoo.cfg
    ```
2. Start zookeeper in standalone mode.

    ```bash
    ../bin/zkServer.sh start
    ```
    If zookeeper start successfully the output is like following.
    ```bash
    ZooKeeper JMX enabled by default
    Using config: /root/zookeeper-3.4.9/bin/../conf/zoo.cfg
    Starting zookeeper ... STARTED
    ```
3. Use java api read and write configuration
    The pom file is like following.
    ```java
    <dependency>
        <groupId>org.apache.zookeeper</groupId>
        <artifactId>zookeeper</artifactId>
        <version>3.4.9</version>
    </dependency>
    ```
    We use `ZkUtil` to create, update and read configuration from zookeeper.

    ```java
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
    ```
    
    The code of client.    
    ```java
    public class ZkTest {
        public static void main(String[] args) throws Exception {
            ZkUtil.createData("/test","value");
            String data = ZkUtil.getData("/test");
            System.out.println(data);
            ZkUtil.updateDate("/test","new value1");
            String newData = ZkUtil.getData("/test");
            System.out.println(newData);
        }
    }
    ```

The one of the most important advantages of using zookeeper is **change configurations dynamically and read them without restart server**