package fr.esgi.business;

import fr.esgi.util.SoundManager;
import javafx.fxml.FXML;
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
    private int sequenceIndexPlayer;
    private List<String> sequence = new ArrayList<>(); // Sequence of colors (e.g., "Red", "Blue")
    private Joueur currentPlayer;
    private int maxLevel;
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
        maxLevel = 0;
        sequenceIndexPlayer = 0;

        if (multiplayer) {
            joueurs.forEach(joueur -> {
                joueur.setScore(0);
                joueur.setCurrentLevel(0);
            });
        } else if (currentPlayer != null) {
            currentPlayer.setScore(0);
            currentPlayer.setCurrentLevel(0);
        }
        addRandomColor();
    }

    /**
     * Adds a random color to the sequence to increase the game's difficulty.
     */
    public void addRandomColor() {
        SoundManager soundManager = new SoundManager();
        String[] colors = {"red", "blue", "green", "yellow"};
        sequence.add(colors[random.nextInt(colors.length)]);
        System.out.println(sequence.toString());
        if (sequence.size() == 10) {
            return;
        }
        for (int i = 0; i < sequence.size(); i++) {
            soundManager.playSound(sequence.get(i).toString());
        }
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

    public void handleSinglePlayerTurn() {
        if (currentPlayer == null) {
            throw new IllegalStateException("Current player is not initialized!");
        }

        System.out.println("Single-player mode activated for: " + currentPlayer.getNom());

        // Récupère la séquence complète du joueur
        List<String> playerSequence = getPlayerSequence(currentPlayer);

        // Vérifie si le joueur a terminé d'entrer sa séquence
        if (playerSequence.size() < sequence.size()) {
            System.out.println("Player's sequence is incomplete.");
            return; // Attendre que le joueur finisse sa séquence
        }

        // Valide la séquence du joueur
        if (validateFullSequence(playerSequence)) {
            score++;
            currentPlayer.setScore(score);

            System.out.println("Sequence complete! Score: " + score);
            addRandomColor(); // Ajoute une nouvelle couleur à la séquence
        } else {
            System.out.println("Game Over! Final Score: " + score);
            resetGame(); // Réinitialise le jeu
        }
    }

    private boolean validateFullSequence(List<String> playerSequence) {
        for (int i = 0; i < sequence.size(); i++) {
            if (!sequence.get(i).equals(playerSequence.get(i))) {
                return false; // La séquence n'est pas correcte
            }
        }
        return true; // La séquence est correcte
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
        int currentLevel = joueur.getCurrentLevel(); // Récupère le niveau du joueur
        if (currentLevel >= sequence.size()) {
            throw new IndexOutOfBoundsException("The player's current level is out of bounds!");
        }
        List<String> playerSequence = getPlayerSequence(joueur);
        for (int i = 0; i <= currentLevel; i++) {
            if (!sequence.get(i).equals(playerSequence.get(i))) {
                return false;
            }
        }

        // Avance le joueur au niveau suivant si la séquence est correcte
        joueur.setCurrentLevel(currentLevel + 1);
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
        if (multiplayer) {
            joueurs.forEach(joueur -> joueur.setCurrentLevel(0));
        } else if (currentPlayer != null) {
            currentPlayer.setCurrentLevel(0);
        }
        addRandomColor();
    }

    /**
     * Validates if the provided color is the next correct color in the sequence.
     *
     * @param color The color provided by the player.
     * @return true if the color is correct, false otherwise.
     */
    @FXML
    public boolean validateColor(String color) {
        if (sequence.isEmpty()) {
            throw new IllegalStateException("The sequence is empty!");
        }

        if (currentPlayer == null) {
            throw new IllegalStateException("Current player is not set!");
        }

        // Ajoute la couleur choisie à l'entrée du joueur
        List<String> currentPlayerInput = List.of();
        currentPlayerInput.add(color);
        System.out.println("Player - Current Input: " + currentPlayerInput);
        System.out.println("Sequence - Expected: " + sequence);

        // Vérifie si le joueur a terminé d'entrer toute la séquence
        if (currentPlayerInput.size() == sequence.size()) {
            // Valide la séquence complète
            if (validateFullSequence(currentPlayerInput)) {
                System.out.println("Sequence complete! Score: " + score);
                score++;
                currentPlayer.setScore(score);
                addRandomColor(); // Ajoute une nouvelle couleur
            } else {
                System.out.println("Incorrect sequence! Game over.");
                resetGame(); // Réinitialise le jeu
            }
            currentPlayerInput.clear(); // Réinitialise l'entrée du joueur pour la prochaine séquence
        } else {
            // Attend que le joueur termine sa séquence
            System.out.println("Waiting for the player to finish the sequence...");
        }
        return false;
    }
}