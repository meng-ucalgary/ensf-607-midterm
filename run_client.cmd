@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE CLIENT FILES
javac -sourcepath src -d bin src/midterm/client/controller/*java src/midterm/client/view/*java

@REM RUN A CLIENT
java -cp bin midterm.client.controller.ClientApp

@REM NO NEED TO PAUSE
@REM PAUSE
