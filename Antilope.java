// Fichier :     Antilope.java
// Création:     30 mars 2022
// Auteurs :     Alexandre Stang (20211138) et Louis-Antoine Martel-Marquis (20217669)  
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Antilope
    extends Animal

**/

public class Antilope extends Animal {

    public static int AGEMAX = 15;

    public Antilope(double facteurCroissance) {
        this.age = 0;
        this.ageMax = AGEMAX;
        this.ageMature = 2;
        this.masse = 10;
        this.facteurCroissance = facteurCroissance;
        this.estPredateur = false;
        this.estProie = true;
        this.estVivant = true;
    }

    @Override
    public Animal accoucher() {
        return new Antilope(facteurCroissance);
    }

}


    // TO BE COMPLETED //
