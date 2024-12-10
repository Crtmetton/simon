package fr.esgi.business;

import lombok.*;

/**
 Ceci est la declaration de la Classe Joueur avec les Prperties sont pour la creation et les datas des joueurs present dans la partie en cours
 * */

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Joueur {
        private long id;
        @NonNull
        private String nom;
        private String prenom;
        private int score;
        private Classement classement;
        private long compteur = 0L;
}


