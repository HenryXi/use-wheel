# git merge rebase
There are two ways to put your change to remote: `merge` and `rebase`. Let's say there is a branch and you develop
your feature in this branch. You `merge` the changes to this branch you will get the result like following.
```
      master_branch
            |
v0--v1--v2--v4--v5  <-- merge result
        \      /
         --v3--   <-- your branch
```
v3 is your changes and v4 is others' changes. 
```
$ git checkout master
$ git merge <your_branch>
```
The result of merge is v5.

If you do `rebase` on your branch.
```
$ git checkout <your_branch>
$ git rebase master
```
you will get the result like following.
```
      master_branch
            |
v0--v1--v2--v4--v3'  <-- rebase result
        \      
         --v3--  <-- this commit will disappear
```
v3 will be disappear and v3' means git will redo v3 changes on v4. 

Now the master branch is still on v4, you need merge v3' to master.
```
$ git checkout master
$ git merge <your_branch>
```

EOF