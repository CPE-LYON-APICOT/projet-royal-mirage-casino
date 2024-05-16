package tp.Models;

import org.springframework.stereotype.Component;

@Component
public class Joueur extends Personne{
    private int solde;
    private int betSum;

    public Joueur(){
        this.solde = 100;
    }

    public void setSolde(int solde){
        this.solde = solde;
    }

    public int getSolde(){
        return this.solde;
    }

    public int bet(int value){
        if(value > this.solde){
            System.out.println("Joueur - bet - Pas assez d'argent");
            return 0;
        }
        this.betSum += value;
        this.solde-=value;
        return value;
    }

    public int getBetSum(){
        return this.betSum;
    }

    @Override
    public void printMain() {
        System.out.println("Main du joueur: ");
        super.printMain();
    }

    public void addSolde(int solde){
        this.solde += solde;
    }
}
