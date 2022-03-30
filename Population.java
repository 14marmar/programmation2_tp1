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

    private Herbe herbe; // Quantity of herbs

    // array composed of the savana's animals
    private ArrayList<Animal> individus = new ArrayList<>();

    // constructor
    // assigns : initial amount of preys and predators in the array
    // quantity of herb
    public Population(Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);
        this.herbe = herbe;

    }

    // determines number of antelopes in the array
    public int getNombreProies() {
        int nombreProies = 0; // initial number of antelopes

        // in the array of animals ...
        for (Animal a : getIndividus()) {
            // if the current animal is an antelope ...
            if (a.estProie()) {
                nombreProies++; // increase the number of antelopes
            }
        }

        return nombreProies; // return the amount
    }

    // determines number of lions in the array
    public int getNombrePredateurs() {
        int nombrePredateurs = 0; // initial number of lions

        // in the array of animals ...
        for (Animal a : getIndividus()) {
            // if the current animal is a lion ...
            if (a.estPredateur()) {
                nombrePredateurs++; // increase the number of lions
            }
        }

        return nombrePredateurs; // return the amount
    }

    // determines number of mature antelopes in the array
    public int getNombreProiesMatures() {
        int nombreProiesMatures = 0; // initial number of mature antelopes

        // in the array of animals ...
        for (Animal a : getIndividus()) {
            // if the current animal is a mature antelope...
            if (a.estProie() && a.estMature()) {
                nombreProiesMatures++; // increase the number of mature antelopes
            }
        }

        return nombreProiesMatures; // return the amount
    }

    // determines number of mature lions in the array
    public int getNombrePredateursMatures() {
        int nombrePredateursMatures = 0;// initial number of mature lions

        // in the array of animals ...
        for (Animal a : getIndividus()) {
            // if the current animal is a mature lion ...
            if (a.estPredateur() && a.estMature()) {
                nombrePredateursMatures++; // increase the number of mature lions
            }
        }

        return nombrePredateursMatures; // return the amount
    }

    // determines the amount of antelopes that can be hunted
    public int getNombreProiesChassables() {
        double nombreProies = getNombreProies(); // total number of antelopes
        double nombreProiesChassablesDouble = Math.floor(nombreProies * 0.20); // calculate 20% of the antelope
                                                                               // population
        int nombreProiesChassables = (int) nombreProiesChassablesDouble; // number of antelopes that can be hunted

        return nombreProiesChassables; // return the amount
    }

    // animal getter in the array
    public ArrayList<Animal> getIndividus() {
        return this.individus;
    }

    // determines the antelopes' total mass
    public double masseProies() {
        double masseProies = 0; // initial total mass

        // in the array of animals ...
        for (Animal a : getIndividus()) {
            // if current animal is an antelope ...
            if (a.estProie()) {
                masseProies += a.getMasse(); // add its mass to the total amount
            }
        }

        return masseProies; // return the amount
    }

    // determines the lions' total mass
    public double massePredateurs() {
        double massePredateurs = 0; // initial total mass

        // in the array of animals ...
        for (Animal a : getIndividus()) {
            // if current animal is a lion ...
            if (a.estPredateur()) {
                massePredateurs += a.getMasse(); // add its mass to the total amount
            }
        }

        return massePredateurs; // return the amount
    }

    // makes animals age
    public void vieillir() {

        // make the herb age
        herbe.vieillir();

        // for each animal in the array of animal...
        for (Animal a : getIndividus()) {
            a.vieillir(); // make them grow older
        }

        // remove the dead animals from the array
        tuerAnimaux();

    }

    // make the animals feed themselves
    public void chasser() {
        melanger(); // shuffle the order of animals in the array

        int nombreProiesChassables = getNombreProiesChassables(); // number of antelopes that can be hunted
        int nombreProiesChassees = 0; // number of hunted antelopes
        double herbeDisponible = herbe.getMasseAnnuelle(); // amount of herb that can be eaten

        for (Animal a : getIndividus()) {

            double masseNecessaire = a.getMasse() * 2; // necessary amount of mass that an animal needs to consume to
                                                       // sustain itself
            // if current animal a is a living antelope ...
            if (a.estProie() && a.estVivant()) {
                // and if there remains enough grass to feed it ...
                if (masseNecessaire <= herbeDisponible) {
                    // remove said amount
                    herbeDisponible -= masseNecessaire;
                    // a.manger();
                } else {
                    a.mourir();
                }
                // if current animal a is a living lion ..
            } else if (a.estPredateur() && a.estVivant()) {
                // and if there remains enough antelopes that can be hunted ...
                if (nombreProiesChassees < nombreProiesChassables) {
                    // find the next antelope b to be hunted if it exists
                    for (Animal b : getIndividus()) {
                        if (b.estProie() && b.estVivant()) {
                            // a.manger();
                            // remove mass needed to be eaten and increase number of hunted preys
                            masseNecessaire -= b.getMasse();
                            nombreProiesChassees++;
                            b.mourir();

                            // move on to the next animal if the lion has been fed or starved to death
                            if (masseNecessaire <= 0) {
                                break;
                            } else if (nombreProiesChassees >= nombreProiesChassables) {
                                a.mourir();
                                break;
                            }
                        }
                    }
                } else {
                    a.mourir();
                }
            }
        }

        // set the correct mass of herb left
        herbe.setMasseAnnuelle(herbeDisponible);
        // remove the dead animals from the array
        tuerAnimaux();

    }

    // make the animals breed
    public void reproduire() {

        int nombreBebesProies = 0; // Number of antelope calfs born so far
        int nombreBebesPredateurs = 0; // Number of lion cubs born so far

        int nombreBebesProiesAttendues = (int)Math.floor(getNombreProiesMatures()/2); // Expected number of calfs to be born
        int nombreBebesPredateursAttendues = (int)Math.floor(getNombrePredateursMatures()/2); // Expected number of cubs to be born

        ArrayList<Animal> currentIndividus = getIndividus();

        // for each mature animal in the array
        for (int i = 0; i < currentIndividus.size(); i++) {

            Animal a = currentIndividus.get(i);

            // determine if it is a parent antelope
            if (a.estMature() && a.estProie() && nombreBebesProies < nombreBebesProiesAttendues) {
                // produce a calf
                nombreBebesProies++;
                getIndividus().add(a.accoucher());

            // determine if it is a parent lion
            } else if (a.estMature() && a.estPredateur() && nombreBebesPredateurs < nombreBebesPredateursAttendues) {
                // produce a cub
                nombreBebesPredateurs++;
                getIndividus().add(a.accoucher());
            }

            // end the loop once all babies have been born
            if (nombreBebesProies == nombreBebesProiesAttendues && nombreBebesPredateurs == nombreBebesPredateursAttendues) {
                break;
            }
        }
    }

    // shuffle the order of animals in the array
    public void melanger() {
        Collections.shuffle(this.individus, new Random(4));
    }

    // remove the dead animals from the array
    public void tuerAnimaux() {
        Iterator<Animal> it = individus.iterator();

        while (it.hasNext()) {
            Animal a = it.next();

            if (!a.estVivant()) {
                it.remove();
            }
        }
    }

    // implementation of the iterator
    // SOURCE : https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java
    public Iterator<Animal> iterator() {

        Iterator<Animal> a = new Iterator<Animal>() {

            private int currentIndex = 0; // current index that's being interated on

            @Override
            public boolean hasNext() {
                return currentIndex < individus.size() && individus.get(currentIndex) != null;
            }

            @Override
            public Animal next() {
                return individus.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        return a;

    }

}
