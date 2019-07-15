# fastjson JSONPath example
We can use fastjson to serialize and deserialize json. When the json structure is complicated, it will be more troublesome to handle.
The json is like following.
```json
{
  "name": "henryxi",
  "address": "beijing",
  "company": {
    "companyName": "xiami",
    "companyAddress": "beijing"
  }
}
```
If you want to get the company name or company address. You can deserialize json to `JSONObject` and then get the value.
Another way to handle it is to use `JSONPath`. 
```java
public class GetPathValueClient {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"name\": \"henryxi\",\n" +
                "  \"address\": \"beijing\",\n" +
                "  \"company\": {\n" +
                "    \"companyName\": \"xiami\",\n" +
                "    \"companyAddress\": \"beijing\"\n" +
                "  }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        String companyAddress = jsonObject.getJSONObject("company").getString("companyAddress");
        System.out.println("company address:" + companyAddress);

        String companyName = (String) JSONPath.extract(json, "$.company.companyName");
        System.out.println("company name:" + companyName);
    }
}
```
The advantage of using `JSONPath` is that there will be no `NullPointerException`.

EOF