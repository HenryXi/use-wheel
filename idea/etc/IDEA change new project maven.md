# IDEA change new project maven home directory
The default home directory of the Maven project in IDEA is `Bundled(Maven 2)` or `Bundled(Maven 3)`. 
I am used to using my own Maven home directory. So, every time I create a new project, I will change this default Maven home directory. It is too much trouble. After reviewing the official documentation, I learned that the default new project settings can be changed. 

`File` -> `Other Settings` -> `Settings for New Projects...`

Then you can change the default home directory of maven through the following path.

`Build` -> `Maven` -> `Maven home directory`

In this way, every time you create a new project, you no longer have to manually change Maven's home directory. Enjoy~

EOF