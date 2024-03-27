package Models;

import interfaces.Miser;

import java.util.ArrayList;
import java.util.List;

public abstract class Personne implements Miser {
    private List<Carte> main;

    public Personne() {
        this.main = new ArrayList<>();
    }

    public void ajouterCarte(Carte carte) {
        main.add(carte);
    }

    public int getMainValeur() {
        return main.stream().mapToInt(Carte::getValeur).sum();
    }

    public void printMain(){
        for (Carte carte : main) {
            System.out.println(carte);
        }
        System.out.println("Valeur totale: " + getMainValeur());
        System.out.println("-----");
    }

    public void mainReset() {
        main.clear();
    }
}
