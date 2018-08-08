# Maven change project version
Let's say you have a project and there are some module in it. If you want change the version of this
project you can find all version number in global search and replace with new version or use following command.
```
mvn versions:set -DnewVersion=1.0.2
```
The command above will change the project version and the module version to `1.0.2` and generate a backup
file to store the version before changing. Use following command to "commit" this change(delete the backup
file)
```
mvn versions:commit
```

EOF 