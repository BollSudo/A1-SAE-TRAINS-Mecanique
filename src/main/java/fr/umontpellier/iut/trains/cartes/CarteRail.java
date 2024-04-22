package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.plateau.Tuile;

public abstract class CarteRail extends Carte {

    public CarteRail(String nom, int cout, int valeur) {
        super(nom, cout, valeur, TypeCarte.RAIL);
    }

    @Override
    public void jouer(Joueur joueur) {
        throw new RuntimeException("Méthode A FAIRE");
    }

    public void effetSurcout(Tuile tuile) {

    }
}