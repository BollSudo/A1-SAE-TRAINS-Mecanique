package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;

public class Remorquage extends CarteAction {
    public Remorquage() {
        super("Remorquage", 3, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        ListeDeCartes cartes = joueur.getDefausse();
        Collection<String> cartesValide = new ArrayList<>();
        for (Carte carte : cartes){
            if (carte.estDeType(TypeCarte.TRAIN)){
                cartesValide.add(carte.getNom());
            }
        }
        String nomCarteChoisis = joueur.choisir("Choisissez une carte train à récupérer", cartesValide, null, false);
        Carte c = joueur.getDefausse().retirer(nomCarteChoisis);
        joueur.ajouterAlaMain(c);
    }
}
