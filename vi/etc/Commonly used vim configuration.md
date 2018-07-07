# Commonly used vim configuration
Here is my own common vim configuration. Disable syntax and enable spell check in markdown file.
```
set number
set smartindent
set tabstop=4
set shiftwidth=4
set expandtab
set showmatch
autocmd BufRead,BufNewFile {*.markdown,*.mdown,*.mkdn,*.md,*.mkd,*.mdwn,*.mdtxt,*.mdtext,*.text} set filetype=markdown.pandoc
autocmd FileType markdown setlocal syntax=off spell spelllang=en_us,cjk
```

EOF
