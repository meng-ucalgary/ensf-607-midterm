package midterm.server.controller;

import midterm.server.model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerStringController implements Runnable {
    private StringModel theModel;
    private Socket clientSocket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    public ServerStringController(Socket cs, StringModel m) {
        this.clientSocket = cs;
        this.theModel = m;

        try {
            this.socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            this.socketOut = new PrintWriter(this.clientSocket.getOutputStream(), true);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str1 = this.socketIn.readLine();
                String str2 = this.socketIn.readLine();
                String strCase = this.socketIn.readLine();

                if (strCase == null || strCase.equals("")) {
                    this.theModel.concatenate(str1, str2);
                }

                else if (strCase.equals("lower")) {
                    this.theModel.concatenateWithLower(str1, str2);
                }

                else {
                    this.theModel.concatenateWithUpper(str1, str2);
                }

                this.socketOut.println(this.theModel.getMyString());
            }
        }

        catch (java.net.SocketException e) {
            if (e.getMessage().equals("Connection reset")) {
                System.out.printf("%n%n[SERVER] Client disconnected");
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
