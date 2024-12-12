package fr.esgi.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The SimonGame class tracks scores, historical max levels, and handles gameplay logic
 * for both single-player and multiplayer modes.
 */
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
    private List<Joueur> joueurs = Collections.synchronizedList(new ArrayList<>()); // Thread-safe list
    private boolean multiplayer; // Boolean to track multiplayer mode

    /**
     * Execute a turn in the game, handling either single-player or multiplayer mode.
     */
    public void playTurn() {
        if (multiplayer) {
            if (joueurs == null || joueurs.isEmpty()) {
                throw new IllegalStateException("Players list is empty in multiplayer mode!");
            }
            System.out.println("Multiplayer mode activated.");
            Joueur fastestPlayer = null;
            long fastestTime = Long.MAX_VALUE;

            for (Joueur joueur : joueurs) {
                System.out.println("Player's turn: " + joueur.getNom());
                long startTime = System.nanoTime(); // Start the timer
                if (!realizeSequence(joueur)) { // Simulate the sequence performed by the player
                    System.out.println(joueur.getNom() + " failed the sequence!");
                }
                long endTime = System.nanoTime(); // End the timer
                long duration = endTime - startTime;
                System.out.println("Time for " + joueur.getNom() + ": " + duration + " nanoseconds.");

                // Determine the fastest player
                if (duration < fastestTime) {
                    fastestTime = duration;
                    fastestPlayer = joueur;
                }
            }

            if (fastestPlayer != null) {
                System.out.println("The fastest player is: " + fastestPlayer.getNom());
                fastestPlayer.setScore(fastestPlayer.getScore() +
                        difficulty.getByCode(difficulty.getCode()).getPoint());  // Award a point
            }
        } else {
            if (currentPlayer == null) {
                throw new IllegalStateException("Current player is not initialized!");
            }
            System.out.println("Single-player mode activated for: " + currentPlayer.getNom());
            long startTime = System.nanoTime();
            if (!realizeSequence(currentPlayer)) {
                System.out.println(currentPlayer.getNom() + " failed the sequence!");
            }
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Time taken by the player: " + duration + " nanoseconds.");
        }
    }

    /**
     * Simulate the completion of a sequence by a player.
     * Replace with your actual game logic.
     *
     * @param joueur The active player.
     * @return true if the sequence is successfully completed, false otherwise.
     */
    private boolean realizeSequence(Joueur joueur) {
        // Insert logic here to verify if the player successfully completes the sequence
        System.out.println("Simulating sequence for: " + joueur.getNom());
        // For example, compare the sequence entered by the player with the actual sequence.
        return Math.random() > 0.5; // Replace with actual success check
    }

    /**
     * Getter for the current player.
     *
     * @return The current player.
     */
    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }
}