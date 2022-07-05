package com.example.adminsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AddItemController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    APIController apiController = new APIController();
    @FXML
    public TextField txtItem;
    @FXML
    public TextField txtOnHand;
    @FXML
    public TextField txtPrice;
    @FXML
    public TextField txtDescription;


    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminLoggedIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void addItem(ActionEvent actionEvent) throws IOException {
        apiController.setItem(txtItem.getText());
        apiController.setOnHand(Integer.parseInt(txtOnHand.getText()));
        apiController.setPrice(Double.parseDouble(txtPrice.getText()));
        apiController.setDescription(txtDescription.getText());
        apiController.addProduct();


        }
    }

