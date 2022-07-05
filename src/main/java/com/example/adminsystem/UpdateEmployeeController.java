package com.example.adminsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class UpdateEmployeeController {
    private Stage stage;
    private Scene scene;
    APIController apiController=new APIController();
    @FXML
    TextField txtUpdatedEmployeeID;
    @FXML
    TextField txtUpdatedLastName;
    @FXML
    TextField txtUpdatedPosition;
    @FXML
    TextField txtTerminationDate;
    @FXML
    TextField txtUpdatedCellPhone;
    @FXML
    TextField txtUpdateAltPhone;
    @FXML
    TextField txtUpdatedEmergencyContact;
    @FXML
    TextField txtUpdatedEmergencyContactPhone;
    @FXML
    TextField txtUpdatedEmergencyContact2;
    @FXML
    TextField txtUpdatedEmergencyContactPhone2;
    @FXML
    TextField txtUpdatedPayRate;
    @FXML
    PasswordField txtUpdatePassword;
    @FXML
    TextField txtUserID;
    public void updateEmployee(ActionEvent event) throws IOException {
        apiController.setNewId(txtUpdatedEmployeeID.getText());
        apiController.setlName(txtUpdatedLastName.getText());
        apiController.setPosition(txtUpdatedPosition.getText());
        if(!Objects.equals(txtTerminationDate.getText(), ""))
        {
            apiController.setTerminationDate(LocalDate.parse(txtTerminationDate.getText()));
        }
        apiController.setPhone(txtUpdatedCellPhone.getText());
        apiController.setAltPhone(txtUpdateAltPhone.getText());
        apiController.setEmergencyContact(txtUpdatedEmergencyContact.getText());
        apiController.setEmergencyContactPhone(txtUpdatedEmergencyContactPhone.getText());
        apiController.setEmergencyContact2(txtUpdatedEmergencyContact2.getText());
        apiController.setEmergencyContactPhone2(txtUpdatedEmergencyContactPhone2.getText());
        if(!Objects.equals(txtUpdatedPayRate.getText(), ""))
        {
            apiController.setPayRate(Double.valueOf(txtUpdatedPayRate.getText()));
        }
        apiController.updateEmployee();
        apiController.setUserID(txtUserID.getText());
        apiController.setUpdatedPassword(txtUpdatePassword.getText());
        apiController.updatePassword();
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
