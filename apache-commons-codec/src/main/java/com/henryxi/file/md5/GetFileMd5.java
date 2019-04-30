package com.henryxi.file.md5;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetFileMd5 {
    public static void main(String[] args) throws Exception {
        try (InputStream is = Files.newInputStream(Paths.get("C:\\Users\\Administrator\\Desktop\\search_0429.apk"))) {
            System.out.println(DigestUtils.md5Hex(is));
        }
    }
}
