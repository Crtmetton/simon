package fr.esgi.business;

import lombok.*;
import java.util.Objects;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Joueur {
        private long id;
        @NonNull
        private String nom; // Nom du joueur
        private String prenom; // Prénom du joueur
        private int score; // Score du joueur
        private int classement; // Classement du joueur
        private long compteur = 0L; // Compteur pour des actions spécifiques
    
        // Constructor
        public Joueur(long id, String nom, String prenom, int score, int classement) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.score = score;
            this.classement = classement;
        }
    
        // Getter pour le nom
        public String getNom() {
            return nom;
        }
    
        // Setter pour le nom (si nécessaire)
        public void setNom(String nom) {
            this.nom = nom;
        }
    
        // Getter et Setter pour les autres attributs (si nécessaire)
        public long getId() {
            return id;
        }
    
        public void setId(long id) {
            this.id = id;
        }
    
        public String getPrenom() {
            return prenom;
        }
    
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
    
        public int getScore() {
            return score;
        }
    
        public void setScore(int score) {
            this.score = score;
        }
    
        public int getClassement() {
            return classement;
        }
    
        public void setClassement(int classement) {
            this.classement = classement;
        }
    
        public long getCompteur() {
            return compteur;
        }
    
        public void setCompteur(long compteur) {
            this.compteur = compteur;
        }
    }
