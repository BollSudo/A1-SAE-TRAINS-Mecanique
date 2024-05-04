package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class UsineDeWagons extends CarteTrainAction {
    public UsineDeWagons() {
        super("Usine de wagons", 5,0);
    }

    private int choisirDeMainCarteEcarte(Joueur joueur){
        ListeDeCartes cartes = joueur.getMain();
        Collection<String> cartesValide = new ArrayList<>();
        for (Carte carte : cartes){
            if (carte.estDeType(TypeCarte.TRAIN)){
                cartesValide.add(carte.getNom());
            }
        }
        String nomCarteValide = joueur.choisir("Choisissez une carte train à équarter", cartesValide, null, false);
        Carte c = joueur.getMain().retirer(nomCarteValide);
        joueur.getJeu().ecarterCarte(c);
        return c.getCout();
    }

    private Collection<String> getCartesValide(Joueur joueur, int prixMax){
        Collection<String> collection = new ArrayList<>();
        for (ListeDeCartes listeDeCartes : joueur.getJeu().getReserve().values()){
            if (listeDeCartes.get(0).estDeType(TypeCarte.TRAIN) && listeDeCartes.get(0).getCout() <= prixMax){
                collection.add("ACHAT:"+listeDeCartes.get(0).getNom());
            }
        }
        return collection;
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        int prixMax = choisirDeMainCarteEcarte(joueur) + 3;
        Collection<String> cartesValide = getCartesValide(joueur, prixMax);

        String nomCartesChoisis = joueur.choisir("Choisissez une nouvelle carte train", cartesValide,null, false);
        nomCartesChoisis = nomCartesChoisis.split(":")[1];
        Carte carte = joueur.getJeu().prendreDansLaReserve(nomCartesChoisis);

        if (carte != null){
            joueur.getJeu().log("Reçoit " + carte); // affichage dans le log
            joueur.ajouterAlaMain(carte);
        }
        
    }
}
