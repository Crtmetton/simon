package fr.esgi.business;

import java.util.Objects;

public class Joueur {
        private long id;
        private String nom;
        private String prenom;
        private int score;
        private int classment;
        private long compteur = 0L;

    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Joueur(int classment, int score, String prenom, String nom, long id) {
        this.classment = classment;
        this.score = score;
        this.prenom = prenom;
        this.nom = nom;
        this.id = id;
    }

    public Joueur() {
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", score=" + score +
                ", classment=" + classment +
                ", compteur=" + compteur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return id == joueur.id && score == joueur.score && classment == joueur.classment && compteur == joueur.compteur && Objects.equals(nom, joueur.nom) && Objects.equals(prenom, joueur.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, score, classment, compteur);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Getter
    //
    /////////////////////////////////////////////////////////////////////////////////////////

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getScore() {
        return score;
    }

    public int getClassment() {
        return classment;
    }

    public long getCompteur() {
        return compteur;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Setter
    //
    /////////////////////////////////////////////////////////////////////////////////////////


    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setClassment(int classment) {
        this.classment = classment;
    }

    public void setCompteur(long compteur) {
        this.compteur = compteur;
    }
}


