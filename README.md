# vassal

Vassal is a simple security-free server that allows you to execute commands on a remote host. It's not meant to be something similar to vnc, rdp, ssh or others. Just see it as it is: a vassal ready to execute your orders. It can press keys, type strings, open files&URLs or execute shell commands.

# ci

[![Build Status](https://snap-ci.com/ludovicianul/vassal/branch/master/build_image)](https://snap-ci.com/ludovicianul/vassal/branch/master)

# build
    mvn clean install
    
# build and push Docker image to registry
    mvn clean install -Pdockerize -Dprefix=PREFIX -Ddocker.registry=URL_OF_DOCKER_REGISTRY
    
# usage
    java -jar vassal.jar 12345

This will start a server accepting commands on port 12345.

In order to connect to the server do:
    
    telnet ip_of_host_where_server_is_running 12345
    
Start sending commands.

# usage through Docker
    docker pull PREFIX/vassal
    docker run -d -p 12345:12345 -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix PREFIX/vassal
    
# issues
If you have issues with X11 while running through Docker, please do a ```xhost +``` in order to make remote connections possible.

# available commands
Once connected to the server using a telnet client, just type ```?``` and you will get the list of all available commands.
