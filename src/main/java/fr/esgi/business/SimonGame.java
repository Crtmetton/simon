package fr.esgi.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.ArrayList;


/**
 Ceci est la declaration de la Classe SimonGame avec les Prperties qui sont present ici on va pouvoir suivre les score et le max levels historique atteint par le joueur
 * */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimonGame {
    private int score;
    private List<Integer> sequence;
    private Joueur currentPlayer;
    private int maxLevel;
    private int currentLevel;
    private Difficulty difficulty;
    private List<Joueur> joueurs;

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setCurrentPlayer(Joueur currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }
}
