package tp.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tp.Models.BlackJack;
import tp.Models.Croupier;
import tp.Models.Joueur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameGraphics extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1110, 800);
        /*scene.getStylesheets().add("style.css");*/
        stage.setTitle("Casino Royale Mirage - Blackjack");
        stage.setScene(scene);
        stage.show();

        AnchorPane anchorPane = (AnchorPane) scene.lookup("#AnchorPaneCroupier");



        /*// Créez l'objet Image. Remplacez "path/to/image.png" par le chemin réel de votre image.
        // Si l'image est dans les ressources du projet, utilisez getClass().getResource("/path/to/image.png").toString()
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/card.png")));

        // Créez l'objet ImageView avec l'image
        ImageView imageView = new ImageView(img);

        // Optionnel: ajustez la position et la taille de l'image si nécessaire
        imageView.setLayoutX(100); // Position horizontale dans l'AnchorPane
        imageView.setLayoutY(50);  // Position verticale dans l'AnchorPane
        imageView.setFitWidth(200);  // Largeur de l'image
        imageView.setFitHeight(150); // Hauteur de l'image

        // Ajoutez l'ImageView à l'AnchorPane
        anchorPane.getChildren().add(imageView);*/

        stage.show();
        Button btnValidBet = (Button) scene.lookup("#validBet");

        // Images Jetons
        List<ImageView> jetons = new ArrayList<ImageView>();
        ImageView betFive = (ImageView) scene.lookup("#betFive");
        ImageView betTen = (ImageView) scene.lookup("#betTen");
        ImageView betTwentyFive = (ImageView) scene.lookup("#betTwentyFive");
        ImageView betHundred = (ImageView) scene.lookup("#betHundred");
        jetons.add(betFive);
        jetons.add(betTen);
        jetons.add(betTwentyFive);
        jetons.add(betHundred);

        // (Jeton)scene.lookup("toto");

        // Images cartes croupier
        List<ImageView> cartesCroupier = new ArrayList<ImageView>();
        ImageView croupierCard1 = (ImageView) scene.lookup("#croupierCard1");
        ImageView croupierCard2 = (ImageView) scene.lookup("#croupierCard2");
        ImageView croupierCard3 = (ImageView) scene.lookup("#croupierCard3");
        ImageView croupierCard4 = (ImageView) scene.lookup("#croupierCard4");
        ImageView croupierCard5 = (ImageView) scene.lookup("#croupierCard5");
        cartesCroupier.add(croupierCard1);
        cartesCroupier.add(croupierCard2);
        cartesCroupier.add(croupierCard3);
        cartesCroupier.add(croupierCard4);
        cartesCroupier.add(croupierCard5);

        // Images cartes joueur
        List<ImageView> cartesJoueur = new ArrayList<ImageView>();

        ImageView joueurCard1 = (ImageView) scene.lookup("#playerCard1");
        ImageView joueurCard2 = (ImageView) scene.lookup("#playerCard2");
        ImageView joueurCard3 = (ImageView) scene.lookup("#playerCard3");
        ImageView joueurCard4 = (ImageView) scene.lookup("#playerCard4");
        ImageView joueurCard5 = (ImageView) scene.lookup("#playerCard5");
        cartesJoueur.add(joueurCard1);
        cartesJoueur.add(joueurCard2);
        cartesJoueur.add(joueurCard3);
        cartesJoueur.add(joueurCard4);
        cartesJoueur.add(joueurCard5);

        /*for (ImageView view : cartesJoueur) {
            view.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                    System.out.println("betFive cliqué !");
                }
            });
        }*/
        betFive.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                System.out.println("betFive cliqué !");
            }
        });


        betTen.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                System.out.println("betTen cliqué !");
            }
        });

        betTwentyFive.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                System.out.println("betTwentyFive cliqué !");
            }
        });

        betHundred.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                System.out.println("betHundred cliqué !");
            }
        });

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