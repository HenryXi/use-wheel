# Maven Java heap space OutOfMemoryError
When I run `mvn clean install -DskipTests` to build my project I got an error message. The content of message is like following.
```
[ERROR] Java heap space -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/OutOfMemoryError
```
This error means there is no enough heap space for maven to build project. To solve this problem we need to increase the size
of memory by adding `MAVEN_OPTS`. The introduction of maven configuration is [here](https://maven.apache.org/configure.html)

I run `MAVEN_OPTS="-Xmx500m" mvn clean install -DskipTests` in terminal and the error message disappears.

EOF