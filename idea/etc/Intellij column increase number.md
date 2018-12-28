# Intellij column increase number
When I defined thrift file I need to create a column of numbers. The file looks something like this.
```thrift
struct ContentItem {
    1: string id;
    2: string balabala;
    3: string balabala1;
    4: string balabala2
    5: string balabala3
    6: string balabala4
    7: string balabala5
    8: string balabala6
    9: string balabala7
    10: string balabala8
}
```
It is boring to write the increase number one by one. I use [String Manipulation](https://plugins.jetbrains.com/plugin/2162-string-manipulation) plugin. I 
assume you have installed this plugin in your environment.

1. use `alt` and left mouse button to input a column with the number which you want to start(Let's say 1), you will get the result like following.
```thrift
struct ContentItem {
    1: string id;
    1: string balabala;
    1: string balabala1;
    1: string balabala2
    1: string balabala3
    1: string balabala4
    1: string balabala5
    1: string balabala6
    1: string balabala7
    1: string balabala8
}
```
2. use `alt` and left mouse button to select this column.
3. press `ctrl+shift+a` and search `Create sequence` then press `enter`
4. now you get an increase column.

EOF