package odomo;

import java.util.Random;

/**
 * Gestion de la partie Météo.
 */
class Meteo {

    /**
     * Température courante dans la maison (en °C).
     */
    static double temperInt;

    /**
     * Température minimale par minute, pour les 60 dernières minutes.
     */
    static double[] temperExtMinMinute;

    static double[] hygroMinute;
    static double[] hygroHeure;
    static double[] hygroJour;
    /**
     * Température minimale par heure, pour les 24 dernières heures.
     */
    static double[] temperExtMinHeure;

    /**
     * Température minimale journalière, pour les 365 derniers jours.
     */
    static double[] temperExtMinJour;

    /**
     * Température moyenne par minute, pour les 60 dernières minutes.
     */
    static double[] temperExtMoyMinute;

    /**
     * Température moyenne par heure, pour les 24 dernières heures.
     */
    static double[] temperExtMoyHeure;

    /**
     * Température moyenne journalière, pour les 365 derniers jours.
     */
    static double[] temperExtMoyJour;

    /**
     * Température maximale par minute, pour les 60 dernières minutes.
     */
    static double[] temperExtMaxMinute;

    /**
     * Température maximale par heure, pour les 24 dernières heures.
     */
    static double[] temperExtMaxHeure;

    /**
     * Température maximale journalière, pour les 365 derniers jours.
     */
    static double[] temperExtMaxJour;

    /**
     * Température extérieure courante.
     */
    static double temperExt;

    /**
     * Pluviométrie par minute, pour les 60 dernières minutes.
     */
    static double[] pluvioMinute;

    /**
     * Pluviométrie par heure, pour les 24 dernières heures.
     */
    static double[] pluvioHeure;

    /**
     * Pluviométrie journalière, pour les 365 derniers jours.
     */
    static double[] pluvioJour;

    /**
     * Hygrométrie courante dans la maison.
     */
    static double hygroInt;

    /**
     * Hygrométrie courante à l'extérieur.
     */
    static double hygroExt;

    /**
     * Pression courante;
     */
    static double pression;

    /**
     * Ensoleillement extérieur (en W/m2).
     */
    static double ensoleillement;

    /**
     * Vitesse courante du vent.
     */
    static double vitesseVent;

    /**
     * Direction courante du vent.
     */
    static String directionVent;

    /**
     * Mise à jour de la température courante dans la maison.
     *
     * @return la température courante dans la maison.
     */
    static double majTemperInt() {
        temperInt = aleatoire(18., 20.);
        return temperInt;
    }

    /**
     * Mise à jour de l'hygrométrie courante dans la maison.
     *
     * @return l'hygrométrie courante dans la maison.
     */
    static double majHygroInt() {
        hygroInt = aleatoire(30., 60.);
        return hygroInt;
    }

    /**
     * Mise à jour de la température courante à l'extérieur.
     *
     * @return la température courante à l'extérieur.
     */
    static double majTemperExt() {
        temperExt = aleatoire(-5., 35.);
        return temperExt;
    }

    /**
     * Mise à jour de l'hygrométrie courante à l'extérieur.
     *
     * @return l'hygrométrie courante à l'extérieur.
     */
    static double majHygroExt() {
        hygroExt = aleatoire(10., 90.);
        return hygroExt;
    }

    /**
     * Mise à jour de la pression atmosphérique courante.
     *
     * @return la pression atmosphérique courante
     */
    static double majPression() {
        pression = aleatoire(980., 1080.);
        return pression;
    }

    /**
     * Mise à jour de l'ensoleillement extérieur.
     *
     * @return l'ensoleillement extérieur
     */
    static double majEnsoleillement() {
        ensoleillement = aleatoire(0., 1000.);
        return ensoleillement;
    }

    /**
     * Insolation courante.
     *
     * @return vrai ssi l'ensoleillement est supérieur ou égal à 120 W/M2
     */
    static boolean insolation() {
        return ensoleillement >= 120;
    }

    /**
     * Pluviométrie de la minute en cours.
     *
     * @return la pluviométrie de la minute en cours
     */
    static double majPluvioMinute() {
        pluvioMinute[0] = aleatoire(0., 5.);
        return pluvioMinute[0];
    }

    /**
     * Mise à jour de la vitesse courante du vent.
     *
     * @return la vitesse courante du vent
     */
    static double majVitesseVent() {
        vitesseVent = aleatoire(0., 110.);
        return vitesseVent;
    }

    /**
     * Mise à jour de la direction courante du vent.
     *
     * @return la direction courante du vent
     */
    static String majDirectionVent() {
        String[] directions = {"NN", "SS", "EE", "OO", "NE", "NO", "SE", "SO"};
        directionVent = directions[(int) aleatoire(0, directions.length - 1)];
        return directionVent;
    }

    /**
     * Initialiser toutes les mesures stockées.
     */
    static void initialiser() {
        initialiserDonneesJournalieres();
        initialiserDonneesParHeure();
        initialiserDonneesParMinute();
    }

    /**
     * Initialiser toutes les mesures journalières stockées.
     */
    static void initialiserDonneesJournalieres() {
        temperExtMinJour = new double[365];
        temperExtMaxJour = new double[365];
        temperExtMoyJour = new double[365];
        pluvioJour = new double[365];
        hygroJour = new double[365];
        for (int i = 0; i < 365; i++) {
            temperExtMoyJour[i] = aleatoire(20., 80.);
            temperExtMinJour[i] = temperExtMoyJour[i] - aleatoire(5., 10.);
            temperExtMaxJour[i] = temperExtMoyJour[i] + aleatoire(5., 10.);
            pluvioJour[i] = Math.max(0., aleatoire(0., 60.) - 40.);
            hygroJour[i] = Math.max(20., 80.);
        }
    }

    /**
     * Initialiser les mesures stockées par heure.
     */
    static void initialiserDonneesParHeure() {
        temperExtMinHeure = new double[24];
        temperExtMoyHeure = new double[24];
        temperExtMaxHeure = new double[24];
        pluvioHeure = new double[24];
        hygroHeure = new double[24];
        for (int i = 0; i < 24; i++) {
            temperExtMoyHeure[i] = aleatoire(-10., 40.);
            temperExtMinHeure[i] = temperExtMoyHeure[i] - aleatoire(0.5, 3.);
            temperExtMaxHeure[i] = temperExtMoyHeure[i] + aleatoire(0.5, 3.);
            pluvioHeure[i] = Math.max(0., aleatoire(0., 50.) - 40.);
            hygroHeure[i] = Math.max(20., 80.);
        }
    }

    /**
     * Initialiser les mesures stockées par minute.
     */
    static void initialiserDonneesParMinute() {
        temperExtMinMinute = new double[60];
        temperExtMoyMinute = new double[60];
        temperExtMaxMinute = new double[60];
        pluvioMinute = new double[60];
        hygroMinute = new double[60];
        for (int i = 0; i < 60; i++) {
            temperExtMoyMinute[i] = aleatoire(20., 80.);
            temperExtMinMinute[i] = temperExtMoyMinute[i] - aleatoire(0., 2.);
            temperExtMaxMinute[i] = temperExtMoyMinute[i] + aleatoire(0., 2.);
            pluvioMinute[i] = Math.max(0., aleatoire(0., 50.) - 45.);
            hygroMinute[i] = aleatoire(20., 80);
        }
    }

    /**
     * Chaque fin de minute, mettre à jour les données cumulées pendant la
     * minute courante dans les données des 60 dernières minutes.
     */
    static void finMinute() {
        finMinuteTemperExtMin();
        finMinuteTemperExtMoy();
        finMinuteTemperExtMax();
        finMinutePluvio();
    }

    /**
     * Mise à jour des données liées à la température extérieure minimale, en
     * fin de minute.
     */
    static void finMinuteTemperExtMin() {
        double min = temperExtMinMinute[0];
        if (min < temperExtMinHeure[0]) {
            temperExtMinHeure[0] = min;
        }
        if (min < temperExtMinJour[0]) {
            temperExtMinJour[0] = min;
        }
        decalageDroite(temperExtMinMinute);
        temperExtMinMinute[0] = temperExt;
    }

    /**
     * Mise à jour des données liées à la température extérieure moyenne, en fin
     * de minute.
     */
    static void finMinuteTemperExtMoy() {
        double sum1 = 0;
        for (int i = 0; i < 60; i++) {
            sum1 += temperExtMoyMinute[i];
        }
        temperExtMoyHeure[0] = sum1 / 60;
        double sum2 = 0;
        for (int i = 0; i < 24; i++) {
            sum2 += temperExtMoyHeure[i];
        }
        temperExtMoyJour[0] = sum2 / 24;

        decalageDroite(temperExtMoyMinute);
        temperExtMoyMinute[0] = temperExt;

    }

    /**
     * Mise à jour des données liées à la température extérieure maximale, en
     * fin de minute.
     */
    static void finMinuteTemperExtMax() {
        double max = temperExtMaxMinute[0];
        if (max > temperExtMaxHeure[0]) {
            temperExtMaxHeure[0] = temperExtMaxMinute[0];
        }
        if (max > temperExtMaxJour[0]) {
            temperExtMaxJour[0] = temperExtMaxMinute[0];
        }
        decalageDroite(temperExtMaxMinute);
        temperExtMaxMinute[0] = temperExt;
    }

    /**
     * Mise à jour des données liées à la pluviométrie, en fin de minute.
     */
    static void finMinutePluvio() {
        pluvioHeure[0] += pluvioMinute[0];
        pluvioJour[0] += pluvioMinute[0];
        decalageDroite(pluvioMinute);
        pluvioMinute[0] = 0;
    }

    /**
     * Chaque fin d'heure, mettre à jour les données cumulées pendant l'heure
     * dans les données des 24 dernières heures.
     */
    static void finHeure() {
        finHeureTemperExt();
        finHeurePluvio();
    }

    /**
     * Mise à jour des données de pluviométrie chaque heure.
     */
    static void finHeurePluvio() {
        decalageDroite(pluvioHeure);
        pluvioHeure[0] = 0;
    }

    /**
     * Mise à jour des données de température extérieure chaque heure.
     */
    static void finHeureTemperExt() {
        decalageDroite(temperExtMinHeure);
        decalageDroite(temperExtMoyHeure);
        decalageDroite(temperExtMaxHeure);
        temperExtMinHeure[0] = temperExt;
        temperExtMoyHeure[0] = temperExt;
        temperExtMaxHeure[0] = temperExt;
    }

    /**
     * Mise à jour des données de température extérieure chaque jour.
     */
    static void finJourTemperExt() {
        decalageDroite(temperExtMinJour);
        decalageDroite(temperExtMoyJour);
        decalageDroite(temperExtMaxJour);
        temperExtMinJour[0] = temperExt;
        temperExtMoyJour[0] = temperExt;
        temperExtMaxJour[0] = temperExt;

    }

    /**
     * Mise à jour des données de pluviométrie chaque jour.
     */
    static void finJourPluvio() {
        decalageDroite(pluvioJour);
        pluvioJour[0] = 0;
    }

    /**
     * Test de cohérence des données stockées sur les températures par minute.
     *
     * @return vrai ssi les données de températures par minute sont cohérentes
     */
    static boolean temperaturesCoherentes() {
        boolean coh = true;
        for (int i = 0; i <= 59; i++) {
            if (!(temperExtMinMinute[i] <= temperExtMoyMinute[i] && temperExtMoyMinute[i] <= temperExtMaxMinute[i])) {
                coh = false;
            }
        }
        for (int i = 1; i <= 59; i++) {
            if (!(temperExtMinMinute[i] >= temperExtMinHeure[0])) {
                coh = false;
            }

        }
        for (int i = 1; i <= 59; i++) {
            if (!(temperExtMaxMinute[i] <= temperExtMaxHeure[0])) {
                coh = false;
            }
        }
        return coh;
    }

    /**
     * Décaler les valeurs d'un tableau d'un rang vers la droite. La dernière
     * valeur est perdue, et la première est dupliquée (tab[0] et tab[1]).
     *
     * @param tab le tableau à modifier
     */
    static void decalageDroite(double[] tab) {
        for (int i = tab.length - 1; i > 0; i--) {
            tab[i] = tab[i - 1];
        }
    }

    /**
     * Matrice de pluviométrie pour l'histogramme.
     *
     * @return la matrice de pluviométrie
     */
    static boolean[][] matricePluvioHeure() {
        boolean[][] matricePluvio = new boolean[8][24];
        int nbCases = 0;
        for (int c = 23; c >= 0; c--) {
            double pluvio = pluvioHeure[23 - c];
            if (pluvioHeure[23 - c] == 0) {
                nbCases = 0;
            } else {

                nbCases = 8 - Ecran.numLigne(pluvio, 0, valeurMax(pluvioHeure));
            }

            allumerNbCasesDuBas(matricePluvio, c, nbCases);
        }
        return matricePluvio;
    }

    /**
     * Matrice de températures pour l'histogramme.
     *
     * @return la matrice de températures
     */
    static boolean[][] matriceTemperMinutes() {
        boolean[][] matriceTemper = new boolean[8][24];
        // ...
        return matriceTemper;
    }

    /**
     * Permet d'agréger 60 valeurs dans les 24 colonnes de l'histogramme.
     *
     * @param col numéro de la colonne de l'histogramme
     * @return ensemble d'indices des 60 valeurs correspondantes
     */
    static int[] agreger60vers24(int col) {
        return null;
    }

    /**
     * Extrait les valeurs d'un tableau de doubles, à partir d'un tableau
     * d'indices.
     *
     * @param tab tableau parmi lequel extraire
     * @param indices indices des valeurs à extraires
     * @return tableau de valeurs extraites
     */
    static double[] tableauDepuisIndices(double[] tab, int[] indices) {
        return null;
    }

    /**
     * Positionne les booléens d'une colonne de la matrice, pour un nombre de
     * cases à allumer donné depuis le bas.
     *
     * @param matrice la matrice booléenne à initialiser
     * @param colonne la colonne de la matrice considérée
     * @param nbCases le nombre de cases à allumer dans cette colonne
     */
    static void allumerNbCasesDuBas(boolean[][] matrice, int colonne, int nbCases) {
        int nb = 7 - nbCases;
        for (int l = 0; l < 8; l++) {
            matrice[l][colonne] = false;

        }
        for (int l = 7; l > nb; l--) {
            matrice[l][colonne] = true;
        }
    }

    /**
     * Positionne les booléens d'une colonne de la matrice, entre deux lignes
     * données. Attention il s'agit ici de lignes de l'histogramme, donc en
     * particulier ligneBas >= ligneHaut.
     *
     * @param matrice la matrice booléenne à initialiser
     * @param colonne la colonne de la matrice considérée
     * @param ligneBas le numéro de la ligne du bas à allumer
     * @param ligneHaut le numéro de la ligne du haut à allumer
     */
    static void allumerNbCasesIntervalle(boolean[][] matrice, int colonne,
            int ligneBas, int ligneHaut) {
    }

    /**
     * Valeur maximale d'un tableau de double. Renvoie 0 si le tableau est vide.
     *
     * @param tab le tableau à considérer
     * @return la valeur maximale du tableau, ou 0 s'il est vide.
     */
    static double valeurMax(double[] tab) {
        if (tab.length == 0) {
            return 0;
        }
        double max = tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }

        }

        return max;
    }

    /**
     * Valeur minimale d'un tableau de double. Renvoie 0 si le tableau est vide.
     *
     * @param tab le tableau à considérer
     * @return la valeur minimale du tableau, ou 0 s'il est vide.
     */
    static double valeurMin(double[] tab) {
        if (tab.length == 0) {
            return 0;
        }
        double min = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] < min) {
                min = tab[i];
            }
        }
        return min;
    }

    /**
     * Génère un nombre aléatoire dans un intervalle donné.
     *
     * @param mini borne inférieure de l'intervalle
     * @param maxi borne supérieure de l'intervalle
     * @return un nombre aléatoire dans l'intervalle
     */
    static double aleatoire(double mini, double maxi) {
        return mini + (maxi - mini) * (new Random().nextFloat());
    }
}
