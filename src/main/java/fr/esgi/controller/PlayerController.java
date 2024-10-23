package fr.esgi.controller;

import fr.esgi.business.Joueur;
import fr.esgi.services.PlayerService;

public class PlayerController {
    private PlayerService playerService;

    private Joueur createPlayer(String nom) {
        return new Joueur(nom);
    }

    private void updateScore(String nom, int score) {

    }
}
