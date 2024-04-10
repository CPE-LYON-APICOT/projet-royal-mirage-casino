package tp.Models;

import org.springframework.stereotype.Component;
import tp.Enum.Types;
import tp.Enum.Figures;

public class Carte {
    private int valeur;
    private Types type;
    private Figures figure;

    public Carte(int valeur, Types type){

        this.valeur = valeur;

        this.figure = Figures.getFigure(this.valeur - 1);
        if (this.valeur > 10){
            this.valeur = 10;
        }

        this.type = type;
    }

    public int getValeur(){
        return this.valeur;
    }

    public String toString(){
        System.out.println(this.figure + " de " + this.type + " avec une valeure de " + this.valeur);
        return "";
    }
}
