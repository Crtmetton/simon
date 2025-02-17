package fr.esgi.business;

/**
 * Enumération représentant les niveaux de difficulté dans le jeu Simon.
 * Chaque niveau de difficulté est associé à un identifiant unique (code) et une description.
 */
public enum Difficulty {

    EASY(1,100,60000,"Facile",10),
    MEDIUM(2,200,45000, "Moyen",20),
    HARD(3,300,30000,"Difficile",30);

    private final int code;         // Identifiant unique de chaque difficulté
    private final String description; // Description lisible de la difficulté
    private final int speed;
    private final int time ;
    private final int point ;
    /**
     * Constructeur de l'énumération Difficulty.
     *
     * @param code L'identifiant unique pour le niveau de difficulté.
     * @param description La description du niveau de difficulté.
     */
    Difficulty(int code, int speed, int time,
               String description, int point) {
        this.code = code;
        this.description = description;
        this.speed = speed;
        this.time = time;
        this.point = point;
    }

    /**
     * Méthode permettant de récupérer un niveau de difficulté à partir de son identifiant.
     *
     * @param code Le code correspondant au niveau de difficulté recherché.
     * @return Une instance de Difficulty correspondant au code donné.
     * @throws IllegalArgumentException Si aucun niveau de difficulté ne correspond au code donné.
     */
    public static Difficulty getByCode(int code) {
        for (Difficulty difficulty : Difficulty.values()) { // Parcours des valeurs de l'énum
            if (difficulty.code == code) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("Code de difficulté invalide : " + code);
    }

    /**
     * Retourne le code (id) associé à ce niveau de difficulté.
     *
     * @return Le code de la difficulté.
     */
    public int getCode() {
        return code;
    }

    /**
     * Retourne la description lisible associée à ce niveau de difficulté.
     *
     * @return La description de la difficulté.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retourne la vitesse lisible associée à ce niveau de difficulté.
     *
     * @return La vitesse de la difficulté.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Retourne le temps alloué pour faire la sequence en temps max lisible associée à ce niveau de difficulté.
     *
     * @return Le temps de la difficulté.
     */
    public int getTime() {
        return time;
    }

    /**
     * Retourne les points données lisible associée à ce niveau de difficulté.
     *
     * @return Les points de la difficulté.
     */
    public int getPoint() {
        return point;
    }
}