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
        int point=0;
        switch (nbGaresPosees) {
            case 1:
                point=2;
            case 2:
                point=4;
            case 3:
                point=8;
        }
        return point;
    }

    @Override
    public void ajouterGare() {
        nbGaresPosees++;
    }

    @Override
    public boolean peutAjouterGare() {
        return nbGaresPosees < nbGaresMax;
    }
}
