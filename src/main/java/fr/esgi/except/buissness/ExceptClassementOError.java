package fr.esgi.except.buissness;

/**
 * Une exception pour signaler des erreurs liées à la gestion du classement.
 */
public class ExceptClassementOError extends RuntimeException {

    /**
     * Constructeur par défaut avec un message prédéfini.
     */
    public ExceptClassementOError() {
        super("Erreur liée au système de classement.");
    }

    /**
     * Constructeur permettant de passer un message personnalisé.
     *
     * @param message Message décrivant l'erreur.
     */
    public ExceptClassementOError(String message) {
        super(message);
    }

    /**
     * Constructeur permettant de passer un message et une cause.
     *
     * @param message Message décrivant l'erreur.
     * @param cause Cause de l'exception.
     */
    public ExceptClassementOError(String message, Throwable cause) {
        super(message, cause);
    }
}