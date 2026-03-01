package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class DTOSettingsText {

    private final String title;
    private final String languageBtn;

    public DTOSettingsText(String title, String languageBtn) {
        this.title = title;
        this.languageBtn = languageBtn;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguageBtn() {
        return languageBtn;
    }

}
