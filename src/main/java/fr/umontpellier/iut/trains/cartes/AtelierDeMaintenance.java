package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;

public class AtelierDeMaintenance extends CarteAction {
    public AtelierDeMaintenance() {
        super("Atelier de maintenance", 5, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        ListeDeCartes allCartes = joueur.getMain();
        Collection<String> cartesValide = new ArrayList<String>();
        for (Carte carte : allCartes) {
            if (carte.estDeType(TypeCarte.TRAIN)) {
                cartesValide.add(carte.getNom());
            }
        }
        String nomCarteChoisis = joueur.choisir("Choisissez une carte en main de type train", cartesValide, null, false);

        Carte carte_ajout = joueur.getJeu().getReserve().get(nomCarteChoisis).remove(0);
        joueur.ajouterCarteRecue(carte_ajout);
    }
}
