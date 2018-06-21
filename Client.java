package com.oczkowski;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private Socket client;
    private boolean isAccepted = false;

    public Client(ServerSocket server){
        try {
            client = server.accept();
            isAccepted = true;
        } catch (IOException e) {
            System.out.println("Server cannot accept new Client");
        }
    }

    public void readMessage(){

    }


    public Socket getClient() {
        return client;
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
