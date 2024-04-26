package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class HorairesTemporaires extends CarteAction {
    public HorairesTemporaires() {
        super("Horaires temporaires", 5, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        int train = 0;
        Carte carte;
        while (train < 2){
            carte = joueur.piocher();
            if (carte.estDeType(TypeCarte.TRAIN)){
                train = train + 1;
                joueur.ajouterAlaMain(carte);
            }
            else {
                joueur.ajouterCarteDansDefausse(carte);
            }
        }
    }
}
