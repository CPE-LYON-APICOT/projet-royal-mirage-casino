package tp.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tp.Models.BlackJack;
import tp.UI.GameGraphics;
import tp.UI.HelloApplication;

import java.util.ArrayList;
import java.util.List;

public class GraphicsController extends Application {
    List<ImageView> jetons = new ArrayList<ImageView>();
    List<ImageView> cartesCroupier = new ArrayList<ImageView>();
    List<ImageView> cartesJoueur = new ArrayList<ImageView>();
    ImageView betFive;
    ImageView betTen;
    ImageView betTwentyFive;
    ImageView betHundred ;
    ImageView croupierCard1;
    ImageView croupierCard2;
    ImageView croupierCard3;
    ImageView croupierCard4;
    ImageView croupierCard5;

    ImageView joueurCard1;
    ImageView joueurCard2;
    ImageView joueurCard3;
    ImageView joueurCard4;
    ImageView joueurCard5;
    Button btnValidBet;
    Scene scene;

    private BlackJack blackJack;


    public GraphicsController(BlackJack blackJack){
        this.blackJack = blackJack;
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        scene = new Scene(fxmlLoader.load(), 1110, 800);
        /*scene.getStylesheets().add("style.css");*/
        stage.setTitle("Casino Royale Mirage - Blackjack");
        stage.setScene(scene);
        stage.show();
        instanciateButtons();
    }

    private void instanciateButtons(){
        /* Bet Buttons */
        betFive = (ImageView) scene.lookup("#betFive");
        betTen = (ImageView) scene.lookup("#betTen");
        betTwentyFive = (ImageView) scene.lookup("#betTwentyFive");
        betHundred = (ImageView) scene.lookup("#betHundred");
        jetons.add(betFive);
        jetons.add(betTen);
        jetons.add(betTwentyFive);
        jetons.add(betHundred);

        /* Croupier Cards */
        croupierCard1 = (ImageView) scene.lookup("#croupierCard1");
        croupierCard2 = (ImageView) scene.lookup("#croupierCard2");
        croupierCard3 = (ImageView) scene.lookup("#croupierCard3");
        croupierCard4 = (ImageView) scene.lookup("#croupierCard4");
        croupierCard5 = (ImageView) scene.lookup("#croupierCard5");
        cartesCroupier.add(croupierCard1);
        cartesCroupier.add(croupierCard2);
        cartesCroupier.add(croupierCard3);
        cartesCroupier.add(croupierCard4);
        cartesCroupier.add(croupierCard5);

        /* Player Cards */
        joueurCard1 = (ImageView) scene.lookup("#playerCard1");
        joueurCard2 = (ImageView) scene.lookup("#playerCard2");
        joueurCard3 = (ImageView) scene.lookup("#playerCard3");
        joueurCard4 = (ImageView) scene.lookup("#playerCard4");
        joueurCard5 = (ImageView) scene.lookup("#playerCard5");
        cartesJoueur.add(joueurCard1);
        cartesJoueur.add(joueurCard2);
        cartesJoueur.add(joueurCard3);
        cartesJoueur.add(joueurCard4);
        cartesJoueur.add(joueurCard5);

        /* Bet Button */
        btnValidBet = (Button) scene.lookup("#validBet");
    }
}
