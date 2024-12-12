package fr.esgi.except.buissness;

/**
 * Une exception pour signaler des erreurs spécifiques à la gestion de Difficulty.
 */
public class ExceptDifficultyOError extends RuntimeException {

    /**
     * Constructeur par défaut avec un message prédéfini.
     */
    public ExceptDifficultyOError() {
        super("Une erreur liée à Difficulty s'est produite.");
    }

    /**
     * Constructeur permettant de passer un message personnalisé.
     *
     * @param message Message détaillant l'erreur.
     */
    public ExceptDifficultyOError(String message) {
        super(message);
    }

    /**
     * Constructeur permettant de passer un message personnalisé ainsi qu'une cause.
     *
     * @param message Message détaillant l'erreur.
     * @param cause L'exception d'origine ayant causé l'erreur.
     */
    public ExceptDifficultyOError(String message, Throwable cause) {
        super(message, cause);
    }
}