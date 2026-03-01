package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContent;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder para construir el {@link ControllerContent} con
 * todas sus vistas y dependencias.
 *
 * <p>
 * Permite configurar de forma fluida cada panel de la
 * aplicación antes de crear el controlador principal
 * del contenido mediante el método {@link #build()}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContent
 * @since 1.0
 */
public class ControllerContentBuilder {

    private Content content;
    private Dashboard dashboard;
    private RegisterBeneficiary registerBeneficiary;
    private RegisterProperty registerProperty;
    private ViewBeneficiaries viewBeneficiaries;
    private SeeProperties seeProperties;
    private SeeResolutions seeResolutions;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;
    private About about;

    public ControllerContentBuilder withViewContent(Content content) {
        this.content = content;
        return this;
    }

    public ControllerContentBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    public ControllerContentBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    public ControllerContentBuilder withViewRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;
        return this;
    }

    public ControllerContentBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    public ControllerContentBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    public ControllerContentBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    public ControllerContentBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerContentBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerContentBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerContentBuilder withViewAbout(About about) {
        this.about = about;
        return this;
    }

    /**
     * Construye una nueva instancia de {@link ControllerContent}
     *
     * @return nuevo DTO configurado
     */
    public ControllerContent build() {
        return new ControllerContent(this);
    }

    public Content getContent() {
        return content;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    public RegisterProperty getRegisterProperty() {
        return registerProperty;
    }

    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    public SeeProperties getSeeProperties() {
        return seeProperties;
    }

    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
    }

    public Subject getSubject() {
        return subject;
    }

    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    public LanguageManager getLang() {
        return lang;
    }

    public About getAbout() {
        return about;
    }

}
