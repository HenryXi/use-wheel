# vim delete specified line
In Vim we can use `j` and `k` to move the cursor to specified line and press `D` or `dd` to delete current. You can also
use next command to delete specified line.
```
:<line_number>d
```
replace line number to your specified line.
Use follow command to delete a range of rows. Following command will delete line 1 to line 10.
```
:1,10d
```

EOF