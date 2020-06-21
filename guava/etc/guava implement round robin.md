# guava implement round robin
we can use `Iterators.cycle` of guava to implement round robin. Here is an example.
```java
public class RoundRobinClient {
    public static void main(String[] args) {
        Iterator<String> cycleIterator = Iterators.cycle(Arrays.asList("A", "B", "C", "D"));
        for (int i = 0; i < 10; i++) {
            System.out.println(cycleIterator.next());
        }
    }
}
```
The output is like following.
```
A
B
C
D
A
B
C
D
A
B
```

EOF