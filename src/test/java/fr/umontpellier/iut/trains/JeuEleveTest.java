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

}

