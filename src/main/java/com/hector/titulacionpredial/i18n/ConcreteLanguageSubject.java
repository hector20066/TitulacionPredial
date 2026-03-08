package com.hector.titulacionpredial.i18n;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the Observer pattern that acts as the
 * centralized observable subject of the system.
 *
 * <p>
 * Use the Singleton pattern to ensure a single instance shared by
 * all application components.
 * </p>
 *
 * <p>
 * It manages an internal list of {@link LanguageObserver} and allows
 * for mass notification when a change occurs in the application's language.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see LanguageSubject
 * @see LanguageObserver
 * @since 1.0
 */
public class ConcreteLanguageSubject implements LanguageSubject {

    private final List<LanguageObserver> observers;
    private static ConcreteLanguageSubject instance;

    /**
     * Private constructor to avoid external instantiation and guarantee
     * the Singleton pattern.
     *
     * <p>
     * Create the observer list instance.
     * </p>
     */
    private ConcreteLanguageSubject() {
        this.observers = new ArrayList<>();
    }

    /**
     * Gets the unique instance of {@link ConcreteLanguageSubject}
     *
     * <p>
     * If the instance does not exist, it creates it. This method is not
     * thread-safe by design, as it runs on the main thread of the Swing
     * application.
     * </p>
     *
     * @return single instance of the specific subject
     */
    public static ConcreteLanguageSubject getInstance() {
        if (instance == null) {
            instance = new ConcreteLanguageSubject();
        }

        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(LanguageObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(LanguageObserver observer) {
        observers.remove(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObserver() {
        observers.forEach(LanguageObserver::updateLanguage);
    }

}
