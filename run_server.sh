#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the server files
javac -sourcepath src -d bin src/midterm/server/controller/*java src/midterm/server/model/*java

# run the server
java -cp bin midterm.server.controller.ServerApp
