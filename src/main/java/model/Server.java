package model;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    public static final int PORT = 2000;
    public static Set<PrintWriter> clients = new HashSet<>();
    public static final Set<String> nicknamesInUse = new HashSet<>();
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening...");

        try {
            while (true) {
                new Handler(server.accept());
            }
        } finally {
            server.close();
        }
    }


}