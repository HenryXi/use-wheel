# guava BloomFilter example
The biggest advantage of the Bloom filter is that his space usage is very high. His disadvantage is that there may be misjudgments.
Bloom filters return two values: elements may exist and elements definitely do not exist.

Here is an example of BloomFilter(in guava)
```
public class BloomClient {
    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 2, 0.1);
        filter.put(1);
        filter.put(3);
        filter.put(4);
        boolean exist = filter.mightContain(3);
        System.out.println("3 might contain:" + exist);
        exist = filter.mightContain(5);
        System.out.println("5 might contain:" + exist);
    }
}
```
If it returns true, this element may exist.

If false is returned, it means that this element absolutely does not exist.

EOF