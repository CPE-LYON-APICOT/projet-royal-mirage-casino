package tp.Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tp.Models.BlackJack;
import tp.UI.GameGraphics;
import tp.UI.HelloApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class GraphicsController implements Initializable {
    List<ImageView> jetons = new ArrayList<ImageView>();
    List<ImageView> cartesCroupier = new ArrayList<ImageView>();
    List<ImageView> cartesJoueur = new ArrayList<ImageView>();
    @FXML
    ImageView betFive;
    @FXML
    ImageView betTen;
    @FXML
    ImageView betTwentyFive;
    @FXML
    ImageView betHundred ;
    @FXML
    ImageView croupierCard1;
    @FXML
    ImageView croupierCard2;
    @FXML
    ImageView croupierCard3;
    @FXML
    ImageView croupierCard4;
    @FXML
    ImageView croupierCard5;

    @FXML
    ImageView joueurCard1;
    @FXML
    ImageView joueurCard2;
    @FXML
    ImageView joueurCard3;
    @FXML
    ImageView joueurCard4;
    @FXML
    ImageView joueurCard5;
    @FXML
    Button btnValidBet;


    private final BlackJack blackJack;



    public GraphicsController(BlackJack blackJack){
        this.blackJack = blackJack;
        System.out.println("GraphicsController constructor");

    }



    //@Override
    public void start(Stage stage) throws Exception {
        System.out.println("GraphicsController start");


        betFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                blackJack.getJoueur().bet(5);
                System.out.println("betFive cliqué !");
            }
        });


        betTen.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                blackJack.getJoueur().bet(10);
            }
        });

        betTwentyFive.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                blackJack.getJoueur().bet(25);
            }
        });

        betHundred.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                blackJack.getJoueur().bet(100);
            }
        });

        btnValidBet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Salut le monde !");
            }
        });
    }

    private void instanciateButtons(){
        /* Bet Buttons */

        jetons.add(betFive);
        jetons.add(betTen);
        jetons.add(betTwentyFive);
        jetons.add(betHundred);

        cartesCroupier.add(croupierCard1);
        cartesCroupier.add(croupierCard2);
        cartesCroupier.add(croupierCard3);
        cartesCroupier.add(croupierCard4);
        cartesCroupier.add(croupierCard5);

        /* Player Cards */
        cartesJoueur.add(joueurCard1);
        cartesJoueur.add(joueurCard2);
        cartesJoueur.add(joueurCard3);
        cartesJoueur.add(joueurCard4);
        cartesJoueur.add(joueurCard5);

        /* Bet Button */
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // instanciateButtons();

        betFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                blackJack.getJoueur().bet(5);
                System.out.println("betFive cliqué !");
            }
        });
    }
}
