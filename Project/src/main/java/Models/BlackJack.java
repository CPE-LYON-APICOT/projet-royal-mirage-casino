package Models;

import java.util.Scanner;

public class BlackJack {

    private final Paquet deck;
    private final Joueur joueur;
    private final Croupier croupier;

    public BlackJack(Joueur joueur){
        this.deck = new Paquet();
        this.joueur = joueur;
        this.croupier = new Croupier();
    }

    public void start(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Lancer une partie ? 1. Oui 2. Non");
        int play =  keyboard.nextInt();
        while (play == 1) {
            System.out.println("Solde: " + joueur.getSolde());
            System.out.println("Combien voulez-vous miser ?");
            int mise = keyboard.nextInt();
            boolean hasWon = new Partie(joueur, croupier, deck).jouer();
            this.deck.reset();
            this.joueur.mainReset();
            this.croupier.mainReset();
            System.out.println(hasWon ? "Vous avez gagné!" : "Vous avez perdu!");
            if (hasWon) {
                joueur.setSolde(joueur.getSolde() + mise * 2);
            } else {
                joueur.setSolde(joueur.getSolde() - mise);
            }
            System.out.println("Solde: " + joueur.getSolde());
            System.out.println("Lancer une partie ? 1. Oui 2. Non");
            play =  keyboard.nextInt();
            System.out.println("Combien voulez-vous miser ?");
            mise = keyboard.nextInt();
            System.out.println("-----------------");
        }
    }


}
