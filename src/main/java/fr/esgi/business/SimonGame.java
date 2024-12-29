package fr.esgi.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The SimonGame class tracks scores, historical max levels, and handles gameplay logic
 * for both single-player and multiplayer modes.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimonGame {

    private int score;
    private List<String> sequence = new ArrayList<>(); // Sequence of colors (e.g., "Red", "Blue")
    private Joueur currentPlayer;
    private int maxLevel;
    private int currentLevel = 0;
    private Difficulty difficulty;
    private List<Joueur> joueurs = Collections.synchronizedList(new ArrayList<>()); // Thread-safe list
    private boolean multiplayer; // Boolean to track multiplayer mode
    private int currentPlayerIndex = 0; // Index to track turns in multiplayer mode
    private Random random = new Random();

    /**
     * Starts a new game, resetting the sequence and scores.
     */
    public void startGame() {
        sequence.clear();
        score = 0;
        currentLevel = 0;
        maxLevel = 0;

        if (multiplayer) {
            joueurs.forEach(joueur -> joueur.setScore(0));
        } else if (currentPlayer != null) {
            currentPlayer.setScore(0);
        }
        addRandomColor();
    }

    /**
     * Adds a random color to the sequence to increase the game's difficulty.
     */
    public void addRandomColor() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        sequence.add(colors[random.nextInt(colors.length)]);
        currentLevel++;
    }

    /**
     * Executes a turn in the game, handling either single-player or multiplayer mode.
     */
    public void playTurn() {
        if (multiplayer) {
            handleMultiplayerTurn();
        } else {
            handleSinglePlayerTurn();
        }
    }

    private void handleSinglePlayerTurn() {
        if (currentPlayer == null) {
            throw new IllegalStateException("Current player is not initialized!");
        }
        System.out.println("Single-player mode activated for: " + currentPlayer.getNom());

        if (validateSequence(currentPlayer)) {
            score++;
            currentPlayer.setScore(score);
            addRandomColor();
            System.out.println("Sequence complete! Score: " + score);
        } else {
            System.out.println("Game Over! Final Score: " + score);
            resetGame();
        }
    }

    private void handleMultiplayerTurn() {
        if (joueurs == null || joueurs.isEmpty()) {
            throw new IllegalStateException("Players list is empty in multiplayer mode!");
        }
        System.out.println("Multiplayer mode activated.");

        Joueur joueur = joueurs.get(currentPlayerIndex);
        System.out.println("Player's turn: " + joueur.getNom());

        if (validateSequence(joueur)) {
            joueur.setScore(joueur.getScore() + 1);
            System.out.println(joueur.getNom() + " completed the sequence! Score: " + joueur.getScore());
        } else {
            System.out.println(joueur.getNom() + " failed the sequence!");
        }

        // Move to the next player
        currentPlayerIndex = (currentPlayerIndex + 1) % joueurs.size();

        // Add a new color after all players have played
        if (currentPlayerIndex == 0) {
            addRandomColor();
        }
    }

    /**
     * Validates the player's input sequence against the game sequence.
     *
     * @param joueur The active player.
     * @return true if the sequence is correct, false otherwise.
     */
    private boolean validateSequence(Joueur joueur) {
        List<String> playerSequence = getPlayerSequence(joueur);
        if (playerSequence.size() != sequence.size()) {
            return false;
        }
        for (int i = 0; i < sequence.size(); i++) {
            if (!sequence.get(i).equals(playerSequence.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Simulates the player's input for the sequence.
     * Replace this method with actual input logic from the UI.
     *
     * @param joueur The active player.
     * @return The player's input sequence.
     */
    private List<String> getPlayerSequence(Joueur joueur) {
        // For now, simulate correct input 80% of the time.
        if (Math.random() < 0.8) {
            return new ArrayList<>(sequence); // Simulate correct input
        } else {
            // Simulate incorrect input by modifying one random element
            List<String> incorrectSequence = new ArrayList<>(sequence);
            int randomIndex = random.nextInt(sequence.size());
            incorrectSequence.set(randomIndex, "Wrong");
            return incorrectSequence;
        }
    }

    /**
     * Resets the game without completely restarting.
     */
    public void resetGame() {
        this.sequence.clear();
        this.score = 0;
        this.currentLevel = 0;
        addRandomColor();
    }

    /**
     * Validates if the provided color is the next correct color in the sequence.
     *
     * @param color The color provided by the player.
     * @return true if the color is correct, false otherwise.
     */
    public boolean validateColor(String color) {
        if (sequence.isEmpty()) {
            throw new IllegalStateException("The sequence is empty!");
        }

        // Check if the provided color matches the expected color in the sequence
        boolean isValid = sequence.get(currentLevel).equals(color);

        // Advance to the next level if the color is correct
        if (isValid) {
            currentLevel++;
        } else {
            System.out.println("Incorrect color! Game over.");
            resetGame(); // Optionally reset the game or handle the end of the round
        }

        return isValid;
    }

    // Getters and setters

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }

    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Joueur currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
