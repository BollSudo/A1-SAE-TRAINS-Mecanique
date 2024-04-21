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

    // @Disabled
    @Test
    void test_estFini_cas_jetons_rails() {
        setAttribute(jeu.getJoueurCourant(), "nbJetonsRails", 0);
        assertTrue(jeu.estFini());
    }

    // @Disabled
    @Test
    void test_estFini_cas_jetons_gares() {
        setAttribute(jeu, "nbJetonsGare", 0);
        assertTrue(jeu.estFini());
    }

    // @Disabled
    @Test
    void test_estFini_cas_4_piles_vides_sans_ferrailles() {
        jeu.getReserve().get("Train express").clear();
        jeu.getReserve().get("Pose de rails").clear();
        jeu.getReserve().get("Appartement").clear();
        jeu.getReserve().get("Gare").clear();

        assertTrue(jeu.estFini());
    }

    // @Disabled
    @Test
    void test_estFini_cas_4_piles_vides_avec_ferrailles() {
        jeu.getReserve().get("Train express").clear();
        jeu.getReserve().get("Pose de rails").clear();
        jeu.getReserve().get("Appartement").clear();
        jeu.getReserve().get("Ferraille").clear();

        assertFalse(jeu.estFini());
    }
}

