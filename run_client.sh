#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the client files
javac -sourcepath src -d bin src/midterm/client/controller/*java src/midterm/client/view/*java

# run a client
java -cp bin midterm.client.controller.ClientApp
