package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de acerca de.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOAboutText {

    private final String title;
    private final String appInfo;
    private final String version;
    private final String releaseDate;
    private final String creators;
    private final String creator1;
    private final String creator2;
    private final String moreInfo;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOAboutText(Builder builder) {
        this.title = builder.title;
        this.appInfo = builder.appInfo;
        this.version = builder.version;
        this.releaseDate = builder.releaseDate;
        this.creators = builder.creators;
        this.creator1 = builder.creator1;
        this.creator2 = builder.creator2;
        this.moreInfo = builder.moreInfo;
    }

    /**
     * Obtiene el texto de título.
     *
     * @return texto de título
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el texto de información de la aplicación.
     *
     * @return texto de información de la aplicación
     */
    public String getAppInfo() {
        return appInfo;
    }

    /**
     * Obtiene el texto de versión.
     *
     * @return texto de versión
     */
    public String getVersion() {
        return version;
    }

    /**
     * Obtiene el texto de fecha de lanzamiento.
     *
     * @return texto de fecha de lanzamiento
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Obtiene el texto de creadores.
     *
     * @return texto de creadores
     */
    public String getCreators() {
        return creators;
    }

    /**
     * Obtiene el texto de creador 1.
     *
     * @return texto de creador 1
     */
    public String getCreator1() {
        return creator1;
    }

    /**
     * Obtiene el texto de creador 2.
     *
     * @return texto de creador 2
     */
    public String getCreator2() {
        return creator2;
    }

    /**
     * Obtiene el texto de más información.
     *
     * @return texto de más información
     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOAboutText}.
     */
    public static class Builder {

        private String title;
        private String appInfo;
        private String version;
        private String releaseDate;
        private String creators;
        private String creator1;
        private String creator2;
        private String moreInfo;

        /**
         * Asigna el texto de título.
         *
         * @param title texto de título
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Asigna el texto de información de la aplicación.
         *
         * @param appInfo texto de información de la aplicación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder appInfo(String appInfo) {
            this.appInfo = appInfo;
            return this;
        }

        /**
         * Asigna el texto de versión.
         *
         * @param version texto de versión
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * Asigna el texto de fecha de lanzamiento.
         *
         * @param releaseDate texto de fecha de lanzamiento
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        /**
         * Asigna el texto de creadores.
         *
         * @param creators texto de creadores
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder creators(String creators) {
            this.creators = creators;
            return this;
        }

        /**
         * Asigna el texto de creador 1.
         *
         * @param creator1 texto de creador 1
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder creator1(String creator1) {
            this.creator1 = creator1;
            return this;
        }

        /**
         * Asigna el texto de creador 2.
         *
         * @param creator2 texto de creador 2
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder creator2(String creator2) {
            this.creator2 = creator2;
            return this;
        }

        /**
         * Asigna el texto de más información.
         *
         * @param moreInfo texto de más información
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder moreInfo(String moreInfo) {
            this.moreInfo = moreInfo;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOAboutText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOAboutText build() {
            return new DTOAboutText(this);
        }

    }

}
