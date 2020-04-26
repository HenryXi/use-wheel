# Maven change mirror repositories
If you want download artifacts faster you need to configure maven `setting.xml` file.

I use following mirror repositories.
```
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

EOF