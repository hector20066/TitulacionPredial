package com.hector.titulacionpredial.observer;

/**
 * Interfaz funcional que define el contrato de un observador
 * dentro del patrón Observer implementado en el sistema.
 *
 * <p>
 * Los observadores se registran en un {@link Subject} y son
 * notificados cuando ocurre un cambio de estado relevante,
 * permitiendo la actualización reactiva de componentes como
 * paneles de dashboard, tablas y vistas.
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
     * Método invocado cuando el {@link Subject} notifica un cambio
     * de estado a sus observadores registrados.
     */
    void update();

}
