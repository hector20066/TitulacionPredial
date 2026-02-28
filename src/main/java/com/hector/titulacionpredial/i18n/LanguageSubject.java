package com.hector.titulacionpredial.i18n;

/**
 * Interfaz que define el contrato del sujeto observable
 * dentro del patron Observer del sistema i18n.
 *
 * <p>
 * Permite registrar, eliminar y notificar a los {@link LanguageObserver}
 * suscritos ante cambios de estado en el sistema, reaccionando cada
 * vez que se cambie el idioma de la aplicacion.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see LanguageObserver
 * @see ConcreteLanguageSubject
 * @since 1.0
 */
public interface LanguageSubject {

    /**
     * Registra un observador para recibir notificaciones.
     *
     * @param observer observador a registrar.
     */
    void register(LanguageObserver observer);

    /**
     * Eliminar un observador previamente registrado.
     *
     * @param observer observador a eliminar.
     */
    void remove(LanguageObserver observer);

    /**
     * Notifica a todos los observadores registrados
     * sobre un cambio de estado.
     */
    void notifyObserver();

}
