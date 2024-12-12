package fr.esgi.controller;


import fr.esgi.util.SoundManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import fr.esgi.business.SimonGame;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameController {
    @FXML
    private static SimonGame simonGame;

    @FXML
    private Label currentPlayerLabel;


    public void updateCurrentPlayer(String playerName) {
        // Met à jour le texte du label avec le nom du joueur
        currentPlayerLabel.setText("Joueur en cours : " + playerName);
    }

    private String colorPick;
    private SimonGame game;

    @FXML
    private Button redButton;
    
    @FXML
    private Button greenButton;
    
    @FXML
    private Button yellowButton;
    
    @FXML
    private Button blueButton;

    @FXML
    public void onRedClick() {
        SoundManager soundManager = new SoundManager();
        // Gérer l'action pour le bouton rouge
        System.out.println("Red button clicked");
        soundManager.playSound("red");
    }

    @FXML
    public void onGreenClick() {
        SoundManager soundManager = new SoundManager();
        // Gérer l'action pour le bouton vert
        System.out.println("Green button clicked");
        soundManager.playSound("green");
    }

    @FXML
    public void onYellowClick() {
        SoundManager soundManager = new SoundManager();
        // Gérer l'action pour le bouton jaune
        System.out.println("Yellow button clicked");
        soundManager.playSound("yellow");
    }

    @FXML
    public void onBlueClick() {
        SoundManager soundManager = new SoundManager();
        // Gérer l'action pour le bouton bleu
        System.out.println("Blue button clicked");
        soundManager.playSound("blue");
    }

    @FXML
    public void openConfig() {
        // Logique pour ouvrir la fenêtre de configuration
        System.out.println("Opening configuration...");
    }


    @FXML
    public void initialize() {
        if (simonGame != null && simonGame.getCurrentPlayer() != null) {
            String playerName = simonGame.getCurrentPlayer().getNom(); // Assure-toi que tu récupères correctement le nom du joueur
            updateCurrentPlayer(playerName);  // Met à jour le label avec le nom du joueur
        } else {
            System.out.println("Aucun joueur défini");
        }
    }

    public static void setSimonGame(SimonGame game) {
        simonGame = game;
    }

}
