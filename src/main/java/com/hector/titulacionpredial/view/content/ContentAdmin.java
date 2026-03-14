package com.hector.titulacionpredial.view.content;

import com.hector.titulacionpredial.view.swing.menu.EventMenuSelected;
import com.hector.titulacionpredial.view.swing.menu.Menu;

import javax.swing.*;

/**
 * Main window ({@code JFrame}) of the Property Titling application.
 *
 * <p>
 * It contains the side menu ({@link com.hector.titulacionpredial.view.swing.menu.Menu}),
 * the title bar ({@link com.hector.titulacionpredial.view.component.Head}) and the dynamic
 * content panel where the different forms of the application are loaded.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ContentAdmin extends javax.swing.JFrame {
    
    /**
     * Create the main window and initialize the menu, header, and content.
     */
    public ContentAdmin() {
        initComponents();

        head.initMoving(this);
        head.getWinButton().initEvent(this, jpl_body);
        //menu.setSelectedIndex(0, 0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpl_body = new javax.swing.JPanel();
        jpl_menu = new javax.swing.JPanel();
        adminMenu1 = new com.hector.titulacionpredial.view.component.AdminMenu();
        buttonAction1 = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jpl_content = new javax.swing.JPanel();
        head = new com.hector.titulacionpredial.view.component.Head();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jpl_body.setBackground(new java.awt.Color(255, 255, 255));

        jpl_menu.setBackground(new java.awt.Color(255, 255, 255));

        buttonAction1.setText("Cerrar Sesion");

        javax.swing.GroupLayout jpl_menuLayout = new javax.swing.GroupLayout(jpl_menu);
        jpl_menu.setLayout(jpl_menuLayout);
        jpl_menuLayout.setHorizontalGroup(
            jpl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(buttonAction1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpl_menuLayout.setVerticalGroup(
            jpl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_menuLayout.createSequentialGroup()
                .addComponent(adminMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpl_content.setBackground(new java.awt.Color(255, 255, 255));
        jpl_content.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(64, 145, 108)));

        javax.swing.GroupLayout jpl_contentLayout = new javax.swing.GroupLayout(jpl_content);
        jpl_content.setLayout(jpl_contentLayout);
        jpl_contentLayout.setHorizontalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpl_bodyLayout.setVerticalGroup(
            jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_bodyLayout.createSequentialGroup()
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jpl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setControllerMenu(EventMenuSelected evt) {
        //menu.addEvent(evt);
    }

    public static JPanel getJpl_content() {
        return jpl_content;
    }

    /*public Menu getMenu() {
        return menu;
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.component.AdminMenu adminMenu1;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction buttonAction1;
    private com.hector.titulacionpredial.view.component.Head head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpl_body;
    private static javax.swing.JPanel jpl_content;
    private javax.swing.JPanel jpl_menu;
    // End of variables declaration//GEN-END:variables
}
