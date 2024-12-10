package fr.esgi.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.ArrayList;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimonGame {
    private int score;
    private List<Integer> sequence;
    private int maxLevel;
    private int currentLevel;

    private List<Joueur> joueurs;
    private Joueur currentPlayer;

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
