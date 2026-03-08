package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOAboutText;

/**
 * «About» panel displaying application information, version,
 * development team credits, and a link to the HLDevWorks website.
 *
 * @author Eng. Hector Acevedo
 * @since 1.0
 */
public class About extends javax.swing.JPanel implements LanguageObserver {

    private final LanguageManager languageManager;

    /**
     * Creates the «About» panel with the application's information.
     */
    public About(LanguageManager languageManager, LanguageSubject languageSubject) {
        initComponents();

        this.languageManager = languageManager;
        languageSubject.register(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        jlb_subtitle1 = new javax.swing.JLabel();
        jlb_version = new javax.swing.JLabel();
        jlb_release = new javax.swing.JLabel();
        jlb_subtitle2 = new javax.swing.JLabel();
        jlb_creator1 = new javax.swing.JLabel();
        jlb_creator2 = new javax.swing.JLabel();
        jlb_moreInfo = new javax.swing.JLabel();
        jlb_link = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(33, 37, 41));
        jlb_title.setText("Acerca De");

        jlb_subtitle1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_subtitle1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_subtitle1.setText("Informacion de la aplicacion");

        jlb_version.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_version.setForeground(new java.awt.Color(33, 37, 41));
        jlb_version.setText("Version: 1.0");

        jlb_release.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_release.setForeground(new java.awt.Color(33, 37, 41));
        jlb_release.setText("Fecha Lanzamiento: Undefined");

        jlb_subtitle2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_subtitle2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_subtitle2.setText("Los Creadores");

        jlb_creator1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_creator1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_creator1.setText("Ing. Hector Acevedo ");

        jlb_creator2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_creator2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_creator2.setText("Ing. Juan Bohorquez");

        jlb_moreInfo.setFont(new java.awt.Font("SansSerif", 2, 15)); // NOI18N
        jlb_moreInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_moreInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_moreInfo.setText("Para mas informacion sobre los creadores visite:");

        jlb_link.setFont(new java.awt.Font("SansSerif", 2, 15)); // NOI18N
        jlb_link.setForeground(new java.awt.Color(33, 37, 41));
        jlb_link.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_link.setText("https://www.hldevworks.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlb_title))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_release)
                                    .addComponent(jlb_version)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_subtitle2)
                                    .addComponent(jlb_subtitle1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_creator2)
                                    .addComponent(jlb_creator1))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlb_moreInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_link, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addGap(45, 45, 45)
                .addComponent(jlb_subtitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_version)
                .addGap(18, 18, 18)
                .addComponent(jlb_release)
                .addGap(54, 54, 54)
                .addComponent(jlb_subtitle2)
                .addGap(18, 18, 18)
                .addComponent(jlb_creator1)
                .addGap(18, 18, 18)
                .addComponent(jlb_creator2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jlb_moreInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_link)
                .addGap(144, 144, 144))
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

    @Override
    public void updateLanguage() {
        DTOAboutText dto = new DTOAboutText.Builder()
                .title(languageManager.app("about.title"))
                .appInfo(languageManager.app("about.app.information"))
                .version(languageManager.app("about.version"))
                .releaseDate(languageManager.app("about.release.date"))
                .creators(languageManager.app("about.creator"))
                .creator1(languageManager.app("about.creator1"))
                .creator2(languageManager.app("about.creator2"))
                .moreInfo(languageManager.app("about.creators.more.info"))
                .build();

        updateLanguage(dto);
    }

    /**
     * Updates the text in the «About» panel with the provided translations.
     *
     * @param texts DTO with the translated text from the panel
     */
    public void updateLanguage(DTOAboutText texts) {
        jlb_title.setText(texts.getTitle());
        jlb_subtitle1.setText(texts.getAppInfo());
        jlb_version.setText(texts.getVersion());
        jlb_release.setText(texts.getReleaseDate());
        jlb_subtitle2.setText(texts.getCreators());
        jlb_creator1.setText(texts.getCreator1());
        jlb_creator2.setText(texts.getCreator2());
        jlb_moreInfo.setText(texts.getMoreInfo());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb_creator1;
    private javax.swing.JLabel jlb_creator2;
    private javax.swing.JLabel jlb_link;
    private javax.swing.JLabel jlb_moreInfo;
    private javax.swing.JLabel jlb_release;
    private javax.swing.JLabel jlb_subtitle1;
    private javax.swing.JLabel jlb_subtitle2;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JLabel jlb_version;
    // End of variables declaration//GEN-END:variables
}
