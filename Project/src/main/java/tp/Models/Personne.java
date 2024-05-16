package tp.Models;

import org.springframework.stereotype.Component;
import tp.interfaces.Miser;

import java.util.ArrayList;
import java.util.List;
@Component
public abstract class Personne implements Miser {
    private ArrayList<Carte> main;

    public Personne() {
        this.main = new ArrayList<>();
    }

    public void ajouterCarte(Carte carte) {
        this.main.add(carte);
    }

    public int getMainValeur() {
        return main.stream().mapToInt(Carte::getValeur).sum();
    }

    public ArrayList<Carte> getMain(){
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
        System.out.println("HAHAHAHAICI");
        this.main.clear();
        this.main = new ArrayList<>();
        for (Carte carte : main) {
            System.out.println(carte.toString());
        }
    }
}
