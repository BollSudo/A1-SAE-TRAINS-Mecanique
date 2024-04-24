package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;

public class Depot extends CarteAction {
    public Depot() {
        super("Dépôt", 3, 1);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        joueur.ajouterAlaMain(joueur.piocher(2));
        Collection<String> cartesValide = new ArrayList<String>();
        for (Carte carte : joueur.getMain()){
            cartesValide.add(carte.getNom());
        }
        String carte1 = joueur.choisir("Choisissez le nom de la carte à défaussé", cartesValide, null, false);
        joueur.ajouterCarteDansDefausse(joueur.getMain().getCarte(carte1));
        joueur.getMain().retirer(carte1);
        cartesValide.remove(carte1);
        String carte2 = joueur.choisir("Choisissez le nom de la carte à défaussé", cartesValide, null, false);
        joueur.ajouterCarteDansDefausse(joueur.getMain().getCarte(carte2));
        joueur.getMain().retirer(carte2);

    }
}
