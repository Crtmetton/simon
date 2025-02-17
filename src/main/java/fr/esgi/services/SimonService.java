package fr.esgi.services;

import fr.esgi.business.Difficulty;
import fr.esgi.business.Joueur;

public interface SimonService {
    /**
     * Calcule le score d'un joueur en fonction de la difficulté.
     * @param player Le joueur.
     * @param difficulty La difficulté actuelle.
     */
    void doCalcScore(Joueur player, Difficulty difficulty);

    /**
     * Génère une nouvelle séquence pour le jeu Simon.
     */
    void doSeqGame();
}
