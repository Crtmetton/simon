package fr.esgi.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
}
