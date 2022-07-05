package com.example.adminsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeLoggedInController
{
    private Stage stage;
    private Scene scene;
    @FXML
    Label lblTimeCardError;
    APIController apiController=new APIController();
    public void clockIn(ActionEvent event) throws IOException {
        apiController.setTimeCardError("");
        lblTimeCardError.setText("");
        apiController.clockIn();
        lblTimeCardError.setText(apiController.getTimeCardError());
    }

    public void clockOut(ActionEvent event) throws IOException {
        apiController.setTimeCardError("");
        lblTimeCardError.setText("");
        apiController.clockOut();
        lblTimeCardError.setText(apiController.getTimeCardError());
    }

    public void startMeal(ActionEvent event) throws IOException {
        apiController.setTimeCardError("");
        lblTimeCardError.setText("");
        apiController.lunchStart();
        lblTimeCardError.setText(apiController.getTimeCardError());
    }

    public void endMeal(ActionEvent event) throws IOException {
        apiController.setTimeCardError("");
        lblTimeCardError.setText("");
        apiController.lunchEnd();
        lblTimeCardError.setText(apiController.getTimeCardError());
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/EmployeeLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Employee Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
