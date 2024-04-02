package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Aiguillage extends Carte {
    public Aiguillage() {
        super("Aiguillage", 5,0);
    }


    /**
     * Effet : ET JE PIOCHE, DRAGON BLANC AUX YEUX BLEU
     * @param joueur
     */
    @Override
    public void jouer(Joueur joueur) {
        joueur.piocher(2);
    }
}
