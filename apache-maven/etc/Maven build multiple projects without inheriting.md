# Maven build multiple projects without inheriting
If you build root maven project the children project will be built automatically. In this page
I will show you how to build multiple maven projects without inheriting. Let's say you have multiple
maven projects like following.
```
├─apache-common-lang3
│  ├─src
│  ├─target
│  └─pom.xml
├─apache-common-io
│  ├─src
│  ├─target
│  └─pom.xml
```
Create another maven project let's say "build-all". The pom of this project is like following.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>use-wheel</artifactId>
        <groupId>com.henryxi.use.wheel</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>apache-maven</artifactId>
    <packaging>pom</packaging><!--change the type of packageing to pom -->
    <modules>
        <module>../apache-common-lang3</module><!--relative path to the project you want build -->
        <module>../apache-common-io</module>
    </modules>
</project>
```
Change the packaging to `pom` and add modules node. The content of child module node is the relative path to the project
you want build. When you build `build-all` project with maven commend `mvn clean install` it will help you build both
`apache-common-lang3` and `apache-common-io`.