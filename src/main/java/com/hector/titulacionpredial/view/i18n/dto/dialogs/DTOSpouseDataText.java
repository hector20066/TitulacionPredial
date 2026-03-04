package com.hector.titulacionpredial.view.i18n.dto.dialogs;

/**
 * DTO que encapsula los textos internacionalizados para el diálogo de datos del cónyuge.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOSpouseDataText {

    private final String title;
    private final String spouseName;
    private final String spouseLastName;
    private final String spouseId;
    private final String spouseExpeditionLocation;
    private final String spouseAddress;
    private final String spousePhone;
    private final String btnSave;
    private final String btnCancel;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOSpouseDataText(Builder builder) {
        this.title = builder.title;
        this.spouseName = builder.spouseName;
        this.spouseLastName = builder.spouseLastName;
        this.spouseId = builder.spouseId;
        this.spouseExpeditionLocation = builder.spouseExpeditionLocation;
        this.spouseAddress = builder.spouseAddress;
        this.spousePhone = builder.spousePhone;
        this.btnSave = builder.btnSave;
        this.btnCancel = builder.btnCancel;
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
     * Obtiene el texto de nombre del cónyuge.
     *
     * @return texto de nombre del cónyuge
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * Obtiene el texto de apellido del cónyuge.
     *
     * @return texto de apellido del cónyuge
     */
    public String getSpouseLastName() {
        return spouseLastName;
    }

    /**
     * Obtiene el texto de identificación del cónyuge.
     *
     * @return texto de identificación del cónyuge
     */
    public String getSpouseId() {
        return spouseId;
    }

    /**
     * Obtiene el texto de lugar de expedición del cónyuge.
     *
     * @return texto de lugar de expedición del cónyuge
     */
    public String getSpouseExpeditionLocation() {
        return spouseExpeditionLocation;
    }

    /**
     * Obtiene el texto de dirección del cónyuge.
     *
     * @return texto de dirección del cónyuge
     */
    public String getSpouseAddress() {
        return spouseAddress;
    }

    /**
     * Obtiene el texto de teléfono del cónyuge.
     *
     * @return texto de teléfono del cónyuge
     */
    public String getSpousePhone() {
        return spousePhone;
    }

    /**
     * Obtiene el texto de botón guardar.
     *
     * @return texto de botón guardar
     */
    public String getBtnSave() {
        return btnSave;
    }

    /**
     * Obtiene el texto de botón cancelar.
     *
     * @return texto de botón cancelar
     */
    public String getBtnCancel() {
        return btnCancel;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOSpouseDataText}.
     */
    public static class Builder {

        private String title;
        private String spouseName;
        private String spouseLastName;
        private String spouseId;
        private String spouseExpeditionLocation;
        private String spouseAddress;
        private String spousePhone;
        private String btnSave;
        private String btnCancel;

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
         * Asigna el texto de nombre del cónyuge.
         *
         * @param spouseName texto de nombre del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseName(String spouseName) {
            this.spouseName = spouseName;
            return this;
        }

        /**
         * Asigna el texto de apellido del cónyuge.
         *
         * @param spouseLastName texto de apellido del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseLastName(String spouseLastName) {
            this.spouseLastName = spouseLastName;
            return this;
        }

        /**
         * Asigna el texto de identificación del cónyuge.
         *
         * @param spouseId texto de identificación del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseId(String spouseId) {
            this.spouseId = spouseId;
            return this;
        }

        /**
         * Asigna el texto de lugar de expedición del cónyuge.
         *
         * @param spouseExpeditionLocation texto de lugar de expedición del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseExpeditionLocation(String spouseExpeditionLocation) {
            this.spouseExpeditionLocation = spouseExpeditionLocation;
            return this;
        }

        /**
         * Asigna el texto de dirección del cónyuge.
         *
         * @param spouseAddress texto de dirección del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseAddress(String spouseAddress) {
            this.spouseAddress = spouseAddress;
            return this;
        }

        /**
         * Asigna el texto de teléfono del cónyuge.
         *
         * @param spousePhone texto de teléfono del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spousePhone(String spousePhone) {
            this.spousePhone = spousePhone;
            return this;
        }

        /**
         * Asigna el texto de botón guardar.
         *
         * @param btnSave texto de botón guardar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder btnSave(String btnSave) {
            this.btnSave = btnSave;
            return this;
        }

        /**
         * Asigna el texto de botón cancelar.
         *
         * @param btnCancel texto de botón cancelar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder btnCancel(String btnCancel) {
            this.btnCancel = btnCancel;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOSpouseDataText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOSpouseDataText build() {
            return new DTOSpouseDataText(this);
        }

    }

}
