# Java add separator to string
Let's say you have a list of string and you want to add separator to them. If you use JDK8+ you can use `String.join()`. 
For JDK7-, I recommend you to use `StringUtils` in `apache-commons-lang`. The code is like following.

**For JDK8+**
```java
String joinStr1 = String.join(",", "a", "b", "c");
System.out.println(joinStr1);

String[] array = new String[] { "d", "e", "f" };
String joinStr2 = String.join(",", array);
System.out.println(joinStr2);

List<String> list = Arrays.asList(array);
String joinStr3 = String.join(",", list);
System.out.println(joinStr3);
```

**Use apache-commons-lang jar**

Dependency in pom file
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.4</version>
</dependency>
```
Code
```java
List<String> testList = new ArrayList<>();
testList.add("a");
testList.add("b");
testList.add("c");
System.out.println(StringUtils.join(testList, ","));
```

EOF
