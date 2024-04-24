package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;

public class CabineDuConducteur extends CarteAction {
    public CabineDuConducteur() {
        super("Cabine du conducteur", 2, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        boolean fini = false;
        Collection<String> cartesValide = new ArrayList<String>();
        for (Carte carte : joueur.getMain()) {
            cartesValide.add(carte.getNom());
        }
        int carte_defaussee = 0;
        while (!fini){
            String nomCarteChoisis = joueur.choisir("Choisissez une carte en main de type train", cartesValide, null, true);
            if (cartesValide.contains(nomCarteChoisis)){
                carte_defaussee = carte_defaussee + 1;
                cartesValide.remove(nomCarteChoisis);
                joueur.ajouterCarteDansDefausse(joueur.getMain().getCarte(nomCarteChoisis));
                joueur.getMain().retirer(nomCarteChoisis);
            }else {
                fini = true;
            }
        }
        for (int i = 0; i< carte_defaussee; i++){
            joueur.ajouterAlaMain(joueur.piocher());
        }
    }
}
