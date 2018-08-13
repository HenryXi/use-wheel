# Java generate random 6 digits number
There are different ways to generate random 6 digits. I recommend you to use `RandomUtils` or `RandomStringUtils`
in `apache-common-lang3` framework to generate it. Here is the sample code.
```java
import org.apache.commons.lang3.RandomUtils;

public class RandomUtilsClient {
    public static void main(String[] args) {
        int sixLengthRandomNumber = RandomUtils.nextInt(100000, 1000000);
        System.out.println("random 6 digit number:" + sixLengthRandomNumber);
        String sixRandomNumber = RandomStringUtils.randomNumeric(6);
        System.out.println("random 6 digit number:" + sixRandomNumber);
    }
}
```

EOF