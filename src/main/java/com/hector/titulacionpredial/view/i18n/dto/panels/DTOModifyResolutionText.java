package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 *
 * @author hectoracevedo
 */
public class DTOModifyResolutionText {

    private final String title;
    private final String code;
    private final String numResolution;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String notary;
    private final String modifyBtn;
    private final String executory;
    private final String notification;

    public DTOModifyResolutionText(Builder builder) {
        this.title = builder.title;
        this.code = builder.code;
        this.numResolution = builder.numResolution;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.modifyBtn = builder.modifyBtn;
        this.executory = builder.executory;
        this.notification = builder.notification;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getNumResolution() {
        return numResolution;
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

    public String getNotary() {
        return notary;
    }

    public String getModifyBtn() {
        return modifyBtn;
    }

    public String getExecutory() {
        return executory;
    }

    public String getNotification() {
        return notification;
    }

    public static class Builder {

        private String title;
        private String code;
        private String numResolution;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private String modifyBtn;
        private String executory;
        private String notification;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
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

        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

        public DTOModifyResolutionText build() {
            return new DTOModifyResolutionText(this);
        }
    }
}
