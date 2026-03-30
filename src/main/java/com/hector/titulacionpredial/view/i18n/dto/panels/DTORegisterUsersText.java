package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 */
public class DTORegisterUsersText {

    private final String title;
    private final String desc;
    private final String fullName;
    private final String id;
    private final String desc2;
    private final String user;
    private final String password;
    private final String rol;
    private final String createBtn;

    /**     * dto register users text.     * @param builder the builder     * @return the dto register users text     */
    public DTORegisterUsersText (Builder builder) {
        this.title = builder.title;
        this.desc = builder.desc;
        this.fullName = builder.fullName;
        this.id = builder.id;
        this.desc2 = builder.desc2;
        this.user = builder.user;
        this.password = builder.password;
        this.rol = builder.rol;
        this.createBtn = builder.createBtn;
    }

    /**     * get title.     * @return the get title     */
    public String getTitle() {
        return title;
    }

    /**     * get desc.     * @return the get desc     */
    public String getDesc() {
        return desc;
    }

    /**     * get full name.     * @return the get full name     */
    public String getFullName() {
        return fullName;
    }

    /**     * get id.     * @return the get id     */
    public String getId() {
        return id;
    }

    /**     * get desc2.     * @return the get desc2     */
    public String getDesc2() {
        return desc2;
    }

    /**     * get user.     * @return the get user     */
    public String getUser() {
        return user;
    }

    /**     * get password.     * @return the get password     */
    public String getPassword() {
        return password;
    }

    /**     * get rol.     * @return the get rol     */
    public String getRol() {
        return rol;
    }

    /**     * get create btn.     * @return the get create btn     */
    public String getCreateBtn() {
        return createBtn;
    }

    public static class Builder {

        private String title;
        private String desc;
        private String fullName;
        private String id;
        private String desc2;
        private String user;
        private String password;
        private String rol;
        private String createBtn;

    /**     * title.     * @param title the title     * @return the title     */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

    /**     * desc.     * @param desc the desc     * @return the desc     */
        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

    /**     * full name.     * @param fullName the full name     * @return the full name     */
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

    /**     * id.     * @param id the id     * @return the id     */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

    /**     * desc2.     * @param desc2 the desc2     * @return the desc2     */
        public Builder desc2(String desc2) {
            this.desc2 = desc2;
            return this;
        }

    /**     * user.     * @param user the user     * @return the user     */
        public Builder user(String user) {
            this.user = user;
            return this;
        }

    /**     * password.     * @param password the password     * @return the password     */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

    /**     * rol.     * @param rol the rol     * @return the rol     */
        public Builder rol(String rol) {
            this.rol = rol;
            return this;
        }

    /**     * create btn.     * @param createBtn the create btn     * @return the create btn     */
        public Builder createBtn(String createBtn) {
            this.createBtn = createBtn;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTORegisterUsersText build() {
            return new DTORegisterUsersText(this);
        }

    }

}
