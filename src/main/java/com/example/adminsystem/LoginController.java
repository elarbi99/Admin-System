package com.example.adminsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController extends APIController {
    private Stage stage;
    private Scene scene;
    @FXML
    public TextField txtFld_Username;
    @FXML
    public TextField txtFld_Password;
    @FXML
    public TextField txtFld_Username1;
    @FXML
    public TextField txtFld_Password1;
    @FXML
    public Button btn_Login;
    @FXML
    public Button btnLogin1;
    APIController apiController=new APIController();
    public LoginController() {

    }

    public void btnLoginOnClick(ActionEvent event) {
        System.out.println("btn_Login clicked.");

        try {
            String id = txtFld_Username.getText();
            String password = txtFld_Password.getText();

            apiController.setId(id);
            apiController.setPassword(password);
            if (!isEmpty(txtFld_Username, txtFld_Password)) {
                System.out.println("Action Needed - username and password is required!");
                return;
            }
            apiController.login();

            if (event.getSource() == btn_Login) {
                // If log in is successful a SceneController object is created and the scene is switched to the
                // default logged in admin page.
                if (Objects.equals(apiController.getTempMessage(), "login successful")) {
                    SceneController adminScene = new SceneController();
//                    adminScene.switchToAdminLoggedInDefault(event);
                    adminScene.switchToAdminLoggedIn(event);
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
            if (!Objects.equals(apiController.getTempMessage(), "login successful")) {
                showAlert("Username or Password is Invalid");
            }
        } //catch (InterruptedException e) {
            //e.printStackTrace();
        //}
    }

    // Check if fields are empty and give appropriate error.
    private boolean isEmpty(TextField txtFld_username, TextField txtFld_password) {
        if (txtFld_username.getText().isEmpty()) {
            showAlert("Please enter username");
            txtFld_username.requestFocus();
            return false;
        } else if (txtFld_Password.getText().isEmpty()) {
            showAlert("Please enter password");
            txtFld_Password.requestFocus();
            return false;
        }
        return true;
    }

    // Reusable alert method to give errors on screen.
    private void showAlert(String errMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Error");
        alert.setContentText(errMessage);
        alert.showAndWait();
    }

    // Method to access the SceneController and switch the scene in the employeeLogin scene
    public void switchToEmployeeLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/EmployeeLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Employee Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    // Method to handle the logout button
    public void btnLogoutOnClick(ActionEvent event) throws IOException {
        SceneController switchScene = new SceneController();
        switchScene.switchToAdminLogin(event);
    }

    public void switchToAdminLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Deve's Admin Login");
        scene = new Scene(root);
        stage.getIcons().add(new Image("croissant.jpg"));
        stage.setResizable(true);
        stage.setScene(scene); // set main launch scene
        stage.show();
    }

    public void btnEmployeeLoginOnClick(ActionEvent event) throws IOException {
        System.out.println("btn_Login clicked.");

        try {
            String id = txtFld_Username1.getText();
            String password = txtFld_Password1.getText();

            apiController.setId(id);
            apiController.setPassword(password);

            apiController.punchLogin();

            if (event.getSource() == btnLogin1) {
                if (Objects.equals(apiController.getTempMessage(), "login successful")) {

                    Parent root = FXMLLoader.load(getClass().getResource("/EmployeeLoggedIn.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Deve's Employee Logged in");
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
            if (!Objects.equals(apiController.getTempMessage(), "login successful")) {
                showAlert("Username or Password is Invalid");
            }
        }


    }


} // end of class