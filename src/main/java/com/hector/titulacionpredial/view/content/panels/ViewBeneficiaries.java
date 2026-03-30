package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOViewBeneficiariesText;
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

/**
 * Panel for viewing and managing beneficiaries in table format.
 *
 * <p>
 * It allows you to search, modify, delete, export and view the
 * profile of beneficiaries registered in the system.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ViewBeneficiaries extends javax.swing.JPanel {

    private String code = "Código";
    private String id = "Cédula";
    private String name = "Nombre";
    private String phone = "Teléfono";
    private String cadastralRef = "Ref. Catastral";
    private String municipality = "Municipio";
    private String address = "Dirección";
    private String codeIdentification = "Código de Identificación";

    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Create the beneficiary query panel and configure the table.
     */
    public ViewBeneficiaries() {
        initComponents();
        
        String[] titles = {code, codeIdentification, id, name, phone, cadastralRef, municipality, address};
        tableModel.setColumnIdentifiers(titles);
        jtbl_beneficiaries.setModel(tableModel);
        
        JTableHeader header = jtbl_beneficiaries.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);
        btn_searchCancel.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpl_content = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_beneficiaries = new javax.swing.JTable();
        roundedPanel1 = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_searchCancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_seeProfile = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_modify = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_delete = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_exportToExcel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jpl_content.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Beneficiarios");

        jtbl_beneficiaries.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jtbl_beneficiaries.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_beneficiaries);

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setBorderColor(new java.awt.Color(116, 198, 157));

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

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_seeProfile.setBackground(new java.awt.Color(64, 145, 108));
        btn_seeProfile.setForeground(new java.awt.Color(255, 255, 255));
        btn_seeProfile.setText("Ver Informacion Completa");
        btn_seeProfile.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_seeProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_modify.setBackground(new java.awt.Color(149, 213, 178));
        btn_modify.setForeground(new java.awt.Color(5, 31, 32));
        btn_modify.setText("Modificar");
        btn_modify.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_modify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_delete.setBackground(new java.awt.Color(149, 213, 178));
        btn_delete.setForeground(new java.awt.Color(5, 31, 32));
        btn_delete.setText("Eliminar");
        btn_delete.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_exportToExcel.setBackground(new java.awt.Color(64, 145, 108));
        btn_exportToExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportToExcel.setText("Exportar a Excel");
        btn_exportToExcel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_exportToExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpl_contentLayout = new javax.swing.GroupLayout(jpl_content);
        jpl_content.setLayout(jpl_contentLayout);
        jpl_contentLayout.setHorizontalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_contentLayout.createSequentialGroup()
                        .addComponent(jlb_title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_contentLayout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btn_exportToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_seeProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_contentLayout.createSequentialGroup()
                        .addGroup(jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpl_contentLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1))
                            .addGroup(jpl_contentLayout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(31, 31, 31))))
        );
        jpl_contentLayout.setVerticalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addGroup(jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_seeProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Update the panel texts according to the selected language.
     *
     * @param texts DTO with translated texts
     */
    public void updateLanguage(DTOViewBeneficiariesText texts) {
        jlb_title.setText(texts.getTitle());
        code = texts.getCode();
        codeIdentification = texts.getCodeIdentification();
        id = texts.getId();
        name = texts.getName();
        phone = texts.getPhone();
        cadastralRef = texts.getCadastralRef();
        municipality = texts.getMunicipality();
        address = texts.getAddress();
        txt_search.setText(texts.getSearch());
        btn_seeProfile.setText(texts.getFullInfoBtn());
        btn_modify.setText(texts.getModifyBtn());
        btn_delete.setText(texts.getDeleteBtn());
        btn_exportToExcel.setText(texts.getExportExcelBtn());

        jtbl_beneficiaries.getColumnModel().getColumn(0).setHeaderValue(code);
        jtbl_beneficiaries.getColumnModel().getColumn(1).setHeaderValue(codeIdentification);
        jtbl_beneficiaries.getColumnModel().getColumn(2).setHeaderValue(id);
        jtbl_beneficiaries.getColumnModel().getColumn(3).setHeaderValue(name);
        jtbl_beneficiaries.getColumnModel().getColumn(4).setHeaderValue(phone);
        jtbl_beneficiaries.getColumnModel().getColumn(5).setHeaderValue(cadastralRef);
        jtbl_beneficiaries.getColumnModel().getColumn(6).setHeaderValue(municipality);
        jtbl_beneficiaries.getColumnModel().getColumn(7).setHeaderValue(address);
        jtbl_beneficiaries.getTableHeader().repaint();
    }

    /**     * set controller view details.     * @param action the action     */
    public void setControllerViewDetails(ActionListener action) {
        btn_seeProfile.addActionListener(action);
    }

    /**     * set controller export to excel.     * @param action the action     */
    public void setControllerExportToExcel(ActionListener action) {
        btn_exportToExcel.addActionListener(action);
    }

    /**     * set controller modify.     * @param action the action     */
    public void setControllerModify(ActionListener action) {
        btn_modify.addActionListener(action);
    }

    /**     * set controller delete.     * @param action the action     */
    public void setControllerDelete(ActionListener action) {
        btn_delete.addActionListener(action);
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

    /**     * get table model.     * @return the get table model     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**     * get btn_delete.     * @return the get btn_delete     */
    public ButtonAction getBtn_delete() {
        return btn_delete;
    }

    /**     * get btn_modify.     * @return the get btn_modify     */
    public ButtonAction getBtn_modify() {
        return btn_modify;
    }

    /**     * get btn_search.     * @return the get btn_search     */
    public ButtonAction getBtn_search() {
        return btn_search;
    }

    /**     * get btn_see profile.     * @return the get btn_see profile     */
    public ButtonAction getBtn_seeProfile() {
        return btn_seeProfile;
    }

    /**     * get btn_search cancel.     * @return the get btn_search cancel     */
    public ButtonAction getBtn_searchCancel() {
        return btn_searchCancel;
    }

    /**     * get jpl_content.     * @return the get jpl_content     */
    public JPanel getJpl_content() {
        return jpl_content;
    }

    /**     * get jtbl_beneficiaries.     * @return the get jtbl_beneficiaries     */
    public JTable getJtbl_beneficiaries() {
        return jtbl_beneficiaries;
    }

    /**     * get rounded panel1.     * @return the get rounded panel1     */
    public RoundedPanel getRoundedPanel1() {
        return roundedPanel1;
    }

    /**     * get txt_search.     * @return the get txt_search     */
    public JTextField getTxt_search() {
        return txt_search;
    }

    /**
     * Load a beneficiary into the table.
     *
     * @param dto simplified beneficiary data
     */
    public void loadData(DTOBeneficiarySimpleDetails dto) {
        int code = dto.getCode();
        String beneficiariesCode = dto.getCodeBeneficiaries();
        long id = dto.getId();
        String fullName = dto.getFullName();
        long phone = dto.getPhone();
        String cadastralReference = dto.getCadastralReference();
        Municipalities municipality = dto.getMunicipalities();
        String address = dto.getAddress();

        Object[] data = new Object[]{code, beneficiariesCode, id, fullName, phone, cadastralReference, municipality.getValue(), address};
        tableModel.addRow(data);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_delete;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_exportToExcel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_modify;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchCancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_seeProfile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JPanel jpl_content;
    private javax.swing.JTable jtbl_beneficiaries;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel1;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
