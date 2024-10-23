package fr.esgi.controller;

import fr.esgi.business.Player;
import fr.esgi.services.PlayerService;

public class PlayerController {
    private PlayerService playerService;

    private Player createPlayer(String nom) {
        return new Player(nom);
    }

    private void updateScore(String nom, int score) {

    }
}
