package tp.interfaces;

import tp.Models.Personne;

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