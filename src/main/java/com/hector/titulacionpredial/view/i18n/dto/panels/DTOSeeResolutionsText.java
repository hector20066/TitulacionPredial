package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the
 * resolutions view panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
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

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
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

    /**     * get code.     * @return the get code     */
    public String getCode() {
        return code;
    }

    /**     * get number.     * @return the get number     */
    public String getNumber() {
        return number;
    }

    /**     * get notification.     * @return the get notification     */
    public String getNotification() {
        return notification;
    }

    /**     * get executory.     * @return the get executory     */
    public String getExecutory() {
        return executory;
    }

    /**     * get notary.     * @return the get notary     */
    public String getNotary() {
        return notary;
    }

    /**     * get fmi.     * @return the get fmi     */
    public String getFmi() {
        return fmi;
    }

    /**     * get act.     * @return the get act     */
    public String getAct() {
        return act;
    }

    /**     * get public writing.     * @return the get public writing     */
    public String getPublicWriting() {
        return publicWriting;
    }

    /**     * get title.     * @return the get title     */
    public String getTitle() {
        return title;
    }

    /**     * get search.     * @return the get search     */
    public String getSearch() {
        return search;
    }

    /**     * get modify btn.     * @return the get modify btn     */
    public String getModifyBtn() {
        return modifyBtn;
    }

    /**
     * Builder for building instances of {@link DTOSeeResolutionsText}.
     */
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

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

    /**     * number.     * @param number the number     * @return the number     */
        public Builder number(String number) {
            this.number = number;
            return this;
        }

    /**     * notification.     * @param notification the notification     * @return the notification     */
        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

    /**     * executory.     * @param executory the executory     * @return the executory     */
        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

    /**     * notary.     * @param notary the notary     * @return the notary     */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

    /**     * fmi.     * @param fmi the fmi     * @return the fmi     */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

    /**     * act.     * @param act the act     * @return the act     */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

    /**     * public writing.     * @param publicWriting the public writing     * @return the public writing     */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

    /**     * title.     * @param title the title     * @return the title     */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

    /**     * search.     * @param search the search     * @return the search     */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

    /**     * modify btn.     * @param modifyBtn the modify btn     * @return the modify btn     */
        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOSeeResolutionsText build() {
            return new DTOSeeResolutionsText(this);
        }

    }

}
