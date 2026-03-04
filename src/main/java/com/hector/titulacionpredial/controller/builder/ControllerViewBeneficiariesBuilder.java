package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerViewBeneficiaries;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder para la construcción de instancias de {@link ControllerViewBeneficiaries}.
 *
 * <p>Centraliza la inyección de dependencias necesarias para la configuración
 * del controlador mediante un patrón de diseño Builder.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerViewBeneficiariesBuilder {

    private RegisterBeneficiary registerBeneficiary;
    private ViewBeneficiaries viewBeneficiaries;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Asigna la vista del panel de registro de beneficiarios.
     *
     * @param registerBeneficiary vista de registro de beneficiarios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerViewBeneficiariesBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Asigna la vista del panel de visualización de beneficiarios.
     *
     * @param viewBeneficiaries vista de visualización de beneficiarios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerViewBeneficiariesBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para notificaciones de datos.
     *
     * @param subject sujeto concreto del patrón Observer
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerViewBeneficiariesBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerViewBeneficiariesBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerViewBeneficiariesBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Construye e inicializa una nueva instancia de {@link ControllerViewBeneficiaries}.
     *
     * @return nueva instancia configurada de {@link ControllerViewBeneficiaries}
     */
    public ControllerViewBeneficiaries build() {
        return new ControllerViewBeneficiaries(this);
    }

    /**
     * Obtiene la vista de registro de beneficiarios.
     *
     * @return vista de registro de beneficiarios
     */
    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    /**
     * Obtiene la vista de visualización de beneficiarios.
     *
     * @return vista de visualización de beneficiarios
     */
    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    /**
     * Obtiene el sujeto del patrón Observer.
     *
     * @return sujeto concreto del patrón Observer
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Obtiene el sujeto de cambio de idioma.
     *
     * @return sujeto del patrón Observer para idiomas
     */
    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    /**
     * Obtiene el gestor de idiomas.
     *
     * @return gestor de idiomas de la aplicación
     */
    public LanguageManager getLang() {
        return lang;
    }

}
