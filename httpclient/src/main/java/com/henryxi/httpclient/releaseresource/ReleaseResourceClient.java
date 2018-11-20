package com.henryxi.httpclient.releaseresource;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class ReleaseResourceClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        withoutRelease(httpClient);
    }

    private static void withoutRelease(CloseableHttpClient httpClient) throws IOException {
        do {
            HttpGet httpGet = new HttpGet("http://192.168.56.6:8080/get");
            CloseableHttpResponse getResponse = httpClient.execute(httpGet);
            InputStream inputStream = getResponse.getEntity().getContent();
            int read1 = inputStream.read();
            int read2 = inputStream.read();
            inputStream.close();
        } while (true);
    }

    private static void withRelease(CloseableHttpClient httpClient) throws IOException {
        do {
            HttpGet httpGet = new HttpGet("http://192.168.56.6:8080/get");
            try (CloseableHttpResponse getResponse = httpClient.execute(httpGet)) {
                System.out.println("get request status: " + getResponse.getStatusLine());
                try (InputStream contentStream = getResponse.getEntity().getContent()) {
                    System.out.println("get request content: " + IOUtils.toString(contentStream));
                }
            }
        } while (true);
    }
}
