package fr.esgi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import fr.esgi.business.Joueur;
import fr.esgi.business.SimonGame;
import fr.esgi.controller.GameController;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;

public class PrimaryController {

    @FXML
    private VBox multiChoiceContainer; // Conteneur des boutons "2 joueurs" et "4 joueurs"
    
    @FXML
    private VBox playerFieldsContainer; // Conteneur pour les champs des pseudos
    
    @FXML
    private Button validateButton;

    // Méthode pour sélectionner le mode solo
    @FXML
    private void goToSoloChoice(ActionEvent event) {
        // Transition vers le mode solo
        playerFieldsContainer.getChildren().clear();
        generatePlayerFields(1); // Un champ pour le pseudo en mode solo
        playerFieldsContainer.setVisible(true);
        validateButton.setVisible(true);
    }

    // Méthode pour sélectionner le mode multi-joueurs
    @FXML
    private void goToMultiChoice(ActionEvent event) {
        // Affiche les boutons de sélection du nombre de joueurs
        multiChoiceContainer.setVisible(true);
    }

    // Méthode pour choisir 2 joueurs en mode multi
    @FXML
    private void goToMultiChoice2(ActionEvent event) {
        multiChoiceContainer.setVisible(false); // Masque les boutons de choix
        playerFieldsContainer.getChildren().clear(); // Vide les champs existants
        generatePlayerFields(2); // Crée 2 champs pour les pseudos
        playerFieldsContainer.setVisible(true);
        validateButton.setVisible(true); // Affiche le bouton de validation
    }

    // Méthode pour choisir 4 joueurs en mode multi
    @FXML
    private void goToMultiChoice4(ActionEvent event) {
        multiChoiceContainer.setVisible(false); // Masque les boutons de choix
        playerFieldsContainer.getChildren().clear(); // Vide les champs existants
        generatePlayerFields(4); // Crée 4 champs pour les pseudos
        playerFieldsContainer.setVisible(true);
        validateButton.setVisible(true); // Affiche le bouton de validation
    }

    // Génère les champs de texte pour les pseudos des joueurs
    private void generatePlayerFields(int count) {
        for (int i = 1; i <= count; i++) {
            TextField textField = new TextField();
            textField.setPromptText("Pseudo joueur " + i);
            playerFieldsContainer.getChildren().add(textField); // Ajoute le champ pour chaque joueur
        }
    }

    @FXML
    private void onValidate() {
        try {
            // Récupérer les pseudos des joueurs
            List<String> playerNames = playerFieldsContainer.getChildren().stream()
                    .filter(node -> node instanceof TextField)
                    .map(node -> ((TextField) node).getText())
                    .collect(Collectors.toList());

            // Créer les objets Joueur
            List<Joueur> joueurs = playerNames.stream()
                    .map(nom -> new Joueur(nom))  // Crée un objet Joueur pour chaque pseudo
                    .collect(Collectors.toList());

            // Initialiser SimonGame avec les joueurs
            SimonGame simonGame = new SimonGame();
            simonGame.setJoueurs(joueurs);

            // Si nécessaire, définir le joueur actuel (par exemple, le premier joueur)
            if (!joueurs.isEmpty()) {
                simonGame.setCurrentPlayer(joueurs.get(0));
            }

            // Passer l'instance de SimonGame au GameController ou dans une méthode statique
            GameController.setSimonGame(simonGame);  // Méthode pour transmettre SimonGame au GameController

            // Charger la scène du jeu
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/esgi/windowsGame.fxml"));
            Parent gameRoot = loader.load();

            // Créer une nouvelle scène et la définir sur le stage principal
            Scene gameScene = new Scene(gameRoot);
            Stage currentStage = (Stage) validateButton.getScene().getWindow();
            currentStage.setScene(gameScene);
            currentStage.show();

            simonGame.startGame(); // Lancer le jeu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
