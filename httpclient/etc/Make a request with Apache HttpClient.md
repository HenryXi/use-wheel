# Make a request with Apache HttpClient
Sometimes we need request the resources programmatically. Apache HttpClient is one of the best way to make a request
in your project. This blog will show you how to make "Get" and "Post" request for restful resource. The structure of
this project is like following.
```
├─main
│  ├─java
│  │  └─com
│  │      └─henryxi
│  │          └─httpclient
│  │              │  RequestClient.java
│  │              │
│  │              └─service
│  │                      ServerController.java
│  │                      UserBean.java
│  │
│  └─resources
└─test
    └─java
```
**ServerController.java** and **UserBean.java**
```java
@RestController
@EnableAutoConfiguration
public class ServerController {
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String get() {
        UserBean userBean = new UserBean();
        userBean.setAge(27);
        userBean.setName("Henry");
        return "This is Get response: " + userBean.toString();
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String post(@RequestBody UserBean userBean) {
        return "This is Post response:" + userBean.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerController.class, args);
    }
}
public class UserBean {
    private String name;
    private int age;

    //getter and setter method

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
This controller provides two interfaces for getting the resource. The one is for GET method and the other is for POST. You can use
"PostMan" or [something](http://www.henryxi.com/use-intellij-idea-rest-client-post-json) like that to test these RESTful interfaces.
In this blog we will use HttpClient to request them.

**RequestClient.java**
```java
public class RequestClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/get");
        CloseableHttpResponse getResponse = httpClient.execute(httpGet);
        System.out.println("get request status: " + getResponse.getStatusLine());
        System.out.println("get request content: " + IOUtils.toString(getResponse.getEntity().getContent()));

        HttpPost httpPost = new HttpPost("http://localhost:8080/post");
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity postDate = new StringEntity("{   \"name\": \"henry\",   \"age\": 27 }");
        httpPost.setEntity(postDate);
        CloseableHttpResponse postResponse = httpClient.execute(httpPost);
        System.out.println("post request status: " + postResponse.getStatusLine());
        System.out.println("post request content: " + IOUtils.toString(postResponse.getEntity().getContent()));
    }
}
```
In RequestClient class we make two requests (GET and POST). We use `IOUtils` convert "inputStream" in response to `String`.
The pom file should be like following.
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.3.3</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>1.3.3.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.4</version>
    </dependency>
</dependencies>
```
**How to test them?**

Run the main method in `ServerController` and run the main method in `RequestClient`. You should get the log of `RequestClient`
like following.
```
get request status: HTTP/1.1 200 OK
13:49:46.537 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "This is Get response: UserBean{name='Henry', age=27}"
13:49:46.538 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection [id: 0][route: {}->http://localhost:8080] can be kept alive indefinitely
13:49:46.538 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection released: [id: 0][route: {}->http://localhost:8080][total kept alive: 1; route allocated: 1 of 2; total allocated: 1 of 20]
get request content: This is Get response: UserBean{name='Henry', age=27}
13:49:46.544 [main] DEBUG o.a.h.c.protocol.RequestAddCookies - CookieSpec selected: best-match
13:49:46.544 [main] DEBUG o.a.h.c.protocol.RequestAuthCache - Auth cache not set in the context
13:49:46.544 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection request: [route: {}->http://localhost:8080][total kept alive: 1; route allocated: 1 of 2; total allocated: 1 of 20]
13:49:46.544 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection leased: [id: 0][route: {}->http://localhost:8080][total kept alive: 0; route allocated: 1 of 2; total allocated: 1 of 20]
13:49:46.545 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Stale connection check
13:49:46.546 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "[read] I/O error: Read timed out"
13:49:46.546 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Executing request POST /post HTTP/1.1
13:49:46.546 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Target auth state: UNCHALLENGED
13:49:46.546 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Proxy auth state: UNCHALLENGED
13:49:46.547 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> POST /post HTTP/1.1
13:49:46.547 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Content-Type: application/json
13:49:46.549 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Content-Length: 34
13:49:46.550 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Host: localhost:8080
13:49:46.550 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Connection: Keep-Alive
13:49:46.550 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> User-Agent: Apache-HttpClient/4.3.3 (java 1.5)
13:49:46.550 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Accept-Encoding: gzip,deflate
13:49:46.550 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "POST /post HTTP/1.1[\r][\n]"
13:49:46.550 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Content-Type: application/json[\r][\n]"
13:49:46.550 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Content-Length: 34[\r][\n]"
13:49:46.551 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Host: localhost:8080[\r][\n]"
13:49:46.551 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Connection: Keep-Alive[\r][\n]"
13:49:46.551 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "User-Agent: Apache-HttpClient/4.3.3 (java 1.5)[\r][\n]"
13:49:46.551 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Accept-Encoding: gzip,deflate[\r][\n]"
13:49:46.551 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "[\r][\n]"
13:49:46.551 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "{   "name": "henry",   "age": 27 }"
Disconnected from the target VM, address: '127.0.0.1:56880', transport: 'socket'
13:49:46.714 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "HTTP/1.1 200 OK[\r][\n]"
13:49:46.714 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Server: Apache-Coyote/1.1[\r][\n]"
13:49:46.714 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Content-Type: text/plain;charset=UTF-8[\r][\n]"
13:49:46.714 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Content-Length: 52[\r][\n]"
13:49:46.714 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Date: Tue, 27 Sep 2016 05:49:46 GMT[\r][\n]"
13:49:46.714 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "[\r][\n]"
13:49:46.714 [main] DEBUG org.apache.http.headers - http-outgoing-0 << HTTP/1.1 200 OK
13:49:46.714 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Server: Apache-Coyote/1.1
13:49:46.714 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Content-Type: text/plain;charset=UTF-8
13:49:46.714 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Content-Length: 52
13:49:46.715 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Date: Tue, 27 Sep 2016 05:49:46 GMT
13:49:46.715 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Connection can be kept alive indefinitely
post request status: HTTP/1.1 200 OK
13:49:46.715 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "This is Post response:UserBean{name='henry', age=27}"
13:49:46.715 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection [id: 0][route: {}->http://localhost:8080] can be kept alive indefinitely
13:49:46.715 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection released: [id: 0][route: {}->http://localhost:8080][total kept alive: 1; route allocated: 1 of 2; total allocated: 1 of 20]
post request content: This is Post response:UserBean{name='henry', age=27}
```