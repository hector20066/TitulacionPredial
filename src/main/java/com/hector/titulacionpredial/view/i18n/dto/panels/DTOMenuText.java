package com.hector.titulacionpredial.view.i18n.dto.panels;

import com.hector.titulacionpredial.controller.builder.ControllerContentBuilder;

/**
 * DTO que encapsula los textos internacionalizados para el panel de menú principal.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
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

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
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

    /**
     * Obtiene el texto de título principal.
     *
     * @return texto de título principal
     */
    public String getMainTitle() {
        return mainTitle;
    }

    /**
     * Obtiene el texto de panel de control.
     *
     * @return texto de panel de control
     */
    public String getDashboard() {
        return dashboard;
    }

    /**
     * Obtiene el texto de información.
     *
     * @return texto de información
     */
    public String getInfo() {
        return info;
    }

    /**
     * Obtiene el texto de información de registro.
     *
     * @return texto de información de registro
     */
    public String getRegisterInfo() {
        return registerInfo;
    }

    /**
     * Obtiene el texto de registrar beneficiarios.
     *
     * @return texto de registrar beneficiarios
     */
    public String getRegisterBeneficiaries() {
        return registerBeneficiaries;
    }

    /**
     * Obtiene el texto de registrar predios.
     *
     * @return texto de registrar predios
     */
    public String getRegisterProperties() {
        return registerProperties;
    }

    /**
     * Obtiene el texto de ver.
     *
     * @return texto de ver
     */
    public String getSee() {
        return see;
    }

    /**
     * Obtiene el texto de ver beneficiarios.
     *
     * @return texto de ver beneficiarios
     */
    public String getSeeBeneficiaries() {
        return seeBeneficiaries;
    }

    /**
     * Obtiene el texto de ver predios.
     *
     * @return texto de ver predios
     */
    public String getSeeProperties() {
        return seeProperties;
    }

    /**
     * Obtiene el texto de ver resoluciones.
     *
     * @return texto de ver resoluciones
     */
    public String getSeeResolutions() {
        return seeResolutions;
    }

    /**
     * Obtiene el texto de configuración.
     *
     * @return texto de configuración
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * Obtiene el texto de ajustes.
     *
     * @return texto de ajustes
     */
    public String getSettings() {
        return settings;
    }

    /**
     * Obtiene el texto de acerca de la aplicación.
     *
     * @return texto de acerca de la aplicación
     */
    public String getAboutApp() {
        return aboutApp;
    }

    /**
     * Obtiene el texto de acerca de.
     *
     * @return texto de acerca de
     */
    public String getAbout() {
        return about;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOMenuText}.
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

        /**
         * Asigna el texto de título principal.
         *
         * @param mainTitle texto de título principal
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder mainTitle(String mainTitle) {
            this.mainTitle = mainTitle;
            return this;
        }

        /**
         * Asigna el texto de panel de control.
         *
         * @param dashboard texto de panel de control
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder dashboard(String dashboard) {
            this.dashboard = dashboard;
            return this;
        }

        /**
         * Asigna el texto de información.
         *
         * @param info texto de información
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder info(String info) {
            this.info = info;
            return this;
        }

        /**
         * Asigna el texto de información de registro.
         *
         * @param registerInfo texto de información de registro
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder registerInfo(String registerInfo) {
            this.registerInfo = registerInfo;
            return this;
        }

        /**
         * Asigna el texto de registrar beneficiarios.
         *
         * @param registerBeneficiaries texto de registrar beneficiarios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder registerBeneficiaries(String registerBeneficiaries) {
            this.registerBeneficiaries = registerBeneficiaries;
            return this;
        }

        /**
         * Asigna el texto de registrar predios.
         *
         * @param registerProperties texto de registrar predios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder registerProperties(String registerProperties) {
            this.registerProperties = registerProperties;
            return this;
        }

        /**
         * Asigna el texto de ver.
         *
         * @param see texto de ver
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder see(String see) {
            this.see = see;
            return this;
        }

        /**
         * Asigna el texto de ver beneficiarios.
         *
         * @param seeBeneficiaries texto de ver beneficiarios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder seeBeneficiaries(String seeBeneficiaries) {
            this.seeBeneficiaries = seeBeneficiaries;
            return this;
        }

        /**
         * Asigna el texto de ver predios.
         *
         * @param seeProperties texto de ver predios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder seeProperties(String seeProperties) {
            this.seeProperties = seeProperties;
            return this;
        }

        /**
         * Asigna el texto de ver resoluciones.
         *
         * @param seeResolutions texto de ver resoluciones
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder seeResolutions(String seeResolutions) {
            this.seeResolutions = seeResolutions;
            return this;
        }

        /**
         * Asigna el texto de configuración.
         *
         * @param configuration texto de configuración
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder configuration(String configuration) {
            this.configuration = configuration;
            return this;
        }

        /**
         * Asigna el texto de ajustes.
         *
         * @param settings texto de ajustes
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder settings(String settings) {
            this.settings = settings;
            return this;
        }

        /**
         * Asigna el texto de acerca de la aplicación.
         *
         * @param aboutApp texto de acerca de la aplicación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder aboutApp(String aboutApp) {
            this.aboutApp = aboutApp;
            return this;
        }

        /**
         * Asigna el texto de acerca de.
         *
         * @param about texto de acerca de
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder about(String about) {
            this.about = about;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOMenuText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOMenuText build() {
            return new DTOMenuText(this);
        }

    }

}
