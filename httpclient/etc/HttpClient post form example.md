# HttpClient post form example
In this page I will show you how to post a form programmatically. Before testing `HttpClient` we need to write a `API` by 
Spring Boot(or use SpringMVC). The code is here.
```java
@RestController
@EnableAutoConfiguration
public class ServerController {
    @RequestMapping(path = "/post-form", method = RequestMethod.POST)
    public String postForm(@RequestParam String name) {
        return "This is Post response:" + name;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerController.class, args);
    }
}
```
The example code of using `HttpClient` to post a form.
```java
public class PostFormClient {
    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("http://localhost:8080/post-form");
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("name", "test_name"));
            postRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse httpResponse = httpClient.execute(postRequest);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                String responseStr = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println(responseStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
The output is like following.
```
post form,name:test_name
18:20:44.439 [main] DEBUG o.a.h.c.protocol.RequestAddCookies - CookieSpec selected: best-match
18:20:44.448 [main] DEBUG o.a.h.c.protocol.RequestAuthCache - Auth cache not set in the context
18:20:44.449 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection request: [route: {}->http://localhost:8080][total kept alive: 0; route allocated: 0 of 2; total allocated: 0 of 20]
18:20:44.457 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection leased: [id: 0][route: {}->http://localhost:8080][total kept alive: 0; route allocated: 1 of 2; total allocated: 1 of 20]
18:20:44.465 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Opening connection {}->http://localhost:8080
18:20:44.469 [main] DEBUG o.a.h.i.c.HttpClientConnectionOperator - Connecting to localhost/127.0.0.1:8080
18:20:44.470 [main] DEBUG o.a.h.i.c.HttpClientConnectionOperator - Connection established 127.0.0.1:60417<->127.0.0.1:8080
18:20:44.470 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Executing request POST /post-form HTTP/1.1
18:20:44.470 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Target auth state: UNCHALLENGED
18:20:44.471 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Proxy auth state: UNCHALLENGED
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> POST /post-form HTTP/1.1
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Content-Length: 14
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Content-Type: application/x-www-form-urlencoded
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Host: localhost:8080
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Connection: Keep-Alive
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> User-Agent: Apache-HttpClient/4.3.3 (java 1.5)
18:20:44.472 [main] DEBUG org.apache.http.headers - http-outgoing-0 >> Accept-Encoding: gzip,deflate
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "POST /post-form HTTP/1.1[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Content-Length: 14[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Content-Type: application/x-www-form-urlencoded[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Host: localhost:8080[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Connection: Keep-Alive[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "User-Agent: Apache-HttpClient/4.3.3 (java 1.5)[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "Accept-Encoding: gzip,deflate[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "[\r][\n]"
18:20:44.472 [main] DEBUG org.apache.http.wire - http-outgoing-0 >> "name=test_name"
18:20:44.475 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "HTTP/1.1 200 OK[\r][\n]"
18:20:44.475 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Server: Apache-Coyote/1.1[\r][\n]"
18:20:44.475 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Content-Type: text/plain;charset=UTF-8[\r][\n]"
18:20:44.475 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Content-Length: 31[\r][\n]"
18:20:44.475 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "Date: Wed, 13 Dec 2017 10:20:44 GMT[\r][\n]"
18:20:44.475 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "[\r][\n]"
18:20:44.477 [main] DEBUG org.apache.http.headers - http-outgoing-0 << HTTP/1.1 200 OK
18:20:44.477 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Server: Apache-Coyote/1.1
18:20:44.477 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Content-Type: text/plain;charset=UTF-8
18:20:44.477 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Content-Length: 31
18:20:44.477 [main] DEBUG org.apache.http.headers - http-outgoing-0 << Date: Wed, 13 Dec 2017 10:20:44 GMT
18:20:44.480 [main] DEBUG o.a.h.impl.execchain.MainClientExec - Connection can be kept alive indefinitely
18:20:44.487 [main] DEBUG org.apache.http.wire - http-outgoing-0 << "This is Post response:test_name"
18:20:44.487 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection [id: 0][route: {}->http://localhost:8080] can be kept alive indefinitely
18:20:44.487 [main] DEBUG o.a.h.i.c.PoolingHttpClientConnectionManager - Connection released: [id: 0][route: {}->http://localhost:8080][total kept alive: 1; route allocated: 1 of 2; total allocated: 1 of 20]
response: This is Post response:test_name
```

EOF