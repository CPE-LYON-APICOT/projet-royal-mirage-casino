package tp.strategies;


import org.springframework.stereotype.Component;
import tp.Models.Croupier;
import tp.Models.Joueur;
import tp.Models.Paquet;
import tp.interfaces.IDistributionStrategie;
import tp.interfaces.ITirerPaquet;
import tp.interfaces.TirerPaquetImpl;
import tp.interfaces.TirerPaquetImplTricheDecorator;

@Component
public class DistributionStrategieTriche implements IDistributionStrategie {
    private ITirerPaquet tirerPaquet;
    private Joueur joueur;
    private Croupier croupier;

    public DistributionStrategieTriche(TirerPaquetImplTricheDecorator tirerPaquet, Joueur joueur, Croupier croupier) {
        this.tirerPaquet = tirerPaquet;
        this.joueur = joueur;
        this.croupier = croupier;

    }

    public void distribTriche() {
        tirerPaquet.tirerCarte(joueur);

        joueur.ajouterCarte(paquet.tirerCarte());
        croupier.ajouterCarte(paquet.tirerCarte());
        joueur.ajouterCarte(paquet.tirerCarte());
        var carte = paquet.tirerCarte();
        while (carte.getValeur() > 10) {
            carte = paquet.tirerCarte();
        }
        croupier.ajouterCarte(carte);
    }

    @Override
    public void Distribuer() {
        distribTriche();
    }
}