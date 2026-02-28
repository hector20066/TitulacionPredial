package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

/**
 * Formulario para la generación de resoluciones de titulación.
 *
 * <p>
 * Presenta un resumen con los datos del beneficiario, predio
 * y coordenadas (solo lectura) junto con campos editables para
 * número de resolución, notificación, ejecutoria, FMI, acta,
 * escritura pública y observaciones.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class GenerateResolution extends javax.swing.JPanel {

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
        jLabel2 = new javax.swing.JLabel();
        scroll2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nameBeneficiary = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_idBeneficiary = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_addressBeneficiary = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_cadastralReference = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_municipality = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_northCoordinate1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_eastCoordinate1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_distance1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_hillside1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_northCoordinate2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_eastCoordinate2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_distance2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_hillside2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_northCoordinate3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_eastCoordinate3 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_distance3 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_hillside3 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_northCoordinate4 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_eastCoordinate4 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_distance4 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_hillside4 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txt_propertyCode = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_area = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_numResolution = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_fmi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_act = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_publicWriting = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_note = new javax.swing.JTextField();
        ftx_notification = new javax.swing.JFormattedTextField();
        ftx_executory = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_generate = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scroll1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 37, 41));
        jLabel2.setText("Resumen de la resolucion");

        scroll2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(33, 37, 41));
        jLabel11.setText("Datos del Beneficiario");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(33, 37, 41));
        jLabel12.setText("Nombre(s):");

        txt_nameBeneficiary.setEditable(false);
        txt_nameBeneficiary.setBackground(new java.awt.Color(255, 255, 255));
        txt_nameBeneficiary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_nameBeneficiary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(33, 37, 41));
        jLabel13.setText("Cedula:");

        txt_idBeneficiary.setEditable(false);
        txt_idBeneficiary.setBackground(new java.awt.Color(255, 255, 255));
        txt_idBeneficiary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_idBeneficiary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 37, 41));
        jLabel14.setText("Direccion:");

        txt_addressBeneficiary.setEditable(false);
        txt_addressBeneficiary.setBackground(new java.awt.Color(255, 255, 255));
        txt_addressBeneficiary.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_addressBeneficiary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(33, 37, 41));
        jLabel15.setText("Ref. Catastral:");

        txt_cadastralReference.setEditable(false);
        txt_cadastralReference.setBackground(new java.awt.Color(255, 255, 255));
        txt_cadastralReference.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_cadastralReference.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(33, 37, 41));
        jLabel16.setText("Municipio:");

        txt_municipality.setEditable(false);
        txt_municipality.setBackground(new java.awt.Color(255, 255, 255));
        txt_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_municipality.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel17.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(33, 37, 41));
        jLabel17.setText("Informacion del Predio");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(33, 37, 41));
        jLabel18.setText("Punto 1");

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(33, 37, 41));
        jLabel19.setText("Coordenada Norte:");

        txt_northCoordinate1.setEditable(false);
        txt_northCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 37, 41));
        jLabel20.setText("Coordenada Este");

        txt_eastCoordinate1.setEditable(false);
        txt_eastCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 37, 41));
        jLabel21.setText("Distancia");

        txt_distance1.setEditable(false);
        txt_distance1.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 37, 41));
        jLabel22.setText("Colindero");

        txt_hillside1.setEditable(false);
        txt_hillside1.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 37, 41));
        jLabel23.setText("Punto 2");

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(33, 37, 41));
        jLabel24.setText("Coordenada Norte:");

        txt_northCoordinate2.setEditable(false);
        txt_northCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(33, 37, 41));
        jLabel25.setText("Coordenada Este");

        txt_eastCoordinate2.setEditable(false);
        txt_eastCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(33, 37, 41));
        jLabel26.setText("Distancia");

        txt_distance2.setEditable(false);
        txt_distance2.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 37, 41));
        jLabel27.setText("Colindero");

        txt_hillside2.setEditable(false);
        txt_hillside2.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(33, 37, 41));
        jLabel28.setText("Punto 3");

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(33, 37, 41));
        jLabel29.setText("Coordenada Norte:");

        txt_northCoordinate3.setEditable(false);
        txt_northCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(33, 37, 41));
        jLabel30.setText("Coordenada Este");

        txt_eastCoordinate3.setEditable(false);
        txt_eastCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(33, 37, 41));
        jLabel31.setText("Distancia");

        txt_distance3.setEditable(false);
        txt_distance3.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(33, 37, 41));
        jLabel32.setText("Colindero");

        txt_hillside3.setEditable(false);
        txt_hillside3.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(33, 37, 41));
        jLabel33.setText("Punto 4");

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(33, 37, 41));
        jLabel34.setText("Coordenada Norte:");

        txt_northCoordinate4.setEditable(false);
        txt_northCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel35.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(33, 37, 41));
        jLabel35.setText("Coordenada Este");

        txt_eastCoordinate4.setEditable(false);
        txt_eastCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(33, 37, 41));
        jLabel36.setText("Distancia");

        txt_distance4.setEditable(false);
        txt_distance4.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel37.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(33, 37, 41));
        jLabel37.setText("Colindero");

        txt_hillside4.setEditable(false);
        txt_hillside4.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(33, 37, 41));
        jLabel38.setText("Codigo de la propiedad:");

        txt_propertyCode.setEditable(false);
        txt_propertyCode.setBackground(new java.awt.Color(255, 255, 255));
        txt_propertyCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_propertyCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(33, 37, 41));
        jLabel39.setText("Area:");

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
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_northCoordinate1)
                                                    .addComponent(txt_eastCoordinate1)
                                                    .addComponent(txt_distance1)
                                                    .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel29)
                                                .addComponent(jLabel30)
                                                .addComponent(jLabel32)
                                                .addComponent(jLabel31)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txt_northCoordinate3)
                                                        .addComponent(txt_eastCoordinate3)
                                                        .addComponent(txt_distance3)
                                                        .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel26)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_northCoordinate2)
                                                    .addComponent(txt_eastCoordinate2)
                                                    .addComponent(txt_distance2)
                                                    .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel33)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel34)
                                                .addComponent(jLabel35)
                                                .addComponent(jLabel37)
                                                .addComponent(jLabel36)
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
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_idBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_addressBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_nameBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_municipality, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cadastralReference, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(42, 42, 42))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_propertyCode, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_nameBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_idBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_addressBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_municipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_cadastralReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txt_propertyCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_northCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_eastCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        scroll2.setViewportView(jPanel3);

        jLabel3.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 37, 41));
        jLabel3.setText("Ingrese la siguiente informacion:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 37, 41));
        jLabel4.setText("N. Resolucion:");

        txt_numResolution.setBackground(new java.awt.Color(255, 255, 255));
        txt_numResolution.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_numResolution.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 37, 41));
        jLabel5.setText("Notificacion:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 37, 41));
        jLabel6.setText("Ejecutoria:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 37, 41));
        jLabel7.setText("FMI:");

        txt_fmi.setBackground(new java.awt.Color(255, 255, 255));
        txt_fmi.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_fmi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(33, 37, 41));
        jLabel8.setText("Acto:");

        txt_act.setBackground(new java.awt.Color(255, 255, 255));
        txt_act.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_act.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(33, 37, 41));
        jLabel9.setText("Esc. Publica:");

        txt_publicWriting.setBackground(new java.awt.Color(255, 255, 255));
        txt_publicWriting.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_publicWriting.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(33, 37, 41));
        jLabel10.setText("Notaria:");

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
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fmi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_numResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftx_notification, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftx_executory, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_act, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_publicWriting, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_note, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_numResolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(ftx_notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftx_executory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_fmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_publicWriting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        scroll1.setViewportView(jPanel2);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 28, 21));
        jLabel1.setText("Generar Resolucion");

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
                        .addComponent(jLabel1)
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
                .addComponent(jLabel1)
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

    public void loadData(double area, String[] point1, String[] point2, String[] point3, String[] point4, int dtoProperty, DTOBeneficiarySimpleDetails dtoBeneficiary, String beneficiariesId) {
        BiConsumer<Integer, DTOBeneficiarySimpleDetails> consumer = (codeProperty, beneficiary) -> {
            txt_nameBeneficiary.setText(beneficiary.getFullName());
            txt_idBeneficiary.setText(beneficiariesId);
            txt_addressBeneficiary.setText(beneficiary.getAddress());
            txt_municipality.setText(beneficiary.getMunicipality().getValue());
            txt_cadastralReference.setText(String.valueOf(beneficiary.getCadastralReference()));

            txt_propertyCode.setText(String.valueOf(codeProperty));

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

        consumer.accept(dtoProperty, dtoBeneficiary);
    }

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
