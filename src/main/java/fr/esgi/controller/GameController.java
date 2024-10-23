package fr.esgi.controller;

import fr.esgi.services.GameService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameController {
    private GameService gameService;

    private void startGame() {

    }
    private void endGame() {

    }
    private boolean handlePlayerInput(List<String> input) {
        return false;
    }
}
