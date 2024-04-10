package tp.Singleton;

import tp.Models.Joueur;

public class JoueurSingleton {
    /*private static JoueurSingleton instance = null;*//**/
    private static Joueur instance = null;
    private int solde;

    private JoueurSingleton(){
        instance = new Joueur();
    }

    public static Joueur getInstance(){
        if(instance == null){
            instance = new Joueur();
        }
        return instance;
    }

    public void setSolde(int solde){
        instance.setSolde(solde);
    }

    public int getSolde(){
        return instance.getSolde();
    }
}
