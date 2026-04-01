package com.hector.titulacionpredial.observer;

/**
 * Functional interface that defines the contract of an observer
 * within the Observer pattern implemented in the system.
 *
 * <p>
 * Observers register in a {@link Subject} and are notified when
 * a relevant state change occurs, allowing reactive updating of
 * components such as dashboard panels, tables, and views.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Subject
 * @see ConcreteSubject
 * @since 1.0
 */
@FunctionalInterface
public interface Observer {

    /**
     * Method invoked when the {@link Subject} notifies its registered
     * observers of a state change.
     *
     * <p>
     * This is the callback method that implementing classes must override
     * to react to state changes in the observed subject.
     * </p>
     */
    void update();

}
