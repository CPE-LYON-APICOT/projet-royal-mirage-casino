package tp.interfaces;

import org.springframework.stereotype.Component;
import tp.Models.Personne;

@Component
public class TirerPaquetImplTricheDecorator implements ITirerPaquet {
    private ITirerPaquet tirerPaquet;
    public TirerPaquetImplTricheDecorator(ITirerPaquet tirerPaquet) {
        this.tirerPaquet = tirerPaquet;
    }
    @Override
    public void tirerCarte(Personne personne) {
        tirerPaquet.tirerCarte(personne);
        System.out.println("Carte trichee tiree");
    }

}