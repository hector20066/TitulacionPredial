package com.hector.titulacionpredial.view.content;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.hector.titulacionpredial.view.component.UserMenu;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOContentLogoutBtnText;
import com.hector.titulacionpredial.view.swing.menu.EventMenuSelected;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ContentUser extends javax.swing.JFrame {
   
    /**
     * Creates new form ContentUser
     */
    public ContentUser() {
        initComponents();
        
        menu.setSelectedIndex(0, 0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpl_body = new javax.swing.JPanel();
        jpl_menu = new javax.swing.JPanel();
        btn_logout = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        menu = new com.hector.titulacionpredial.view.component.UserMenu();
        jpl_content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpl_body.setBackground(new java.awt.Color(255, 255, 255));

        jpl_menu.setBackground(new java.awt.Color(255, 255, 255));

        btn_logout.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout.setForeground(new java.awt.Color(33, 37, 41));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log-out.png"))); // NOI18N
        btn_logout.setText("  Cerrar Sesion");
        btn_logout.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout jpl_menuLayout = new javax.swing.GroupLayout(jpl_menu);
        jpl_menu.setLayout(jpl_menuLayout);
        jpl_menuLayout.setHorizontalGroup(
            jpl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpl_menuLayout.setVerticalGroup(
            jpl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_menuLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpl_content.setBackground(new java.awt.Color(255, 255, 255));
        jpl_content.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(64, 145, 108)));

        javax.swing.GroupLayout jpl_contentLayout = new javax.swing.GroupLayout(jpl_content);
        jpl_content.setLayout(jpl_contentLayout);
        jpl_contentLayout.setHorizontalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1081, Short.MAX_VALUE)
        );
        jpl_contentLayout.setVerticalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loge-app.png"))); // NOI18N

        javax.swing.GroupLayout jpl_bodyLayout = new javax.swing.GroupLayout(jpl_body);
        jpl_body.setLayout(jpl_bodyLayout);
        jpl_bodyLayout.setHorizontalGroup(
            jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_bodyLayout.createSequentialGroup()
                .addComponent(jpl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpl_bodyLayout.setVerticalGroup(
            jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_bodyLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jpl_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpl_bodyLayout.createSequentialGroup()
                        .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Update the view to display content in the specified language.
     *
     * @param texts the DTO containing localized logout button text
     */
    public void updateLanguage(DTOContentLogoutBtnText texts) {
        btn_logout.setText(texts.logout());
    }

    /**
     * Set the menu item selection event handler.
     *
     * @param evt the menu event handler
     */
    public void setControllerMenu(EventMenuSelected evt) {
        menu.addEvent(evt);
    }

    /**
     * Set the logout button click handler.
     *
     * @param action the action listener
     */
    public void setControllerLogout(ActionListener action) {
        btn_logout.addActionListener(action);
    }

    public UserMenu getMenu() {
        return menu;
    }

    public static JPanel getJpl_content() {
        return jpl_content;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpl_body;
    private static javax.swing.JPanel jpl_content;
    private javax.swing.JPanel jpl_menu;
    private com.hector.titulacionpredial.view.component.UserMenu menu;
    // End of variables declaration//GEN-END:variables
}
