module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires spring.context;

    opens com.example.project to javafx.fxml;
    exports tp;
    exports tp.Models;
    exports tp.interfaces;
    exports tp.Enum;
    exports tp.strategies;
    opens tp to javafx.fxml;
}