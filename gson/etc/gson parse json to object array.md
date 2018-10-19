# gson parse json to object array
In this page I will show you how to use gson parse json string to object array. Add gson dependency in pom.xml file.
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.2</version>
</dependency>
```
The `User` entity is here
```java
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```
The client is here
```java
public class GsonClient {
    public static void main(String[] args) {
        String usersJson = "[ { \"name\": \"henry\" }, { \"name\": \"justin\" } ]";
        Gson gson = new Gson();
        User[] users = gson.fromJson(usersJson, User[].class);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
```
Run main method and get the output.
```
User{name='henry'}
User{name='justin'}
```

EOF