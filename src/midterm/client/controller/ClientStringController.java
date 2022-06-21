package midterm.client.controller;

import midterm.client.view.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientStringController {
    private Socket clientSocket;
    private BufferedReader stdin;
    private BufferedReader socketIn;
    private PrintWriter socketOut;
    private StringView theView;

    public ClientStringController(String serverName, int portNumber) {
        try {
            this.stdin = new BufferedReader(new InputStreamReader(System.in));
            this.clientSocket = new Socket(serverName, portNumber);
            this.socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            this.socketOut = new PrintWriter((this.clientSocket.getOutputStream()), true);
            this.theView = new StringView();
            this.theView.setVisible(true);

            this.theView.addStringListener(new StringListener());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class StringListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String first, sec, strCase;

            try {
                first = theView.getFirstString();
                sec = theView.getSecString();
                strCase = theView.getStringCase();

                socketOut.println(first);
                socketOut.println(sec);
                socketOut.println(strCase);
            }

            catch (Exception ex) {
                theView.displayErrorMessage("Error!");
            }
        }
    }

    public void communicateWithServer() {
        try {
            while (true) {
                String line = null;

                line = this.socketIn.readLine();

                if (line.contains("\0")) {
                    line = line.replace("\0", "");
                    this.theView.displayErrorMessage(line);
                    break;
                }

                else {
                    this.theView.setResult(line);
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                this.stdin.close();
                this.socketIn.close();
                this.socketOut.close();
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
