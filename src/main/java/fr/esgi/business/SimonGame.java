package fr.esgi.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimonGame {
    private int score;
    private List<Integer> sequence;
    private Joueur currentPlayer;
    private int maxLevel;
    private int currentLevel;
}
