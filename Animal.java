import java.util.Collections;

// Fichier :     Animal.java
// Création:     30 mars 2022
// Auteurs :     Alexandre Stang (20211138) et Louis-Antoine Martel-Marquis (20217669)
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
 * class Animal
 * implements the Prey/Predator relationship
 * 
 **/

public class Animal implements ProiePredateur {

    protected int age, ageMax, ageMature; // animal's current age, maximum age and mature age
    protected double masse, facteurCroissance; // animal's current max and growth factor
    protected boolean estPredateur, estProie, estVivant; // determines whether an animal is prey or predator; alive or
                                                         // dead

    // makes an animal grow older
    public void vieillir() {
        age++; // increase an animal's age by 1
        masse = masse * facteurCroissance; // multiply an animal's mass by its growth factor to increase set mass

        // if an animal's age exceeds their species' maximum age ...
        if (age > ageMax) {
            mourir(); // it dies
        }
    }

    // implementation of eating method
    public void manger() {
    }

    // implementation of birth method
    public Animal accoucher() {
        return null;
    }

    // sets animal as dead
    public void mourir() {
        estVivant = false;
    }

    // boolean that sets animal as living
    public boolean estVivant() {
        return estVivant;
    }

    // boolean that sets animal as mature if it grows old enough
    public boolean estMature() {

        if (age >= ageMature) {
            return true;
        } else {
            return false;
        }

    }

    // prey setter
    public void setProie(boolean proie) {
        this.estProie = proie;
    }

    // boolean that sets animal as prey
    public boolean estProie() {
        return estProie;
    }

    // predator setter
    public void setPredateur(boolean predateur) {
        this.estPredateur = predateur;
    }

    // boolean that sets animal as predator
    public boolean estPredateur() {
        return estPredateur;
    }

    // mass getter
    public double getMasse() {
        return masse;
    }

    // mass setter
    public void setMasse(double masse) {
        this.masse = masse;
    }

    // age setter
    public void setAge(int age) {
        this.age = age;
    }

    // age getter
    public int getAge() {
        return age;
    }

    // max age getter
    public int getAgeMax() {
        return ageMax;
    }

    // mature age getter
    public int getAgeMature() {
        return ageMature;
    }

}
