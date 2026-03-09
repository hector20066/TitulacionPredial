package com.hector.titulacionpredial.observer;

/**
 * Interface that defines the contract of the observable subject
 * within the Observer pattern.
 *
 * <p>
 * It allows you to register, delete, and notify subscribed
 * {@link Observer} about changes in system status.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Observer
 * @see ConcreteSubject
 * @since 1.0
 */
public interface Subject {

    /**
     * Register an observer to receive notifications.
     *
     * @param observer observer to record
     */
    void register(Observer observer);

    /**
     * Remove a previously registered observer.
     *
     * @param observer observer to be removed
     */
    void remove(Observer observer);

    /**
     * Notify all registered observers about a status change.
     */
    void notifyObservers();

}
