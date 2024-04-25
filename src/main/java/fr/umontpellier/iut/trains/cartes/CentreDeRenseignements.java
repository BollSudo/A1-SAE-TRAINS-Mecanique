package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CentreDeRenseignements extends CarteAction {
    public CentreDeRenseignements() {
        super("Centre de renseignements", 4, 1);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        String nomCarte1, nomCarte2, nomCarte3, nomDerniereCarte;
        List<Carte> cartes1 = joueur.piocher(4);
        ListeDeCartes cartes = new ListeDeCartes();
        Collection<String> cartesValide = new ArrayList<String>();
        for (Carte carte : cartes1){
            cartesValide.add(carte.getNom());
            cartes.add(carte);
        }
        String action = joueur.choisir("Choisissez le nom de la carte a gardé", cartesValide, null, true);
        if (action == ""){
            nomDerniereCarte = joueur.choisir("Choisissez le nom a mettre le plus bas", cartesValide, null, false);
            cartesValide.remove(nomDerniereCarte);
            nomCarte3 = joueur.choisir("Choisissez le nom a mettre le plus bas", cartesValide, null, false);
            cartesValide.remove(nomCarte3);
            nomCarte2 = joueur.choisir("Choisissez le nom a mettre le plus bas", cartesValide, null, false);
            cartesValide.remove(nomCarte2);
            nomCarte1 = joueur.choisir("Choisissez la carte restante", cartesValide, null, false);

            joueur.ajouterCarteSurPioche(cartes.getCarte(nomDerniereCarte));
            joueur.ajouterCarteSurPioche(cartes.getCarte(nomCarte3));
            joueur.ajouterCarteSurPioche(cartes.getCarte(nomCarte2));
            joueur.ajouterCarteSurPioche(cartes.getCarte(nomCarte1));

        }else {
            nomDerniereCarte = joueur.choisir("Choisissez le nom a mettre le plus bas", cartesValide, null, false);
            cartesValide.remove(nomDerniereCarte);
            nomCarte2 = joueur.choisir("Choisissez le nom a mettre le plus bas", cartesValide, null, false);
            cartesValide.remove(nomCarte2);
            nomCarte1 = joueur.choisir("Choisissez la carte restante", cartesValide, null, false);

            joueur.ajouterAlaMain(cartes.getCarte(action));
            joueur.ajouterCarteSurPioche(cartes.getCarte(nomDerniereCarte));
            joueur.ajouterCarteSurPioche(cartes.getCarte(nomCarte2));
            joueur.ajouterCarteSurPioche(cartes.getCarte(nomCarte1));
        }



    }
}
