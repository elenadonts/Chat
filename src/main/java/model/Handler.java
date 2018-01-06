package model;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread{

    private BufferedReader reader;
    private PrintWriter writer;
    private Socket clientSocket;

    public Handler(Socket client) {
        this.clientSocket = client;
        start();
    }

    @Override
    public void run()  {
        try {
            writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);//send to client
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//receive from client
        } catch (IOException e) {
            e.printStackTrace();
        }

        Server.clients.add(writer);

        while (true){
            String msgIn;
            try {
                if (reader.ready()){
                    msgIn = reader.readLine();//receives from this thread's client
                    for (PrintWriter writer : Server.clients){
                        writer.println(msgIn);// server sends to everyone
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

