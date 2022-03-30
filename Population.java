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

    // TO BE COMPLETED //
    private ArrayList<Animal> individus = new ArrayList<>();

    public Population(Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);
        this.herbe = herbe;

    }

    public int getNombreProies() {
        int nombreProies = 0;

        for (Animal a : getIndividus()) {
            if(a.estProie()) {
                nombreProies++;
            }
        }

        return nombreProies;
    }

    public int getNombrePredateurs() {
        int nombrePredateurs = 0;

        for (Animal a : getIndividus()) {
            if(a.estPredateur()) {
                nombrePredateurs++;
            }
        }

        return nombrePredateurs;
    }

    public int getNombreProiesMatures() {
        int nombreProiesMatures = 0;

        for (Animal a : getIndividus()) {
            if(a.estProie() && a.estMature()) {
                nombreProiesMatures++;
            }
        }

        return nombreProiesMatures;
    }

    public int getNombrePredateursMatures() {
        int nombrePredateursMatures = 0;

        for (Animal a : getIndividus()) {
            if(a.estPredateur() && a.estMature()) {
                nombrePredateursMatures++;
            }
        }

        return nombrePredateursMatures;
    }

    public int getNombreProiesChassables() {
        double nombreProies = getNombreProies();
        double nombreProiesChassablesDouble = Math.round(nombreProies*0.20); // Calculate 20% of the antelope population
        int nombreProiesChassables = (int)nombreProiesChassablesDouble;
        System.out.println( nombreProiesChassables );

        return nombreProiesChassables;
    }

    public ArrayList<Animal> getIndividus() {
        return this.individus;
    }

    public double masseProies() {
        double masseProies = 0;

        for (Animal a : getIndividus()) {
            if(a.estProie()) {
                masseProies += a.getMasse();
            }
        }

        return masseProies;
    }

    public double massePredateurs() {
        double massePredateurs = 0;

        for (Animal a : getIndividus()) {
            if(a.estPredateur()) {
                massePredateurs += a.getMasse();
            }
        }

        return massePredateurs;
    }

    public void vieillir() {

        herbe.vieillir();

        for (Animal a : getIndividus()) {
            a.vieillir();
        }

        tuerAnimaux();

    }

    public void chasser() {
        melanger();

        int nombreProiesChassables = getNombreProiesChassables();
        int nombreProiesChassees = 0;
        double herbeDisponible = herbe.getMasseAnnuelle();

        for (Animal a : getIndividus()) {
            double masseNecessaire = a.getMasse()*2;

            if (a.estProie() && a.estVivant()) {
                if (masseNecessaire <= herbeDisponible) {
                    herbeDisponible -= masseNecessaire;
                    // a.manger();
                } else {
                    a.mourir();
                }
            } else if (a.estPredateur() && a.estVivant()) {
                if(nombreProiesChassees < nombreProiesChassables) {
                    for (Animal b : getIndividus()) {
                        if (b.estProie() && b.estVivant()) {
                            // a.manger();
                            masseNecessaire -= b.getMasse();
                            nombreProiesChassees++;
                            b.mourir();
                        }
                        if (masseNecessaire <= 0) {
                            break;
                        } else if (nombreProiesChassees >= nombreProiesChassables) {
                            a.mourir();
                            break;
                        }
                    }
                } else {
                    a.mourir();
                }
            }
        }

        herbe.setMasseAnnuelle(herbeDisponible);
        tuerAnimaux();

    }

    public void reproduire() {

        int nombreParentsProies = 0;
        int nombreParentsPredateurs = 0;

        ArrayList<Animal> currentIndividus = getIndividus();

        for (int i = 0; i<currentIndividus.size(); i++) {
            Animal a = currentIndividus.get(i);
            if (a.estMature() && a.estProie()) {
                nombreParentsProies++;
                if (nombreParentsProies%2 == 0) {
                    getIndividus().add(a.accoucher());
                }
            } else if (a.estMature() && a.estPredateur()) {
                nombreParentsPredateurs++;
                if(nombreParentsPredateurs%2 == 0) {
                    getIndividus().add(a.accoucher());
                }
            }
        }
    }

    public void melanger() {
        Collections.shuffle(this.individus, new Random(4));
    }

    public void tuerAnimaux() {
        Iterator<Animal> it = individus.iterator();

        while (it.hasNext()) {
            Animal a = it.next();
            
            if (!a.estVivant) {
                it.remove();
            }
        }
    }

    public Iterator<Animal> iterator() {

        Iterator<Animal> a = new Iterator<Animal>() {

            private int currentIndex = 0;

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
