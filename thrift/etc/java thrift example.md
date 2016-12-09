# Java thrift example
`Thrift` is one of the most popular remote procedure call (RPC) frameworks. You can use it to build cross-platform
system. In this page I will show you how to use it in Java.

**The structure of project**
```
├─main
│  ├─java
│  │  └─com
│  │      └─henryxi
│  │          └─thrift
│  │              └─manual
│  │                      AdditionClient.java
│  │                      AdditionService.java
│  │                      AdditionServiceHandler.java
│  │                      MyServer.java
│  │
│  └─resources
│          add.thrift
│
└─test
    └─java
```

**0. Install thrift**

You can click [here](https://thrift.apache.org/docs/install/) to get the thrift for your environment. I have downloaded
"thrift-0.9.3.exe" for my environment (Windows).

The dependency of project is like following.
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.thrift</groupId>
        <artifactId>libthrift</artifactId>
        <version>0.9.3</version>
    </dependency>
</dependencies>
```

**1. Create `.thrift` file**

`.thrift` file is used to generate the class which is useful for connect client and server. The code of `add.thrift`
is like following.
```java
namespace java com.henryxi.thrift.addserver

typedef i32 int

service AdditionService {
    int add(1:int n1, 2:int n2)
}
```

**2. Generate class by `.thrift` file**

Run `D:\thrift\thrift-0.9.3.exe --gen java add.thrift` (I install thrift in my D driver) it will generate `AdditionService`
class. You need move this class into your package and resolve the problem of dependencies manually.

**3. Server and Client class**

Code of server class is like following.
```java
public class MyServer {

    public static void StartsimpleServer(AdditionService.Processor<AdditionServiceHandler> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(
                    new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StartsimpleServer(new AdditionService.Processor<>(new AdditionServiceHandler()));
    }
}
```

Client
```java
public class AdditionClient {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            AdditionService.Client client = new AdditionService.Client(protocol);
            System.out.println("add result:" + client.add(100, 200));
            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}
```
Handler 
```java
public class AdditionServiceHandler implements AdditionService.Iface {

    public int add(int n1, int n2) throws TException {
        return n1 + n2;
    }
}
```
**4. Run server and client to test**

Run `MyServer` class and `AdditionClient` class you will get the output like following.
```
add result:300
```