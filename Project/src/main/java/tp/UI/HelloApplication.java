package tp.UI;

import tp.Controllers.GraphicsController;
import tp.Models.BlackJack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tp.Models.Personne;

import java.io.IOException;

@ComponentScan("tp")
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        fxmlLoader.setControllerFactory(new AnnotationConfigApplicationContext(HelloApplication.class)::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);/*1110*/
        /*scene.getStylesheets().add("style.css");*/
        stage.setTitle("Casino Royale Mirage - Blackjack");
        scene.setOnKeyPressed(event -> {GraphicsController.handleKeyPass(event.getCode());});
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch();
    }
}