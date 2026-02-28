package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 *
 * @author hectoracevedo
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

    public String getMainTitle() {
        return mainTitle;
    }

    public String getDashboard() {
        return dashboard;
    }

    public String getInfo() {
        return info;
    }

    public String getRegisterInfo() {
        return registerInfo;
    }

    public String getRegisterBeneficiaries() {
        return registerBeneficiaries;
    }

    public String getRegisterProperties() {
        return registerProperties;
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

        public Builder mainTitle(String mainTitle) {
            this.mainTitle = mainTitle;
            return this;
        }

        public Builder dashboard(String dashboard) {
            this.dashboard = dashboard;
            return this;
        }

        public Builder info(String info) {
            this.info = info;
            return this;
        }

        public Builder registerInfo(String registerInfo) {
            this.registerInfo = registerInfo;
            return this;
        }

        public Builder registerBeneficiaries(String registerBeneficiaries) {
            this.registerBeneficiaries = registerBeneficiaries;
            return this;
        }

        public Builder registerProperties() {
            this.registerProperties = registerProperties;
            return this;
        }

        public Builder see(String see) {
            this.see = see;
            return this;
        }

        public Builder seeBeneficiaries(String seeBeneficiaries) {
            this.seeBeneficiaries = seeBeneficiaries;
            return this;
        }

        public Builder seeProperties(String seeProperties) {
            this.seeProperties = seeProperties;
            return this;
        }

        public Builder seeResolutions(String seeResolutions) {
            this.seeResolutions = seeResolutions;
            return this;
        }

        public Builder configuration(String configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder settings(String settings) {
            this.settings = settings;
            return this;
        }

        public Builder aboutApp(String aboutApp) {
            this.aboutApp = aboutApp;
            return this;
        }

        public Builder about(String about) {
            this.about = about;
            return this;
        }

        public DTOMenuText build() {
            return new DTOMenuText(this);
        }

    }

}
