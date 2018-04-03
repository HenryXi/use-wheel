# git delete branch
Using `git branch -d <branch_name>` to delete local branch. Using `git push -u origin --delete <branch_name>` to delete 
the remote branch.

**create local and remote branch `tobedel`**
```
[root@virtual]$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/develop
  remotes/origin/master
[root@virtual]$ git checkout -b tobedel remotes/origin/master
Branch tobedel set up to track remote branch master from origin.
Switched to a new branch 'tobedel'
[root@virtual]$ vi README.md 
[root@virtual]$ git add .
[root@virtual]$ git commit -m 'add'
[tobedel b97d673] add
 1 files changed, 0 insertions(+), 1 deletions(-)
[root@virtual]$ git push -u origin tobedel
Counting objects: 5, done.
Delta compression using up to 2 threads.
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 311 bytes, done.
Total 3 (delta 0), reused 0 (delta 0)
To git@github.com:your_github_name/your_project_name.git
 * [new branch]      tobedel -> tobedel
Branch tobedel set up to track remote branch tobedel from origin.
[root@virtual]$ git branch -a
  master
* tobedel
  remotes/origin/HEAD -> origin/master
  remotes/origin/develop
  remotes/origin/master
  remotes/origin/tobedel
[root@virtual]$ git checkout master
Switched to branch 'master'
```
**delete local branch**
```
[root@virtual]$ git branch -d tobedel
warning: deleting branch 'tobedel' that has been merged to
         'refs/remotes/origin/tobedel', but it is not yet merged to HEAD.
Deleted branch tobedel (was b97d673).
[root@virtual]$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/develop
  remotes/origin/master
  remotes/origin/tobedel
```

**delete remote branch**
```
[root@virtual]$ git push -u origin --delete tobedel
To git@github.com:your_github_name/your_project_name.git
 - [deleted]         tobedel
[root@virtual]$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/develop
  remotes/origin/master
```

EOF