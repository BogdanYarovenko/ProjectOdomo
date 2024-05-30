package odomo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests des méthodes de la classe Chauffage.
 */
public class ChauffageTest {

    @Test
    public void testInitialiser() {
        Chauffage.initialiser();
        assertEquals(Chauffage.temperNormal, 18);
        assertEquals(Chauffage.temperEco, 16);
    }

    @Test
    public void testCreneauMode() {
        Chauffage.initialiser();
        Chauffage.creneau1
                = new int[][]{{6, 9}, {6, 9}, {6, 22}, {6, 9}, {6, 9}, {7, 23}, {7, 23}};
        Chauffage.creneau2
                = new int[][]{{17, 22}, {17, 22}, {1, 0}, {17, 22}, {17, 22}, {1, 0}, {1, 0}};
        assertFalse(Chauffage.creneauMode(0, 0));
        assertTrue(Chauffage.creneauMode(0, 6));
        assertTrue(Chauffage.creneauMode(1, 7));
        assertTrue(Chauffage.creneauMode(1, 8));
        assertTrue(Chauffage.creneauMode(1, 9));
        assertFalse(Chauffage.creneauMode(1, 10));
        assertFalse(Chauffage.creneauMode(1, 16));
        assertTrue(Chauffage.creneauMode(1, 17));
        assertTrue(Chauffage.creneauMode(1, 22));
        assertFalse(Chauffage.creneauMode(1, 23));
        assertFalse(Chauffage.creneauMode(2, 0));
        assertFalse(Chauffage.creneauMode(6, 0));
        assertFalse(Chauffage.creneauMode(6, 1));
        assertFalse(Chauffage.creneauMode(6, 6));
        assertTrue(Chauffage.creneauMode(6, 7));
        assertTrue(Chauffage.creneauMode(6, 8));
        assertTrue(Chauffage.creneauMode(6, 22));
        assertTrue(Chauffage.creneauMode(6, 23));
    }

    @Test
    public void testTemperatureSouhaitee() {
        Chauffage.temperEco = 14;
        Chauffage.temperNormal = 18;
        Chauffage.creneau1 = new int[][]{{6, 9}, {6, 9}, {6, 22}, {6, 9}, {6, 9}, {7, 23}, {7, 23}};
        Chauffage.creneau2 = new int[][]{{17, 22}, {17, 22}, {1, 0}, {17, 22}, {17, 22}, {1, 0}, {1, 0}};
        assertEquals(14, Chauffage.temperatureSouhaitee(0, 0));
        assertEquals(14, Chauffage.temperatureSouhaitee(0, 5));
        assertEquals(18, Chauffage.temperatureSouhaitee(0, 6));
        assertEquals(18, Chauffage.temperatureSouhaitee(0, 9));
        assertEquals(14, Chauffage.temperatureSouhaitee(0, 10));
        assertEquals(18, Chauffage.temperatureSouhaitee(2, 10));
        assertEquals(18, Chauffage.temperatureSouhaitee(2, 22));
        assertEquals(14, Chauffage.temperatureSouhaitee(2, 23));
        assertEquals(14, Chauffage.temperatureSouhaitee(6, 6));
        assertEquals(18, Chauffage.temperatureSouhaitee(6, 12));
    }

    @Test
    public void testTraitementSaisieCreneaux() {
        Chauffage.initialiser();
        Odomo.mode = Odomo.MODE_SAISIE_CHAUFFAGE;
        assertTrue(Chauffage.traitementSaisieCreneaux("jeu;6;8"));
        assertTrue(Chauffage.traitementSaisieCreneaux("mar;6;8;10;12"));
        assertTrue(Chauffage.traitementSaisieCreneaux("mar;10;12;6;8"));
        assertTrue(Chauffage.traitementSaisieCreneaux("dim;10;12;6;11"));
        assertTrue(Chauffage.traitementSaisieCreneaux("lun;10;10"));
        assertTrue(Chauffage.traitementSaisieCreneaux("ven;10;10;10;10"));
        assertTrue(Chauffage.traitementSaisieCreneaux("jeu;1;0;0;23"));
        assertTrue(Chauffage.traitementSaisieCreneaux("dim;1;0;1;0"));
        assertFalse(Chauffage.traitementSaisieCreneaux("sam;11;10"));
        assertFalse(Chauffage.traitementSaisieCreneaux("mer;1;0;11;10"));
        assertFalse(Chauffage.traitementSaisieCreneaux("8;9"));
        assertFalse(Chauffage.traitementSaisieCreneaux("lundi;8;9"));
        assertFalse(Chauffage.traitementSaisieCreneaux("lun,mar;8;9"));
        assertFalse(Chauffage.traitementSaisieCreneaux("ven;8"));
        assertFalse(Chauffage.traitementSaisieCreneaux("jeu;3;7;5"));
        assertFalse(Chauffage.traitementSaisieCreneaux("mer;2;;5"));
        assertFalse(Chauffage.traitementSaisieCreneaux("lun;4;"));
    }
}
