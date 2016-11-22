# Convert windows path to unix in java

File separator is "/" on UNIX and "\" on Windows. Using `FilenameUtils` convert path between windows and UNIX is easily. 
`FilenameUtils.separatorsToSystem` method can help you to use correct separator.

```java
public static void main(String[] args) {
    String unixPath = "/test/linux/path";
    String windowsPath = "\\test\\windows\\path";
    System.out.println(FilenameUtils.separatorsToWindows(unixPath));
    System.out.println(FilenameUtils.separatorsToUnix(windowsPath));
    System.out.println(FilenameUtils.separatorsToSystem(windowsPath));
}
```