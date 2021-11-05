@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE SERVER FILES
javac -sourcepath src -d bin src/midterm/server/controller/*java src/midterm/server/model/*java

@REM RUN THE SERVER
java -cp bin midterm.server.controller.ServerApp

@REM DON'T SUDDENLY QUIT
PAUSE
