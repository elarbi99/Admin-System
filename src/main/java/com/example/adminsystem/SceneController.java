package com.example.adminsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SceneController extends LoginController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField txtSearch;
    @FXML
    public TableView<Table> tbl_Employees;
    @FXML
    public TableColumn<Table, String> clm_EmployeeId;
    @FXML
    public TableColumn<Table, String> clm_FName;
    @FXML
    public TableColumn<Table, String> clm_LName;
    @FXML
    public TableColumn<Table, String> clm_Position;
    @FXML
    public TableColumn<Table, String> clm_DOH ;
    @FXML
    public TableColumn<Table, String> clm_Email;
    @FXML
    public TableColumn<Table, String> clm_Phone;
    @FXML
    public TableColumn<Table, String> clm_AltPhone;
    @FXML
    public TableColumn<ProductTable, String> clm_Id;
    @FXML
    public TableColumn<Table, String> clm_EmergencyContact;
    @FXML
    public TableColumn<Table, String> clm_EmergencyContactPhone;
    @FXML
    public TableColumn<Table, String> clm_EmergencyContact2;
    @FXML
    public TableColumn<Table, String> clm_EmergencyContactPhone2;
    @FXML
    public TableColumn<Table, String> clm_PayRate;
    @FXML
    public TableView<ProductTable> tbl_Products;
    @FXML
    public TableColumn<OrdersTable, String> clm_Item;
    @FXML
    public TableColumn<OrdersTable, String> clm_Price;
    @FXML
    public TableColumn<OrdersTable, String> clm_OnHand;
    @FXML
    public TableColumn<OrdersTable, String> clm_Description;
    @FXML
    public TableColumn<OrdersTable, String> clm_productId;
    @FXML
    public TableView<TimeCard> tbl_TimeCard;
    @FXML
    public TableColumn<Table, String> clm_TimeCardId;
    @FXML
    public TableColumn<Table, String> clm_TimeCardfName;
    @FXML
    public TableColumn<Table, String> clm_TimeCardlName;
    @FXML
    public TableColumn<Table, String> clm_TimeCardPosition;
    @FXML
    public TableColumn<Table, String> clm_TimeCardClockIn;
    @FXML
    public TableColumn<Table, String> clm_TimeCardClockOut;
    @FXML
    public TableColumn<Table, String> clm_TimeCardStartMeal;
    @FXML
    public TableColumn<Table, String> clm_TimeCardEndMeal;
    @FXML
    public TableColumn<Table, String> clm_TimeCardDate;
    @FXML
    public TableView<OrdersTable> tbl_Orders;
    @FXML
    public TableColumn<OrdersTable, String> clm_OrderId;
    @FXML
    public TableColumn<OrdersTable, String> clm_Subtotal;
    @FXML
    public TableColumn<OrdersTable, String> clm_Total;
    @FXML
    public TableColumn<OrdersTable, String> clm_Discount;
    @FXML
    public TableColumn<OrdersTable, String> clm_OrderDate;

    APIController apiController = new APIController();
    // The Scene Controller will be used to switch to the different scenes in the Admin Application.
    // All methods are named switchTo plus the name of the FXML file it loads.

    // switch to main Admin Login fxml (to be used after logging out of account, etc)
    public void switchToAdminLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    // switch to Employee Login fxml for clocking in (to be used after logging out for employees, etc)


    public void switchToEmployeeLoggedIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/EmployeeLoggedIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Employee Time Portal");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    // Testing for new logged in admin page !!!!
    public void switchToAdminLoggedIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminLoggedIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void addEmployee(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("/AdminAddEmployee.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void addItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminAddItem.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        /*
        apiController.setItem(txtItem.getText());
        apiController.setOnHand(Integer.parseInt(txtOnHand.getText()));
        apiController.setPrice(Double.parseDouble(txtPrice.getText()));
        apiController.setDescription(txtDescription.getText());
        apiController.addProduct();
        for ( int i = 0; i<tbl_Products.getItems().size(); i++) {
            tbl_Products.getItems().clear();
        }
        apiController.getItemList().clear();
        apiController.getPriceList().clear();
        apiController.getOnHandList().clear();
        apiController.getDescriptionList().clear();
        apiController.displayProducts();
        ObservableList<ProductTable> productList = FXCollections.observableArrayList();
        for (int i = 0; i < apiController.getItemList().size(); i++) {


            productList.addAll(FXCollections.observableArrayList(new ProductTable(apiController.getItemList().get(i), apiController.getPriceList().get(i),
                    apiController.getOnHandList().get(i), apiController.getDescriptionList().get(i))));

            clm_Item.setCellValueFactory(new PropertyValueFactory<ProductTable, String>("item"));
            clm_Price.setCellValueFactory(new PropertyValueFactory<ProductTable, String>("price"));
            clm_OnHand.setCellValueFactory(new PropertyValueFactory<ProductTable, String>("onHand"));
            clm_Description.setCellValueFactory(new PropertyValueFactory<ProductTable, String>("description"));
            tbl_Products.setItems(productList);


        }
        */

    }
    public String twoDecimals(double a)
    {
        String numStr= String.valueOf(a);
        String[] test=numStr.split(Pattern.quote("."));
        if(test[1].length()<2)
        {
            numStr+="0";
        }
        return numStr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            apiController.displayEmployeeData();

            for ( int i = 0; i<tbl_Employees.getItems().size(); i++) {
                tbl_Employees.getItems().clear();
            }
            ObservableList<Table> list = FXCollections.observableArrayList();
            for (int i = 0; i < apiController.getEmployeeIDList().size(); i++) {




                    list.addAll(FXCollections.observableArrayList(new Table(apiController.getEmployeeIDList().get(i), apiController.getfNameList().get(i)
                            , apiController.getlNameList().get(i), apiController.getPositionList().get(i), apiController.getDohList().get(i), apiController.getEmailList().get(i), apiController.getPhoneList().get(i),
                            apiController.getPhoneList2().get(i), apiController.getEmergencyContactList().get(i), apiController.getEmergencyContactListPhone().get(i), apiController.getEmergencyContactList2().get(i)
                            , apiController.getEmergencyContactListPhone2().get(i), apiController.getPayRateList().get(i))));

                    clm_EmployeeId.setCellValueFactory(new PropertyValueFactory<Table, String>("id"));
                    clm_FName.setCellValueFactory(new PropertyValueFactory<Table, String>("fName"));
                    clm_LName.setCellValueFactory(new PropertyValueFactory<Table, String>("lName"));
                    clm_Position.setCellValueFactory(new PropertyValueFactory<Table, String>("position"));
                    clm_DOH.setCellValueFactory(new PropertyValueFactory<Table, String>("doh"));
                    clm_Email.setCellValueFactory(new PropertyValueFactory<Table, String>("email"));
                    clm_Phone.setCellValueFactory(new PropertyValueFactory<Table, String>("phone"));
                    clm_AltPhone.setCellValueFactory(new PropertyValueFactory<Table, String>("phone2"));
                    clm_EmergencyContact.setCellValueFactory(new PropertyValueFactory<Table, String>("emergencyContact"));
                    clm_EmergencyContactPhone.setCellValueFactory(new PropertyValueFactory<Table, String>("emergencyContactPhone"));
                    clm_EmergencyContact2.setCellValueFactory(new PropertyValueFactory<Table, String>("emergencyContact2"));
                    clm_EmergencyContactPhone2.setCellValueFactory(new PropertyValueFactory<Table, String>("emergencyContactPhone2"));
                    clm_PayRate.setCellValueFactory(new PropertyValueFactory<Table, String>("payRate"));
                    tbl_Employees.setItems(list);

            }



            for ( int i = 0; i<tbl_Products.getItems().size(); i++) {
                tbl_Products.getItems().clear();
            }
            apiController.getProductIdList().clear();
            apiController.getItemList().clear();
            apiController.getPriceList().clear();
            apiController.getOnHandList().clear();
            apiController.getDescriptionList().clear();
            apiController.displayProducts();

            ObservableList<ProductTable> productList = FXCollections.observableArrayList();
            for (int i = 0; i < apiController.getItemList().size(); i++) {


                productList.addAll(FXCollections.observableArrayList(new ProductTable(apiController.getProductIdList().get(i),apiController.getItemList().get(i), twoDecimals(Double.parseDouble(apiController.getPriceList().get(i))),
                        apiController.getOnHandList().get(i), apiController.getDescriptionList().get(i))));

                clm_productId.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("id"));
                clm_Item.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("item"));
                clm_Price.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("price"));
                clm_OnHand.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("onHand"));
                clm_Description.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("description"));
                tbl_Products.setItems(productList);
            }
            apiController.displayOrders();
            ObservableList<OrdersTable> orderList = FXCollections.observableArrayList();
            for (int i = 0; i < apiController.getOrderIDList().size(); i++) {


                orderList.addAll(FXCollections.observableArrayList(new OrdersTable(apiController.getOrderIDList().get(i),twoDecimals(Double.parseDouble(apiController.getSubtotalList().get(i))), twoDecimals(Double.parseDouble(apiController.getTotalList().get(i))),
                        apiController.getDiscountList().get(i), apiController.getOrderDateList().get(i))));

                clm_OrderId.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("orderId"));
                clm_Subtotal.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("subtotal"));
                clm_Total.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("total"));
                clm_Discount.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("discount"));
                clm_OrderDate.setCellValueFactory(new PropertyValueFactory<OrdersTable, String>("orderDate"));
                tbl_Orders.setItems(orderList);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void updateItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUpdateItem.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void removeItems(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminRemoveItem.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void updateEmployeeTab(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminUpdateEmployee.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Deve's Admin Panel");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void search(ActionEvent event) throws IOException {
        for ( int i = 0; i<tbl_TimeCard.getItems().size(); i++) {
            tbl_TimeCard.getItems().clear();
        }
        apiController.getTimeCardIdList().clear();
        apiController.getTimeCardFNameList().clear();
        apiController.getTimeCardLNameList().clear();
        apiController.getTimeCardPositionList().clear();
        apiController.getPunchInList().clear();
        apiController.getPunchOutList().clear();
        apiController.getPunchStartMealList().clear();
        apiController.getPunchEndMealList().clear();
        apiController.getTimeCardDate().clear();
        apiController.setTimeCardID(Integer.parseInt(txtSearch.getText()));
        apiController.displayEmployeeTimecard();
        ObservableList<TimeCard> list = FXCollections.observableArrayList();
        for (int i = 0; i < apiController.getTimeCardFNameList().size(); i++) {


            list.addAll(FXCollections.observableArrayList(new TimeCard(apiController.getTimeCardIdList().get(i), apiController.getTimeCardFNameList().get(i)
                    , apiController.getTimeCardLNameList().get(i), apiController.getTimeCardPositionList().get(i), apiController.getPunchInList().get(i), apiController.getPunchOutList().get(i), apiController.getPunchStartMealList().get(i),
                    apiController.getPunchEndMealList().get(i), apiController.getTimeCardDate().get(i))));

            clm_TimeCardId.setCellValueFactory(new PropertyValueFactory<Table, String>("timeCardId"));
            clm_TimeCardfName.setCellValueFactory(new PropertyValueFactory<Table, String>("timeCardFName"));
            clm_TimeCardlName.setCellValueFactory(new PropertyValueFactory<Table, String>("timecardLName"));
            clm_TimeCardPosition.setCellValueFactory(new PropertyValueFactory<Table, String>("timecardPosition"));
            clm_TimeCardClockIn.setCellValueFactory(new PropertyValueFactory<Table, String>("punchIn"));
            clm_TimeCardClockOut.setCellValueFactory(new PropertyValueFactory<Table, String>("punchOut"));
            clm_TimeCardStartMeal.setCellValueFactory(new PropertyValueFactory<Table, String>("startMeal"));
            clm_TimeCardEndMeal.setCellValueFactory(new PropertyValueFactory<Table, String>("endMeal"));
            clm_TimeCardDate.setCellValueFactory(new PropertyValueFactory<Table, String>("timecardDate"));
            tbl_TimeCard.setItems(list);
        }
    }
}// end of class
