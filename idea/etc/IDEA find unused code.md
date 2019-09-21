# IDEA find unused code
There are many unused code in my project. Whenever I see useless code, I will remove them. I think this is too inefficient.
Fortunately, I found that IDEA can help me discover all the useless code in the project. In this blog I will show you how
to use this feature.

Click `Analyze` -> `Inspect Code` choose the project you want to deal with. The more projects you choose the slower IDEA
handle them.

After running the `Analyze` you will get the output in `Inspection` window. You can find unused code in
`Declaration redundancy` -> `Unused declaration`

There are many others "issue" in `Inspection` window. You can handle them according to your own situation.
