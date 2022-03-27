// Fichier :     Lion.java
// Création:     30 mars 2022
// Auteurs :     Alexandre Stang (20211138) et Louis-Antoine Martel-Marquis (20217669)
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Lion
    extends Animal

**/

public class Lion extends Animal {

    public static int AGEMAX = 50;
    
    public Lion(double facteurCroissance) {
        this.age = 0;
        this.ageMax = AGEMAX;
        this.ageMature = 5;
        this.masse = 10;
        this.facteurCroissance = facteurCroissance;
        this.estPredateur = true;
        this.estProie = false;
        this.estVivant = true;
    }

    @Override
    public Animal accoucher() {
        return new Lion(facteurCroissance);
    }

}

    // TO BE COMPLETED //
