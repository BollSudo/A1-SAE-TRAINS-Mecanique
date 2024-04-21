package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public abstract class CarteVictoire extends Carte {
    private int pointVictoire;
    public CarteVictoire(String nom, int cout, int valeur, int pv) {
        super(nom, cout, valeur);
        pv = pointVictoire;
    }

    //Carte non jouable

    public int getPointVictoire() {
        return pointVictoire;
    }
}
