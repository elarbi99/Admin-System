package com.example.adminsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddEmployeeController
{
    private Stage stage;
    private Scene scene;
    APIController apiController=new APIController();
    @FXML
    TextField txtFName;
    @FXML
    TextField txtLName;
    @FXML
    RadioButton rdEmployee;
    @FXML
    RadioButton rdManager;
    @FXML
    TextField txtDoh;
    @FXML
    TextField txtEmail;
    @FXML
    TextField txtPhone;
    @FXML
    TextField txtPhone2;
    @FXML
    TextField txtEmergencyContact;
    @FXML
    TextField txtEmergencyContactPhoneNumber;
    @FXML
    TextField txtEmergencyContact2;
    @FXML
    TextField txtEmergencyContactPhoneNumber2;
    @FXML
    TextField txtPayRate;
    @FXML
    TextField txtUserName;
    @FXML
    PasswordField txtPassword;
    public void addEmployee2(ActionEvent event) throws IOException {
        apiController.setfName(txtFName.getText());
        apiController.setlName(txtLName.getText());
        if(rdEmployee.isSelected()){
            apiController.setPosition("Cashier");
            apiController.setRoles("Role_Employee");
        }
        else if(rdManager.isSelected()){
            apiController.setPosition("Manager");
            apiController.setRoles("Admin");
        }
        apiController.setPhone(txtPhone.getText());
        apiController.setEmail(txtEmail.getText());
        apiController.setEmergencyContact(txtEmergencyContact.getText());
        apiController.setDoh(LocalDate.parse(txtDoh.getText()));
        apiController.setEmergencyContactPhone(txtEmergencyContactPhoneNumber.getText());
        apiController.setEmergencyContactPhone2(txtEmergencyContactPhoneNumber2.getText());
        apiController.setEmergencyContact2(txtEmergencyContact2.getText());
        apiController.setPayRate(Double.valueOf(txtPayRate.getText()));
        apiController.setAddUserName(txtUserName.getText());
        apiController.setNewPassword(txtPassword.getText());
        apiController.setAltPhone(txtPhone2.getText());
        apiController.addNewEmployee();
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
