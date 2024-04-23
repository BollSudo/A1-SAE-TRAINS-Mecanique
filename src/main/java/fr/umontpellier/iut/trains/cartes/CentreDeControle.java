package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class CentreDeControle extends CarteAction {
    public CentreDeControle() {
        super("Centre de contrôle", 3, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        if (joueur.peutPiocher(2)){
            joueur.ajouterAlaMain(joueur.piocher());
            Collection<String> cartesValide = new ArrayList<String>();
            for (Map.Entry<String, ListeDeCartes> entry : joueur.getJeu().getReserve().entrySet()){
                cartesValide.add(entry.getKey());
            }
            cartesValide.add("Train omnibus");
            String nomCarteChoisis = joueur.choisir("Choisissez le nom d'une carte", cartesValide, null, true);
            Carte carte = joueur.piocher();
            if (nomCarteChoisis == carte.getNom()){
                joueur.ajouterAlaMain(carte);
            }else {
                joueur.ajouterCarteSurPioche(carte);
            }
        }
    }
}
