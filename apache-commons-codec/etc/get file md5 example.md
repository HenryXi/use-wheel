# Get file md5 example
When we download file from remote server. We need to check the integrity of the file. In general, the website will provide 
the md5 value of the downloaded file. In this page I will show you how to use `apache-commons-codec` to get the md5 of file.
```java
public class GetFileMd5 {
    public static void main(String[] args) throws Exception {
        try (InputStream is = Files.newInputStream(Paths.get("<your_file_path>"))) {
            System.out.println(DigestUtils.md5Hex(is));
        }
    }
}
```

EOF