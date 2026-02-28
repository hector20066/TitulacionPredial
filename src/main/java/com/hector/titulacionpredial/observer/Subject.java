package com.hector.titulacionpredial.observer;

/**
 * Interfaz que define el contrato del sujeto observable
 * dentro del patrón Observer.
 *
 * <p>
 * Permite registrar, eliminar y notificar a los {@link Observer}
 * suscritos ante cambios de estado en el sistema.
 * </p>
 *
 * @author Hector Acevedo
 * @see Observer
 * @see ConcreteSubject
 * @since 1.0
 */
public interface Subject {

    /**
     * Registra un observador para recibir notificaciones.
     *
     * @param observer observador a registrar
     */
    void register(Observer observer);

    /**
     * Elimina un observador previamente registrado.
     *
     * @param observer observador a eliminar
     */
    void remove(Observer observer);

    /**
     * Notifica a todos los observadores registrados
     * sobre un cambio de estado.
     */
    void notifyObservers();

}
