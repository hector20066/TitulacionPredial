package com.hector.titulacionpredial.i18n;

/**
 * Interface that defines the contract of the observable subject within
 * the Observer pattern of the i18n system.
 *
 * <p>
 * It allows you to register, delete, and notify subscribed
 * {@link LanguageObserver} about changes in system status,
 * reacting every time the application language changes.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see LanguageObserver
 * @see ConcreteLanguageSubject
 * @since 1.0
 */
public interface LanguageSubject {

    /**
     * Register an observer to receive notifications.
     *
     * @param observer observer to record.
     */
    void register(LanguageObserver observer);

    /**
     * Remove a previously registered observer.
     *
     * @param observer observer to be removed.
     */
    void remove(LanguageObserver observer);

    /**
     * Notify all registered observers about a status change.
     */
    void notifyObserver();

}
