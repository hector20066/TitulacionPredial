package com.hector.titulacionpredial.view.content.panels;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertySimpleDetails;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterBeneficiaryText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

/**
 * Form for registering and modifying beneficiaries.
 *
 * <p>
 * Includes fields for first name, last name, ID number, department,
 * municipality, marital status, property tax assessment, and tracking
 * code. Supports creation mode and edit (modification) mode.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class RegisterBeneficiary extends javax.swing.JPanel {

    private boolean modify = false;
    private MaritalStatus nowStatus;
    private int modifyCode;

    private String jlbTitleModify = "Modificar Beneficiario";
    private String btnModifyText = "MODIFICAR BENEFICIARIO";

    /**
     * Create the beneficiary registration form and configure the dropdown
     * menus and text areas.
     */
    public RegisterBeneficiary() {
        initComponents();

        jscp_info.getVerticalScrollBar().setUnitIncrement(15);

        txa_affectation.setLineWrap(true);
        txa_affectation.setWrapStyleWord(true);
        txa_crossing.setLineWrap(true);
        txa_crossing.setWrapStyleWord(true);

        cbo_department.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Department) {
                    setText(((Department) value).getValue());
                }

                return this;
            }
        });

        cbo_maritalStatus.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof MaritalStatus) {
                    setText(((MaritalStatus) value).getValue());
                }

                return this;
            }
        });

        cbo_municipality.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Municipalities) {
                    setText(((Municipalities) value).getValue());
                }

                return this;
            }
        });
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public boolean isModify() {
        return modify;
    }

    public void setNowStatus(MaritalStatus nowStatus) {
        this.nowStatus = nowStatus;
    }

    public MaritalStatus getNowStatus() {
        return nowStatus;
    }

    public String getJlbTitleModify() {
        return jlbTitleModify;
    }

    public void setJlbTitleModify(String jlbTitleModify) {
        this.jlbTitleModify = jlbTitleModify;
    }

    public String getBtnModifyText() {
        return btnModifyText;
    }

    public void setBtnModifyText(String btnModifyText) {
        this.btnModifyText = btnModifyText;
    }

    public void setModifyCode(int modifyCode) {
        this.modifyCode = modifyCode;
    }

    public int getModifyCode() {
        return modifyCode;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        jscp_info = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jlb_beneficiaryInfo = new javax.swing.JLabel();
        jlb_fullName = new javax.swing.JLabel();
        txt_fullName = new javax.swing.JTextField();
        jlb_phone = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jlb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jlb_maritalStatus = new javax.swing.JLabel();
        cbo_maritalStatus = new javax.swing.JComboBox<>();
        jlb_residenceData = new javax.swing.JLabel();
        jlb_department = new javax.swing.JLabel();
        cbo_department = new javax.swing.JComboBox<>();
        jlb_neighborhood = new javax.swing.JLabel();
        txt_neighborhood = new javax.swing.JTextField();
        cbo_municipality = new javax.swing.JComboBox<>();
        jlb_municipality = new javax.swing.JLabel();
        jlb_address = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jlb_cadastralRef = new javax.swing.JLabel();
        txt_cadastralReference = new javax.swing.JTextField();
        jlb_crossing = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_crossing = new javax.swing.JTextArea();
        jlb_affectation = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txa_affectation = new javax.swing.JTextArea();
        jlb_expeditionLocation = new javax.swing.JLabel();
        txt_expeditionLocation = new javax.swing.JTextField();
        jlb_publication = new javax.swing.JLabel();
        cbo_publication = new javax.swing.JComboBox<>();
        btn_addBeneficiaries = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_register = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jlb_code = new javax.swing.JLabel();
        txt_followingCode = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Agregar Beneficiario");

        jscp_info.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlb_beneficiaryInfo.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_beneficiaryInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_beneficiaryInfo.setText("Informacion del beneficiario del sistema");

        jlb_fullName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_fullName.setForeground(new java.awt.Color(33, 37, 41));
        jlb_fullName.setText("Nombre Completo:");

        txt_fullName.setBackground(new java.awt.Color(255, 255, 255));
        txt_fullName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_phone.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_phone.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phone.setText("Telefono:");

        txt_phone.setBackground(new java.awt.Color(255, 255, 255));
        txt_phone.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_id.setForeground(new java.awt.Color(33, 37, 41));
        jlb_id.setText("Cedula:");

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_maritalStatus.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_maritalStatus.setForeground(new java.awt.Color(33, 37, 41));
        jlb_maritalStatus.setText("Estado Civil:");

        cbo_maritalStatus.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cbo_maritalStatus.setModel(new javax.swing.DefaultComboBoxModel<>(MaritalStatus.values()));

        jlb_residenceData.setFont(new java.awt.Font("SansSerif", 2, 15)); // NOI18N
        jlb_residenceData.setForeground(new java.awt.Color(33, 37, 41));
        jlb_residenceData.setText("Datos de residencia");

        jlb_department.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_department.setForeground(new java.awt.Color(33, 37, 41));
        jlb_department.setText("Departamento");

        cbo_department.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cbo_department.setModel(new javax.swing.DefaultComboBoxModel<>(Department.values()));

        jlb_neighborhood.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_neighborhood.setForeground(new java.awt.Color(33, 37, 41));
        jlb_neighborhood.setText("Barrio:");

        txt_neighborhood.setBackground(new java.awt.Color(255, 255, 255));
        txt_neighborhood.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        cbo_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_municipality.setForeground(new java.awt.Color(33, 37, 41));
        jlb_municipality.setText("Municipio:");

        jlb_address.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_address.setForeground(new java.awt.Color(33, 37, 41));
        jlb_address.setText("Direccion:");

        txt_address.setBackground(new java.awt.Color(255, 255, 255));
        txt_address.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jlb_cadastralRef.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_cadastralRef.setForeground(new java.awt.Color(33, 37, 41));
        jlb_cadastralRef.setText("Referencia Catastral:");

        txt_cadastralReference.setBackground(new java.awt.Color(255, 255, 255));
        txt_cadastralReference.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_crossing.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_crossing.setForeground(new java.awt.Color(33, 37, 41));
        jlb_crossing.setText("Cruce:");

        txa_crossing.setColumns(20);
        txa_crossing.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txa_crossing.setRows(3);
        jScrollPane2.setViewportView(txa_crossing);

        jlb_affectation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_affectation.setForeground(new java.awt.Color(33, 37, 41));
        jlb_affectation.setText("Afectacion:");

        txa_affectation.setEditable(false);
        txa_affectation.setColumns(20);
        txa_affectation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txa_affectation.setRows(4);
        jScrollPane3.setViewportView(txa_affectation);

        jlb_expeditionLocation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_expeditionLocation.setForeground(new java.awt.Color(33, 37, 41));
        jlb_expeditionLocation.setText("Lugar Expedicion:");

        txt_expeditionLocation.setBackground(new java.awt.Color(255, 255, 255));
        txt_expeditionLocation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_publication.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_publication.setForeground(new java.awt.Color(33, 37, 41));
        jlb_publication.setText("Publicacion:");

        cbo_publication.setBackground(new java.awt.Color(255, 255, 255));
        cbo_publication.setForeground(new java.awt.Color(0, 0, 0));
        cbo_publication.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        btn_addBeneficiaries.setBackground(new java.awt.Color(64, 145, 108));
        btn_addBeneficiaries.setText("Agregar Beneficiario");
        btn_addBeneficiaries.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_addBeneficiaries.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jlb_phone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_phone)
                                        .addGap(46, 46, 46)
                                        .addComponent(jlb_maritalStatus))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jlb_fullName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbo_maritalStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jlb_expeditionLocation)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_expeditionLocation))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(145, 145, 145)
                                        .addComponent(jlb_id)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_id)
                                        .addGap(202, 202, 202))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_department)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(cbo_department, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(175, 175, 175)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(cbo_municipality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jlb_municipality)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jlb_neighborhood)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_neighborhood)
                                        .addGap(96, 96, 96)
                                        .addComponent(jlb_address)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_address)
                                        .addGap(79, 79, 79)))
                                .addGap(222, 222, 222))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlb_crossing, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jlb_cadastralRef)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cadastralReference)
                                        .addGap(62, 62, 62)
                                        .addComponent(jlb_publication)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbo_publication, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlb_affectation, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE))))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_beneficiaryInfo)
                                    .addComponent(jlb_residenceData)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_addBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_beneficiaryInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_fullName)
                    .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_phone)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_maritalStatus)
                    .addComponent(cbo_maritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_expeditionLocation)
                    .addComponent(txt_expeditionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_addBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_residenceData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_department)
                    .addComponent(jlb_municipality))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_municipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_neighborhood)
                    .addComponent(jlb_address)
                    .addComponent(txt_neighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_cadastralRef)
                    .addComponent(txt_cadastralReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_publication)
                    .addComponent(cbo_publication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_crossing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlb_affectation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jscp_info.setViewportView(jPanel2);

        btn_register.setBackground(new java.awt.Color(64, 145, 108));
        btn_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register.setText("AGREGAR BENEFICIARIO");
        btn_register.setEnabled(false);
        btn_register.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlb_code.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_code.setForeground(new java.awt.Color(33, 37, 41));
        jlb_code.setText("Codigo:");

        txt_followingCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(859, Short.MAX_VALUE)
                        .addComponent(jlb_code)
                        .addGap(0, 0, 0)
                        .addComponent(txt_followingCode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_title))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jscp_info, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jlb_title)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_code)
                    .addComponent(txt_followingCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscp_info, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Updates the panel text according to the selected language.
     *
     * @param texts DTO with the translated text
     */
    public void updateLanguage(DTORegisterBeneficiaryText texts) {
        jlb_title.setText(texts.getAddTitle());
        jlb_beneficiaryInfo.setText(texts.getBeneficiaryInfo());
        jlb_fullName.setText(texts.getFullName());
        jlb_phone.setText(texts.getPhone());
        jlb_id.setText(texts.getId());
        jlb_maritalStatus.setText(texts.getMaritalStatus());
        jlb_residenceData.setText(texts.getResidenceData());
        jlb_department.setText(texts.getDepartment());
        jlb_municipality.setText(texts.getMunicipality());
        jlb_neighborhood.setText(texts.getNeighborhood());
        jlb_address.setText(texts.getAddress());
        jlb_cadastralRef.setText(texts.getCadastralRef());
        jlb_crossing.setText(texts.getCrossing());
        jlb_affectation.setText(texts.getAffectation());
        jlb_expeditionLocation.setText(texts.getExpeditionLocation());
        jlb_publication.setText(texts.getPublication());
        jlb_code.setText(texts.getCode());
        btn_register.setText(texts.getRegisterBtn());
        btn_addBeneficiaries.setText(texts.getAddBeneficiaryBtn());
        setBtnModifyText(texts.getModifyBtn());
        setJlbTitleModify(texts.getModifyTitle());
    }

    public void setControllerRegister(ActionListener action) {
        btn_register.addActionListener(action);
    }

    public void setControllerAddBeneficiaries(ActionListener action) {
        btn_addBeneficiaries.addActionListener(action);
    }

    public void setControllerCbo_department(ActionListener action) {
        cbo_department.addActionListener(action);
    }

    public void setControllerCbo_maritalStatus(ActionListener action) {
        cbo_maritalStatus.addActionListener(action);
    }

    public ButtonAction getBtn_register() {
        return btn_register;
    }

    public ButtonAction getBtn_addBeneficiaries() {
        return btn_addBeneficiaries;
    }

    public JCheckBox getCbx_affectation() {
        return new JCheckBox();
    }

    public JComboBox<Department> getCbo_department() {
        return cbo_department;
    }

    public JComboBox<MaritalStatus> getCbo_maritalStatus() {
        return cbo_maritalStatus;
    }

    public JComboBox<Municipalities> getCbo_municipality() {
        return cbo_municipality;
    }

    public JScrollPane getJscp_info() {
        return jscp_info;
    }

    public JTextArea getTxa_affectation() {
        return txa_affectation;
    }

    public JTextArea getTxa_crossing() {
        return txa_crossing;
    }

    public JTextField getTxt_address() {
        return txt_address;
    }

    public JTextField getTxt_cadastralReference() {
        return txt_cadastralReference;
    }

    public JTextField getTxt_expeditionLocation() {
        return txt_expeditionLocation;
    }

    public JTextField getTxt_followingCode() {
        return txt_followingCode;
    }

    public JTextField getTxt_neighborhood() {
        return txt_neighborhood;
    }

    public JTextField getTxt_id() {
        return txt_id;
    }

    public JTextField getTxt_fullName() {
        return txt_fullName;
    }

    public JTextField getTxt_phone() {
        return txt_phone;
    }

    public JComboBox<String> getCbo_publication() {
        return cbo_publication;
    }

    public void loadFollowingCode(int code) {
        txt_followingCode.setText(String.valueOf(code));
    }

    public boolean isLoading = false;

    /**
     * Check if the panel is currently loading data.
     *
     * @return {@code true} if loading, {@code false} otherwise
     */
    public boolean isLoading() {
        return isLoading;
    }

    /**
     * Load the beneficiary data for modification.
     *
     * @param dtoBeneficiary detailed beneficiary data
     */
    public void loadDataModify(DTOBeneficiaryDetails dtoBeneficiary, DTOPropertySimpleDetails dtoProperty) {
        isLoading = true;
        txt_followingCode.setText(dtoBeneficiary.getCodeBeneficiaries());

        txt_fullName.setText(dtoBeneficiary.getFullName());
        txt_id.setText(String.valueOf(dtoBeneficiary.getId()));
        txt_phone.setText(String.valueOf(dtoBeneficiary.getPhone()));
        cbo_maritalStatus.setSelectedItem(dtoBeneficiary.getMaritalStatus());
        txt_expeditionLocation.setText(dtoBeneficiary.getExpeditionLocation());
        txa_affectation.setText(dtoBeneficiary.getAffectation());
        txt_cadastralReference.setText(dtoBeneficiary.getCadastralRef());

        cbo_department.setSelectedItem(dtoProperty.getDepartment());
        cbo_municipality.setSelectedItem(dtoProperty.getMunicipality());
        txt_neighborhood.setText(dtoProperty.getNeighborhood());
        txt_address.setText(dtoProperty.getAddress());
        txa_crossing.setText(dtoProperty.getCrossing());
        cbo_publication.setSelectedItem(dtoProperty.getPublication());
        
        jlb_title.setText(getJlbTitleModify());
        btn_register.setText(getBtnModifyText());

        isLoading = false;
    }

    /**
     * Resets fields to editable mode after a modification.
     */
    public void resetUI() {
        txt_fullName.setEditable(true);
        txt_id.setEditable(true);
        txt_cadastralReference.setEditable(true);
        txt_expeditionLocation.setEditable(true);
        txa_affectation.setEditable(false);
    }
    
    /**
     * Clear all fields and reset the form to registration mode.
     */
    public void clearFields() {
        txt_followingCode.setText("");
        jlb_title.setText(LanguageManager.getInstance().app("register.beneficiary.add.title"));
        btn_register.setText(LanguageManager.getInstance().app("register.beneficiary.register.btn"));
        txt_fullName.setText("");
        txt_id.setText("");
        txt_phone.setText("");
        txt_expeditionLocation.setText("");
        txt_neighborhood.setText("");
        txt_address.setText("");
        txt_cadastralReference.setText("");
        cbo_publication.setSelectedIndex(0);
        txa_crossing.setText("");
        txa_affectation.setText("");
        cbo_department.setSelectedIndex(0);
        cbo_maritalStatus.setSelectedIndex(0);
        cbo_municipality.setSelectedIndex(0);
        this.modifyCode = 0;

        resetUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_addBeneficiaries;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_register;
    private javax.swing.JComboBox<Department> cbo_department;
    private javax.swing.JComboBox<MaritalStatus> cbo_maritalStatus;
    private javax.swing.JComboBox<Municipalities> cbo_municipality;
    private javax.swing.JComboBox<String> cbo_publication;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_address;
    private javax.swing.JLabel jlb_affectation;
    private javax.swing.JLabel jlb_beneficiaryInfo;
    private javax.swing.JLabel jlb_cadastralRef;
    private javax.swing.JLabel jlb_code;
    private javax.swing.JLabel jlb_crossing;
    private javax.swing.JLabel jlb_department;
    private javax.swing.JLabel jlb_expeditionLocation;
    private javax.swing.JLabel jlb_fullName;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JLabel jlb_maritalStatus;
    private javax.swing.JLabel jlb_municipality;
    private javax.swing.JLabel jlb_neighborhood;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JLabel jlb_publication;
    private javax.swing.JLabel jlb_residenceData;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JScrollPane jscp_info;
    private javax.swing.JTextArea txa_affectation;
    private javax.swing.JTextArea txa_crossing;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_cadastralReference;
    private javax.swing.JTextField txt_expeditionLocation;
    private javax.swing.JTextField txt_followingCode;
    private javax.swing.JTextField txt_fullName;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_neighborhood;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
