# vassal

Vassal is a simple security-free server that allows you to execute commands on a remote host. It's not meant to be something similar to vnc, rdp, ssh or others. Just see it as it is: a vassal ready to execute your orders. It can press keys, type strings, open files&URLs or execute shell commands.

# ci

[![Build Status](https://snap-ci.com/ludovicianul/vassal/branch/master/build_image)](https://snap-ci.com/ludovicianul/vassal/branch/master)

# build
    gradle jar
    
# usage
    java -jar vassal.jar 12345

This will start a server accepting commands on port 12345.

In order to connect to the server do:
    
    telnet ip_of_host_where_server_is_running 12345
    
Start sending commands.

# available commands
Once connected to the server using a telnet client, just type ```?``` and you will get the list of all available commands.
