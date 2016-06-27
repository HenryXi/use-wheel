# Remove the last character in Java
`StringUtils` in apache-common-lang3 framework is an useful class. You can use `removeEnd` to remove the last character
or characters. If you want remove the character and ignore the case use `removeEndIngoreCase` instead.
```java
public class StringUtilsTest {
    public static void main(String[] args) {
        String target = "this is a target string";
        System.out.println(StringUtils.removeEnd(target,"g"));
        System.out.println(StringUtils.removeEndIgnoreCase(target,"String"));
    }
}
```
the out put of above code
```bash
this is a target strin
this is a target
```