package fr.esgi.business;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Player {
        private long id;
        @NonNull
        private String nom;
        private String prenom;
        private int score;
        private int classement;
        private long compteur = 0L;
}


