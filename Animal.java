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
   class Animal
    implements the Prey/Predator relationship

**/

public class Animal implements ProiePredateur {

    protected int age, ageMax, ageMature;
    protected double masse, facteurCroissance;
    protected boolean estPredateur, estProie, estVivant;

    public void vieillir() {
        age++;
        masse = masse * facteurCroissance;

        if (age > ageMax) {
            mourir();
        }
    }

    public void manger() {
        
        
    }

    public Animal accoucher() {
        return null;
    }

    public void mourir() {
        estVivant = false;
    }

    public boolean estVivant() {
        return estVivant;
    }

    public boolean estMature() {

        if (age >= ageMature) {
            return true;
        } else {
            return false;
        }

    }

    public void setProie(boolean proie) {
        this.estProie = proie;
    }

    public boolean estProie() {
        return estProie;
    }

    public void setPredateur(boolean predateur) {
        this.estPredateur = predateur;
    }

    public boolean estPredateur() {
        return estPredateur;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) {
        this.masse = masse;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public int getAgeMature() {
        return ageMature;
    }

    


}
