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

    public Partie(Joueur joueur, Croupier croupier, DistributionStrategie distributionStrategie) {
        this.joueur = joueur;
        //this.distributionStrategie = ctx.getBean(DistributionStrategieTriche.class);
        this.croupier = croupier;
        this.distributionStrategie = distributionStrategie;
    }

    public boolean jouer() {
        distributionStrategie.Distribuer();

        return joueur.getMainValeur() > croupier.getMainValeur() && joueur.getMainValeur() <= 21;
    }
}
