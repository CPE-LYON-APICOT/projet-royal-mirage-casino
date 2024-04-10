package tp.strategies;


import org.springframework.stereotype.Component;
import tp.Models.Croupier;
import tp.Models.Joueur;
import tp.interfaces.IDistributionStrategie;
import tp.interfaces.ITirerPaquet;
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

    }

    @Override
    public void Distribuer() {
        distribTriche();
    }
}