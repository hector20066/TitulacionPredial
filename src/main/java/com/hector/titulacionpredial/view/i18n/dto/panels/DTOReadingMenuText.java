package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 */
public class DTOReadingMenuText extends DTOMenuText {

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTOReadingMenuText(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOMenuText.Builder<Builder> {

        public DTOReadingMenuText build() {
            return new DTOReadingMenuText(this);
        }

    }

}
