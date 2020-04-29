package com.henryxi.httpclient.youdao;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequestClient {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        File file = new File("D:\\code\\use-wheel\\httpclient\\src\\main\\resources\\investing.txt");
        File target = new File("D:\\code\\use-wheel\\httpclient\\src\\main\\resources\\target.txt");
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        for (String line : lines) {
            line = line.replaceAll("\\p{C}", "");
            if (StringUtils.isEmpty(line)) {
                FileUtils.writeStringToFile(file, "\n", true);
            } else {
                String responseJson = translate(line);
                Response response = objectMapper.readValue(responseJson, Response.class);
                for (String sentence : response.getTranslation()) {
                    FileUtils.writeStringToFile(target, sentence+"\n", true);
                }
            }
        }
    }

    private static String translate(String tobeTranslate) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost("https://openapi.youdao.com/api");
        List<NameValuePair> urlParameters = new ArrayList<>();
        String appKey = "0ed5c45bb1b78f5a";
        String salt = UUID.randomUUID().toString();
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        urlParameters.add(new BasicNameValuePair("q", tobeTranslate));
        urlParameters.add(new BasicNameValuePair("from", "en"));
        urlParameters.add(new BasicNameValuePair("to", "zh-CHS"));
        urlParameters.add(new BasicNameValuePair("appKey", appKey));
        urlParameters.add(new BasicNameValuePair("salt", salt));
        urlParameters.add(new BasicNameValuePair("sign", getSign(appKey, tobeTranslate, salt, curtime)));
        urlParameters.add(new BasicNameValuePair("signType", "v3"));
        urlParameters.add(new BasicNameValuePair("curtime", curtime));

        postRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
        try (CloseableHttpResponse httpResponse = httpClient.execute(postRequest)) {
            System.out.println("get request status: " + httpResponse.getStatusLine());
            try (InputStream contentStream = httpResponse.getEntity().getContent()) {
                return IOUtils.toString(contentStream);
            }
        }
    }

    private static String getSign(String appKey, String tobeTranslate, String salt, String curtime) {
        String input;
        if (tobeTranslate.length() <= 20) {
            input = tobeTranslate;
        } else {
            String first10 = StringUtils.substring(tobeTranslate, 0, 10);
            String length = String.valueOf(tobeTranslate.length());
            String last10 = StringUtils.substring(tobeTranslate, tobeTranslate.length() - 10);
            input = first10 + length + last10;
        }
        return DigestUtils.sha256Hex(appKey + input + salt + curtime + "wEFATUUkrlsJ5agsxh0sTbFvZgqivnrb");
    }
}
