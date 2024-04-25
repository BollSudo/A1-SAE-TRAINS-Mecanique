package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Bouton;
import fr.umontpellier.iut.trains.Joueur;

import java.util.Arrays;
import java.util.List;

public class HorairesEstivaux extends CarteAction {
    public HorairesEstivaux() {
        super("Horaires estivaux", 3, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        super.jouer(joueur);
        Bouton boutonOui = new Bouton("oui", "oui");
        Bouton boutonNon = new Bouton("non", "non");
        List<Bouton> boutons = Arrays.asList(boutonOui, boutonNon);

        String rep = joueur.choisir("Voulez vous défaussez la carte ?", null, boutons, true);

        if (rep == "oui"){
            joueur.getJeu().ecarterCarte(joueur.getCartesEnJeu().retirer("Horaires estivaux"));
            joueur.incrementerArgent(3);
        }
    }
}
