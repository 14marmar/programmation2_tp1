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
 * class Antilope
 * extends Animal
 * 
 **/

public class Antilope extends Animal {

    public static int AGEMAX = 15; // animal's max age before death

    // constructor
    // defines : animal's age upon birth
    // animal's max age before death
    // animal's age upon which it's considered an adult
    // animal's mass upon birth
    // animal's growth factor
    // whether animal is predator or prey
    // sets animal as alive
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

    // simulates the birth of an animal
    @Override
    public Animal accoucher() {
        return new Antilope(facteurCroissance); // return a new antilope (calf)
    }

}