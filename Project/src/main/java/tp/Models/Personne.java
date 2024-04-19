package tp.Models;

import org.springframework.stereotype.Component;
import tp.interfaces.Miser;

import java.util.ArrayList;
import java.util.List;
@Component
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

    public List<Carte> getMain(){
        return this.main;
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
