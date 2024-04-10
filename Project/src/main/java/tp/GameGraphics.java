package tp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameGraphics extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1110, 800);
        /*scene.getStylesheets().add("style.css");*/
        stage.setTitle("Casino Royale Mirage - Blackjack");
        stage.setScene(scene);
        stage.show();

        AnchorPane anchorPane = (AnchorPane) scene.lookup("#AnchorPane");
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
        Image img = new Image("file:".concat(currentPath.concat("Images/card.png")));
        ImageView imageView = new ImageView(img);
        imageView.setLayoutX(100);
        imageView.setLayoutY(50);
        imageView.setFitWidth(200);
        imageView.setFitHeight(150);
        anchorPane.getChildren().add(imageView);

        /*Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream("Images/card.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);*/

        Button btnValidBet = (Button) scene.lookup("#validBet");
        btnValidBet.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Salut le monde !");
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }


}
