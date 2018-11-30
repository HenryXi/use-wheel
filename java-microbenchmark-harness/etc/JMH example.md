# JMH example
`Java Microbenchmark Harness` is a good tool to test your code. It can tell you the code is efficiently or not. Today I 
will show you how to use it to test your code. Let's say you want to implement a functionality about probability. Maybe
you want your program have a 1/10 probability of doing something. You have two ways to implement this.

* Use `ThreadLocalRandom.current().nextInt(10) == 1`
* Use `num % 10 == 1`

Then the next question is which one is more efficient? 

The answer is "Test and compare them!". Here is the `JMH` code.
```java
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class JMHModClient {
    private int[] numbers;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHModClient.class.getSimpleName())
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void mod() {
        int i = 0;
        for (int num : numbers) {
            if (num % 10 == 1) {
                i++;
            }
        }
        System.out.println(i);
    }

    @Benchmark
    public void random() {
        int i = 0;
        for (int num : numbers) {
            if (ThreadLocalRandom.current().nextInt(10) == 1) {
                i++;
            }
        }
        System.out.println(i);
    }

    @Setup
    public void setUp() {
        numbers = IntStream.rangeClosed(1, 1000).toArray();
    }
}
```

Before run `JMH` code you need add maven dependency in you pom.xml. 
```xml
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-core</artifactId>
    <version>1.14.1</version>
</dependency>
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-generator-annprocess</artifactId>
    <version>1.14.1</version>
    <scope>provided</scope>
</dependency>
```
The part of result is here
```
# Run complete. Total time: 00:00:42

Benchmark            Mode  Cnt   Score   Error  Units
JMHModClient.mod     avgt   10  34.935 ± 0.818  us/op
JMHModClient.random  avgt   10  39.888 ± 3.123  us/op
```
We can see mod function is a little better than random. "Error" column has nothing. "Score" column show the result with "+0.818".

EOF