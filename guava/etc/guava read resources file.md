# guava read resources file
It is very simple to read files using the tool classes in guava. Here is the example.
```
public class ReadResourcesFile {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("test.txt");
        String text = Resources.toString(url, StandardCharsets.UTF_8);
        System.out.println(text);
    }
}
```
Add a file named `test.txt` and run the above code you will get the file content in output.

EOF