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
    private final String registerInfo;
    private final String registerBeneficiaries;
    private final String registerProperties;
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
    public DTOMenuText(Builder builder) {
        this.mainTitle = builder.mainTitle;
        this.dashboard = builder.dashboard;
        this.info = builder.info;
        this.registerInfo = builder.registerInfo;
        this.registerBeneficiaries = builder.registerBeneficiaries;
        this.registerProperties = builder.registerProperties;
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

    /**     * get register info.     * @return the get register info     */
    public String getRegisterInfo() {
        return registerInfo;
    }

    /**     * get register beneficiaries.     * @return the get register beneficiaries     */
    public String getRegisterBeneficiaries() {
        return registerBeneficiaries;
    }

    /**     * get register properties.     * @return the get register properties     */
    public String getRegisterProperties() {
        return registerProperties;
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
    public static class Builder {

        private String mainTitle;
        private String dashboard;
        private String info;
        private String registerInfo;
        private String registerBeneficiaries;
        private String registerProperties;
        private String see;
        private String seeBeneficiaries;
        private String seeProperties;
        private String seeResolutions;
        private String configuration;
        private String settings;
        private String aboutApp;
        private String about;

    /**     * main title.     * @param mainTitle the main title     * @return the main title     */
        public Builder mainTitle(String mainTitle) {
            this.mainTitle = mainTitle;
            return this;
        }

    /**     * dashboard.     * @param dashboard the dashboard     * @return the dashboard     */
        public Builder dashboard(String dashboard) {
            this.dashboard = dashboard;
            return this;
        }

    /**     * info.     * @param info the info     * @return the info     */
        public Builder info(String info) {
            this.info = info;
            return this;
        }

    /**     * register info.     * @param registerInfo the register info     * @return the register info     */
        public Builder registerInfo(String registerInfo) {
            this.registerInfo = registerInfo;
            return this;
        }

    /**     * register beneficiaries.     * @param registerBeneficiaries the register beneficiaries     * @return the register beneficiaries     */
        public Builder registerBeneficiaries(String registerBeneficiaries) {
            this.registerBeneficiaries = registerBeneficiaries;
            return this;
        }

    /**     * register properties.     * @param registerProperties the register properties     * @return the register properties     */
        public Builder registerProperties(String registerProperties) {
            this.registerProperties = registerProperties;
            return this;
        }

    /**     * see.     * @param see the see     * @return the see     */
        public Builder see(String see) {
            this.see = see;
            return this;
        }

    /**     * see beneficiaries.     * @param seeBeneficiaries the see beneficiaries     * @return the see beneficiaries     */
        public Builder seeBeneficiaries(String seeBeneficiaries) {
            this.seeBeneficiaries = seeBeneficiaries;
            return this;
        }

    /**     * see properties.     * @param seeProperties the see properties     * @return the see properties     */
        public Builder seeProperties(String seeProperties) {
            this.seeProperties = seeProperties;
            return this;
        }

    /**     * see resolutions.     * @param seeResolutions the see resolutions     * @return the see resolutions     */
        public Builder seeResolutions(String seeResolutions) {
            this.seeResolutions = seeResolutions;
            return this;
        }

    /**     * configuration.     * @param configuration the configuration     * @return the configuration     */
        public Builder configuration(String configuration) {
            this.configuration = configuration;
            return this;
        }

    /**     * settings.     * @param settings the settings     * @return the settings     */
        public Builder settings(String settings) {
            this.settings = settings;
            return this;
        }

    /**     * about app.     * @param aboutApp the about app     * @return the about app     */
        public Builder aboutApp(String aboutApp) {
            this.aboutApp = aboutApp;
            return this;
        }

    /**     * about.     * @param about the about     * @return the about     */
        public Builder about(String about) {
            this.about = about;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOMenuText build() {
            return new DTOMenuText(this);
        }

    }

}
