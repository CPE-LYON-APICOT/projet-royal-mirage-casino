package Models;

import java.util.Scanner;

public class Partie {

    private Joueur joueur;
    private Croupier croupier;
    private Paquet paquet;
    private boolean hasWon = false;
    private boolean isOver = false;
    private boolean hit = false;

    public Partie(Joueur joueur, Croupier croupier, Paquet paquet){
        this.joueur = joueur;
        this.croupier = croupier;
        this.paquet = paquet;
    }

    public boolean jouer() {
        croupier.ajouterCarte(paquet.tirerCarte());
        joueur.ajouterCarte(paquet.tirerCarte());
        joueur.ajouterCarte(paquet.tirerCarte());
        joueur.printMain();
        croupier.printMain();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1: Hit, 2: Stand");
        int hitInt = keyboard.nextInt();

        while (hitInt == 1 && joueur.getMainValeur() < 21) {
            joueur.ajouterCarte(paquet.tirerCarte());
            joueur.printMain();
            if (joueur.getMainValeur() > 21) {
                System.out.println("Vous avez dépassé 21!");
                return false;
            }
            System.out.println("1: Hit, 2: Stand");
            hitInt = keyboard.nextInt();
        }

        while (croupier.getMainValeur() < 16) {
            croupier.ajouterCarte(paquet.tirerCarte());
            croupier.printMain();
        }
        if (croupier.getMainValeur() > 21) {
            return false;
        }
        System.out.println("Mains finales: ");
        System.out.println("\t-Joueur: " + joueur.getMainValeur()); // Notez le '+' pour la concaténation
        System.out.println("\t-Croupier: " + croupier.getMainValeur());
        return joueur.getMainValeur() > croupier.getMainValeur() && joueur.getMainValeur() <= 21;
    }
}
