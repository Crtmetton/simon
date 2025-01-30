package fr.esgi.business;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * Ceci est la declaration de la Classe Joueur avec les Prperties sont pour la creation et les datas des joueurs present dans la partie en cours
 */
@Data
public class Joueur {
        private long id;
        @NonNull
        private String nom;
        private String prenom;
        private int score;
        private int currentLevel;
        private Classement classement;
        private List<String> sequence;
        private long compteur = 0L;

        public Joueur(@NonNull String nom) {
                this.nom = nom;
        }

        public Joueur(long id, @NonNull String nom, String prenom, int score, Classement classement, long compteur) {
                this.id = id;
                this.nom = nom;
                this.prenom = prenom;
                this.score = score;
                this.classement = classement;
                this.compteur = compteur;
        }

        public Joueur() {
        }

        public long getId() {
                return this.id;
        }

        public @NonNull String getNom() {
                return this.nom;
        }

        public String getPrenom() {
                return this.prenom;
        }

        public int getScore() {
                return this.score;
        }

        public Classement getClassement() {
                return this.classement;
        }

        public long getCompteur() {
                return this.compteur;
        }

        public void setId(long id) {
                this.id = id;
        }

        public int getCurrentLevel() {
                return this.currentLevel;
        }
        public void setNom(@NonNull String nom) {
                this.nom = nom;
        }

        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }

        public void setScore(int score) {
                this.score = score;
        }

        public void setClassement(Classement classement) {
                this.classement = classement;
        }

        public void setCompteur(long compteur) {
                this.compteur = compteur;
        }

        public boolean equals(final Object o) {
                if (o == this) return true;
                if (!(o instanceof Joueur)) return false;
                final Joueur other = (Joueur) o;
                if (!other.canEqual((Object) this)) return false;
                if (this.getId() != other.getId()) return false;
                final Object this$nom = this.getNom();
                final Object other$nom = other.getNom();
                if (this$nom == null ? other$nom != null : !this$nom.equals(other$nom)) return false;
                final Object this$prenom = this.getPrenom();
                final Object other$prenom = other.getPrenom();
                if (this$prenom == null ? other$prenom != null : !this$prenom.equals(other$prenom)) return false;
                if (this.getScore() != other.getScore()) return false;
                final Object this$classement = this.getClassement();
                final Object other$classement = other.getClassement();
                if (this$classement == null ? other$classement != null : !this$classement.equals(other$classement))
                        return false;
                if (this.getCompteur() != other.getCompteur()) return false;
                return true;
        }

        protected boolean canEqual(final Object other) {
                return other instanceof Joueur;
        }

        public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                final long $id = this.getId();
                result = result * PRIME + (int) ($id >>> 32 ^ $id);
                final Object $nom = this.getNom();
                result = result * PRIME + ($nom == null ? 43 : $nom.hashCode());
                final Object $prenom = this.getPrenom();
                result = result * PRIME + ($prenom == null ? 43 : $prenom.hashCode());
                result = result * PRIME + this.getScore();
                final Object $classement = this.getClassement();
                result = result * PRIME + ($classement == null ? 43 : $classement.hashCode());
                final long $compteur = this.getCompteur();
                result = result * PRIME + (int) ($compteur >>> 32 ^ $compteur);
                return result;
        }

        public String toString() {
                return "Joueur(id=" + this.getId() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", score=" + this.getScore() + ", classement=" + this.getClassement() + ", compteur=" + this.getCompteur() + ")";
        }
}


