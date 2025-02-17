package fr.esgi.services;

import fr.esgi.business.Difficulty;
import fr.esgi.business.Joueur;

import java.util.ArrayList;
import java.util.List;

public class SimonServiceImpl implements SimonService {
    private List<Integer> sequence = new ArrayList<>();

    @Override
    public void doCalcScore(Joueur player, Difficulty difficulty) {
        int newScore = player.getScore() + difficulty.getPoint();
        player.setScore(newScore);
        System.out.println("Nouveau score pour " + player.getNom() + ": " + newScore);
    }

    @Override
    public void doSeqGame() {
        // Ajoute un nouvel élément à la séquence
        sequence.add((int) (Math.random() * 4)); // Exemple : valeurs 0 à 3 pour 4 couleurs
        System.out.println("Nouvelle séquence : " + sequence);
    }
}
