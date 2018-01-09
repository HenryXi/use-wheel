# guava cache example
Cache is very important for the project. Redis or MemoryCache are good choose for distribution project. If you want use 
local cache for your project `guava` is a good choose. I will show you how to use guava cache in this page.

**pom.xml**
```xml
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>23.0</version>
</dependency>
```

**GuavaClient.java**
```java
public class GuavaClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long timestamp = System.currentTimeMillis();
        Cache<String, String> localCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build();
        String firstGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("firstGet:" + firstGet + ",time cost:" + (System.currentTimeMillis() - timestamp));
        timestamp = System.currentTimeMillis();
        String secondGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("secondGet:" + secondGet + ",time cost:" + (System.currentTimeMillis() - timestamp));
        Thread.sleep(3000);
        timestamp = System.currentTimeMillis();
        String thirdGet = localCache.get("key", () -> getDataFromDB("key"));
        System.out.println("thirdGet:" + thirdGet + ",time cost:" + (System.currentTimeMillis() - timestamp));

    }

    private static String getDataFromDB(String key) throws InterruptedException {
        System.out.println("get data from database...");
        Thread.sleep(2000);
        if (StringUtils.equals(key, "key")) {
            return "data";
        }
        return null;
    }
}
```
The output is like following. When the client get data from "database" it cost long time. Save the data in guava cache after
getting the data. When the client requests data at the second time it will get data from the cache. When the data in cache is expired
client will get data from database again. 
```
get data from database...
firstGet:data,time cost:2097
secondGet:data,time cost:1
get data from database...
thirdGet:data,time cost:2014
```

EOF
