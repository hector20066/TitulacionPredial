package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSeeProperties;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerSeePropertiesBuilder {

    private GenerateResolution generateResolution;
    private SeeProperties seeProperties;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerSeePropertiesBuilder withViewGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;
        return this;
    }

    public ControllerSeePropertiesBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    public ControllerSeePropertiesBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerSeePropertiesBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerSeePropertiesBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerSeeProperties build() {
        return new ControllerSeeProperties(this);
    }

    public GenerateResolution getGenerateResolution() {
        return generateResolution;
    }

    public SeeProperties getSeeProperties() {
        return seeProperties;
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
