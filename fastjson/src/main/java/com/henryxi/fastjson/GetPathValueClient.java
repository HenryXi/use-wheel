package com.henryxi.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

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
