# Unable to open debugger port in Intellij IDEA
When I start tomcat to deploy my application I got the error message like following.
```
Error running '<application_name>': Unable to open debugger port (127.0.0.1:57214): java.net.SocketException "socket closed"
``` 
* Solution

1. Open right bottom `Event Log` window. My `Event Log` is here
```
16:01	Error running '<application_name>': Address localhost:8080 is already in use
16:01	Error running '<application_name>': Unable to open debugger port (127.0.0.1:57214): java.net.SocketException "socket closed"
```
2. Check the port can not open.(In my environment, the port is 8080)
3. Change the port or close the application which use that port.

* How to change the tomcat port in IDEA ?

1. Edit Configurations
2. Server tab to change http and JMX port
3. Startup/Connection tab choose Debug to change debugger port.