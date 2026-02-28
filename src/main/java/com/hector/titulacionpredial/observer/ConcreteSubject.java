package com.hector.titulacionpredial.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta del patrón Observer que actúa como
 * sujeto observable centralizado del sistema.
 *
 * <p>
 * Utiliza el patrón Singleton para garantizar una única instancia
 * compartida por todos los componentes de la aplicación.
 * </p>
 *
 * <p>
 * Gestiona una lista interna de {@link Observer} y permite
 * notificarlos de forma masiva cuando ocurre un cambio relevante
 * en el estado del sistema (por ejemplo, registro, modificación
 * o eliminación de datos).
 * </p>
 *
 * @author Hector Acevedo
 * @see Subject
 * @see Observer
 * @since 1.0
 */
public class ConcreteSubject implements Subject {

    /**
     * Instancia única del sujeto concreto (Singleton).
     */
    private static ConcreteSubject instance;

    /**
     * Lista de observadores registrados.
     */
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Constructor privado para evitar instanciación externa
     * y garantizar el patrón Singleton.
     */
    private ConcreteSubject() {

    }

    /**
     * Obtiene la instancia única de {@link ConcreteSubject}.
     *
     * <p>
     * Si la instancia no existe, la crea. Este método no es
     * thread-safe por diseño, ya que se ejecuta en el hilo
     * principal de la aplicación Swing.
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
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

}
