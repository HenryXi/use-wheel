# http header missing
Today I solve a problem about missing http header. I add some extra information in http headers when I request server.
The code works well in my local environment. When I deploy it on the remote machine some http headers are missing.
After google I solve the problem.

I use tomcat in my local environment and the headers are all right. Remote environment use nginx for load balancing. 
**Nginx will ignore the http header which contains underline("_")**. My missing http header is like "token_a". After changing
the name of http header all things OK.

Click the link for more details of [nginx missing http headers](https://www.nginx.com/resources/wiki/start/topics/tutorials/config_pitfalls/?highlight=disappearing%20http%20headers#missing-disappearing-http-headers)

EOF