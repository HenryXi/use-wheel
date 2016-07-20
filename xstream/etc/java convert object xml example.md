# Java convert object xml example
There are many ways to convert object to xml. In this post I will show you how to use [XStream](http://x-stream.github.io/)
to convert object to xml. In order to use XStream add maven dependency like following.

**pom**
```xml
<dependency>
    <groupId>com.thoughtworks.xstream</groupId>
    <artifactId>xstream</artifactId>
    <version>1.4.7</version>
</dependency>
```
**project structure**
```
├─main
│  ├─java
│  │  └─com
│  │      └─henryxi
│  │          └─xstream
│  │                  Address.java
│  │                  ConvertObjectToXml.java
│  │                  ConvertXmlToObject.java
│  │                  User.java
│  │
│  └─resources
└─test
    └─java
```
**Java Model**
```java
@XStreamAlias("user")
public class User {
    private String name;
    private int age;
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}
```
```java
@XStreamAlias("address")
public class Address {
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

```
**convert object to xml**
```java
public class ConvertObjectToXml {
    public static void main(String[] args) {
        User henry = initDate();
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String xml = xStream.toXML(henry);
        System.out.println(xml);
    }

    private static User initDate() {
        User henry = new User();
        henry.setName("henry");
        henry.setAge(27);
        Address home = new Address();
        home.setCountry("China");
        home.setCity("Hebei");
        Address company = new Address();
        company.setCountry("China");
        company.setCity("Beijing");
        List<Address> addressList = new ArrayList<>();
        addressList.add(home);
        addressList.add(company);
        henry.setAddresses(addressList);
        return henry;
    }
}
```
The output like following
```xml
<user>
  <name>henry</name>
  <age>27</age>
  <addresses>
    <address>
      <country>China</country>
      <city>Hebei</city>
    </address>
    <address>
      <country>China</country>
      <city>Beijing</city>
    </address>
  </addresses>
</user>

```
If you do not use `@XStreamAlias("user")` the node name will contain package name and class name. Execute `autodetectAnnotations`
before execute `toXml` method.

**convert xml to object**
```java
public class ConvertXmlToObject {
    public static void main(String[] args) {
        String xml = "<user>\n" +
                "  <name>henry</name>\n" +
                "  <age>27</age>\n" +
                "  <addresses>\n" +
                "    <address>\n" +
                "      <country>China</country>\n" +
                "      <city>Hebei</city>\n" +
                "    </address>\n" +
                "    <address>\n" +
                "      <country>China</country>\n" +
                "      <city>Beijing</city>\n" +
                "    </address>\n" +
                "  </addresses>\n" +
                "</user>";

        XStream xStream = new XStream();
        xStream.processAnnotations(User.class);

        User henry = (User)xStream.fromXML(xml);
        System.out.println(henry.toString());
    }
}
```
For converting xml to object, execute `processAnnotations` method if you want specify the node name.