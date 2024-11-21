package fr.esgi.business;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Ceci est la déclaration de la Classe Difficulty avec les propriétés qui permettent
 * de stocker et paramétrer les difficultés qui seront proposées aux joueurs.
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Difficulty {
    /**
     * Propriétés de la difficulté.
     */
    private String name;
    private String description;
    private String type;
    @NonNull
    private int code;

    /**
     * Propriétés spécifiques à la partie.
     */
    private int speed;  // Vitesse de la difficulté.
    private int point;  // Points attribués dans cette difficulté.

    /**
     * Initialise une liste contenant trois niveaux de difficulté prédéfinis.
     *
     * @return Une liste contenant les trois niveaux de difficulté.
     */
    //$TASK$ Basic Diff
    public static List<Difficulty> initBasicThreeDifficulty() {
        List<Difficulty> difficulties = new ArrayList<>();

        /* Difficulté facile */
        difficulties.add(new Difficulty(
                "Facile",
                "Une difficulté adaptée pour les débutants.",
                "Easy",
                1,
                5,
                10
        ));

        /* Difficulté moyenne */
        difficulties.add(new Difficulty(
                "Moyenne",
                "Une difficulté intermédiaire pour les joueurs expérimentés.",
                "Medium",
                2,
                10,
                20
        ));

        /* Difficulté difficile */
        difficulties.add(new Difficulty(
                "Difficile",
                "Une difficulté élevée pour les experts.",
                "Hard",
                3,
                15,
                30
        ));

        return difficulties;
    }
}