package fr.esgi.services;

import fr.esgi.business.Player;

public interface PlayerService {


    private Player createPlayer(String name){
        Player player = new Player(name);
        return player;
    }

    private void updateScore(Player player, int score){

    }
}
