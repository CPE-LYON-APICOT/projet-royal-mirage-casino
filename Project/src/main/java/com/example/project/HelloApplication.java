package com.example.project;

import Models.BlackJack;
import Models.Croupier;
import Models.Joueur;
import Models.Personne;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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

    public static void main(String[] args) {
        Joueur joueur = new Joueur();
        BlackJack blackJack = new BlackJack(joueur);
        blackJack.start();
/*
        GameGraphics.start();
*/
    }
}