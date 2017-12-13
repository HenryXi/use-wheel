package com.henryxi.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class PostFormClient {
    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost("http://localhost:8080/post-form");
            List<NameValuePair> urlParameters = new ArrayList<>();
            String value = "test_name";
            System.out.println("post form,name:" + value);
            urlParameters.add(new BasicNameValuePair("name", value));
            postRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse httpResponse = httpClient.execute(postRequest);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                String responseStr = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("response: " + responseStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
