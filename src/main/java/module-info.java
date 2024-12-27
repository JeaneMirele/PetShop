module com.petshop.petshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.petshop to javafx.fxml;
    exports com.petshop;
    exports com.petshop.controller;
    opens com.petshop.controller to javafx.fxml;
    exports com.petshop.model;
    opens com.petshop.model to javafx.fxml;
}