package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Aiguillage extends CarteAction {
    public Aiguillage() {
        super("Aiguillage", 5,0);
    }


    /**
     * Effet : le joueur pioche 2 cartes
     * @param joueur
     */
    @Override
    public void jouer(Joueur joueur) {
        joueur.piocher(2);
    }
}
