# vim recording and execution macro
Using macros to perform repetitive operations is a very efficient way. In this page I will show you how to use it.

Recently I am translating some English articles into Chinese. I need to enter two Chinese spaces at the beginning before I translate a paragraph.
I plan to use macros to do this boring thing.

**recording**

1. press `qa` in normal mode. "recording" will show in the bottom. This means you are recording macro and save it in "a" register
2. press `o` to move cursor to next line.
3. press Ctrl+v and `u` to prepare input unicode character.
4. the number of chinese space is `3000` in unicode. then press 3000.
5. press `esc` to return normal mode, press `q` to save current macro

**execution**

After recording the macro successfully you can use `@<your_macro_name>` in my case is `@a` to execute the macro.

EOF