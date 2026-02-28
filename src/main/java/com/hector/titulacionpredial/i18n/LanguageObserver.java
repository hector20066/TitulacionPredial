package com.hector.titulacionpredial.i18n;

/**
 * Intefaz funcional que define el contrato de un observador
 * dentro del patron Observer implementadio para el sistema
 * <strong>i18n.</strong>
 *
 * <p>
 * Los observadores se registran en un {@link LanguageSubject}
 * y son notificados cuando se cambia el idioma de la aplicacion,
 * permitiendo la actualizacion reactiva de componentes como
 * paneles con los textos del idioma seleccionado.
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
     * Método invocado cuando el {@link LanguageSubject}
     * notifica un cambio de <strong>estado</strong> a sus observadores
     * registrados.
     * </p>
     *
     * El <strong>estado</strong> se refiere al cambio de idioma
     * de la app.
     */
    void updateLanguage();

}
