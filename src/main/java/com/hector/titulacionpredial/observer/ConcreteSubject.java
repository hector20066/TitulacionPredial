package com.hector.titulacionpredial.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the Observer pattern that acts
 * as the centralized observable subject of the system.
 *
 * <p>
 * Use the Singleton pattern to ensure a single instance shared
 * by all application components.
 * </p>
 *
 * <p>
 * Manage an internal list of {@link Observer} and allow you to
 * notify them en masse when a relevant change occurs in the system
 * state (e.g., registration, modification or deletion of data).
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Subject
 * @see Observer
 * @since 1.0
 */
public class ConcreteSubject implements Subject {

    private static ConcreteSubject instance;
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Private constructor to avoid external instantiation and
     * guarantee the Singleton pattern.
     */
    private ConcreteSubject() {

    }

    /**
     * Gets the unique instance of {@link ConcreteSubject}.
     *
     * <p>
     * If the instance does not exist, it creates it. This method is
     * not thread-safe by design, as it runs on the main thread of
     * the Swing application.
     * </p>
     *
     * @return instancia única del sujeto concreto
     */
    public static ConcreteSubject getInstance() {
        if (instance == null) {
            instance = new ConcreteSubject();
        }

        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * register.     * @param observer the observer     */
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * remove.     * @param observer the observer     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * notify observers.     */
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

}
