package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 *
 * @author hectoracevedo
 */
public class DTOSeeResolutionsText {

    private final String code;
    private final String number;
    private final String notification;
    private final String executory;
    private final String notary;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String title;
    private final String search;
    private final String modifyBtn;

    public DTOSeeResolutionsText(Builder builder) {
        this.code = builder.code;
        this.number = builder.number;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.notary = builder.notary;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.title = builder.title;
        this.search = builder.search;
        this.modifyBtn = builder.modifyBtn;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public String getNotification() {
        return notification;
    }

    public String getExecutory() {
        return executory;
    }

    public String getNotary() {
        return notary;
    }

    public String getFmi() {
        return fmi;
    }

    public String getAct() {
        return act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public String getTitle() {
        return title;
    }

    public String getSearch() {
        return search;
    }

    public String getModifyBtn() {
        return modifyBtn;
    }

    public static class Builder {

        private String code;
        private String number;
        private String notification;
        private String executory;
        private String notary;
        private String fmi;
        private String act;
        private String publicWriting;
        private String title;
        private String search;
        private String modifyBtn;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        public Builder act(String act) {
            this.act = act;
            return this;
        }

        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

        public DTOSeeResolutionsText build() {
            return new DTOSeeResolutionsText(this);
        }

    }

}
