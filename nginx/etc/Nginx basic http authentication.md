# Nginx basic http authentication
I want to add basic http authentication in my personal wiki. I don't want to write any code to implement this function.
After searching on the Internet, I found Nginx can do this by adding configuration.

**Install `httpd-tools` and generate password**

```
yum install httpd-tools

htpasswd -c <password path> <user name>
```

**config nginx**

add following configuration in your nginx.
```
server {
	listen 80;
    location  / {
		auth_basic        "input you user name and password";
		auth_basic_user_file   <password path>;
    }
}
```

**enbale nginx configuration**

```
nginx -s reload
```

You have added basic http authentication so far. It needs to input user name and password when anyone want visit your website

EOF