package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSettingsText;

import javax.swing.*;

/**
 * Application settings panel that allows the user to select the
 * interface language.
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Settings extends javax.swing.JPanel {

    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();

        rbn_spanish.setActionCommand("es");
        rbn_english.setActionCommand("en");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btg_languages = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jpl_content = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        rbn_spanish = new javax.swing.JRadioButton();
        rbn_english = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jpl_content.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(0, 0, 0));
        jlb_title.setText("Seleccione el idioma.");

        rbn_spanish.setBackground(new java.awt.Color(255, 255, 255));
        btg_languages.add(rbn_spanish);
        rbn_spanish.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        rbn_spanish.setForeground(new java.awt.Color(0, 0, 0));
        rbn_spanish.setText("Español - ES");

        rbn_english.setBackground(new java.awt.Color(255, 255, 255));
        btg_languages.add(rbn_english);
        rbn_english.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        rbn_english.setForeground(new java.awt.Color(0, 0, 0));
        rbn_english.setText("English - EN");

        javax.swing.GroupLayout jpl_contentLayout = new javax.swing.GroupLayout(jpl_content);
        jpl_content.setLayout(jpl_contentLayout);
        jpl_contentLayout.setHorizontalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_contentLayout.createSequentialGroup()
                .addGroup(jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_contentLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jlb_title))
                    .addGroup(jpl_contentLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbn_english)
                            .addComponent(rbn_spanish))))
                .addContainerGap(852, Short.MAX_VALUE))
        );
        jpl_contentLayout.setVerticalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_contentLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlb_title)
                .addGap(46, 46, 46)
                .addComponent(rbn_spanish)
                .addGap(18, 18, 18)
                .addComponent(rbn_english)
                .addContainerGap(431, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_content, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /**
     * Update the texts in the settings panel with the provided
     * translations.
     *
     * @param texts DTO with translated configuration texts
     */
    public void updateLanguage(DTOSettingsText texts) {
        jlb_title.setText(texts.title());
    }

    public JRadioButton getRbn_spanish() {
        return rbn_spanish;
    }

    public JRadioButton getRbn_english() {
        return rbn_english;
    }

    public JLabel getJlb_title() {
        return jlb_title;
    }

    public ButtonGroup getBtg_languages() {
        return btg_languages;
    }

    public JPanel getJpl_content() {
        return jpl_content;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btg_languages;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JPanel jpl_content;
    private javax.swing.JRadioButton rbn_english;
    private javax.swing.JRadioButton rbn_spanish;
    // End of variables declaration//GEN-END:variables
}
