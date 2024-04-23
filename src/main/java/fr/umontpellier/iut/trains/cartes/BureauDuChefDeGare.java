package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;

public class BureauDuChefDeGare extends CarteAction {
    public BureauDuChefDeGare() {
        super("Bureau du chef de gare", 4, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);

        ListeDeCartes allCartes = joueur.getMain();
        Collection<String> cartesValide = new ArrayList<String>();
        for (Carte carte : allCartes) {
            if (carte.estDeType(TypeCarte.ACTION)) {
                cartesValide.add(carte.getNom());
            }
        }

        String nomCarteChoisis = joueur.choisir("Choisissez une carte en main", cartesValide, null, true);
        joueur.getMain().getCarte(nomCarteChoisis).jouer(joueur);
    }
}
