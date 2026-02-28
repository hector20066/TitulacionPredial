package com.hector.titulacionpredial.i18n;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion concreta del patrong Observer que actua como sujeto
 * observable centralizado del sistema.
 *
 * <p>
 * Utiliza el patron Singleton para garantizar una unica instancia
 * compartida por todos los componentes de la aplicacion.
 * </p>
 *
 * <p>
 * Gestiona una lista interna de {@link LanguageObserver} y permite
 * notificarlos de forma masiva cuando ocurre un cambio en el
 * idioma de la aplicacion.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see LanguageSubject
 * @see LanguageObserver
 * @since 1.0
 */
public class ConcreteLanguageSubject implements LanguageSubject {

    /**
     * Lista de Observadores registrados.
     */
    private final List<LanguageObserver> observers;

    /**
     * Instancia unica del sujeto concreto (Singleton).
     */
    private static ConcreteLanguageSubject instance;

    /**
     * Constructor privado para evitar instanciacion externa y
     * garantizar el patron Singleton.
     *
     * <p>
     * Crea la instancia de la lista de observadores.
     * </p>
     */
    private ConcreteLanguageSubject() {
        this.observers = new ArrayList<>();
    }

    /**
     * Obtiene la instancia unica de {@link ConcreteLanguageSubject}
     *
     * <p>
     * Si la instancia no existe, la crea. Este metodo no es Thread-safe
     * por diseño, ya que se ejecuta en el hilo principal de la aplicacion
     * Swing.
     * </p>
     *
     * @return instancia unica del sujeto concreto
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
