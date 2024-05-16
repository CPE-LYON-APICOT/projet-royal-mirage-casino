package tp.Models;

import org.springframework.stereotype.Component;
import tp.Singleton.JoueurSingleton;
import tp.interfaces.TirerPaquetImpl;
import tp.interfaces.TirerPaquetImplTricheDecorator;
import tp.strategies.DistributionStrategie;

import java.util.Scanner;
@Component
public class BlackJack {

    private final Paquet deck;
    private final Joueur joueur;
    private final Croupier croupier;

    public BlackJack(Paquet paquet, Croupier croupier){
        this.deck = paquet;
        this.joueur = JoueurSingleton.getInstance();
        this.croupier = croupier;
    }

    public void play(){
        this.deck.reset();
        this.joueur.mainReset();
        this.croupier.mainReset();
        Partie partie = new Partie(joueur, croupier, new DistributionStrategie(new TirerPaquetImpl(deck), joueur, croupier));
        partie.jouer();
    }

    public void playTriche(){
        this.deck.reset();
        this.joueur.mainReset();
        this.croupier.mainReset();
        /*
        Partie partie = new Partie(joueur, croupier, new DistributionStrategie(new TirerPaquetImplTricheDecorator(deck), joueur, croupier));
        partie.jouer();
        */
    }

    public void start() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Lancer une partie ? 1. Oui 2. Non");
        int play =  keyboard.nextInt();
        while (play == 1) {
            System.out.println("Solde: " + joueur.getSolde());
            System.out.println("Combien voulez-vous miser ?");
            int mise = keyboard.nextInt();
            boolean hasWon = new Partie(joueur, croupier, new DistributionStrategie(new TirerPaquetImpl(deck), joueur, croupier)).jouer();
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

    public Paquet getDeck() {
        return deck;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Croupier getCroupier() {
        return croupier;
    }
}
