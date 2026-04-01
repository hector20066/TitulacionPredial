package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the
 * main menu panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOMenuText {

    private final String mainTitle;
    private final String dashboard;
    private final String info;
    private final String see;
    private final String seeBeneficiaries;
    private final String seeProperties;
    private final String seeResolutions;
    private final String configuration;
    private final String settings;
    private final String aboutApp;
    private final String about;

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTOMenuText(Builder<?> builder) {
        this.mainTitle = builder.mainTitle;
        this.dashboard = builder.dashboard;
        this.info = builder.info;
        this.see = builder.see;
        this.seeBeneficiaries = builder.seeBeneficiaries;
        this.seeProperties = builder.seeProperties;
        this.seeResolutions = builder.seeResolutions;
        this.configuration = builder.configuration;
        this.settings = builder.settings;
        this.aboutApp = builder.aboutApp;
        this.about = builder.about;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getDashboard() {
        return dashboard;
    }

    public String getInfo() {
        return info;
    }

    public String getSee() {
        return see;
    }

    public String getSeeBeneficiaries() {
        return seeBeneficiaries;
    }

    public String getSeeProperties() {
        return seeProperties;
    }

    public String getSeeResolutions() {
        return seeResolutions;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getSettings() {
        return settings;
    }

    public String getAboutApp() {
        return aboutApp;
    }

    public String getAbout() {
        return about;
    }

    /**
     * Builder for building instances of {@link DTOMenuText}.
     */
    public static class Builder<T extends Builder<T>> {

        private String mainTitle;
        private String dashboard;
        private String info;
        private String see;
        private String seeBeneficiaries;
        private String seeProperties;
        private String seeResolutions;
        private String configuration;
        private String settings;
        private String aboutApp;
        private String about;

        protected T self() {
            return (T) this;
        }

        /**
         * Set the main title text.
         *
         * @param mainTitle the title to set
         * @return builder instance for chaining
         */
        public T mainTitle(String mainTitle) {
            this.mainTitle = mainTitle;
            return self();
        }

        /**
         * Set the dashboard label text.
         *
         * @param dashboard the label to set
         * @return builder instance for chaining
         */
        public T dashboard(String dashboard) {
            this.dashboard = dashboard;
            return self();
        }

        /**
         * Set the info label text.
         *
         * @param info the label to set
         * @return builder instance for chaining
         */
        public T info(String info) {
            this.info = info;
            return self();
        }

        /**
         * Set the 'see' command text.
         *
         * @param see the text to set
         * @return builder instance for chaining
         */
        public T see(String see) {
            this.see = see;
            return self();
        }

        /**
         * Set the 'see beneficiaries' menu text.
         *
         * @param seeBeneficiaries the text to set
         * @return builder instance for chaining
         */
        public T seeBeneficiaries(String seeBeneficiaries) {
            this.seeBeneficiaries = seeBeneficiaries;
            return self();
        }

        /**
         * Set the 'see properties' menu text.
         *
         * @param seeProperties the text to set
         * @return builder instance for chaining
         */
        public T seeProperties(String seeProperties) {
            this.seeProperties = seeProperties;
            return self();
        }

        /**
         * Set the 'see resolutions' menu text.
         *
         * @param seeResolutions the text to set
         * @return builder instance for chaining
         */
        public T seeResolutions(String seeResolutions) {
            this.seeResolutions = seeResolutions;
            return self();
        }

        /**
         * Set the configuration text.
         *
         * @param configuration the text to set
         * @return builder instance for chaining
         */
        public T configuration(String configuration) {
            this.configuration = configuration;
            return self();
        }

        /**
         * Set the settings text.
         *
         * @param settings the text to set
         * @return builder instance for chaining
         */
        public T settings(String settings) {
            this.settings = settings;
            return self();
        }

        /**
         * Set the about application text.
         *
         * @param aboutApp the text to set
         * @return builder instance for chaining
         */
        public T aboutApp(String aboutApp) {
            this.aboutApp = aboutApp;
            return self();
        }

        /**
         * Set the about text.
         *
         * @param about the text to set
         * @return builder instance for chaining
         */
        public T about(String about) {
            this.about = about;
            return self();
        }

        /**
         * Build and return a new instance of {@link DTOMenuText}.
         *
         * @return configured DTOMenuText instance
         */
        public DTOMenuText build() {
            return new DTOMenuText(this);
        }

    }

}
