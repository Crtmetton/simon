package fr.esgi.except.buissness;

/**
 * Une exception pour signaler des erreurs spécifiques à la gestion des joueurs.
 */
public class ExceptPlayerOError extends RuntimeException {

    /**
     * Constructeur par défaut avec un message prédéfini.
     */
    public ExceptPlayerOError() {
        super("Une erreur liée à la gestion du joueur s'est produite.");
    }

    /**
     * Constructeur permettant de passer un message personnalisé.
     *
     * @param message Message détaillant l'erreur.
     */
    public ExceptPlayerOError(String message) {
        super(message);
    }

    /**
     * Constructeur permettant de passer un message personnalisé ainsi qu'une cause.
     *
     * @param message Message détaillant l'erreur.
     * @param cause L'exception d'origine ayant causé l'erreur.
     */
    public ExceptPlayerOError(String message, Throwable cause) {
        super(message, cause);
    }
}