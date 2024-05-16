
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

L'objectif principal de notre projet était de développer un jeu de Blackjack tout en adoptant une architecture flexible permettant l'ajout ultérieur d'autres jeux de casino tels que le Poker, la Roulette, et d'autres encore. Nous voulions créer une base solide et modulaire pour faciliter l'expansion future du logiciel, en intégrant des principes de conception robustes et en utilisant les meilleures pratiques de développement.

## Résultat

Nous avons réussi à développer un jeu de Blackjack fonctionnel, y compris la gestion des mises du joueur. Le jeu permet une expérience utilisateur fluide et intègre les règles classiques du Blackjack. Cependant, malgré cette réussite, nous n'avons pas atteint notre objectif d'implémenter une structure facilitant l'ajout d'autres jeux de casino.

En outre, notre progression a été ralentie par des retards dans le développement de l'interface graphique. Notre but etait de se concentrer en partie sur d'abord realiser un jeu fonctionnel en ligne de commande, afin d'avoir une base solide sur laquelle derriere construire l'interface graphique.
Cependant, cela ne s'est pas avere tres utile, du fait que nous avons pratiquement du tout recommencer une fois l'interface graphique.
L'interface graphique a egalement elle ete ralentie du fait d'une mauvaise comprehension de l'utilisation des differents elements de JFX.

### Améliorations possibles

Nous pourrions mettre en place des animations plus poussée des différentes actions. Mais aussi faire un menu de jeu qui pourrait nous permettre de sélectionner notre jeu et d'en faire d'autre dans un second temps. Ce menu contiendrai une page permettant de rajouter des pièces sur son solde.

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

L'ajout et la modification de cartes est simplifiée par la conception du projet, les cartes et les types sont listées dans un Enum. Il suffit donc de rajouter un item dans l'enum pour rajouter une carte. Nous pouvons également à tout moment mettre en place une nouvelle strategie de distribution dans le blackjack.

### Faiblesses du code

Nous avons des parties reutilisables pour d'autres jeux, mais pas toutes. Par exemple, la classe  joueur ou cartes peuvent être facilement réutilisées dans les autres jeux avec leur methodes. Mais l'interface contient des méthodes qui sont spécifiques au jeu du black jack.
La gestion du controller est mauvaise et complexe avec trop de code à l'intérieur, on aurait du mieux répartir le code en essayant de plus le factoriser.

### Difficultés rencontrées

#### 1. [Gestion de l'interface]

Nous avons rencontrés des difficultés lors de la gestion de l'interface dynamique.
Gestion de l'interface dynamique. Pour corriger cela, nous avons utilise des listes d'elements graphiques pour pouvoir interagir avec toute la page selon les evenements et les interactions des utilisateurs.

#### 2. [Problemes dans l'ordre d'execution]

Nous avons eu des problemes car nous utilisions nos classes avant qu'elles soient completement instanciée et liées avec l'interface graphique. Nous avons eu le meme probleme avec des actions qui se faisaient avant ou après l'interface graphique.


### *Design Patterns* mis en oeuvre

#### 1. [Singleton]
Nous avons mis en place un Singleton pour recuperer la seule instance du joueur (utilisateur), ce Singleton sera utile pour les autres jeux et le menu. Le fait d'utiliser un Singleton nous a simplifié le code lors de l'utilisation de méthodes statiques (nécessaire pour l'interface graphique).


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
Nous faisons de l'injection de dépendances lors de la création de notre BlackJack notamment (voir ci-dessous)

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
Permet de redefinir la maniere dont on distribue les cartes. Cette stratégie a été mise en place dans le blackjack console mais n'est pas utilisable avec l'outil graphique.
```java
public interface IDistributionStrategie {
    public void Distribuer();
}
```

#### 4. [Observable]

Notre observable suit les différentes actions sur le clavier, dès que le mot triche est tapé, l'action est appelé.
Notre joueur aura ainsi 1000 pièces en plus.

```java
public static void handleKeyPass(KeyCode code) {
        if(code == KeyCode.T){
            tappedText+="T";
        }else if(code == KeyCode.R){
            tappedText+="R";
        }else if(code == KeyCode.I){
            tappedText+="I";
        }else if(code == KeyCode.C){
            tappedText+="C";
        }else if(code == KeyCode.H){
            tappedText+="H";
        }else if(code == KeyCode.E){
            tappedText+="E";
        }else{
            tappedText = "";
        }

        if(tappedText.equals("TRICHE")){
            triche();
            tappedText = "";
        }
    }

    public static void triche(){
        JoueurSingleton.getInstance().addSolde(1000);
    }
```

---
# Partie pédagogique


### En quoi la POO vous a été utile

Dans notre application la POO est indispensable pour ne pas avoir à rééecrire notre code pour d'autres jeux sur la meme application (projet initial). Ici cela nous permet d'avoir un seul joueur pour tous les jeux qui a un solde et des informations qui lui sont propre. Les actions qu'il peut réaliser peuvent être faite dans tous les jeux comme miser par exemple. La POO permet la maintenabilité, c'est à dire que le code est divisé en pleins de petites parties qui sont donc plus facilement débuggable. La POO nous permet également de mettre en place de nouvelles règles ou différentes manieres de jouer avec les strategies notamment. Il est aussi plus simple de gérer l'interface graphique avec la POO avec l'utilisation des différentes classes et controlleurs. La POO permet de faciliter la collaboration pour coder, en effet le code etant structuré et plus visuel le travail en équipe est plus simple.

### Conclusion

Le projet nous a permit de redécouvrir la notion d'injection de dépendance et de l'utiliser de manière poussée, cela nous a facilité notre code en diminuant sa taille et en le rendant plus simple et compréhensible.