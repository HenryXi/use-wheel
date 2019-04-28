package com.henryxi.okthhp;

import okhttp3.*;

import java.io.IOException;

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
