module com.example.tp.UI {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires spring.context;

    exports tp;
    exports tp.Models;
    exports tp.interfaces;
    exports tp.Enum;
    exports tp.strategies;
    exports tp.Singleton;
    exports tp.UI;
    exports tp.Controllers;
    opens tp to javafx.fxml;
    opens tp.Controllers to javafx.fxml;
    opens tp.UI to javafx.fxml;
}