package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Server;
import view.Client;

public class Controller {
    @FXML
    private TextArea messagesArea;
    @FXML
    private TextField txtFieldInput;
    @FXML
    private Button buttonSend;

    private Client client;


    @FXML
    public void initialize(){
        client = new Client();
        client.setNickname(getNickname());
        client.start();
        client.setGuiController(this);
    }
    @FXML
    public void sendMessage(){
        String message = txtFieldInput.getText();
        txtFieldInput.setText("");
        client.send(client.getNickname(), message);

    }
    public static String getNickname(){
        String nick = "";
        while (nick.equals("")) {
            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setTitle("Your nickname");
            textInputDialog.setContentText("Nick:");
            textInputDialog.showAndWait();
            nick = textInputDialog.getResult();
        }

        return nick;
    }
    public void receiveMessage(String message){
        messagesArea.appendText(message + '\n');
    }
}
