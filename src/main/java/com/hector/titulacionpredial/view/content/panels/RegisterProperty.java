package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterPropertyText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.button.ButtonBadges;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Form for registering properties with their geographic coordinates.
 *
 * <p>
 * Uses a {@code CardLayout} to organize the entry of up to 4 geographic
 * points (North, East, distance, and slope). Includes fields for
 * cadastral number, area, and associated beneficiary code.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class RegisterProperty extends javax.swing.JPanel {

    /**
     * Create the property registration form with 4 dot panels.
     */
    public RegisterProperty() {
        initComponents();
        
        jpl_contentPoints.add(jpl_point1, "point1");
        jpl_contentPoints.add(jpl_point2, "point2");
        jpl_contentPoints.add(jpl_point3, "point3");
        jpl_contentPoints.add(jpl_point4, "point4");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        jpl_contentPoints = new javax.swing.JPanel();
        jpl_point1 = new javax.swing.JPanel();
        jlb_point1 = new javax.swing.JLabel();
        btn_goPoint2 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jlb_north1 = new javax.swing.JLabel();
        txt_northCoordinate1 = new javax.swing.JTextField();
        jlb_east1 = new javax.swing.JLabel();
        txt_eastCoordinate1 = new javax.swing.JTextField();
        jlb_distance1 = new javax.swing.JLabel();
        txt_distance1 = new javax.swing.JTextField();
        jlb_hillside1 = new javax.swing.JLabel();
        txt_hillside1 = new javax.swing.JTextField();
        jpl_point2 = new javax.swing.JPanel();
        jlb_point2 = new javax.swing.JLabel();
        btn_goPoint3 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        btn_returnPoint1 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jlb_north2 = new javax.swing.JLabel();
        txt_northCoordinate2 = new javax.swing.JTextField();
        jlb_distance2 = new javax.swing.JLabel();
        txt_distance2 = new javax.swing.JTextField();
        jlb_hillside2 = new javax.swing.JLabel();
        txt_hillside2 = new javax.swing.JTextField();
        jlb_east2 = new javax.swing.JLabel();
        txt_eastCoordinate2 = new javax.swing.JTextField();
        jpl_point3 = new javax.swing.JPanel();
        jlb_point3 = new javax.swing.JLabel();
        btn_returnPoint2 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        btn_goPoint4 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jlb_north3 = new javax.swing.JLabel();
        txt_northCoordinate3 = new javax.swing.JTextField();
        jlb_distance3 = new javax.swing.JLabel();
        txt_distance3 = new javax.swing.JTextField();
        jlb_hillside3 = new javax.swing.JLabel();
        txt_hillside3 = new javax.swing.JTextField();
        jlb_east3 = new javax.swing.JLabel();
        txt_eastCoordinate3 = new javax.swing.JTextField();
        jpl_point4 = new javax.swing.JPanel();
        jlb_point4 = new javax.swing.JLabel();
        btn_returnPoint3 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jlb_north4 = new javax.swing.JLabel();
        txt_northCoordinate4 = new javax.swing.JTextField();
        jlb_distance4 = new javax.swing.JLabel();
        txt_distance4 = new javax.swing.JTextField();
        jlb_hillside4 = new javax.swing.JLabel();
        txt_hillside4 = new javax.swing.JTextField();
        jlb_east4 = new javax.swing.JLabel();
        txt_eastCoordinate4 = new javax.swing.JTextField();
        btn_register = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jlb_propertyInfo = new javax.swing.JLabel();
        jlb_cadastralId = new javax.swing.JLabel();
        txt_cadastralId = new javax.swing.JTextField();
        jlb_area = new javax.swing.JLabel();
        txt_area = new javax.swing.JTextField();
        jlb_pointInfo = new javax.swing.JLabel();
        jlb_beneficiaryCode = new javax.swing.JLabel();
        txt_beneficiaryCode = new javax.swing.JTextField();
        btn_searchBeneficiaries = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jLabel1 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        btn_importExcelData = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Registrar Predio");

        jpl_contentPoints.setBackground(new java.awt.Color(255, 255, 255));
        jpl_contentPoints.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(140, 183, 155), 1, true));
        jpl_contentPoints.setLayout(new java.awt.CardLayout());

        jpl_point1.setBackground(new java.awt.Color(255, 255, 255));

        jlb_point1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_point1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point1.setText("Punto 1");

        btn_goPoint2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/circle-chevron-right.png"))); // NOI18N

        jlb_north1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north1.setText("Coordenada Norte:");

        txt_northCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_east1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east1.setText("Coordenada Este:");

        txt_eastCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance1.setText("Distancia(m):");

        txt_distance1.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside1.setText("Lindero");

        txt_hillside1.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout jpl_point1Layout = new javax.swing.GroupLayout(jpl_point1);
        jpl_point1.setLayout(jpl_point1Layout);
        jpl_point1Layout.setHorizontalGroup(
            jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point1Layout.createSequentialGroup()
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_point1Layout.createSequentialGroup()
                        .addContainerGap(940, Short.MAX_VALUE)
                        .addComponent(btn_goPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpl_point1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_point1))
                    .addGroup(jpl_point1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point1Layout.createSequentialGroup()
                                .addComponent(jlb_distance1)
                                .addGap(222, 222, 222)
                                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_hillside1)
                                    .addGroup(jpl_point1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpl_point1Layout.createSequentialGroup()
                                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_north1)
                                    .addGroup(jpl_point1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_northCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_distance1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpl_point1Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(txt_eastCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpl_point1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jlb_east1)))))))
                .addContainerGap())
        );
        jpl_point1Layout.setVerticalGroup(
            jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_point1)
                .addGap(18, 18, 18)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_north1)
                    .addComponent(jlb_east1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_distance1)
                    .addComponent(jlb_hillside1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_distance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btn_goPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpl_contentPoints.add(jpl_point1, "card2");

        jpl_point2.setBackground(new java.awt.Color(255, 255, 255));

        jlb_point2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_point2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point2.setText("Punto 2");

        btn_goPoint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/circle-chevron-right.png"))); // NOI18N

        btn_returnPoint1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/circle-chevron-left.png"))); // NOI18N

        jlb_north2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north2.setText("Coordenada Norte:");

        txt_northCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance2.setText("Distancia(m):");

        txt_distance2.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside2.setText("Lindero:");

        txt_hillside2.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_east2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east2.setText("Coordenada Este:");

        txt_eastCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout jpl_point2Layout = new javax.swing.GroupLayout(jpl_point2);
        jpl_point2.setLayout(jpl_point2Layout);
        jpl_point2Layout.setHorizontalGroup(
            jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_point2Layout.createSequentialGroup()
                        .addComponent(jlb_point2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_point2Layout.createSequentialGroup()
                        .addComponent(btn_returnPoint1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_goPoint3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jpl_point2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_point2Layout.createSequentialGroup()
                        .addComponent(jlb_distance2)
                        .addGap(222, 222, 222)
                        .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_hillside2)
                            .addGroup(jpl_point2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpl_point2Layout.createSequentialGroup()
                        .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_north2)
                            .addGroup(jpl_point2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_northCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_distance2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(txt_eastCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpl_point2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jlb_east2)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jpl_point2Layout.setVerticalGroup(
            jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_point2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_north2)
                    .addComponent(jlb_east2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_distance2)
                    .addComponent(jlb_hillside2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_distance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_goPoint3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_returnPoint1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpl_contentPoints.add(jpl_point2, "card3");

        jpl_point3.setBackground(new java.awt.Color(255, 255, 255));

        jlb_point3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_point3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point3.setText("Punto 3");

        btn_returnPoint2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/circle-chevron-left.png"))); // NOI18N

        btn_goPoint4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/circle-chevron-right.png"))); // NOI18N

        jlb_north3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north3.setText("Coordenada Norte:");

        txt_northCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance3.setText("Distancia(m):");

        txt_distance3.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside3.setText("Lindero:");

        txt_hillside3.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_east3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east3.setText("Coordenada Este:");

        txt_eastCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout jpl_point3Layout = new javax.swing.GroupLayout(jpl_point3);
        jpl_point3.setLayout(jpl_point3Layout);
        jpl_point3Layout.setHorizontalGroup(
            jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_point3Layout.createSequentialGroup()
                        .addComponent(jlb_point3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpl_point3Layout.createSequentialGroup()
                        .addComponent(btn_returnPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_goPoint4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jpl_point3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_point3Layout.createSequentialGroup()
                        .addComponent(jlb_distance3)
                        .addGap(222, 222, 222)
                        .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_hillside3)
                            .addGroup(jpl_point3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpl_point3Layout.createSequentialGroup()
                        .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_north3)
                            .addGroup(jpl_point3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_northCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_distance3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point3Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(txt_eastCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpl_point3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jlb_east3)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jpl_point3Layout.setVerticalGroup(
            jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_point3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_point3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_north3)
                    .addComponent(jlb_east3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_distance3)
                    .addComponent(jlb_hillside3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_distance3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_goPoint4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_returnPoint2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpl_contentPoints.add(jpl_point3, "card4");

        jpl_point4.setBackground(new java.awt.Color(255, 255, 255));

        jlb_point4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_point4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_point4.setText("Punto 4");

        btn_returnPoint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/circle-chevron-left.png"))); // NOI18N

        jlb_north4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_north4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_north4.setText("Coordenada Norte:");

        txt_northCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance4.setText("Distancia(m):");

        txt_distance4.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside4.setText("Lindero:");

        txt_hillside4.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_east4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east4.setText("Coordenada Este:");

        txt_eastCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout jpl_point4Layout = new javax.swing.GroupLayout(jpl_point4);
        jpl_point4.setLayout(jpl_point4Layout);
        jpl_point4Layout.setHorizontalGroup(
            jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point4Layout.createSequentialGroup()
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_point4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_point4)
                            .addComponent(btn_returnPoint3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpl_point4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point4Layout.createSequentialGroup()
                                .addComponent(jlb_distance4)
                                .addGap(222, 222, 222)
                                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_hillside4)
                                    .addGroup(jpl_point4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpl_point4Layout.createSequentialGroup()
                                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_north4)
                                    .addGroup(jpl_point4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_northCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpl_point4Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(txt_eastCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpl_point4Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jlb_east4)))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jpl_point4Layout.setVerticalGroup(
            jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_point4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_north4)
                    .addComponent(jlb_east4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_distance4)
                    .addComponent(jlb_hillside4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btn_returnPoint3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpl_contentPoints.add(jpl_point4, "card5");

        btn_register.setBackground(new java.awt.Color(64, 145, 108));
        btn_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register.setText("REGISTRAR PREDIO");
        btn_register.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlb_propertyInfo.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_propertyInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_propertyInfo.setText("Informacion del Predio:");

        jlb_cadastralId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_cadastralId.setForeground(new java.awt.Color(33, 37, 41));
        jlb_cadastralId.setText("Cedula Catastral:");

        txt_cadastralId.setBackground(new java.awt.Color(255, 255, 255));
        txt_cadastralId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_area.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_area.setForeground(new java.awt.Color(33, 37, 41));
        jlb_area.setText("Area(m^2):");

        txt_area.setBackground(new java.awt.Color(255, 255, 255));
        txt_area.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_pointInfo.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_pointInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_pointInfo.setText("Informacion de los puntos:");

        jlb_beneficiaryCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_beneficiaryCode.setForeground(new java.awt.Color(33, 37, 41));
        jlb_beneficiaryCode.setText("Codigo del Beneficiario:");

        txt_beneficiaryCode.setBackground(new java.awt.Color(255, 255, 255));
        txt_beneficiaryCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        btn_searchBeneficiaries.setBackground(new java.awt.Color(149, 213, 178));
        btn_searchBeneficiaries.setForeground(new java.awt.Color(33, 37, 41));
        btn_searchBeneficiaries.setText("Buscar Beneficiario");
        btn_searchBeneficiaries.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_searchBeneficiaries.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Direccion:");

        btn_importExcelData.setBackground(new java.awt.Color(149, 213, 178));
        btn_importExcelData.setForeground(new java.awt.Color(0, 0, 0));
        btn_importExcelData.setText("Importar Datos de Excel");
        btn_importExcelData.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(47, Short.MAX_VALUE)
                        .addComponent(jpl_contentPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jlb_cadastralId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cadastralId, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113)
                                        .addComponent(jlb_area)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jlb_beneficiaryCode)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_beneficiaryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_searchBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_importExcelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlb_title))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_propertyInfo)
                                    .addComponent(jlb_pointInfo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addGap(18, 18, 18)
                .addComponent(jlb_propertyInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_cadastralId)
                    .addComponent(txt_cadastralId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_area)
                    .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_beneficiaryCode)
                    .addComponent(txt_beneficiaryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_importExcelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addComponent(jlb_pointInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpl_contentPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Updates the panel text according to the selected language.
     *
     * @param texts DTO with the translated text
     */
    public void updateLanguage(DTORegisterPropertyText texts) {
        jlb_title.setText(texts.getTitle());
        jlb_propertyInfo.setText(texts.getPropertyInfo());
        jlb_cadastralId.setText(texts.getCadastralId());
        jlb_area.setText(texts.getArea());
        jlb_beneficiaryCode.setText(texts.getBeneficiaryCode());
        btn_searchBeneficiaries.setText(texts.getSearchBeneficiary());
        jlb_pointInfo.setText(texts.getPointsInfo());
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
        btn_register.setText(texts.getRegisterBtn());
    }

    /**     * set controller register.     * @param action the action     */
    public void setControllerRegister(ActionListener action) {
        btn_register.addActionListener(action);
    }

    /**     * set controller search beneficiaries.     * @param action the action     */
    public void setControllerSearchBeneficiaries(ActionListener action) {
        btn_searchBeneficiaries.addActionListener(action);
    }
    /**     * set controller import excel data.     * @param action the action     */
    public void setControllerImportExcelData(ActionListener action) {
        btn_importExcelData.addActionListener(action);
    }

    /**     * set controller go point2.     * @param action the action     */
    public void setControllerGoPoint2(ActionListener action) {
        btn_goPoint2.addActionListener(action);
    }

    /**     * set controller go point3.     * @param action the action     */
    public void setControllerGoPoint3(ActionListener action) {
        btn_goPoint3.addActionListener(action);
    }

    /**     * set controller go point4.     * @param action the action     */
    public void setControllerGoPoint4(ActionListener action) {
        btn_goPoint4.addActionListener(action);
    }

    /**     * set controller return point1.     * @param action the action     */
    public void setControllerReturnPoint1(ActionListener action) {
        btn_returnPoint1.addActionListener(action);
    }

    /**     * set controller return point2.     * @param action the action     */
    public void setControllerReturnPoint2(ActionListener action) {
        btn_returnPoint2.addActionListener(action);
    }

    /**     * set controller return point3.     * @param action the action     */
    public void setControllerReturnPoint3(ActionListener action) {
        btn_returnPoint3.addActionListener(action);
    }

    /**     * get btn_go point2.     * @return the get btn_go point2     */
    public ButtonBadges getBtn_goPoint2() {
        return btn_goPoint2;
    }

    /**     * get btn_go point3.     * @return the get btn_go point3     */
    public ButtonBadges getBtn_goPoint3() {
        return btn_goPoint3;
    }

    /**     * get btn_go point4.     * @return the get btn_go point4     */
    public ButtonBadges getBtn_goPoint4() {
        return btn_goPoint4;
    }

    /**     * get btn_register.     * @return the get btn_register     */
    public ButtonAction getBtn_register() {
        return btn_register;
    }

    /**     * get btn_return point1.     * @return the get btn_return point1     */
    public ButtonBadges getBtn_returnPoint1() {
        return btn_returnPoint1;
    }

    /**     * get btn_return point2.     * @return the get btn_return point2     */
    public ButtonBadges getBtn_returnPoint2() {
        return btn_returnPoint2;
    }

    /**     * get btn_return point3.     * @return the get btn_return point3     */
    public ButtonBadges getBtn_returnPoint3() {
        return btn_returnPoint3;
    }

    /**     * get btn_search beneficiary.     * @return the get btn_search beneficiary     */
    public ButtonAction getBtn_searchBeneficiary() {
        return btn_searchBeneficiaries;
    }

    /**     * get btn_import excel data.     * @return the get btn_import excel data     */
    public ButtonAction getBtn_importExcelData() {
        return btn_importExcelData;
    }

    /**     * get jpl_content points.     * @return the get jpl_content points     */
    public JPanel getJpl_contentPoints() {
        return jpl_contentPoints;
    }

    /**     * get jpl_point1.     * @return the get jpl_point1     */
    public JPanel getJpl_point1() {
        return jpl_point1;
    }

    /**     * get jpl_point2.     * @return the get jpl_point2     */
    public JPanel getJpl_point2() {
        return jpl_point2;
    }

    /**     * get jpl_point3.     * @return the get jpl_point3     */
    public JPanel getJpl_point3() {
        return jpl_point3;
    }

    /**     * get jpl_point4.     * @return the get jpl_point4     */
    public JPanel getJpl_point4() {
        return jpl_point4;
    }

    /**     * get txt_area.     * @return the get txt_area     */
    public JTextField getTxt_area() {
        return txt_area;
    }

    /**     * get txt_beneficiary code.     * @return the get txt_beneficiary code     */
    public JTextField getTxt_beneficiaryCode() {
        return txt_beneficiaryCode;
    }

    /**     * get txt_cadastral id.     * @return the get txt_cadastral id     */
    public JTextField getTxt_cadastralId() {
        return txt_cadastralId;
    }

    /**     * get txt_address.     * @return the get txt_address     */
    public JTextField getTxt_address() {
        return txt_address;
    }
    
    /**     * get txt_distance1.     * @return the get txt_distance1     */
    public JTextField getTxt_distance1() {
        return txt_distance1;
    }

    /**     * get txt_distance2.     * @return the get txt_distance2     */
    public JTextField getTxt_distance2() {
        return txt_distance2;
    }

    /**     * get txt_distance3.     * @return the get txt_distance3     */
    public JTextField getTxt_distance3() {
        return txt_distance3;
    }

    /**     * get txt_distance4.     * @return the get txt_distance4     */
    public JTextField getTxt_distance4() {
        return txt_distance4;
    }

    /**     * get txt_east coordinate1.     * @return the get txt_east coordinate1     */
    public JTextField getTxt_eastCoordinate1() {
        return txt_eastCoordinate1;
    }

    /**     * get txt_east coordinate2.     * @return the get txt_east coordinate2     */
    public JTextField getTxt_eastCoordinate2() {
        return txt_eastCoordinate2;
    }

    /**     * get txt_east coordinate3.     * @return the get txt_east coordinate3     */
    public JTextField getTxt_eastCoordinate3() {
        return txt_eastCoordinate3;
    }

    /**     * get txt_east coordinate4.     * @return the get txt_east coordinate4     */
    public JTextField getTxt_eastCoordinate4() {
        return txt_eastCoordinate4;
    }

    /**     * get txt_hillside1.     * @return the get txt_hillside1     */
    public JTextField getTxt_hillside1() {
        return txt_hillside1;
    }

    /**     * get txt_hillside2.     * @return the get txt_hillside2     */
    public JTextField getTxt_hillside2() {
        return txt_hillside2;
    }

    /**     * get txt_hillside3.     * @return the get txt_hillside3     */
    public JTextField getTxt_hillside3() {
        return txt_hillside3;
    }

    /**     * get txt_hillside4.     * @return the get txt_hillside4     */
    public JTextField getTxt_hillside4() {
        return txt_hillside4;
    }

    /**     * get txt_north coordinate1.     * @return the get txt_north coordinate1     */
    public JTextField getTxt_northCoordinate1() {
        return txt_northCoordinate1;
    }

    /**     * get txt_north coordinate2.     * @return the get txt_north coordinate2     */
    public JTextField getTxt_northCoordinate2() {
        return txt_northCoordinate2;
    }

    /**     * get txt_north coordinate3.     * @return the get txt_north coordinate3     */
    public JTextField getTxt_northCoordinate3() {
        return txt_northCoordinate3;
    }

    /**     * get txt_north coordinate4.     * @return the get txt_north coordinate4     */
    public JTextField getTxt_northCoordinate4() {
        return txt_northCoordinate4;
    }

    /**
     * Clear all fields of the property registration form.
     */
    public void clearFields() {
        txt_cadastralId.setText("");
        txt_area.setText("");
        txt_beneficiaryCode.setText("");
        txt_northCoordinate1.setText("");
        txt_eastCoordinate1.setText("");
        txt_distance1.setText("");
        txt_hillside1.setText("");
        txt_northCoordinate2.setText("");
        txt_eastCoordinate2.setText("");
        txt_distance2.setText("");
        txt_hillside2.setText("");
        txt_northCoordinate3.setText("");
        txt_eastCoordinate3.setText("");
        txt_distance3.setText("");
        txt_hillside3.setText("");
        txt_northCoordinate4.setText("");
        txt_eastCoordinate4.setText("");
        txt_distance4.setText("");
        txt_hillside4.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_goPoint2;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_goPoint3;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_goPoint4;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_importExcelData;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_register;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint1;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint2;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint3;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchBeneficiaries;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlb_area;
    private javax.swing.JLabel jlb_beneficiaryCode;
    private javax.swing.JLabel jlb_cadastralId;
    private javax.swing.JLabel jlb_distance1;
    private javax.swing.JLabel jlb_distance2;
    private javax.swing.JLabel jlb_distance3;
    private javax.swing.JLabel jlb_distance4;
    private javax.swing.JLabel jlb_east1;
    private javax.swing.JLabel jlb_east2;
    private javax.swing.JLabel jlb_east3;
    private javax.swing.JLabel jlb_east4;
    private javax.swing.JLabel jlb_hillside1;
    private javax.swing.JLabel jlb_hillside2;
    private javax.swing.JLabel jlb_hillside3;
    private javax.swing.JLabel jlb_hillside4;
    private javax.swing.JLabel jlb_north1;
    private javax.swing.JLabel jlb_north2;
    private javax.swing.JLabel jlb_north3;
    private javax.swing.JLabel jlb_north4;
    private javax.swing.JLabel jlb_point1;
    private javax.swing.JLabel jlb_point2;
    private javax.swing.JLabel jlb_point3;
    private javax.swing.JLabel jlb_point4;
    private javax.swing.JLabel jlb_pointInfo;
    private javax.swing.JLabel jlb_propertyInfo;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JPanel jpl_contentPoints;
    private javax.swing.JPanel jpl_point1;
    private javax.swing.JPanel jpl_point2;
    private javax.swing.JPanel jpl_point3;
    private javax.swing.JPanel jpl_point4;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_beneficiaryCode;
    private javax.swing.JTextField txt_cadastralId;
    private javax.swing.JTextField txt_distance1;
    private javax.swing.JTextField txt_distance2;
    private javax.swing.JTextField txt_distance3;
    private javax.swing.JTextField txt_distance4;
    private javax.swing.JTextField txt_eastCoordinate1;
    private javax.swing.JTextField txt_eastCoordinate2;
    private javax.swing.JTextField txt_eastCoordinate3;
    private javax.swing.JTextField txt_eastCoordinate4;
    private javax.swing.JTextField txt_hillside1;
    private javax.swing.JTextField txt_hillside2;
    private javax.swing.JTextField txt_hillside3;
    private javax.swing.JTextField txt_hillside4;
    private javax.swing.JTextField txt_northCoordinate1;
    private javax.swing.JTextField txt_northCoordinate2;
    private javax.swing.JTextField txt_northCoordinate3;
    private javax.swing.JTextField txt_northCoordinate4;
    // End of variables declaration//GEN-END:variables
}
