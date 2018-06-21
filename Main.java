package com.oczkowski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        int portNumber = 4321;
        ServerSocket server;
        Socket client;
        BufferedReader in;
        PrintWriter out;
        String line;

        try {
            server = new ServerSocket(portNumber);

            client = server.accept();
            in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(),
                    true);

            while(true){
                try{
                    line = "";//in.readLine();

                    int lenght = in.read();
                    int msg = in.read();

                    byte[] bytes = ByteBuffer.allocate(4).putInt(msg).array();
                    out.println(new String(bytes));

                    out.println("Hello there!");

                } catch (IOException e) {
                    System.out.println("Read failed");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port 4321");
            System.exit(-1);

        }
    }

}
