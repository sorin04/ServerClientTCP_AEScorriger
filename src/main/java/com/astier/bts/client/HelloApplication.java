package com.astier.bts.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController controller = loader.getController(); //recupére le contrôleur
        stage.setOnCloseRequest((event -> {
            try {
                if (controller.enRun){
                    controller.tcp.deconnection();
                }
                System.exit(0);
            } catch (Exception ex) {
            }
        }));
        stage.setTitle("TCP-Client  MM");
        stage.getIcons().add(new Image("/icone/index.jpg"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}