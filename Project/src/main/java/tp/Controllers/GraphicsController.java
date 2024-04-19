package tp.Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tp.Models.BlackJack;
import tp.Models.Carte;
import tp.Singleton.JoueurSingleton;
import tp.UI.GameGraphics;
import tp.UI.HelloApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

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
    Label labelBet;
    @FXML
    Label labelWallet;
    @FXML
    Label mainVal;
    @FXML
    Label croupierMainVal;
    @FXML
    Button validBet;
    @FXML
    Button buttonHit;
    @FXML
    Button buttonStand;

    private final BlackJack blackJack;

    public GraphicsController(BlackJack blackJack){
        this.blackJack = blackJack;
    }


    private void instanciateButtons(){

        jetons.add(betFive);
        jetons.add(betTen);
        jetons.add(betTwentyFive);
        jetons.add(betHundred);

        cartesCroupier.add(croupierCard1);
        cartesCroupier.add(croupierCard2);
        cartesCroupier.add(croupierCard3);
        cartesCroupier.add(croupierCard4);
        cartesCroupier.add(croupierCard5);

        cartesJoueur.add(joueurCard1);
        cartesJoueur.add(joueurCard2);
        cartesJoueur.add(joueurCard3);
        cartesJoueur.add(joueurCard4);
        cartesJoueur.add(joueurCard5);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instanciateButtons();
        validBet.setDisable(true);

        betFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                int val = blackJack.getJoueur().bet(5);
                if (val == 0) {
                    soldeInsuffisant();
                }
                else{
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        betTen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                int val = blackJack.getJoueur().bet(10);
                if (val == 0) {
                    soldeInsuffisant();
                } else {
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        betTwentyFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                int val = blackJack.getJoueur().bet(25);
                if (val == 0) {
                    soldeInsuffisant();
                } else {
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        betHundred.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                int val = blackJack.getJoueur().bet(100);
                if (val == 0) {
                    soldeInsuffisant();
                } else {
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        validBet.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                validBet.setDisable(true);
                actionBetView(false);

                blackJack.play();
                List<Carte> cartes = blackJack.getJoueur().getMain();
                setPlayerCards(cartes);
                setDealerCards(blackJack.getCroupier().getMain());
                mainVal.setText("Valeur main : " + blackJack.getJoueur().getMainValeur());
                mainVal.setVisible(true);
                croupierMainVal.setText("Main Croupier : " + blackJack.getCroupier().getMainValeur());
                croupierMainVal.setVisible(true);
                buttonHit.setVisible(true);
                buttonStand.setVisible(true);
            }
        });

        updateSolde();
        updateBetLabel();
    }

    private void soldeInsuffisant(){
        //TODO: faire un evenement solde insuffisant
        labelWallet.setTextFill(javafx.scene.paint.Color.RED);
    }

    private void updateBetLabel(){
        int betSum = JoueurSingleton.getInstance().getBetSum();
        labelBet.setText("Mise : " + betSum);
    }

    private void updateSolde() {
        int solde = JoueurSingleton.getInstance().getSolde();
        labelWallet.setText("Solde : " + solde);
    }

    private void actionBetView(Boolean bool){
        for (ImageView element : jetons) {
            element.setVisible(bool);
        }
        validBet.setVisible(bool);
    }

    private void setPlayerCards(List<Carte> main){
        int compteurCarte = 0;
        for (Carte carte : main){
            cartesJoueur.get(compteurCarte).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(carte.imageSrc()))));
            compteurCarte++;
        }
    }

    private void setDealerCards(List<Carte> main){
        int compteurCarte = 0;
        for (Carte carte : main){
            cartesCroupier.get(compteurCarte).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(carte.imageSrc()))));
            compteurCarte++;
        }
    }

}
