package com.henryxi.httpclient;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

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
