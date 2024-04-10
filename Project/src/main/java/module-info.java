module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires spring.context;

    opens com.example.tp to javafx.fxml;
    exports tp;
    exports tp.Models;
    exports tp.interfaces;
    exports tp.Enum;
    exports tp.strategies;
    exports tp.UI;
    opens tp to javafx.fxml;
    opens tp.UI to javafx.fxml;
}