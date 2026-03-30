package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSeeResolutionsText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.panel.RoundedPanel;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;

/**
 * Panel for displaying recorded resolutions in table format.
 *
 * <p>
 * It allows you to search for and modify existing resolutions.
 * It displays information such as resolution number, property
 * code, FMI, notification dates, and enforcement date.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SeeResolutions extends javax.swing.JPanel {

    private String code = "Código";
    private String number = "Num. Resolución";
    private String notification = "Notificación";
    private String executory = "Ejecutora";
    private String notary = "Notaria";
    private String fmi = "FMI";
    private String act = "Acto";
    private String publicWriting = "Esc. Pública";

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Create the resolutions query panel and configure the table.
     */
    public SeeResolutions() {
        initComponents();
        
        String[] titles = {code, number, notification, executory, notary, fmi, act, publicWriting};
        model.setColumnIdentifiers(titles);
        jtbl_resolutions.setModel(model);
        
        JTableHeader header = jtbl_resolutions.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);
        btn_searchCancel.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_resolutions = new javax.swing.JTable();
        jlb_title = new javax.swing.JLabel();
        roundedPanel3 = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_searchCancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_modify = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setBackground(new java.awt.Color(255, 255, 255));

        jtbl_resolutions.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jtbl_resolutions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbl_resolutions);

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Resoluciones");

        roundedPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel3.setBorderColor(new java.awt.Color(116, 198, 157));

        txt_search.setBackground(new java.awt.Color(255, 255, 255));
        txt_search.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_search.setForeground(new java.awt.Color(64, 145, 108));
        txt_search.setText("Buscar");
        txt_search.setBorder(null);

        btn_search.setBackground(new java.awt.Color(255, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_searchCancel.setBackground(new java.awt.Color(255, 255, 255));
        btn_searchCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/x.png"))); // NOI18N
        btn_searchCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_searchCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_modify.setBackground(new java.awt.Color(64, 145, 108));
        btn_modify.setForeground(new java.awt.Color(255, 255, 255));
        btn_modify.setText("Modificar");
        btn_modify.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_modify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
                                .addGap(19, 19, 19))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addGap(26, 26, 26)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Update the panel texts according to the selected language.
     *
     * @param texts DTO with translated texts
     */
    public void updateLanguage(DTOSeeResolutionsText texts) {
        jlb_title.setText(texts.getTitle());
        code = texts.getCode();
        number = texts.getNumber();
        notification = texts.getNotification();
        executory = texts.getExecutory();
        notary = texts.getNotary();
        fmi = texts.getFmi();
        act = texts.getAct();
        publicWriting = texts.getPublicWriting();
        txt_search.setText(texts.getSearch());
        btn_modify.setText(texts.getModifyBtn());

        jtbl_resolutions.getColumnModel().getColumn(0).setHeaderValue(code);
        jtbl_resolutions.getColumnModel().getColumn(1).setHeaderValue(number);
        jtbl_resolutions.getColumnModel().getColumn(2).setHeaderValue(notification);
        jtbl_resolutions.getColumnModel().getColumn(3).setHeaderValue(executory);
        jtbl_resolutions.getColumnModel().getColumn(4).setHeaderValue(notary);
        jtbl_resolutions.getColumnModel().getColumn(5).setHeaderValue(fmi);
        jtbl_resolutions.getColumnModel().getColumn(6).setHeaderValue(act);
        jtbl_resolutions.getColumnModel().getColumn(7).setHeaderValue(publicWriting);
        jtbl_resolutions.getTableHeader().repaint();
    }

    /**     * set controller modify.     * @param action the action     */
    public void setControllerModify(ActionListener action) {
        btn_modify.addActionListener(action);
    }

    /**     * set controller search.     * @param action the action     */
    public void setControllerSearch(ActionListener action) {
        btn_search.addActionListener(action);
    }

    /**     * set controller search cancel.     * @param action the action     */
    public void setControllerSearchCancel(ActionListener action) {
        btn_searchCancel.addActionListener(action);
    }

    /**     * set controller txt_search document.     * @param listen the listen     */
    public void setControllerTxt_searchDocument(DocumentListener listen) {
        txt_search.getDocument().addDocumentListener(listen);
    }

    /**     * set controller txt_search mouse listener.     * @param listen the listen     */
    public void setControllerTxt_searchMouseListener(MouseListener listen) {
        txt_search.addMouseListener(listen);
    }

    /**     * set controller txt_search focus.     * @param listen the listen     */
    public void setControllerTxt_searchFocus(FocusListener listen) {
        txt_search.addFocusListener(listen);
    }

    /**     * get model.     * @return the get model     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**     * get btn_modify.     * @return the get btn_modify     */
    public ButtonAction getBtn_modify() {
        return btn_modify;
    }

    /**     * get btn_search.     * @return the get btn_search     */
    public ButtonAction getBtn_search() {
        return btn_search;
    }

    /**     * get btn_search cancel.     * @return the get btn_search cancel     */
    public ButtonAction getBtn_searchCancel() {
        return btn_searchCancel;
    }

    /**     * get jtbl_resolutions.     * @return the get jtbl_resolutions     */
    public JTable getJtbl_resolutions() {
        return jtbl_resolutions;
    }

    /**     * get rounded panel3.     * @return the get rounded panel3     */
    public RoundedPanel getRoundedPanel3() {
        return roundedPanel3;
    }

    /**     * get txt_search.     * @return the get txt_search     */
    public JTextField getTxt_search() {
        return txt_search;
    }

    /**
     * Load a resolution into the table.
     *
     * @param dto resolution data
     */
    public void loadData(DTOResolutionDetails dto) {
        int code = dto.getCode();
        long numResolution = dto.getResolutionNumber();
        LocalDate notification = dto.getNotification();
        LocalDate executory = dto.getExecutory();
        String notary = dto.getNotary();
        String fmi = dto.getFmi();
        String act = dto.getAct();
        String publicWriting = dto.getPublicWriting();

        Object[] data = new Object[]{code, numResolution, notification, executory, notary, fmi, act, publicWriting};
        model.addRow(data);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_modify;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchCancel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JTable jtbl_resolutions;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
