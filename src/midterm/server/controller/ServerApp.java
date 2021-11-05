package midterm.server.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import midterm.server.model.StringModel;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    private ServerSocket serverSocket;
    private ExecutorService pool;

    ServerApp(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            this.pool = Executors.newCachedThreadPool();
            System.out.printf("%n[SERVER] The server is now running!");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void communicateWithClient() {
        try {
            while (true) {
                System.out.printf("%n%n[SERVER] Waiting for a connection.");

                Socket clientsocket = this.serverSocket.accept();
                System.out.printf("%n%n[SERVER] Connection accepted from a client.");

                StringModel m = new StringModel();
                ServerStringController sc = new ServerStringController(clientsocket, m);

                this.pool.execute(sc);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            this.pool.shutdown();
            System.out.printf("%n%n[SERVER] The server is shutting down!");
        }
    }

    public static void main(String[] args) {
        ServerApp s = new ServerApp(9090);
        s.communicateWithClient();
    }
}
