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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        var context = new AnnotationConfigApplicationContext(HelloApplication.class);

        /*Personne joueur = context.getBean(Personne.class);
        GameGraphics gameGraphics = context.getBean(GameGraphics.class);*/
        //var blackJack = context.getBean(BlackJack.class);
        GraphicsController graphicsController = context.getBean(GraphicsController.class);
        //GameGraphics.main(null);/
    }
}