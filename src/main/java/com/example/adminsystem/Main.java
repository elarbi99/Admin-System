package com.example.adminsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Main Code
        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AdminLogin.fxml")));
            Scene launchScene = new Scene(root);
            stage.setTitle("Deve's Admin Login");
            stage.getIcons().add(new Image("croissant.jpg"));
            stage.setResizable(true);
            stage.setScene(launchScene); // set main launch scene
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}