package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Aiguillage extends CarteAction {
    public Aiguillage() {
        super("Aiguillage", 5,0);
    }


    /**
     * Effet : pioche 2 cartes
     * @param joueur le joueur qui joue la carte
     */
    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        if (joueur.peutPiocher(2)){
            joueur.ajouterAlaMain(joueur.piocher(2));
        }
    }
}
