# Nginx htpasswd old password still working
Today I encountered a problem about `htpasswd`. I use `htpasswd` to make simple user authentication for my website.
I use nginx as the reverse agent of my personal website. Today I tried to modify a password. I added a random number
behind my old password. Like this `old_pwd -> old_pwd_666`. After the password is modified, I found that the old password
can still pass the authentication. It's too strange. After reviewing the `htpasswd` helping documentation,
I found the reason for the problem.

```
When using the crypt() algorithm, note that only the  first  8  characters  of  the
password  are  used  to  form the password. If the supplied password is longer, the
extra characters will be silently discarded.
```

My original password length is 8 characters!!! Therefore, the random number added later is ignored.


EOF