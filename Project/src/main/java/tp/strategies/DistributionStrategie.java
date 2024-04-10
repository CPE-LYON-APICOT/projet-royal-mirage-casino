package tp.strategies;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tp.Models.Croupier;
import tp.Models.Joueur;
import tp.Models.Paquet;
import tp.interfaces.IDistributionStrategie;
import tp.interfaces.ITirerPaquet;
import tp.interfaces.TirerPaquetImpl;

@Component
@Primary
public class DistributionStrategie implements IDistributionStrategie {
    private ITirerPaquet tirerPaquet;
    private Joueur joueur;
    private Croupier croupier;

    public DistributionStrategie(TirerPaquetImpl tirerPaquet, Joueur joueur, Croupier croupier) {
        this.tirerPaquet = tirerPaquet;
        this.joueur = joueur;
        this.croupier = croupier;

    }

    public void distribClassique() {
        tirerPaquet.tirerCarte(joueur);
        tirerPaquet.tirerCarte(croupier);
        tirerPaquet.tirerCarte(joueur);
    }



    @Override
    public void Distribuer() {
        distribClassique();
    }
}
