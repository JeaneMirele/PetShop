module com.petshop.petshop {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.petshop to javafx.fxml;
    exports com.petshop;
    exports com.petshop.controller;
    opens com.petshop.controller to javafx.fxml;
    exports com.petshop.model;
    opens com.petshop.model to javafx.fxml;
}