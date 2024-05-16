package tp.interfaces;

import tp.Models.Paquet;
import tp.Models.Personne;
import org.springframework.stereotype.Component;

@Component()
public class TirerPaquetImpl implements ITirerPaquet {
    private Paquet paquet;
    public TirerPaquetImpl(Paquet paquet) {
        this.paquet = paquet;
    }
    @Override
    public void tirerCarte(Personne personne) {
        personne.ajouterCarte(paquet.tirerCarte());
    }

}
