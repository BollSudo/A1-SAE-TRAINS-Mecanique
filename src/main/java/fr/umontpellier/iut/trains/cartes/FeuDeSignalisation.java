package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Bouton;
import fr.umontpellier.iut.trains.Joueur;

import java.util.Arrays;
import java.util.List;


public class FeuDeSignalisation extends CarteAction {
    public FeuDeSignalisation() {
        super("Feu de signalisation", 2, 0);
    }

    @Override
    public void jouer(Joueur joueur){
        joueur.ajouterAlaMain(joueur.piocher());
        Carte carte = joueur.piocher();
        Bouton boutonOui = new Bouton("oui", "oui");
        Bouton boutonNon = new Bouton("non", "non");
        List<Bouton> boutons = Arrays.asList(boutonOui, boutonNon);

        String rep = joueur.choisir("Voulez vous défaussez la carte ?", null, boutons, false);

        if (rep == "oui"){
            joueur.ajouterCarteDansDefausse(carte);
        }else {
            joueur.ajouterCarteSurPioche(carte);
        }
    }
}
