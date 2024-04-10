package tp.Models;

import org.springframework.stereotype.Component;

@Component
public class Croupier extends Personne {

    @Override
    public void printMain() {
        System.out.println("Main du croupier: ");
        super.printMain();
    }
}
