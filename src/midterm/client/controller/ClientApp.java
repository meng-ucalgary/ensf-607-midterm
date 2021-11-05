package midterm.client.controller;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        ClientStringController client = new ClientStringController("localhost", 9090);
        client.communicateWithServer();
    }
}