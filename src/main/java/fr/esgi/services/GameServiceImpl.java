package fr.esgi.services;

import fr.esgi.business.SimonGame;

import java.util.List;

public class GameServiceImpl implements GameService {
    private final SimonGame simonGame;

    public GameServiceImpl() {
        this.simonGame = new SimonGame();
    }

    @Override
    public void startNewGame() {
        simonGame.resetGame();
        addNextColor();
    }

    @Override
    public void addNextColor() {
        simonGame.addRandomColor();
    }

    @Override
    public boolean validateUserInput(String color) {
        return simonGame.validateColor(color);
    }

    @Override
    public List<String> getSequence() {
        return simonGame.getSequence();
    }

    @Override
    public int getScore() {
        return simonGame.getScore();
    }
}
