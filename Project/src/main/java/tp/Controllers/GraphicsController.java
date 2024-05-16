package tp.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Component;
import tp.Models.BlackJack;
import tp.Models.Carte;
import tp.Singleton.JoueurSingleton;
import tp.interfaces.TirerPaquetImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

@Component
public class GraphicsController implements Initializable {
    ArrayList<ImageView> jetons = new ArrayList<ImageView>();
    ArrayList<ImageView> imagesMoins = new ArrayList<ImageView>();
    ArrayList<ImageView> cartesCroupier = new ArrayList<ImageView>();
    ArrayList<ImageView> cartesJoueur = new ArrayList<ImageView>();
    private static String tappedText = "";
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
    @FXML
    Label soldeMessage;
    @FXML
    Label message;
    @FXML
    Button buttonRestart;

    @FXML
    ImageView moinsCinq;
    @FXML
    ImageView moinsDix;

    @FXML
    ImageView moinsVingtCinq;
    @FXML
    ImageView moinsCent;

    TirerPaquetImpl tirerPaquet;
    private final BlackJack blackJack;

    public GraphicsController(BlackJack blackJack){
        this.blackJack = blackJack;
        this.tirerPaquet = new TirerPaquetImpl(this.blackJack.getDeck());
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

        imagesMoins.add(moinsCinq);
        imagesMoins.add(moinsDix);
        imagesMoins.add(moinsVingtCinq);
        imagesMoins.add(moinsCent);
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
                    soldeSuffisant();
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        moinsCinq.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                if(blackJack.getJoueur().getBetSum() >= 5){
                    blackJack.getJoueur().bet(-5);
                    updateSolde();
                    updateBetLabel();

                    if(blackJack.getJoueur().getBetSum() == 0){
                        validBet.setDisable(true);
                    }
                    else{
                        validBet.setDisable(false);
                    }
                    soldeSuffisant();
                }
                else {
                    soldeInsuffisant();
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
                    soldeSuffisant();
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        moinsDix.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                if(blackJack.getJoueur().getBetSum() >= 10){
                    blackJack.getJoueur().bet(-10);
                    updateSolde();
                    updateBetLabel();

                    if(blackJack.getJoueur().getBetSum() == 0){
                        validBet.setDisable(true);
                    }
                    else{
                        validBet.setDisable(false);
                    }
                    soldeSuffisant();
                }
                else {
                    soldeInsuffisant();
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
                    soldeSuffisant();
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        moinsVingtCinq.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                if(blackJack.getJoueur().getBetSum() >= 25){
                    blackJack.getJoueur().bet(-25);
                    updateSolde();
                    updateBetLabel();

                    if(blackJack.getJoueur().getBetSum() == 0){
                        validBet.setDisable(true);
                    }
                    else{
                        validBet.setDisable(false);
                    }
                    soldeSuffisant();
                }
                else {
                    soldeInsuffisant();
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
                    soldeSuffisant();
                    validBet.setDisable(false);
                    updateSolde();
                    updateBetLabel();
                }
            }
        });

        moinsCent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                if(blackJack.getJoueur().getBetSum() >= 100){
                    blackJack.getJoueur().bet(-100);
                    updateSolde();
                    updateBetLabel();

                    if(blackJack.getJoueur().getBetSum() == 0){
                        validBet.setDisable(true);
                    }
                    else{
                        validBet.setDisable(false);
                    }
                    soldeSuffisant();
                }
                else {
                    soldeInsuffisant();
                }
            }
        });

        validBet.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                validBet.setDisable(true);
                actionBetView(false);
                moinsCent.setVisible(false);
                soldeSuffisant();

                blackJack.play();
                ArrayList<Carte> cartes = blackJack.getJoueur().getMain();
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

        buttonStand.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                buttonStand.setDisable(true);
                buttonHit.setDisable(true);

                while (blackJack.getCroupier().getMainValeur() <= 16) {
                    tirerPaquet.tirerCarte(blackJack.getCroupier());
                }
                setDealerCards(blackJack.getCroupier().getMain());

                if (blackJack.getCroupier().getMainValeur() > 21) {
                    endGame(true);
                } else if (blackJack.getCroupier().getMainValeur() > blackJack.getJoueur().getMainValeur()) {
                    endGame(false);
                } else {
                    endGame(true);
                }
            }
        });

        buttonHit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                tirerPaquet.tirerCarte(blackJack.getJoueur());
                setPlayerCards(blackJack.getJoueur().getMain());
                if ( blackJack.getJoueur().getMainValeur() > 21) {
                    endGame(false);
                    System.out.println("Défaite votre score dépasse 21");
                } else if (blackJack.getJoueur().getMainValeur() == 21) {
                    endGame(true);
                    System.out.println("Bravo vous avez 21");
                }

            }
        });

        buttonRestart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                reset();
            }
        });

        updateSolde();
        updateBetLabel();
    }

    // crée un code de triche
    public static void handleKeyPass(KeyCode code) {
        if(code == KeyCode.T){
            tappedText+="T";
        }else if(code == KeyCode.R){
            tappedText+="R";
        }else if(code == KeyCode.I){
            tappedText+="I";
        }else if(code == KeyCode.C){
            tappedText+="C";
        }else if(code == KeyCode.H){
            tappedText+="H";
        }else if(code == KeyCode.E){
            tappedText+="E";
        }else{
            tappedText = "";
        }

        if(tappedText.equals("TRICHE")){
            triche();
            tappedText = "";
        }
    }

    public static void triche(){
        JoueurSingleton.getInstance().addSolde(1000);
    }

    private void soldeInsuffisant(){
        //TODO: faire un evenement solde insuffisant
        labelWallet.setTextFill(javafx.scene.paint.Color.RED);
    }

    private void soldeSuffisant(){
        labelWallet.setTextFill(javafx.scene.paint.Color.WHITE);
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
        for (ImageView element : imagesMoins) {
            element.setVisible(bool);
        }
        validBet.setVisible(bool);
    }

    private void setPlayerCards(ArrayList<Carte> main){
        int compteurCarte = 0;
        for (Carte carte : main){
            System.out.println(carte.toString());
            cartesJoueur.get(compteurCarte).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(carte.imageSrc()))));
            compteurCarte++;
        }
        mainVal.setText("Valeur main : " + blackJack.getJoueur().getMainValeur());
    }

    private void setDealerCards(ArrayList<Carte> main){
        int compteurCarte = 0;
        for (Carte carte : main){
            System.out.println(carte.toString());
            cartesCroupier.get(compteurCarte).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(carte.imageSrc()))));
            compteurCarte++;
        }
        croupierMainVal.setText("Main Croupier : " + blackJack.getCroupier().getMainValeur());
    }

    private void resetAllCards(){

        for (ImageView carte : cartesJoueur) {
            carte.setImage(null);
        }
        for (ImageView carte : cartesCroupier) {
            carte.setImage(null);
        }
    }

    private void endGame(boolean status) {
        if (status ) {
            this.blackJack.getJoueur().setSolde(this.blackJack.getJoueur().getSolde() + this.blackJack.getJoueur().getBetSum() * 2);
        }
        //TOUT DESAC
        buttonHit.setVisible(false);
        buttonStand.setVisible(false);
        buttonHit.setDisable(false);
        buttonStand.setDisable(false);
        //afficher le texte
        if ( status ) {
            message.setText("Vous avez gagné !");
            soldeMessage.setText("+" + blackJack.getJoueur().getBetSum()*2 );
            soldeMessage.setTextFill(javafx.scene.paint.Color.web("#f9b427"));
        } else {
            message.setText("Vous avez perdu !");
            soldeMessage.setText("-" + blackJack.getJoueur().getBetSum() );
            soldeMessage.setTextFill(javafx.scene.paint.Color.RED);
        }
        message.setVisible(true);
        soldeMessage.setVisible(true);
        buttonRestart.setVisible(true);
        updateSolde();
        updateBetLabel();
        //TOUT REACTIVER
    }

    private void reset() {
        //RESET LES DEUX MAINS
        blackJack.getJoueur().mainReset();
        blackJack.getJoueur().setBetSum(0);
        blackJack.getCroupier().mainReset();
        blackJack.getDeck().reset();

        //RESET LE DECK
        //RESET LAFFICHAGE DES MAINS
        updateSolde();
        updateBetLabel();
        croupierMainVal.setVisible(false);
        mainVal.setVisible(false);


        // Remet les boutons pour parier
        actionBetView(true);

        message.setVisible(false);
        soldeMessage.setVisible(false);
        buttonRestart.setVisible(false);

        resetAllCards();
    }



}
