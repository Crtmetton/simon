package fr.esgi;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class SecondaryController {

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        App.setRoot(stage, "windowsChoice");
    }
}