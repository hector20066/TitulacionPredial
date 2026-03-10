package com.hector.titulacionpredial.i18n;

/**
 * Functional interface that defines the contract of an observer
 * within the Observer pattern implemented for the system
 * <strong>i18n.</strong>
 *
 * <p>
 * Observers register in a {@link LanguageSubject} and are notified
 * when the application language changes, allowing reactive updating
 * of components such as panels with texts in the selected language.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see LanguageSubject
 * @see ConcreteLanguageSubject
 * @since 1.0
 */
@FunctionalInterface
public interface LanguageObserver {

    /**
     * <p>
     * Method invoked when the {@link LanguageSubject} notifies its
     * registered observers of a change in <strong>state</strong>.
     * </p>
     *
     * <p>
     * The <strong>state</strong> refers to the app's language change.
     * </p>
     */
    void updateLanguage();

}
