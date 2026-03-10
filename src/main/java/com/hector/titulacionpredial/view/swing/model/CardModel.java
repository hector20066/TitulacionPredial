package com.hector.titulacionpredial.view.swing.model;

import javax.swing.*;

/**
 * Data model for dashboard cards.
 *
 * <p>
 * Stores the title, numeric values, icon, and gradient colors
 * used by {@link com.hector.titulacionpredial.view.swing.chart.Card}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class CardModel {

    private Icon icon;
    private String title;
    private String values;
    private String description;

    /**
     * Create a card template with the specified data.
     *
     * @param icon        card icon
     * @param title      title
     * @param values     numerical value
     * @param description description
     */
    public CardModel(Icon icon, String title, String values, String description) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.description = description;
    }

    /**
     * Create an empty card template.
     */
    public CardModel() {

    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
