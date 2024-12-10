package fr.esgi.controller;

import fr.esgi.services.GameService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import fr.esgi.business.SimonGame; 

import java.util.List;

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
        // Gérer l'action pour le bouton rouge
        System.out.println("Red button clicked");
    }

    @FXML
    public void onGreenClick() {
        // Gérer l'action pour le bouton vert
        System.out.println("Green button clicked");
    }

    @FXML
    public void onYellowClick() {
        // Gérer l'action pour le bouton jaune
        System.out.println("Yellow button clicked");
    }

    @FXML
    public void onBlueClick() {
        // Gérer l'action pour le bouton bleu
        System.out.println("Blue button clicked");
    }

    @FXML
    public void openConfig() {
        // Logique pour ouvrir la fenêtre de configuration
        System.out.println("Opening configuration...");
    }

    public static void setSimonGame(SimonGame game) {
        simonGame = game;
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




}
