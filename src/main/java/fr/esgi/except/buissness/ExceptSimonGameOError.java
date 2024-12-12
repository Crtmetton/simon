package fr.esgi.except.buissness;

/**
 * Une exception pour signaler des erreurs spécifiques à la classe SimonGame.
 */
public class ExceptSimonGameOError extends RuntimeException {

    /**
     * Constructeur par défaut avec un message prédéfini.
     */
    public ExceptSimonGameOError() {
        super("Une erreur liée à SimonGame s'est produite.");
    }

    /**
     * Constructeur permettant de passer un message personnalisé.
     *
     * @param message Message détaillant l'erreur.
     */
    public ExceptSimonGameOError(String message) {
        super(message);
    }

    /**
     * Constructeur permettant de passer un message personnalisé ainsi qu'une cause.
     *
     * @param message Message détaillant l'erreur.
     * @param cause L'exception d'origine ayant causé l'erreur.
     */
    public ExceptSimonGameOError(String message, Throwable cause) {
        super(message, cause);
    }
}