package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterUsersText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class RegisterUsers extends javax.swing.JPanel {

    /**
     * Creates new form RegisterUsers
     */
    public RegisterUsers() {
        initComponents();
        
        Icon normalIcon = new ImageIcon(getClass().getResource("/image/eye.png"));
        Icon iconOff = new ImageIcon(getClass().getResource("/image/eye-off.png"));
        rbn_seePasswd.setIcon(normalIcon);
        rbn_seePasswd.setSelectedIcon(iconOff);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /**     * init components.     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        jlb_desc = new javax.swing.JLabel();
        jlb_fullName = new javax.swing.JLabel();
        txt_fullName = new javax.swing.JTextField();
        jlb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jlb_desc2 = new javax.swing.JLabel();
        jlb_user = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jlb_password = new javax.swing.JLabel();
        jpld_password = new javax.swing.JPasswordField();
        jlb_rol = new javax.swing.JLabel();
        cbo_role = new javax.swing.JComboBox<>();
        btn_createAccount = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        rbn_seePasswd = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Agregar Usuarios");

        jlb_desc.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_desc.setForeground(new java.awt.Color(8, 28, 21));
        jlb_desc.setText("Ingrese toda la informacion de los usuarios que tendran acceso al sistema.");

        jlb_fullName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_fullName.setForeground(new java.awt.Color(8, 28, 21));
        jlb_fullName.setText("Nombre Completo:");

        txt_fullName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_id.setForeground(new java.awt.Color(8, 28, 21));
        jlb_id.setText("Cedula:");

        txt_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_desc2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_desc2.setForeground(new java.awt.Color(8, 28, 21));
        jlb_desc2.setText("Por favor ingrese las credenciales de acceso que tendra el nuevo usuario");

        jlb_user.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_user.setForeground(new java.awt.Color(8, 28, 21));
        jlb_user.setText("Usuario:");

        txt_user.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_password.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_password.setForeground(new java.awt.Color(8, 28, 21));
        jlb_password.setText("Contraseña:");

        jpld_password.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_rol.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_rol.setForeground(new java.awt.Color(8, 28, 21));
        jlb_rol.setText("Rol del Usuario:");

        cbo_role.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cbo_role.setModel(new javax.swing.DefaultComboBoxModel<>(Role.values()));

        btn_createAccount.setBackground(new java.awt.Color(64, 145, 108));
        btn_createAccount.setForeground(new java.awt.Color(255, 255, 255));
        btn_createAccount.setText("Crear Cuenta");
        btn_createAccount.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_createAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        rbn_seePasswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jlb_fullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jlb_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_desc2)
                            .addComponent(jlb_desc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jlb_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jlb_password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpld_password, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbn_seePasswd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cbo_role, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlb_rol)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(btn_createAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addGap(27, 27, 27)
                .addComponent(jlb_desc)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_fullName)
                    .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jlb_desc2)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlb_user)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb_password)
                        .addComponent(jpld_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbn_seePasswd))
                .addGap(35, 35, 35)
                .addComponent(jlb_rol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btn_createAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**     * update language.     * @param texts the texts     */
    public void updateLanguage(DTORegisterUsersText texts) {
        jlb_title.setText(texts.getTitle());
        jlb_desc.setText(texts.getDesc());
        jlb_fullName.setText(texts.getFullName());
        jlb_id.setText(texts.getId());
        jlb_desc2.setText(texts.getDesc2());
        jlb_user.setText(texts.getUser());
        jlb_password.setText(texts.getPassword());
        jlb_rol.setText(texts.getRol());
        btn_createAccount.setText(texts.getCreateBtn());
    }

    /**     * set controller create.     * @param action the action     */
    public void setControllerCreate(ActionListener action) {
        btn_createAccount.addActionListener(action);
    }
    
    /**     * set controller see password.     * @param action the action     */
    public void setControllerSeePassword(ActionListener action) {
        rbn_seePasswd.addActionListener(action);
    }

    /**     * get btn_create account.     * @return the get btn_create account     */
    public ButtonAction getBtn_createAccount() {
        return btn_createAccount;
    }

    public JComboBox<Role> getCbo_role() {
        return cbo_role;
    }

    /**     * get jpld_password.     * @return the get jpld_password     */
    public JPasswordField getJpld_password() {
        return jpld_password;
    }

    /**     * get txt_full name.     * @return the get txt_full name     */
    public JTextField getTxt_fullName() {
        return txt_fullName;
    }

    /**     * get txt_id.     * @return the get txt_id     */
    public JTextField getTxt_id() {
        return txt_id;
    }

    /**     * get txt_user.     * @return the get txt_user     */
    public JTextField getTxt_user() {
        return txt_user;
    }

    /**     * get rbn_see passwd.     * @return the get rbn_see passwd     */
    public JRadioButton getRbn_seePasswd() {
        return rbn_seePasswd;
    }

    /**     * clear fields.     */
    public void clearFields() {
        txt_id.setText("");
        txt_user.setText("");
        txt_fullName.setText("");
        jpld_password.setText("");
        cbo_role.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_createAccount;
    private javax.swing.JComboBox<Role> cbo_role;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb_desc;
    private javax.swing.JLabel jlb_desc2;
    private javax.swing.JLabel jlb_fullName;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JLabel jlb_password;
    private javax.swing.JLabel jlb_rol;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JLabel jlb_user;
    private javax.swing.JPasswordField jpld_password;
    private javax.swing.JRadioButton rbn_seePasswd;
    private javax.swing.JTextField txt_fullName;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
