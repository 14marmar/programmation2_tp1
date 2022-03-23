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

    @Override
    public void vieillir() {
        // TODO Auto-generated method stub
        age++;
        masse = masse * facteurCroissance;

        if (age > ageMax) {
            mourir();
        }
    }

    @Override
    public void manger() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Animal accoucher() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void mourir() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean estVivant() {
        return estVivant;
    }

    @Override
    public boolean estMature() {
        
        if (age >= ageMature) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void setProie(boolean proie) {
        this.estProie = proie;
    }

    @Override
    public boolean estProie() {
        return estProie;
    }

    @Override
    public void setPredateur(boolean predateur) {
        this.estPredateur = predateur;
    }

    @Override
    public boolean estPredateur() {
        return estPredateur;
    }

    @Override
    public double getMasse() {
        return masse;
    }

    @Override
    public void setMasse(double masse) {
        this.masse = masse;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getAgeMax() {
        return ageMax;
    }

    @Override
    public int getAgeMature() {
        return ageMature;
    }


}
