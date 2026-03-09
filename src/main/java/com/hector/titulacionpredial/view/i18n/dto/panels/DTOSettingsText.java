package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the configuration panel.
 *
 * @author Ing. Hector Acevedo
 */
public class DTOSettingsText {

    private final String title;
    private final String languageBtn;

    /**
     * Build an instance with the configuration texts.
     *
     * @param title title text
     * @param languageBtn language button text
     */
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
