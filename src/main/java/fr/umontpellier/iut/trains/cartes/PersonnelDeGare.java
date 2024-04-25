package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Bouton;
import fr.umontpellier.iut.trains.Joueur;

import java.util.Arrays;
import java.util.List;

public class PersonnelDeGare extends CarteAction {
    public PersonnelDeGare() {
        super("Personnel de gare", 2, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        Bouton boutonPioche = new Bouton("piocher", "piocher");
        Bouton boutonFerraille = new Bouton("ferraille", "ferraille");
        Bouton boutonArgent = new Bouton("argent", "argent");
        List<Bouton> boutons = Arrays.asList(boutonPioche, boutonFerraille, boutonArgent);

        String rep = joueur.choisir("Choisissez un parmi les trois :", null, boutons, false);

        if (rep == "piocher"){
            joueur.ajouterAlaMain(joueur.piocher());
        } else if (rep == "ferraille"){
            Carte c = joueur.getMain().retirer("Ferraille");
            joueur.getJeu().getReserve().get("Ferraille").add(c);
        } else {
            joueur.incrementerArgent(1);
        }
    }
    
}
