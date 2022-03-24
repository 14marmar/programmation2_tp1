// Fichier :     Population.java
// Création:     30 mars 2022
// Auteurs :     Alexandre Stang (20211138) et Louis-Antoine Martel-Marquis (20217669)
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Population
    implements EcoSysteme, Iterable<Animal>

**/

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

// Defines a population of herb and animals (preys and predators), iterable
public class Population implements EcoSysteme, Iterable<Animal> {

    // TO BE COMPLETED //
    private ArrayList<Animal> individus = new ArrayList<>();

    public Population(Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs) {

        // TO BE COMPLETED //

    }

    public int getNombreProies() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getNombrePredateurs() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getNombreProiesMatures() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getNombrePredateursMatures() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getNombreProiesChassables() {
        // TODO Auto-generated method stub
        return 0;
    }

    public ArrayList<Animal> getIndividus() {
        // TO BE COMPLETED //
        return this.individus;
    }

    public double masseProies() {
        // TODO Auto-generated method stub
        return 0;
    }

    public double massePredateurs() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void vieillir() {
        // TODO Auto-generated method stub
        
    }

    public void chasser() {
        // TODO Auto-generated method stub
        
    }

    public void reproduire() {
        // TODO Auto-generated method stub
        
    }

    public void melanger() {
        Collections.shuffle(this.individus, new Random(4));
    }

    public Iterator<Animal> iterator() {
        return null;
    }

}
