module com.example.adminsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.apache.commons.io;


    opens com.example.adminsystem to javafx.fxml;
    exports com.example.adminsystem;

}