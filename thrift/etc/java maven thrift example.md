# Java maven thrift example
In last [blog](http://www.henryxi.com/java-thrift-example) I have show you how to use thrift in java. You may found
that you have to use command to generate class and move it into your package. Today I will show you how to use maven
generate thrift class. It is easy and efficient.

**The structure of project**
```
├─main
│  ├─java
│  │  └─com
│  │      └─henryxi
│  │          └─thrift
│  │              └─maven
│  │                      Client.java
│  │                      UserServer.java
│  │                      UserServiceImpl.java
│  │
│  ├─resources
│  └─thrift
│          user.thrift
│
└─test
    └─java
```
**Write your thrift file**

Before generating thrift class file you need write `*.thrift` file and put it into *thrift* directory. The content
of `.thrift` file is like following.
```java
namespace java com.henryxi.thrift.userserver

    typedef i32 int
    typedef User user

    service UserService {
            user find();
    }


    struct User{
        string name;
        int age;
    }
```


**The content of pom.xml file**

You need add `maven-thrift-plugin` in your pom.xml file. It will generate thrift classes automatically.
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.thrift.tools</groupId>
            <artifactId>maven-thrift-plugin</artifactId>
            <version>0.1.11</version>
            <configuration>
                <thriftExecutable>D:\thrift\thrift-0.9.3.exe</thriftExecutable>
            </configuration>
            <executions>
                <execution>
                    <id>thrift-sources</id>
                    <phase>generate-sources</phase>
                    <goals>
                        <goal>compile</goal>
                    </goals>
                </execution>
                <execution>
                    <id>thrift-test-sources</id>
                    <phase>generate-test-sources</phase>
                    <goals>
                        <goal>testCompile</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
<dependencies>
    <dependency>
        <groupId>org.apache.thrift</groupId>
        <artifactId>libthrift</artifactId>
        <version>0.9.3</version>
    </dependency>
</dependencies>
```

**Run `mvn thrift:compile`**

Thrift maven plugin will generate thrift class by running `mvn thrift:compile` command. You only need to resolve the 
problem of dependencies. Project structure is like following after generating the thrift classes. (The generated classes 
are in *target* directory.)
```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─henryxi
│  │  │          └─thrift
│  │  │              └─maven
│  │  │                      Client.java
│  │  │                      UserServer.java
│  │  │                      UserServiceImpl.java
│  │  │
│  │  ├─resources
│  │  └─thrift
│  │          user.thrift
│  │
│  └─test
│      └─java
└─target
    └─generated-sources
        └─thrift
            └─com
                └─henryxi
                    └─thrift
                        └─userserver
                                User.java
                                UserService.java

```

**Code**

Client
```java
public class Client {
    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            UserService.Client client = new UserService.Client(protocol);
            System.out.println("user info:" + client.find());
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}
```
UserServer
```java
public class UserServer {
    public static void StartsimpleServer(UserService.Processor<UserServiceHandler> processor) {
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
        StartsimpleServer(new UserService.Processor<>(new UserServiceHandler()));
    }
}
```
UserServiceImpl
```java
public class UserServiceImpl implements UserService.Iface {
    @Override
    public User find() throws TException {
        User user = new User();
        user.setName("HenryXi");
        user.setAge(27);
        return user;
    }
}
```
