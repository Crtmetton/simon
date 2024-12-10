package fr.esgi.controller;

import fr.esgi.business.Joueur;
import fr.esgi.business.SimonGame;
import fr.esgi.services.PlayerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import fr.esgi.App;
public class PlayerController {
    @FXML
    private VBox playerFieldsContainer;
    @FXML
    private TextField playerCountField;

    private boolean isMulti = false;

    @FXML
    public void initialize() {
        // Afficher le champ de saisie si multi-joueurs
        playerCountField.setVisible(isMulti);
        createPlayerFields(1); // Par défaut, un seul joueur pour solo
    }

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        // Récupérer les noms des joueurs et créer les objets Joueur
        List<String> playerNames = playerFieldsContainer.getChildren().stream()
                .filter(node -> node instanceof TextField)
                .map(node -> ((TextField) node).getText())
                .collect(Collectors.toList());

        // Créer la liste de joueurs
        List<Joueur> joueurs = playerNames.stream()
                .map(nom -> new Joueur(nom))  // Crée un objet Joueur pour chaque nom
                .collect(Collectors.toList());

        // Transmettre les joueurs à l'instance de SimonGame
        SimonGame simonGame = new SimonGame();
        simonGame.setJoueurs(joueurs);  // Ajouter les joueurs à l'instance de SimonGame

        // Initialiser le premier joueur (ou faire d'autres initialisations selon le besoin)
        simonGame.setCurrentPlayer(joueurs.get(0));  // Par exemple, choisir le premier joueur

        // Passer à la fenêtre suivante
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        App.setRoot(stage, "windowsChoice");
    }


    private void createPlayerFields(int playerCount) {
        playerFieldsContainer.getChildren().clear();
        for (int i = 0; i < playerCount; i++) {
            TextField playerField = new TextField();
            playerField.setPromptText("Nom du joueur " + (i + 1));
            playerFieldsContainer.getChildren().add(playerField);
        }
    }
}
