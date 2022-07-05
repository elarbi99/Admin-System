package com.example.adminsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateItemController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public TextField txtUpdateItem;
    @FXML
    public TextField txtItemID;
    @FXML
    public TextField txtUpdatePrice;
    @FXML
    public TextField txtUpdateDescription;
    @FXML
    public TextField txtUpdateOnHand;
    APIController apiController = new APIController();
    public void update(ActionEvent event) throws IOException {
        apiController.setItemId(txtItemID.getText());
        apiController.setOnHand(Integer.parseInt(txtUpdateOnHand.getText()));
        apiController.setPrice(Double.parseDouble(txtUpdatePrice.getText()));
        //apiController.setDescription(txtUpdateDescription.getText());
        apiController.updateProduct();
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminLoggedIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
