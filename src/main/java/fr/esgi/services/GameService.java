package fr.esgi.services;

import java.util.List;

public interface GameService {
    void startNewGame();
    void addNextColor();
    boolean validateUserInput(String color);
    List<String> getSequence();
    int getScore();
}