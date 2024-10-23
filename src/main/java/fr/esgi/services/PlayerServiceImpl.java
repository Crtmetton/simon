package fr.esgi.services;

import fr.esgi.business.Joueur;

public class PlayerServiceImpl implements PlayerService {

    private Joueur createPlayer(String name){
        Joueur joueur = new Joueur(name);
        return joueur;
    }

    private void updateScore(Joueur joueur, int score){

    }
}
