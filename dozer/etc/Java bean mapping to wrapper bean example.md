# Java bean mapping to wrapper bean example
We need to convert java beans to another java bean when pass it from one layer to another. For example, you need to convert
PO(persistent object) to BO(business object) when pass it from DAO layers to business layers. I recommend you to use
[Dozer](http://dozer.sourceforge.net/) instead of converting them by yourself.

The content of pom is like following.
```xml
<dependency>
    <groupId>net.sf.dozer</groupId>
    <artifactId>dozer</artifactId>
    <version>5.5.1</version>
</dependency>
```
The code of convert java bean to wrapper bean is like following.
```java
public class DozerTest {
    public static void main(String[] args) {
        DozerBeanMapper dozer = new DozerBeanMapper();
        User user = new User();
        user.setName("Henry");
        user.setAge(28);
        System.out.println(user.toString());
        UserWrapper userWrapper = dozer.map(user, UserWrapper.class);
        System.out.println(userWrapper.toString());
    }
}
```