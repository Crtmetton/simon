package fr.esgi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        setRoot(primaryStage, "windowsAcc"); // Passer le primaryStage ici
        primaryStage.setTitle("Simon Game");

        // Définir une taille minimale
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);

        // Définir une taille initiale
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        primaryStage.show();
    }

    public static void setRoot(Stage stage, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fr/esgi/" + fxml + ".fxml"));
        Region root = loader.load(); // Charger la scène
        Scene scene = new Scene(root);
        stage.setScene(scene); // Appliquer la scène sur le stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
