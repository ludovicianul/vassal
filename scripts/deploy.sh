#!/bin/bash

MACHINE_NAME=$1
JAR_FILE=$(find vassal*.jar)

if [ $# -lt 1 ]
  then
    echo "No arguments supplied"
    echo "USAGE: machine_name "
    exit 1
fi



if [ -z "$JAR_FILE" ]
  then
    echo "No Jar File found"
    exit 1
fi


echo "-----------------------------------------------------------------------"
echo "Deploy on $MACHINE_NAME"

chmod 777 $JAR_FILE

sudo ln -sf  ~/vassal/$JAR_NAME /etc/init.d/vassal
export DISPLAY=:1
sudo /etc/init.d/vassal restart

echo "Deploy on $MACHINE_NAME done"
echo "-----------------------------------------------------------------------"
