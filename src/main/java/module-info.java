module csci205_final_project.main{

    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports group12;
    exports group12.controller;

    opens group12.controller to javafx.fxml;


}