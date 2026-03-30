package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the about panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
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
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
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

    /**     * get title.     * @return the get title     */
    public String getTitle() {
        return title;
    }

    /**     * get app info.     * @return the get app info     */
    public String getAppInfo() {
        return appInfo;
    }

    /**     * get version.     * @return the get version     */
    public String getVersion() {
        return version;
    }

    /**     * get release date.     * @return the get release date     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**     * get creators.     * @return the get creators     */
    public String getCreators() {
        return creators;
    }

    /**     * get creator1.     * @return the get creator1     */
    public String getCreator1() {
        return creator1;
    }

    /**     * get creator2.     * @return the get creator2     */
    public String getCreator2() {
        return creator2;
    }

    /**     * get more info.     * @return the get more info     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * Builder for building instances of {@link DTOAboutText}.
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

    /**     * title.     * @param title the title     * @return the title     */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

    /**     * app info.     * @param appInfo the app info     * @return the app info     */
        public Builder appInfo(String appInfo) {
            this.appInfo = appInfo;
            return this;
        }

    /**     * version.     * @param version the version     * @return the version     */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

    /**     * release date.     * @param releaseDate the release date     * @return the release date     */
        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

    /**     * creators.     * @param creators the creators     * @return the creators     */
        public Builder creators(String creators) {
            this.creators = creators;
            return this;
        }

    /**     * creator1.     * @param creator1 the creator1     * @return the creator1     */
        public Builder creator1(String creator1) {
            this.creator1 = creator1;
            return this;
        }

    /**     * creator2.     * @param creator2 the creator2     * @return the creator2     */
        public Builder creator2(String creator2) {
            this.creator2 = creator2;
            return this;
        }

    /**     * more info.     * @param moreInfo the more info     * @return the more info     */
        public Builder moreInfo(String moreInfo) {
            this.moreInfo = moreInfo;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOAboutText build() {
            return new DTOAboutText(this);
        }

    }

}
