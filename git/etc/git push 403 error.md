# git push 403 error
When I use `git push` to push local changes to github I got this error message:`error: The requested URL returned error: 
403 Forbidden while accessing https://github.com/<my_project_url> fatal: HTTP request failed`. It is easy to solve this
problem.

1. change the remote url to `git@git...`
```
git remote set-url origin git@github.com:<your_project_url>
```
2. add ssh-key in github, you can click [here](https://help.github.com/articles/connecting-to-github-with-ssh/) for more detail.

EOF