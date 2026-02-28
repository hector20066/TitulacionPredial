package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
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

    public String getTitle() {
        return title;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public String getVersion() {
        return version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCreators() {
        return creators;
    }

    public String getCreator1() {
        return creator1;
    }

    public String getCreator2() {
        return creator2;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public static class Builder {

        private String title;
        private String appInfo;
        private String version;
        private String releaseDate;
        private String creators;
        private String creator1;
        private String creator2;
        private String moreInfo;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder appInfo(String appInfo) {
            this.appInfo = appInfo;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder creators(String creators) {
            this.creators = creators;
            return this;
        }

        public Builder creator1(String creator1) {
            this.creator1 = creator1;
            return this;
        }

        public Builder creator2(String creator2) {
            this.creator2 = creator2;
            return this;
        }

        public Builder moreInfo(String moreInfo) {
            this.moreInfo = moreInfo;
            return this;
        }

        public DTOAboutText build() {
            return new DTOAboutText(this);
        }

    }

}
