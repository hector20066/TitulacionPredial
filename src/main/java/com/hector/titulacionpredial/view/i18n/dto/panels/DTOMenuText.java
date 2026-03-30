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

    /**     * get main title.     * @return the get main title     */
    public String getMainTitle() {
        return mainTitle;
    }

    /**     * get dashboard.     * @return the get dashboard     */
    public String getDashboard() {
        return dashboard;
    }

    /**     * get info.     * @return the get info     */
    public String getInfo() {
        return info;
    }

    /**     * get see.     * @return the get see     */
    public String getSee() {
        return see;
    }

    /**     * get see beneficiaries.     * @return the get see beneficiaries     */
    public String getSeeBeneficiaries() {
        return seeBeneficiaries;
    }

    /**     * get see properties.     * @return the get see properties     */
    public String getSeeProperties() {
        return seeProperties;
    }

    /**     * get see resolutions.     * @return the get see resolutions     */
    public String getSeeResolutions() {
        return seeResolutions;
    }

    /**     * get configuration.     * @return the get configuration     */
    public String getConfiguration() {
        return configuration;
    }

    /**     * get settings.     * @return the get settings     */
    public String getSettings() {
        return settings;
    }

    /**     * get about app.     * @return the get about app     */
    public String getAboutApp() {
        return aboutApp;
    }

    /**     * get about.     * @return the get about     */
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

    /**     * main title.     * @param mainTitle the main title     * @return the main title     */
        public T mainTitle(String mainTitle) {
            this.mainTitle = mainTitle;
            return self();
        }

    /**     * dashboard.     * @param dashboard the dashboard     * @return the dashboard     */
        public T dashboard(String dashboard) {
            this.dashboard = dashboard;
            return self();
        }

    /**     * info.     * @param info the info     * @return the info     */
        public T info(String info) {
            this.info = info;
            return self();
        }

    /**     * see.     * @param see the see     * @return the see     */
        public T see(String see) {
            this.see = see;
            return self();
        }

    /**     * see beneficiaries.     * @param seeBeneficiaries the see beneficiaries     * @return the see beneficiaries     */
        public T seeBeneficiaries(String seeBeneficiaries) {
            this.seeBeneficiaries = seeBeneficiaries;
            return self();
        }

    /**     * see properties.     * @param seeProperties the see properties     * @return the see properties     */
        public T seeProperties(String seeProperties) {
            this.seeProperties = seeProperties;
            return self();
        }

    /**     * see resolutions.     * @param seeResolutions the see resolutions     * @return the see resolutions     */
        public T seeResolutions(String seeResolutions) {
            this.seeResolutions = seeResolutions;
            return self();
        }

    /**     * configuration.     * @param configuration the configuration     * @return the configuration     */
        public T configuration(String configuration) {
            this.configuration = configuration;
            return self();
        }

    /**     * settings.     * @param settings the settings     * @return the settings     */
        public T settings(String settings) {
            this.settings = settings;
            return self();
        }

    /**     * about app.     * @param aboutApp the about app     * @return the about app     */
        public T aboutApp(String aboutApp) {
            this.aboutApp = aboutApp;
            return self();
        }

    /**     * about.     * @param about the about     * @return the about     */
        public T about(String about) {
            this.about = about;
            return self();
        }

    /**     * build.     * @return the build     */
        public DTOMenuText build() {
            return new DTOMenuText(this);
        }

    }

}
