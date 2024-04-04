package fr.umontpellier.iut.trains;

import fr.umontpellier.iut.trains.cartes.Ferraille;
import fr.umontpellier.iut.trains.cartes.Carte;
import fr.umontpellier.iut.trains.cartes.ListeDeCartes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JeuEleveTest extends BaseTestClass {

    @BeforeEach
    public void initTest() {
        setupJeu();
        initialisation();
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMainRecursif_aucune_feraille_dans_main() {
        jeu.getJoueurCourant().getMain().clear();
        jeu.getReserve().get("Ferraille").clear();
        jeu.removeAllFerrailleDepuisMainRecursif(1);

        assertEquals(0, jeu.getJoueurCourant().getMain().size());
        assertTrue(containsReferences(jeu.getJoueurCourant().getMain()));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille")));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMainRecursif_une_feraille_dans_main() {
        Carte ferraille = new Ferraille();
        jeu.getJoueurCourant().getMain().clear();
        jeu.getReserve().get("Ferraille").clear();
        jeu.getJoueurCourant().getMain().add(ferraille);
        jeu.removeAllFerrailleDepuisMainRecursif(1);

        assertEquals(0, jeu.getJoueurCourant().getMain().size());
        assertTrue(containsReferences(jeu.getJoueurCourant().getMain()));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMainRecursif_max_feraille_dans_main() {
        Carte ferraille1 = new Ferraille();Carte ferraille2 = new Ferraille();Carte ferraille3 = new Ferraille();Carte ferraille4 = new Ferraille();Carte ferraille5 = new Ferraille();
        jeu.getJoueurCourant().getMain().clear();
        jeu.getReserve().get("Ferraille").clear();
        jeu.getJoueurCourant().getMain().add(ferraille1);jeu.getJoueurCourant().getMain().add(ferraille2);jeu.getJoueurCourant().getMain().add(ferraille3);jeu.getJoueurCourant().getMain().add(ferraille4);jeu.getJoueurCourant().getMain().add(ferraille5);
        jeu.removeAllFerrailleDepuisMainRecursif(1);

        assertEquals(0, jeu.getJoueurCourant().getMain().size());
        assertTrue(containsReferences(jeu.getJoueurCourant().getMain()));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille1, ferraille2, ferraille3, ferraille4, ferraille5));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMain_aucune_feraille_dans_main() {
        jeu.getJoueurCourant().getMain().clear();
        jeu.getReserve().get("Ferraille").clear();
        jeu.removeAllFerrailleDepuisMain();

        assertEquals(0, jeu.getJoueurCourant().getMain().size());
        assertTrue(containsReferences(jeu.getJoueurCourant().getMain()));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille")));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMain_une_feraille_dans_main() {
        Carte ferraille = new Ferraille();
        jeu.getJoueurCourant().getMain().clear();
        jeu.getReserve().get("Ferraille").clear();
        jeu.getJoueurCourant().getMain().add(ferraille);
        jeu.removeAllFerrailleDepuisMain();

        assertEquals(0, jeu.getJoueurCourant().getMain().size());
        assertTrue(containsReferences(jeu.getJoueurCourant().getMain()));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMain_max_feraille_dans_main() {
        Carte ferraille1 = new Ferraille();
        Carte ferraille2 = new Ferraille();
        Carte ferraille3 = new Ferraille();
        Carte ferraille4 = new Ferraille();
        Carte ferraille5 = new Ferraille();

        jeu.getJoueurCourant().getMain().clear();
        jeu.getReserve().get("Ferraille").clear();
        jeu.getJoueurCourant().getMain().add(ferraille1);
        jeu.getJoueurCourant().getMain().add(ferraille2);
        jeu.getJoueurCourant().getMain().add(ferraille3);
        jeu.getJoueurCourant().getMain().add(ferraille4);
        jeu.getJoueurCourant().getMain().add(ferraille5);
        jeu.removeAllFerrailleDepuisMain();

        assertEquals(0, jeu.getJoueurCourant().getMain().size());
        assertTrue(containsReferences(jeu.getJoueurCourant().getMain()));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille1, ferraille2, ferraille3, ferraille4, ferraille5));
    }
}

