package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    private static final int defaultWidth = 500;
    private static final int defaultHeight = 350;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/client.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, defaultWidth, defaultHeight));
        primaryStage.setMinWidth(defaultWidth);
        primaryStage.setMinHeight(defaultHeight);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(we -> {
            System.exit(0);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
