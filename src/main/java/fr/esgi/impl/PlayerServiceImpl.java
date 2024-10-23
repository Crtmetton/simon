package fr.esgi.impl;

import fr.esgi.business.Player;
import fr.esgi.services.PlayerService;

public class PlayerServiceImpl implements PlayerService {

    private Player createPlayer(String name){
        Player player = new Player(name);
        return player;
    }

    private void updateScore(Player player, int score){

    }
}
