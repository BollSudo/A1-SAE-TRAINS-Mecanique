package fr.umontpellier.iut.trains;

import fr.umontpellier.iut.trains.cartes.*;
import fr.umontpellier.iut.trains.plateau.TuileTerrain;
import fr.umontpellier.iut.trains.plateau.TuileVille;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JoueurEleveTest extends BaseTestClass {

    @BeforeEach
    public void initTest() {
        setupJeu();
        initialisation();
    }

    // @Disabled
    @Test
    void test_jouerTour_passer_action_speciale() {
        Carte ferraille1 = new Ferraille();
        Carte ferraille2 = new Ferraille();
        Carte omni3 = new TrainOmnibus();
        Carte omni4 = new TrainOmnibus();
        Carte omni5 = new TrainOmnibus();
        Carte gare1 = new Gare();
        Carte gare2 = new Gare();
        Carte gare3 = new Gare();
        Carte gare4 = new Gare();
        Carte ferraille5 = new Gare();
        Carte fondPioche = new Ferraille();

        jeu.getReserve().get("Ferraille").clear();
        addAll(main, ferraille1, ferraille2, omni3, omni4, omni5);
        addAll(pioche, gare1, gare2, gare3, gare4, ferraille5, fondPioche);

        jeu.setInput("SPECIAL");
        joueur.jouerTour();

        assertTrue(containsReferences(main, gare1, gare2, gare3, gare4, ferraille5));
        assertTrue(containsReferencesInOrder(pioche, fondPioche));
        assertTrue(containsReferences(defausse, omni3, omni4, omni5));
        assertTrue(containsReferences(cartesEnJeu));
        assertTrue(containsReferences(cartesRecues));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille1, ferraille2));
        assertEquals(0, getArgent(joueur));
        assertEquals(0, getPointsRails(joueur));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMainRecursif_aucune_ferraille_dans_main() {
        main.clear();
        jeu.getReserve().get("Ferraille").clear();
        joueur.removeAllFerrailleDepuisMainRecursif(1);

        assertEquals(0, main.size());
        assertTrue(containsReferences(main));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille")));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMainRecursif_une_ferraille_dans_main() {
        Carte ferraille = new Ferraille();
        main.clear();
        jeu.getReserve().get("Ferraille").clear();
        main.add(ferraille);
        joueur.removeAllFerrailleDepuisMainRecursif(1);

        assertEquals(0, main.size());
        assertTrue(containsReferences(main));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMainRecursif_max_ferraille_dans_main() {
        Carte ferraille1 = new Ferraille();
        Carte ferraille2 = new Ferraille();
        Carte ferraille3 = new Ferraille();
        Carte ferraille4 = new Ferraille();
        Carte ferraille5 = new Ferraille();

        main.clear();
        jeu.getReserve().get("Ferraille").clear();
        addAll(main, ferraille1, ferraille2, ferraille3, ferraille4, ferraille5);
        joueur.removeAllFerrailleDepuisMainRecursif(1);

        assertEquals(0, main.size());
        assertTrue(containsReferences(main));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille1, ferraille2, ferraille3, ferraille4, ferraille5));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMain_aucune_ferraille_dans_main() {
        main.clear();
        jeu.getReserve().get("Ferraille").clear();
        joueur.removeAllFerrailleDepuisMain();

        assertEquals(0, main.size());
        assertTrue(containsReferences(main));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille")));
    }

    //@Disabled
    @Test
    void test_removeAllFerrailleDepuisMain_une_feraille_dans_main() {
        Carte ferraille = new Ferraille();
        main.clear();
        jeu.getReserve().get("Ferraille").clear();
        main.add(ferraille);
        joueur.removeAllFerrailleDepuisMain();

        assertEquals(0, main.size());
        assertTrue(containsReferences(main));
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

        main.clear();
        jeu.getReserve().get("Ferraille").clear();
        addAll(main, ferraille1, ferraille2, ferraille3, ferraille4, ferraille5);
        joueur.removeAllFerrailleDepuisMain();

        assertEquals(0, main.size());
        assertTrue(containsReferences(main));
        assertTrue(containsReferences(jeu.getReserve().get("Ferraille"), ferraille1, ferraille2, ferraille3, ferraille4, ferraille5));
    }

    // @Disabled
    @Test
    void test_choisirTuileDeDepart() {
        jeu.setInput("TUILE:1");
        joueur.choisirTuileDeDepart();

        assertTrue(jeu.getTuile(1).hasRail(joueur));
        assertFalse(jeu.getTuile(1).hasRail(joueurs.get(0)));
        assertTrue((jeu.getTuile(1) instanceof TuileTerrain) || (jeu.getTuile(1) instanceof TuileVille));
        assertEquals(19, getNbJetonsRails(joueur));
        checkPlateau(null, List.of(1), null);
    }

    // @Disabled
    @Test
    void test_ajouter_rail_ne_peut_ajouter_une_seule_rail_par_action_carte_pose() {
        setupJeu();
        initialisation();
        tuiles.get(1).ajouterRail(joueur);

        Carte pose = new PoseDeRails();
        addAll(main, pose);

        jouerTourPartiel("Pose de rails", "TUILE:2", "TUILE:3");

        assertTrue(containsReferences(main));
        assertTrue(containsReferences(cartesEnJeu, pose));
        checkPlateau(null, List.of(1, 2), null);
    }

    // @Disabled
    @Test
    void test_ajouter_rail_obliger_de_placer_rail_si_joue_carte_pose() {
        setupJeu();
        initialisation();
        tuiles.get(1).ajouterRail(joueur);

        Carte pose = new PoseDeRails();
        Carte omni = new TrainOmnibus();
        addAll(main, pose, omni);

        jouerTourPartiel("Pose de rails", "Train omnibus");

        assertTrue(containsReferences(main, omni));
        assertTrue(containsReferences(cartesEnJeu, pose));
        checkPlateau(null, List.of(1), null);
    }

    // @Disabled
    @Test
    void test_ajouter_rail_uniquement_sur_les_tuiles_voisines() {
        setupJeu();
        initialisation();
        tuiles.get(1).ajouterRail(joueur);

        Carte pose = new PoseDeRails();
        addAll(main, pose);

        jouerTourPartiel("Pose de rails", "TUILE:3");

        assertTrue(containsReferences(main));
        assertTrue(containsReferences(cartesEnJeu, pose));
        checkPlateau(null, List.of(1), null);
    }

}