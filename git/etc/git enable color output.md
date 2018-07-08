# git enable color output
The default output of git is without color. Add following config in `~/.gitconfig` can enable the git 
color output in your terminal. If there is not `.gitconfig` file create one.
```
[color]
    diff = auto
    status = auto
    branch = auto
    interactive = auto
    ui = true
    pager = true
```

EOF