
# Retro-conception

**Binome 1 : [BOUVIER Gaston]**
**Binome 2 : [ADAM Emilien]**

Complétez ce document pour décrire votre projet, les difficultés rencontrées, les design patterns mis en oeuvre, les améliorations possibles, et en quoi la POO vous a été utile.

> **Faites le avec sérieux, ce document ainsi que votre code seront évalués.**
Si vous considérez que votre code est quasi-parfait, je vais chercher les erreurs et en trouver, et cela vous pénalisera.
Si vous êtes critique envers vous-même et que vous expliquez correctement vos difficultés, vous serez "à moitié" pardonné.

Ce n'est pas grave de ne pas avoir été au bout de ce que vous vouliez faire, comportez vous comme un ingénieur qui doit rendre des comptes à son client, et qui doit expliquer pourquoi il n'a pas pu tout faire.
Pour rappel le client n'est pas un developpeur (sinon il ne vous aurait pas payé une fortune pour le faire à sa place), vous devez lui expliquer de manière simple et claire les problèmes rencontrés, en vous justifiant 
>Imaginez que vous avez codé Mortal Kombat 
Ne dites pas "je n'ai pas eu le temps de tout faire", mais plutôt "j'ai préféré me concentrer sur la création des spectaculaires "Finish Him" des personnages car c'est un élément essentiel du gameplay, cependant la difficulté dynamique en fonction de la maîtrise du joueur n'a pas pu être implémentée à temps, compte tenu que les critères de maîtrises sont difficilement modélisables, toutefois nous pourrions envisager d'implémenter que plus le combat dure longtemps, plus les coups portés sont puissants, ce qui est rapide à implémenter et lors d'une mise à jour, nous pourrions remplacer ce système par quelque chose de plus élaboré"

Aussi, en entreprise, vous serez confronté à des programmes très mal codés, et vous allez galérer à les comprendre, vous risquez d'essayer de les corriger et tomber dans les mêmes ecueils que les développeurs précédents.
Pour cela, il est courrant de tenir un jour un Document d'Architecture Technique (DAT) qui explique comment fonctionne le programme, et comment le reprendre ainsi qu'un document de réversibilité qui explique comment reprendre le code de quelqu'un d'autre.
(C'est obligatoire pour les marchés publics de prévoir une réversibilité, c'est à dire que le client peut vous dégager et une autre entreprise doit pouvoir reprendre votre code sans difficulté)
Dans ces documents, il ne s'agit pas de cacher la poussière sous le tapis, il faut être honnête et proposer une vision d'ensemble de votre code, et expliquer pourquoi vous avez fait des choix, et pourquoi vous n'avez pas fait d'autres choix, il est souvent question de compromis (on fait un truc pas ouf pour gagner du temps, mais la qualité du code en pâtit, etc.)
> Vous pouvez dire : "Pour la gestion des collisions, nous utilisons une librairie tierce, toutefois celle-ci ne gère que les collisions entre des rectangles, au fur et à mesure des itérations, des ennemis de grande taille et de forme complexe sont apparus, toutefois, nous avons conservé une hitbox rectangulaire, en résulte que le joueur peut être touché alors que visuellement, il n'est pas en contact avec l'ennemi ; nous avions également envisagé de créer plusieurs hitbox de tailles différentes sur un même ennemi afin de mieux coller à la forme de celui-ci, toutefois, les performances du jeu ont étés trop dégradées"



---
# Partie "Client" (pas trop technique) :

## Objectif du projet

Notre but etait de mettre en place avec un jeu de Blackjack, mais avec une conception qui permettait d'implementer d'autres jeux de casino (Poker, Roulette...).

## Résultat

Nous avons pu mettre en place le jeu de Blackjack avec les mises du joueur. Cependant, il manque les aspects permettant une implementation simple des autres jeux. 

### Améliorations possibles

Mises en place d'animation, gestion plus propre du fil du jeu et de l'architecture global et mise en place d'un autre jeu

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

[Si pendant votre implémentation, vous trouvez que vous pouvez être particulièrment fiers d'une partie de votre code, décrivez là ici ; par exemple si vous avez généré une carte de manière procédurale, ou à l'aide d'un fichier]

### Faiblesses du code

Nous avons des parties reutilisables pour d'autre jeux, mais pas toutes. Par exemple, la classe croupier ou cartes peuvent etre facilement reutilisees dans les autres jeux avec leur methodes. Mais les mises par exemple, ne sont pour l'instant pas reutilisable.
De plus, notre maitrise de JFX etant limitee, la gestion du controller est assez brouillon et complexe avec beaucoup de code dedans.

### Difficultés rencontrées

#### 1. [Génération dynamique des ... pour ...]

Gestion de l'interface dynamique. Pour corriger cela, nous avons utilise des listes d'elements grapgiques pour pouvoir interagir avec toute la page selon les evenements et les interactions des utilisateurs.

Instaciation des classes aux bons moments. Nous avions des problemes sur quelles classes etaient instanciees quand, selon quand la fenetre se lance, si la partie commance ect... Nous avonc utilises des injections de dependances pour les crees dans le controller pour les recuperer.

Nombreux problemes sur JFX, resolution de bugs basique.

#### 2. [Gestion des collisions]

[Exemple : Nous n'avons pas réussi à gérer les collisions, PARCE QUE, mes objets n'héritaient pas d'une classe commune, car nos objets héirtaient de ... et nos personnages de ...]


### *Design Patterns* mis en oeuvre

#### 1. [Singleton]
Nous avons mis en place un Singleton pour recuperer la seule instance du joueur (utilisateur):


```java
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
}
```

#### 2. [Injection de dependances]
On ecrit plus de new Class()...

```java
@Component
public class BlackJack {

    private final Paquet deck;
    private final Joueur joueur;
    private final Croupier croupier;

    public BlackJack(Paquet paquet, Croupier croupier){
        this.deck = paquet;
        this.joueur = JoueurSingleton.getInstance();
        this.croupier = croupier;
    }
```

#### 3. [Strategies]
Permet de redefinir la maniere dont on distribue les classes
```java
public interface IDistributionStrategie {
    public void Distribuer();
}
```

#### 4. [Strategies]

---
# Partie pédagogique


### En quoi la POO vous a été utile

[Par exemple, expliquez que vous auriez éprouvé des difficultés à gérer les collisions si vous n'aviez pas utilisé la POO, ou que vous avez pu facilement ajouter des fonctionnalités à votre jeu grâce à la POO
Minimum 10 lignes (personnalisé en fonction de votre projet)]

### Conclusion

[Décrivez ici si vous avez compris un concept particulier que vous n'aviez pas compris en cours, inversement si vous pensiez qu'il était possible de faire qqchose mais que cela ne s'est pas passé comme prévu]