package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Echangeur extends CarteAction {
    public Echangeur() {
        super("Échangeur", 3, 1);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        ListeDeCartes cartes = joueur.getCartesEnJeu();

        Collection<String> cartesValide = new ArrayList<String>();
        for (Carte carte : cartes) {
            if (carte.estDeType(TypeCarte.TRAIN)){
                cartesValide.add(carte.getNom());
            }
        }
        String nomCarteChoisis = joueur.choisir("Choisissez une carte à récupérer", cartesValide, null, false);
        joueur.ajouterCarteSurPioche(joueur.getCartesEnJeu().retirer(nomCarteChoisis));

    }
}
