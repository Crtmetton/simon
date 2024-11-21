package fr.esgi.business;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Cette classe gère le classement des joueurs en fonction de leurs scores.
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Classement {

    private int rankingPlayer;

    @NonNull
    private List<Joueur> players;

    private List<Joueur> rankedJoueurs;

    /**
     * Cette méthode classe les joueurs en fonction de leurs scores.
     */
    public void doRankingPlayer() {
        //$TASK$ Tri players décroissant
        rankedJoueurs = new ArrayList<>(players);
        rankedJoueurs.sort(Comparator.comparingInt(Joueur::getScore).reversed());

        //$TASK$ Show Rank
        System.out.println("Classement des joueurs : ");
        for (int i = 0; i < rankedJoueurs.size(); i++) {
            Joueur joueur = rankedJoueurs.get(i);
            System.out.println((i + 1) + ". " + joueur.getNom() + " - Score: " + joueur.getScore());
        }
    }
}