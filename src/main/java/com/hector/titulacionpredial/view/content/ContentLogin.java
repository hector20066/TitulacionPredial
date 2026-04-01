package com.hector.titulacionpredial.view.content;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTOContentLoginText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ContentLogin extends javax.swing.JFrame {

    /**
     * Creates new form ContentLogin
     */
    public ContentLogin() {
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jlb_title = new javax.swing.JLabel();
        jlb_user = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jlb_password = new javax.swing.JLabel();
        jpld_password = new javax.swing.JPasswordField();
        cbo_access = new javax.swing.JComboBox<>();
        jlb_access = new javax.swing.JLabel();
        btn_login = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        rbn_seePasswd = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(64, 145, 108));
        jSeparator1.setForeground(new java.awt.Color(64, 145, 108));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loge-app-login.png"))); // NOI18N

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(33, 37, 41));
        jlb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_title.setText("INICIAR SESION");

        jlb_user.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jlb_user.setForeground(new java.awt.Color(33, 37, 41));
        jlb_user.setText("Usuario:");

        txt_user.setBackground(new java.awt.Color(255, 255, 255));
        txt_user.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_user.setForeground(new java.awt.Color(33, 37, 41));
        txt_user.setText("Ingrese el usuario");
        txt_user.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jlb_password.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jlb_password.setForeground(new java.awt.Color(33, 37, 41));
        jlb_password.setText("Contraseña:");

        jpld_password.setBackground(new java.awt.Color(255, 255, 255));
        jpld_password.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jpld_password.setForeground(new java.awt.Color(33, 37, 41));
        jpld_password.setText("••••••••");
        jpld_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        cbo_access.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        cbo_access.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solo lectura", "Info. Sahagun", "Inf. Monteria" }));

        jlb_access.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jlb_access.setForeground(new java.awt.Color(33, 37, 41));
        jlb_access.setText("Acceso");

        btn_login.setBackground(new java.awt.Color(64, 145, 108));
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Iniciar Sesion");
        btn_login.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        rbn_seePasswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jpld_password, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlb_password)
                                    .addComponent(jlb_user)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlb_access)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_access, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addComponent(rbn_seePasswd)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jlb_title)
                        .addGap(66, 66, 66)
                        .addComponent(jlb_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpld_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbn_seePasswd))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_access, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_access))
                        .addGap(70, 70, 70)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Update the view to display content in the specified language.
     *
     * @param texts the DTO containing localized labels and messages
     */
    public void updateLanguage(DTOContentLoginText texts) {
        jlb_title.setText(texts.getTitle());
        jlb_user.setText(texts.getUser());
        txt_user.setText(texts.getUserText());
        jlb_password.setText(texts.getPassword());
        jlb_access.setText(texts.getAccess());
        btn_login.setText(texts.getLogin());
    }

    /**
     * Set the login button click handler.
     *
     * @param action the action listener
     */
    public void setControllerLogin(ActionListener action) {
        btn_login.addActionListener(action);
    }

    /**
     * Set the see password toggle button click handler.
     *
     * @param action the action listener
     */
    public void setControllerSeePassword(ActionListener action) {
        rbn_seePasswd.addActionListener(action);
    }

    /**
     * Set the mouse listener for the user text field.
     *
     * @param listen the mouse listener
     */
    public void setTxt_userMouse(MouseListener listen) {
        txt_user.addMouseListener(listen);
    }

    /**
     * Set the action listener for the user text field.
     *
     * @param action the action listener
     */
    public void setTxt_userAction(ActionListener action) {
        txt_user.addActionListener(action);
    }

    /**
     * Set the mouse listener for the password field.
     *
     * @param listen the mouse listener
     */
    public void setJpld_passwordMouse(MouseListener listen) {
        jpld_password.addMouseListener(listen);
    }

    /**
     * Set the action listener for the password field.
     *
     * @param action the action listener
     */
    public void setJpld_passwordAction(ActionListener action) {
        jpld_password.addActionListener(action);
    }

    public ButtonAction getBtn_login() {
        return btn_login;
    }

    public JComboBox<String> getCbo_access() {
        return cbo_access;
    }

    public JTextField getTxt_user() {
        return txt_user;
    }

    public JPasswordField getJpld_password() {
        return jpld_password;
    }

    public JRadioButton getRbn_seePasswd() {
        return rbn_seePasswd;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_login;
    private javax.swing.JComboBox<String> cbo_access;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlb_access;
    private javax.swing.JLabel jlb_password;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JLabel jlb_user;
    private javax.swing.JPasswordField jpld_password;
    private javax.swing.JRadioButton rbn_seePasswd;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
