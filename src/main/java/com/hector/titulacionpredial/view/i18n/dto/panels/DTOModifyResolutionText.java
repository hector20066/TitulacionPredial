package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts
 * for the modify resolution panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
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

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
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

    /**     * get title.     * @return the get title     */
    public String getTitle() {
        return title;
    }

    /**     * get code.     * @return the get code     */
    public String getCode() {
        return code;
    }

    /**     * get num resolution.     * @return the get num resolution     */
    public String getNumResolution() {
        return numResolution;
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

    /**     * get notary.     * @return the get notary     */
    public String getNotary() {
        return notary;
    }

    /**     * get modify btn.     * @return the get modify btn     */
    public String getModifyBtn() {
        return modifyBtn;
    }

    /**     * get executory.     * @return the get executory     */
    public String getExecutory() {
        return executory;
    }

    /**     * get notification.     * @return the get notification     */
    public String getNotification() {
        return notification;
    }

    /**
     * Builder for building instances of {@link DTOModifyResolutionText}.
     */
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

    /**     * title.     * @param title the title     * @return the title     */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

    /**     * num resolution.     * @param numResolution the num resolution     * @return the num resolution     */
        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
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

    /**     * notary.     * @param notary the notary     * @return the notary     */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

    /**     * modify btn.     * @param modifyBtn the modify btn     * @return the modify btn     */
        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

    /**     * executory.     * @param executory the executory     * @return the executory     */
        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

    /**     * notification.     * @param notification the notification     * @return the notification     */
        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOModifyResolutionText build() {
            return new DTOModifyResolutionText(this);
        }

    }

}
