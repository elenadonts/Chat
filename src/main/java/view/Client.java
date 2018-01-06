package view;
import controller.Controller;
import model.Server;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String nickname;
    private Controller guiController;

    public void setGuiController(Controller guiController) {
        this.guiController = guiController;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void run() {
        try {
            socket = new Socket("localhost", Server.PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//сюда получаем
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String msgIn;
            while (true) {
                if (reader.ready()) {//append message in Gui
                    msgIn = reader.readLine();
                    guiController.receiveMessage(msgIn);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String nick, String message){
        this.writer.println(nick + " : " + message);// на сервер
    }

}