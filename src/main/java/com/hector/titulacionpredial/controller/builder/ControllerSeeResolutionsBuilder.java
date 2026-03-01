package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSeeResolutions;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerSeeResolutionsBuilder {

    private ModifyResolution modifyResolution;
    private SeeResolutions seeResolutions;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerSeeResolutionsBuilder withViewModifyResolution(ModifyResolution modifyResolution) {
        this.modifyResolution = modifyResolution;
        return this;
    }

    public ControllerSeeResolutionsBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    public ControllerSeeResolutionsBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerSeeResolutionsBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerSeeResolutionsBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerSeeResolutions build() {
        return new ControllerSeeResolutions(this);
    }

    public ModifyResolution getModifyResolution() {
        return modifyResolution;
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

}
