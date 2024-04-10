package tp.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tp.Enum.Types;
import org.springframework.stereotype.Component;

@Component
public class Paquet {
    private List<Carte> cartes;

    public Paquet () {
        this.cartes = new ArrayList<>();

        for (Types type : Types.values()) {
            for (int i = 1; i <= 13; i++) {
                this.cartes.add(new Carte(i, type));
            }
        }
        Collections.shuffle(this.cartes);
    }

    public Carte tirerCarte() {
        if (!cartes.isEmpty()) {
            return cartes.remove(0); // Retire et retourne la première carte du deck
        }
        return null;
    }

    public void reset() {
        this.cartes.clear();
        for (Types type : Types.values()) {
            for (int i = 1; i <= 13; i++) {
                this.cartes.add(new Carte(i, type));
            }
        }
        Collections.shuffle(this.cartes);
    }
}
