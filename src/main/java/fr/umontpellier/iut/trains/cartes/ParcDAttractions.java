package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;

public class ParcDAttractions extends CarteAction {
    public ParcDAttractions() {
        super("Parc d'attractions", 4, 1);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        ListeDeCartes cartes = joueur.getCartesEnJeu();
        Collection<String> cartesValide = new ArrayList<>();
        for (Carte carte : cartes){
            if (carte.estDeType(TypeCarte.TRAIN)){
                cartesValide.add(carte.getNom());
            }
        }
        String carteChoisi = joueur.choisir("Choisissez une carte Train", cartesValide, null, false);
        int value = cartes.getCarte(carteChoisi).getValeur();
        joueur.incrementerArgent(value);
    }
}
