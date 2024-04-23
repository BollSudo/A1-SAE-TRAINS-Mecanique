package fr.umontpellier.iut.trains.plateau;

/**
 * Classe représentant une tuile ville (où l'on peut poser des gares)
 */
public class TuileVille extends Tuile {
    /**
     * Nombre maximum de gares que l'on peut poser sur la tuile
     */
    private int nbGaresMax;
    /**
     * Nombre de gares posées sur la tuile
     */
    private int nbGaresPosees;

    public TuileVille(int taille) {
        super();
        this.nbGaresMax = taille;
        this.nbGaresPosees = 0;
    }

    // FONCTIONS AJOUTEES
    //**************************************************************************************/
    /*                             A NETOYER AVANT DE RENDRE                              */
    //**************************************************************************************/

    @Override
    public int getPoint() {
        return switch (nbGaresPosees) {
            case 1 -> 2;
            case 2 -> 4;
            case 3 -> 8;
            default -> 0;
        };
    }

    @Override
    public void ajouterGare() {
        nbGaresPosees++;
    }

    @Override
    public boolean peutAjouterGare() {
        return nbGaresPosees < nbGaresMax;
    }

    @Override
    public int getSurcout() {
        return super.getSurcout() + 1 + nbGaresPosees;
    }
}
