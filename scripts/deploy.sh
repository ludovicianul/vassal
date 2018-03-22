#!/bin/bash

MACHINE_NAME=$1
TARGET_JAR_FILE=$(find target/vassal*.jar)

if [ $# -lt 1 ]
  then
    echo "No arguments supplied"
    echo "USAGE: machine_name "
    exit 1
fi



if [ -z "$TARGET_JAR_FILE" ]
  then
    echo "No Jar File found"
    exit 1
fi


echo "-----------------------------------------------------------------------"
echo "Deploy on $MACHINE_NAME"

JAR_NAME=$(basename $TARGET_JAR_FILE)
JAR_FILE=~/vassal/$JAR_NAME
mv $TARGET_JAR_FILE $JAR_FILE

chmod 777 $JAR_FILE

sudo ln -sf  $JAR_FILE /etc/init.d/vassal
export DISPLAY=:1
sudo /etc/init.d/vassal restart

echo "Deploy on $MACHINE_NAME done"
echo "-----------------------------------------------------------------------"
