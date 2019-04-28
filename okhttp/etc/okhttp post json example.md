# okhttp post json example
`okhttp` is one of best network framework. In this page I will show your how to use it post json to remote server. The code
is here.
```java
public class OkHttpExampleClient {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, "{\"name\":\"henry\",\"age\":30}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/postUrl")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
```
You need add dependency in your pom file.
```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>3.13.1</version>
</dependency>
```

EOF