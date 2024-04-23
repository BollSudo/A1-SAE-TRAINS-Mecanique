package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.plateau.Plateau;
import fr.umontpellier.iut.trains.plateau.Tuile;

import java.util.ArrayList;
import java.util.List;

public class Gare extends Carte {
    public Gare() {
        super("Gare", 3, 0, TypeCarte.GARE);
    }

    @Override
    public void jouer(Joueur joueur) {
        List<String> choixPossibles = joueur.choixTuilesVille();
        if (!choixPossibles.isEmpty()) {
            String choix = joueur.choisir("", choixPossibles, null, false);
            if (choix.startsWith("TUILE:")) {
                joueur.placerJetonGare(choix);
                joueur.recevoirUneFerraille();
            }
        }
    }
}
