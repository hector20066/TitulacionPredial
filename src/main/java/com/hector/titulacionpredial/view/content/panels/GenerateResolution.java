package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOGenerateResolutionText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

/**
 * Form for generating title resolutions.
 *
 * <p>
 * Presents a summary with the beneficiary's data, property
 * details, and coordinates (read-only) along with editable
 * fields for: resolution number, notification, enforcement,
 * FMI, minutes,public deed, and observations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class GenerateResolution extends javax.swing.JPanel {

    /**
     * Create the resolution generation form.
     */
    public GenerateResolution() {
        initComponents();
        
        scroll1.getVerticalScrollBar().setUnitIncrement(15);
        scroll2.getVerticalScrollBar().setUnitIncrement(15);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jlb_resume = new javax.swing.JLabel();
        scroll2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jlb_beneficiaryData = new javax.swing.JLabel();
        jlb_names = new javax.swing.JLabel();
        txt_nameBeneficiary = new javax.swing.JTextField();
        jlb_id = new javax.swing.JLabel();
        txt_idBeneficiary = new javax.swing.JTextField();
        jlb_address = new javax.swing.JLabel();
        txt_addressBeneficiary = new javax.swing.JTextField();
        jlb_cadastralRef = new javax.swing.JLabel();
        txt_cadastralReference = new javax.swing.JTextField();
        jlb_municipality = new javax.swing.JLabel();
        txt_municipality = new javax.swing.JTextField();
        jlb_propertyInfo = new javax.swing.JLabel();
        jlb_point1 = new javax.swing.JLabel();
        jlb_north1 = new javax.swing.JLabel();
        txt_northCoordinate1 = new javax.swing.JTextField();
        jlb_east1 = new javax.swing.JLabel();
        txt_eastCoordinate1 = new javax.swing.JTextField();
        jlb_distance1 = new javax.swing.JLabel();
        txt_distance1 = new javax.swing.JTextField();
        jlb_hillside1 = new javax.swing.JLabel();
        txt_hillside1 = new javax.swing.JTextField();
        jlb_point2 = new javax.swing.JLabel();
        jlb_north2 = new javax.swing.JLabel();
        txt_northCoordinate2 = new javax.swing.JTextField();
        jlb_east2 = new javax.swing.JLabel();
        txt_eastCoordinate2 = new javax.swing.JTextField();
        jlb_distance2 = new javax.swing.JLabel();
        txt_distance2 = new javax.swing.JTextField();
        jlb_hillside2 = new javax.swing.JLabel();
        txt_hillside2 = new javax.swing.JTextField();
        jlb_point3 = new javax.swing.JLabel();
        jlb_north3 = new javax.swing.JLabel();
        txt_northCoordinate3 = new javax.swing.JTextField();
        jlb_east3 = new javax.swing.JLabel();
        txt_eastCoordinate3 = new javax.swing.JTextField();
        jlb_distance3 = new javax.swing.JLabel();
        txt_distance3 = new javax.swing.JTextField();
        jlb_hillside3 = new javax.swing.JLabel();
        txt_hillside3 = new javax.swing.JTextField();
        jlb_point4 = new javax.swing.JLabel();
        jlb_north4 = new javax.swing.JLabel();
        txt_northCoordinate4 = new javax.swing.JTextField();
        jlb_east4 = new javax.swing.JLabel();
        txt_eastCoordinate4 = new javax.swing.JTextField();
        jlb_distance4 = new javax.swing.JLabel();
        txt_distance4 = new javax.swing.JTextField();
        jlb_hillside4 = new javax.swing.JLabel();
        txt_hillside4 = new javax.swing.JTextField();
        jlb_propertyCode = new javax.swing.JLabel();
        txt_propertyCode = new javax.swing.JTextField();
        jlb_area = new javax.swing.JLabel();
        txt_area = new javax.swing.JTextField();
        jlb_enterInfo = new javax.swing.JLabel();
        jlb_numResolution = new javax.swing.JLabel();
        txt_numResolution = new javax.swing.JTextField();
        jlb_notification = new javax.swing.JLabel();
        jlb_executory = new javax.swing.JLabel();
        jlb_fmi = new javax.swing.JLabel();
        txt_fmi = new javax.swing.JTextField();
        jlb_act = new javax.swing.JLabel();
        txt_act = new javax.swing.JTextField();
        jlb_publicWriting = new javax.swing.JLabel();
        txt_publicWriting = new javax.swing.JTextField();
        jlb_notary = new javax.swing.JLabel();
        txt_note = new javax.swing.JTextField();
        ftx_notification = new javax.swing.JFormattedTextField();
        ftx_executory = new javax.swing.JFormattedTextField();
        jlb_title = new javax.swing.JLabel();
        btn_generate = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scroll1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlb_resume.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_resume.setForeground(new java.awt.Color(33, 37, 41));
        jlb_resume.setText("Resumen de la resolucion");

        scroll2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlb_beneficiaryData.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_beneficiaryData.setForeground(new java.awt.Color(33, 37, 41));
        jlb_beneficiaryData.setText("Datos del Beneficiario");

        jlb_names.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_names.setForeground(new java.awt.Color(33, 37, 41));
        jlb_names.setText("Nombre(s):");

        txt_nameBeneficiary.setEditable(false);
        txt_nameBeneficiary.setBackground(new java.awt.Color(255, 255, 255));
        txt_nameBeneficiary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_nameBeneficiary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_id.setForeground(new java.awt.Color(33, 37, 41));
        jlb_id.setText("Cedula:");

        txt_idBeneficiary.setEditable(false);
        txt_idBeneficiary.setBackground(new java.awt.Color(255, 255, 255));
        txt_idBeneficiary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_idBeneficiary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_address.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_address.setForeground(new java.awt.Color(33, 37, 41));
        jlb_address.setText("Direccion:");

        txt_addressBeneficiary.setEditable(false);
        txt_addressBeneficiary.setBackground(new java.awt.Color(255, 255, 255));
        txt_addressBeneficiary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_addressBeneficiary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_cadastralRef.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_cadastralRef.setForeground(new java.awt.Color(33, 37, 41));
        jlb_cadastralRef.setText("Ref. Catastral:");

        txt_cadastralReference.setEditable(false);
        txt_cadastralReference.setBackground(new java.awt.Color(255, 255, 255));
        txt_cadastralReference.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_cadastralReference.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_municipality.setForeground(new java.awt.Color(33, 37, 41));
        jlb_municipality.setText("Municipio:");

        txt_municipality.setEditable(false);
        txt_municipality.setBackground(new java.awt.Color(255, 255, 255));
        txt_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_municipality.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_propertyInfo.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_propertyInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_propertyInfo.setText("Informacion del Predio");

        jlb_point1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jlb_point1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point1.setText("Punto 1");

        jlb_north1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north1.setText("Coordenada Norte:");

        txt_northCoordinate1.setEditable(false);
        txt_northCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east1.setText("Coordenada Este");

        txt_eastCoordinate1.setEditable(false);
        txt_eastCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance1.setText("Distancia");

        txt_distance1.setEditable(false);
        txt_distance1.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside1.setText("Colindero");

        txt_hillside1.setEditable(false);
        txt_hillside1.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_point2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jlb_point2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point2.setText("Punto 2");

        jlb_north2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north2.setText("Coordenada Norte:");

        txt_northCoordinate2.setEditable(false);
        txt_northCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east2.setText("Coordenada Este");

        txt_eastCoordinate2.setEditable(false);
        txt_eastCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance2.setText("Distancia");

        txt_distance2.setEditable(false);
        txt_distance2.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside2.setText("Colindero");

        txt_hillside2.setEditable(false);
        txt_hillside2.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_point3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jlb_point3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point3.setText("Punto 3");

        jlb_north3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north3.setText("Coordenada Norte:");

        txt_northCoordinate3.setEditable(false);
        txt_northCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east3.setText("Coordenada Este");

        txt_eastCoordinate3.setEditable(false);
        txt_eastCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance3.setText("Distancia");

        txt_distance3.setEditable(false);
        txt_distance3.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside3.setText("Colindero");

        txt_hillside3.setEditable(false);
        txt_hillside3.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_point4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jlb_point4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point4.setText("Punto 4");

        jlb_north4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north4.setText("Coordenada Norte:");

        txt_northCoordinate4.setEditable(false);
        txt_northCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east4.setText("Coordenada Este");

        txt_eastCoordinate4.setEditable(false);
        txt_eastCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance4.setText("Distancia");

        txt_distance4.setEditable(false);
        txt_distance4.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside4.setText("Colindero");

        txt_hillside4.setEditable(false);
        txt_hillside4.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_propertyCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_propertyCode.setForeground(new java.awt.Color(33, 37, 41));
        jlb_propertyCode.setText("Codigo de la propiedad:");

        txt_propertyCode.setEditable(false);
        txt_propertyCode.setBackground(new java.awt.Color(255, 255, 255));
        txt_propertyCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_propertyCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_area.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_area.setForeground(new java.awt.Color(33, 37, 41));
        jlb_area.setText("Area:");

        txt_area.setEditable(false);
        txt_area.setBackground(new java.awt.Color(255, 255, 255));
        txt_area.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_area.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_beneficiaryData))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_point1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_north1)
                                            .addComponent(jlb_east1)
                                            .addComponent(jlb_distance1)
                                            .addComponent(jlb_hillside1)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_northCoordinate1)
                                                    .addComponent(txt_eastCoordinate1)
                                                    .addComponent(txt_distance1)
                                                    .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlb_point3)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlb_north3)
                                                .addComponent(jlb_east3)
                                                .addComponent(jlb_hillside3)
                                                .addComponent(jlb_distance3)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txt_northCoordinate3)
                                                        .addComponent(txt_eastCoordinate3)
                                                        .addComponent(txt_distance3)
                                                        .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_point2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_north2)
                                            .addComponent(jlb_east2)
                                            .addComponent(jlb_hillside2)
                                            .addComponent(jlb_distance2)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_northCoordinate2)
                                                    .addComponent(txt_eastCoordinate2)
                                                    .addComponent(txt_distance2)
                                                    .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlb_point4)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlb_north4)
                                                .addComponent(jlb_east4)
                                                .addComponent(jlb_hillside4)
                                                .addComponent(jlb_distance4)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txt_northCoordinate4)
                                                        .addComponent(txt_eastCoordinate4)
                                                        .addComponent(txt_distance4)
                                                        .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGap(91, 91, 91))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jlb_id)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_idBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jlb_address)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_addressBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jlb_names)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_nameBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jlb_municipality)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_municipality, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jlb_cadastralRef)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cadastralReference, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(42, 42, 42))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_propertyInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jlb_area)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlb_propertyCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_propertyCode, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_beneficiaryData)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_names)
                    .addComponent(txt_nameBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_id)
                    .addComponent(txt_idBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_address)
                    .addComponent(txt_addressBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_municipality)
                    .addComponent(txt_municipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_cadastralRef)
                    .addComponent(txt_cadastralReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlb_propertyInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_area))
                        .addGap(29, 29, 29)
                        .addComponent(jlb_point1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_north1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_east1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_distance1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_hillside1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_propertyCode)
                            .addComponent(txt_propertyCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jlb_point2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_north2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_east2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_distance2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_hillside2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jlb_point3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_north3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_east3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_distance3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_hillside3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jlb_point4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_north4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_east4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_distance4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlb_hillside4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        scroll2.setViewportView(jPanel3);

        jlb_enterInfo.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_enterInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_enterInfo.setText("Ingrese la siguiente informacion:");

        jlb_numResolution.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_numResolution.setForeground(new java.awt.Color(33, 37, 41));
        jlb_numResolution.setText("N. Resolucion:");

        txt_numResolution.setBackground(new java.awt.Color(255, 255, 255));
        txt_numResolution.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_numResolution.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_notification.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_notification.setForeground(new java.awt.Color(33, 37, 41));
        jlb_notification.setText("Notificacion:");

        jlb_executory.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_executory.setForeground(new java.awt.Color(33, 37, 41));
        jlb_executory.setText("Ejecutoria:");

        jlb_fmi.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_fmi.setForeground(new java.awt.Color(33, 37, 41));
        jlb_fmi.setText("FMI:");

        txt_fmi.setBackground(new java.awt.Color(255, 255, 255));
        txt_fmi.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_fmi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_act.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_act.setForeground(new java.awt.Color(33, 37, 41));
        jlb_act.setText("Acto:");

        txt_act.setBackground(new java.awt.Color(255, 255, 255));
        txt_act.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_act.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_publicWriting.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_publicWriting.setForeground(new java.awt.Color(33, 37, 41));
        jlb_publicWriting.setText("Esc. Publica:");

        txt_publicWriting.setBackground(new java.awt.Color(255, 255, 255));
        txt_publicWriting.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_publicWriting.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_notary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_notary.setForeground(new java.awt.Color(33, 37, 41));
        jlb_notary.setText("Notaria:");

        txt_note.setBackground(new java.awt.Color(255, 255, 255));
        txt_note.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_note.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        ftx_notification.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG))));

        ftx_executory.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_enterInfo)
                            .addComponent(jlb_resume)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_act)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlb_fmi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fmi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlb_numResolution)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_numResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jlb_notification)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftx_notification, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jlb_executory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftx_executory, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlb_publicWriting)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_act, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_publicWriting, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlb_notary)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_note, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_resume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_enterInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_numResolution)
                    .addComponent(txt_numResolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_notification)
                    .addComponent(jlb_executory)
                    .addComponent(ftx_notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftx_executory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_fmi)
                    .addComponent(txt_fmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jlb_act)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jlb_publicWriting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_publicWriting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_notary)
                    .addComponent(txt_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        scroll1.setViewportView(jPanel2);

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Generar Resolucion");

        btn_generate.setBackground(new java.awt.Color(64, 145, 108));
        btn_generate.setForeground(new java.awt.Color(255, 255, 255));
        btn_generate.setText("Generar");
        btn_generate.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_generate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlb_title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
     * Updates the panel text according to the selected language.
     *
     * @param texts DTO with the translated text
     */
    public void updateLanguage(DTOGenerateResolutionText texts) {
        jlb_title.setText(texts.getGenerateLabel());
        jlb_resume.setText(texts.getResumeTitle());
        jlb_beneficiaryData.setText(texts.getBeneficiaryData());
        jlb_names.setText(texts.getNames());
        jlb_id.setText(texts.getId());
        jlb_address.setText(texts.getAddress());
        jlb_cadastralRef.setText(texts.getCadastralRef());
        jlb_municipality.setText(texts.getMunicipality());
        jlb_propertyInfo.setText(texts.getPropertyInfo());
        jlb_point1.setText(texts.getPoint() + " 1");
        jlb_point2.setText(texts.getPoint() + " 2");
        jlb_point3.setText(texts.getPoint() + " 3");
        jlb_point4.setText(texts.getPoint() + " 4");
        jlb_north1.setText(texts.getNorthCord());
        jlb_north2.setText(texts.getNorthCord());
        jlb_north3.setText(texts.getNorthCord());
        jlb_north4.setText(texts.getNorthCord());
        jlb_east1.setText(texts.getEastCord());
        jlb_east2.setText(texts.getEastCord());
        jlb_east3.setText(texts.getEastCord());
        jlb_east4.setText(texts.getEastCord());
        jlb_distance1.setText(texts.getDistance());
        jlb_distance2.setText(texts.getDistance());
        jlb_distance3.setText(texts.getDistance());
        jlb_distance4.setText(texts.getDistance());
        jlb_hillside1.setText(texts.getHillside());
        jlb_hillside2.setText(texts.getHillside());
        jlb_hillside3.setText(texts.getHillside());
        jlb_hillside4.setText(texts.getHillside());
        jlb_propertyCode.setText(texts.getPropertyCode());
        jlb_area.setText(texts.getArea());
        jlb_enterInfo.setText(texts.getEnterInfo());
        jlb_numResolution.setText(texts.getNumResolution());
        jlb_notification.setText(texts.getNotification());
        jlb_executory.setText(texts.getExecutory());
        jlb_fmi.setText(texts.getFmi());
        jlb_act.setText(texts.getAct());
        jlb_publicWriting.setText(texts.getPublicWriting());
        jlb_notary.setText(texts.getNotary());
        btn_generate.setText(texts.getGenerateBtn());
    }

    public void setControllerGenerate(ActionListener action) {
        btn_generate.addActionListener(action);
    }

    public ButtonAction getBtn_generate() {
        return btn_generate;
    }

    public JTextField getTxt_act() {
        return txt_act;
    }

    public JFormattedTextField getFtx_executory() {
        return ftx_executory;
    }

    public JFormattedTextField getFtx_notification() {
        return ftx_notification;
    }

    public JTextField getTxt_propertyCode() {
        return txt_propertyCode;
    }

    public JTextField getTxt_area() {
        return txt_area;
    }

    public JTextField getTxt_addressBeneficiary() {
        return txt_addressBeneficiary;
    }

    public JTextField getTxt_cadastralReference() {
        return txt_cadastralReference;
    }

    public JTextField getTxt_distance1() {
        return txt_distance1;
    }

    public JTextField getTxt_distance2() {
        return txt_distance2;
    }

    public JTextField getTxt_distance3() {
        return txt_distance3;
    }

    public JTextField getTxt_distance4() {
        return txt_distance4;
    }

    public JTextField getTxt_eastCoordinate1() {
        return txt_eastCoordinate1;
    }

    public JTextField getTxt_eastCoordinate2() {
        return txt_eastCoordinate2;
    }

    public JTextField getTxt_eastCoordinate3() {
        return txt_eastCoordinate3;
    }

    public JTextField getTxt_eastCoordinate4() {
        return txt_eastCoordinate4;
    }

    public JTextField getTxt_fmi() {
        return txt_fmi;
    }

    public JTextField getTxt_hillside1() {
        return txt_hillside1;
    }

    public JTextField getTxt_hillside2() {
        return txt_hillside2;
    }

    public JTextField getTxt_hillside3() {
        return txt_hillside3;
    }

    public JTextField getTxt_hillside4() {
        return txt_hillside4;
    }

    public JTextField getTxt_idBeneficiary() {
        return txt_idBeneficiary;
    }

    public JTextField getTxt_nameBeneficiary() {
        return txt_nameBeneficiary;
    }

    public JTextField getTxt_municipality() {
        return txt_municipality;
    }

    public JTextField getTxt_northCoordinate1() {
        return txt_northCoordinate1;
    }

    public JTextField getTxt_northCoordinate2() {
        return txt_northCoordinate2;
    }

    public JTextField getTxt_northCoordinate3() {
        return txt_northCoordinate3;
    }

    public JTextField getTxt_northCoordinate4() {
        return txt_northCoordinate4;
    }

    public JTextField getTxt_note() {
        return txt_note;
    }

    public JTextField getTxt_numResolution() {
        return txt_numResolution;
    }

    public JTextField getTxt_publicWriting() {
        return txt_publicWriting;
    }

    /**
     * Load the property and beneficiary data into the form fields.
     *
     @param area            Property area
     @param point1          Coordinates of point 1 (north, east, distance, slope)
     @param point2          Coordinates of point 2
     @param point3          Coordinates of point 3
     @param point4          Coordinates of point 4
     @param codeBeneficiaries     Property code
     @param dtoBeneficiary  Beneficiary data
     @param beneficiariesId Beneficiary ID numbers
     */
    public void loadData(double area, String[] point1, String[] point2, String[] point3, String[] point4, String codeBeneficiaries, DTOBeneficiarySimpleDetails dtoBeneficiary, String beneficiariesId) {
        BiConsumer<String, DTOBeneficiarySimpleDetails> consumer = (codeProperty, beneficiary) -> {
            txt_nameBeneficiary.setText(beneficiary.getFullName());
            txt_idBeneficiary.setText(beneficiariesId);
            txt_addressBeneficiary.setText(beneficiary.getAddress());
            txt_municipality.setText(beneficiary.getMunicipalities().getValue());
            txt_cadastralReference.setText(String.valueOf(beneficiary.getCadastralReference()));

            txt_propertyCode.setText(codeProperty);

            txt_northCoordinate1.setText(point1[0]);
            txt_eastCoordinate1.setText(point1[1]);
            txt_distance1.setText(point1[2]);
            txt_hillside1.setText(point1[3]);

            txt_northCoordinate2.setText(point2[0]);
            txt_eastCoordinate2.setText(point2[1]);
            txt_distance2.setText(point2[2]);
            txt_hillside2.setText(point2[3]);

            txt_northCoordinate3.setText(point3[0]);
            txt_eastCoordinate3.setText(point3[1]);
            txt_distance3.setText(point3[2]);
            txt_hillside3.setText(point3[3]);

            txt_northCoordinate4.setText(point4[0]);
            txt_eastCoordinate4.setText(point4[1]);
            txt_distance4.setText(point4[2]);
            txt_hillside4.setText(point4[3]);
            
            txt_area.setText(String.valueOf(area));
        };

        consumer.accept(codeBeneficiaries, dtoBeneficiary);
    }

    /**
     * Clear the editable fields of the resolution form.
     */
    public void clearFields() {
        txt_numResolution.setText("");
        ftx_executory.setText("");
        ftx_notification.setText("");
        txt_fmi.setText("");
        txt_act.setText("");
        txt_publicWriting.setText("");
        txt_note.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_generate;
    private javax.swing.JFormattedTextField ftx_executory;
    private javax.swing.JFormattedTextField ftx_notification;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlb_act;
    private javax.swing.JLabel jlb_address;
    private javax.swing.JLabel jlb_area;
    private javax.swing.JLabel jlb_beneficiaryData;
    private javax.swing.JLabel jlb_cadastralRef;
    private javax.swing.JLabel jlb_distance1;
    private javax.swing.JLabel jlb_distance2;
    private javax.swing.JLabel jlb_distance3;
    private javax.swing.JLabel jlb_distance4;
    private javax.swing.JLabel jlb_east1;
    private javax.swing.JLabel jlb_east2;
    private javax.swing.JLabel jlb_east3;
    private javax.swing.JLabel jlb_east4;
    private javax.swing.JLabel jlb_enterInfo;
    private javax.swing.JLabel jlb_executory;
    private javax.swing.JLabel jlb_fmi;
    private javax.swing.JLabel jlb_hillside1;
    private javax.swing.JLabel jlb_hillside2;
    private javax.swing.JLabel jlb_hillside3;
    private javax.swing.JLabel jlb_hillside4;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JLabel jlb_municipality;
    private javax.swing.JLabel jlb_names;
    private javax.swing.JLabel jlb_north1;
    private javax.swing.JLabel jlb_north2;
    private javax.swing.JLabel jlb_north3;
    private javax.swing.JLabel jlb_north4;
    private javax.swing.JLabel jlb_notary;
    private javax.swing.JLabel jlb_notification;
    private javax.swing.JLabel jlb_numResolution;
    private javax.swing.JLabel jlb_point1;
    private javax.swing.JLabel jlb_point2;
    private javax.swing.JLabel jlb_point3;
    private javax.swing.JLabel jlb_point4;
    private javax.swing.JLabel jlb_propertyCode;
    private javax.swing.JLabel jlb_propertyInfo;
    private javax.swing.JLabel jlb_publicWriting;
    private javax.swing.JLabel jlb_resume;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JTextField txt_act;
    private javax.swing.JTextField txt_addressBeneficiary;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_cadastralReference;
    private javax.swing.JTextField txt_distance1;
    private javax.swing.JTextField txt_distance2;
    private javax.swing.JTextField txt_distance3;
    private javax.swing.JTextField txt_distance4;
    private javax.swing.JTextField txt_eastCoordinate1;
    private javax.swing.JTextField txt_eastCoordinate2;
    private javax.swing.JTextField txt_eastCoordinate3;
    private javax.swing.JTextField txt_eastCoordinate4;
    private javax.swing.JTextField txt_fmi;
    private javax.swing.JTextField txt_hillside1;
    private javax.swing.JTextField txt_hillside2;
    private javax.swing.JTextField txt_hillside3;
    private javax.swing.JTextField txt_hillside4;
    private javax.swing.JTextField txt_idBeneficiary;
    private javax.swing.JTextField txt_municipality;
    private javax.swing.JTextField txt_nameBeneficiary;
    private javax.swing.JTextField txt_northCoordinate1;
    private javax.swing.JTextField txt_northCoordinate2;
    private javax.swing.JTextField txt_northCoordinate3;
    private javax.swing.JTextField txt_northCoordinate4;
    private javax.swing.JTextField txt_note;
    private javax.swing.JTextField txt_numResolution;
    private javax.swing.JTextField txt_propertyCode;
    private javax.swing.JTextField txt_publicWriting;
    // End of variables declaration//GEN-END:variables
}
