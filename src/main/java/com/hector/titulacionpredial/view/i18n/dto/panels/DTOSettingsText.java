package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de configuración.
 *
 * @author Ing. Hector Acevedo
 */
public class DTOSettingsText {

    private final String title;
    private final String languageBtn;

    /**
     * Construye una instancia con los textos de configuración.
     *
     * @param title texto del título
     * @param languageBtn texto del botón de idioma
     */
    public DTOSettingsText(String title, String languageBtn) {
        this.title = title;
        this.languageBtn = languageBtn;
    }

    /** Obtiene el texto del título. @return texto del título */
    public String getTitle() {
        return title;
    }

    /** Obtiene el texto del botón de idioma. @return texto del botón de idioma */
    public String getLanguageBtn() {
        return languageBtn;
    }

}
