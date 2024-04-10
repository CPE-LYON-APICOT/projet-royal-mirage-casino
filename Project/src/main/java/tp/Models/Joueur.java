package tp.Models;

import org.springframework.stereotype.Component;

@Component
public class Joueur extends Personne{
    private int solde;

    public Joueur(){
        this.solde = 100;
    }

    public void setSolde(int solde){
        this.solde = solde;
    }

    public int getSolde(){
        return this.solde;
    }

    @Override
    public void printMain() {
        System.out.println("Main du joueur: ");
        super.printMain();
    }
}
