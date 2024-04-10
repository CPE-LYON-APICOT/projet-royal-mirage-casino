package tp.Models;

import org.springframework.context.ApplicationContext;
import tp.interfaces.IDistributionStrategie;
import tp.interfaces.ITirerPaquet;
import tp.interfaces.TirerPaquetImpl;
import tp.strategies.DistributionStrategie;
import tp.strategies.DistributionStrategieTriche;

import java.util.Scanner;

public class Partie {

    private Joueur joueur;
    private Croupier croupier;
    private IDistributionStrategie distributionStrategie;
    //private Paquet paquet;
    private boolean hasWon = false;
    private boolean isOver = false;
    private boolean hit = false;
    private TirerPaquetImpl tirerPaquet;
    public Partie(Joueur joueur, Croupier croupier, IDistributionStrategie distributionStrategie){
        this.joueur = joueur;
        //this.distributionStrategie = ctx.getBean(DistributionStrategieTriche.class);
        this.croupier = croupier;
        this.distributionStrategie = distributionStrategie;
    }

    public boolean jouer() {
        this.tirerPaquet.tirerCarte(croupier);
        this.tirerPaquet.tirerCarte(joueur);
        this.tirerPaquet.tirerCarte(joueur);

        joueur.printMain();
        croupier.printMain();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1: Hit, 2: Stand");
        int hitInt = keyboard.nextInt();

        while (hitInt == 1 && joueur.getMainValeur() < 21) {
            this.tirerPaquet.tirerCarte(joueur);
            joueur.printMain();
            if (joueur.getMainValeur() > 21) {
                System.out.println("Vous avez dépassé 21!");
                return false;
            }
            System.out.println("1: Hit, 2: Stand");
            hitInt = keyboard.nextInt();
        }

        while (croupier.getMainValeur() < 16) {
            this.tirerPaquet.tirerCarte(croupier);
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
