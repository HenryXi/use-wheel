# Java Compare JSON string example
Use `jsonassert` framework to compare two json are same or not. It only compare the content of them. The example code is
here;
```java
public class JsonAssertClient {
    public static void main(String[] args) {
        String json1Str = "{ \"name\":\"henry\", \"age\":\"28\" }";
        String json2Str = "{ \"name\":\"henry2\", \"age\":\"28\" }";
        String json3StrWithBlank = "{ \"name\"  :  \"henry\"    ,      \"age\"   :   \"28\"    }";
        String json4StrWithDiffOrder = "{\"age\":\"28\", \"name\":\"henry\"}";
        System.out.println("json1 is same with json2:" + isSame(json1Str, json2Str));
        System.out.println("json1 is same with json3:" + isSame(json1Str, json3StrWithBlank));
        System.out.println("json1 is same with json4:" + isSame(json1Str, json4StrWithDiffOrder));
    }

    private static boolean isSame(String json1, String json2) {
        try {
            JSONAssert.assertEquals(json1, json2, true);
        } catch (AssertionError e){
            return false;
        } catch (JSONException e) {
            System.out.println("json format error!");
            return false;
        }
        return true;
    }
}
```
output
```
json1 is same with json2:false
json1 is same with json3:true
json1 is same with json4:true
```
The maven dependency:
```xml
<dependency>
    <groupId>org.skyscreamer</groupId>
    <artifactId>jsonassert</artifactId>
    <version>1.5.0</version>
</dependency>
```
EOF