package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerGenerateResolution;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerGenerateResolutionBuilder {

    private GenerateResolution generateResolution;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerGenerateResolutionBuilder withViewGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;
        return this;
    }

    public ControllerGenerateResolutionBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerGenerateResolutionBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerGenerateResolutionBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerGenerateResolution build() {
        return new ControllerGenerateResolution(this);
    }

    public GenerateResolution getGenerateResolution() {
        return generateResolution;
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

}
