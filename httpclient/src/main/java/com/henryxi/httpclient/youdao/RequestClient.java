package com.henryxi.httpclient.youdao;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequestClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost("https://openapi.youdao.com/api");
        List<NameValuePair> urlParameters = new ArrayList<>();
        String tobeTranslate = "Royalty trusts, like MLPs, generally invest in energy sector assets. Unlike the steady cash flows at MLPs, royalty trusts generate income from the production of natural resources such as coal, oil, and natural gas. These cash flows are subject to swings in commodity prices and production levels, which can cause them to be very inconsistent from year to year. The trusts have no physical operations of their own and have no management or employees. Rather, they are merely financing vehicles that are run by banks, and they trade like stocks. Other companies mine the resources and pay royalties on those resources to the trust. For example, Burlington Resources, an oil exploration and production company, is the operator for the assets that the largest U.S. royalty trust, San Juan Basin Royalty Trust (SJT), owns the royalties on.";
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
                System.out.println("get request content: " + IOUtils.toString(contentStream));
            }
        }
    }

    private static String getSign(String appKey, String tobeTranslate, String salt, String curtime) {
        String input;
        if (tobeTranslate.length() < 20) {
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
