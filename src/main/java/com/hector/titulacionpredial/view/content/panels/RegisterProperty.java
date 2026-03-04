package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterPropertyText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.button.ButtonBadges;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Formulario para el registro de predios con sus
 * coordenadas geográficas.
 *
 * <p>
 * Utiliza un {@code CardLayout} para organizar la entrada
 * de hasta 4 puntos geográficos (Norte, Este, distancia y
 * ladera). Incluye campos para cédula catastral, área y
 * código del beneficiario asociado.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class RegisterProperty extends javax.swing.JPanel {

    /**
     * Crea el formulario de registro de predios con 4 paneles de puntos.
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
        btn_selectBeneficiary = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

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
        txt_northCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east1.setText("Coordenada Este:");

        txt_eastCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance1.setText("Distancia(m):");

        txt_distance1.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside1.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside1.setText("Colindero:");

        txt_hillside1.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
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
        txt_northCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance2.setText("Distancia(m):");

        txt_distance2.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside2.setText("Colindero:");

        txt_hillside2.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east2.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east2.setText("Coordenada Este:");

        txt_eastCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
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
        txt_northCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance3.setText("Distancia(m):");

        txt_distance3.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside3.setText("Colindero:");

        txt_hillside3.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east3.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east3.setText("Coordenada Este:");

        txt_eastCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
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
        txt_northCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_distance4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_distance4.setText("Distancia(m):");

        txt_distance4.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_hillside4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_hillside4.setText("Colindero:");

        txt_hillside4.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_east4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_east4.setForeground(new java.awt.Color(33, 37, 41));
        jlb_east4.setText("Coordenada Este:");

        txt_eastCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
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
        txt_cadastralId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_area.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_area.setForeground(new java.awt.Color(33, 37, 41));
        jlb_area.setText("Area(m^2):");

        txt_area.setBackground(new java.awt.Color(255, 255, 255));
        txt_area.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_area.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jlb_pointInfo.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_pointInfo.setForeground(new java.awt.Color(33, 37, 41));
        jlb_pointInfo.setText("Informacion de los puntos:");

        jlb_beneficiaryCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_beneficiaryCode.setForeground(new java.awt.Color(33, 37, 41));
        jlb_beneficiaryCode.setText("Codigo del Beneficiario:");

        txt_beneficiaryCode.setBackground(new java.awt.Color(255, 255, 255));
        txt_beneficiaryCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_beneficiaryCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        btn_selectBeneficiary.setBackground(new java.awt.Color(149, 213, 178));
        btn_selectBeneficiary.setForeground(new java.awt.Color(33, 37, 41));
        btn_selectBeneficiary.setText("Buscar Beneficiario");
        btn_selectBeneficiary.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_selectBeneficiary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jpl_contentPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jlb_beneficiaryCode)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_beneficiaryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(btn_selectBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jlb_cadastralId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cadastralId, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113)
                                        .addComponent(jlb_area)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlb_title))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_pointInfo)
                                    .addComponent(jlb_propertyInfo))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
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
                    .addComponent(btn_selectBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jlb_pointInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpl_contentPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
     * Actualiza los textos del panel según el idioma seleccionado.
     *
     * @param texts DTO con los textos traducidos
     */
    public void updateLanguage(DTORegisterPropertyText texts) {
        jlb_title.setText(texts.getTitle());
        jlb_propertyInfo.setText(texts.getPropertyInfo());
        jlb_cadastralId.setText(texts.getCadastralId());
        jlb_area.setText(texts.getArea());
        jlb_beneficiaryCode.setText(texts.getBeneficiaryCode());
        btn_selectBeneficiary.setText(texts.getSearchBeneficiary());
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

    /**
     * Asigna el listener para el botón de registrar.
     *
     * @param action listener del botón
     */
    public void setControllerRegister(ActionListener action) {
        btn_register.addActionListener(action);
    }

    /**
     * Asigna el listener para mostrar beneficiarios.
     *
     * @param action listener del botón
     */
    public void setControllerShowBeneficiaries(ActionListener action) {
        btn_selectBeneficiary.addActionListener(action);
    }

    /**
     * Asigna el listener para ir al punto 2.
     *
     * @param action listener del botón
     */
    public void setControllerGoPoint2(ActionListener action) {
        btn_goPoint2.addActionListener(action);
    }

    /**
     * Asigna el listener para ir al punto 3.
     *
     * @param action listener del botón
     */
    public void setControllerGoPoint3(ActionListener action) {
        btn_goPoint3.addActionListener(action);
    }

    /**
     * Asigna el listener para ir al punto 4.
     *
     * @param action listener del botón
     */
    public void setControllerGoPoint4(ActionListener action) {
        btn_goPoint4.addActionListener(action);
    }

    /**
     * Asigna el listener para regresar al punto 1.
     *
     * @param action listener del botón
     */
    public void setControllerReturnPoint1(ActionListener action) {
        btn_returnPoint1.addActionListener(action);
    }

    /**
     * Asigna el listener para regresar al punto 2.
     *
     * @param action listener del botón
     */
    public void setControllerReturnPoint2(ActionListener action) {
        btn_returnPoint2.addActionListener(action);
    }

    /**
     * Asigna el listener para regresar al punto 3.
     *
     * @param action listener del botón
     */
    public void setControllerReturnPoint3(ActionListener action) {
        btn_returnPoint3.addActionListener(action);
    }

    /**
     * Obtiene el componente botón para ir al punto 2.
     *
     * @return componente {@link ButtonBadges}
     */
    public ButtonBadges getBtn_goPoint2() {
        return btn_goPoint2;
    }

    /**
     * Obtiene el componente botón para ir al punto 3.
     *
     * @return componente {@link ButtonBadges}
     */
    public ButtonBadges getBtn_goPoint3() {
        return btn_goPoint3;
    }

    /**
     * Obtiene el componente botón para ir al punto 4.
     *
     * @return componente {@link ButtonBadges}
     */
    public ButtonBadges getBtn_goPoint4() {
        return btn_goPoint4;
    }

    /**
     * Obtiene el componente botón de registrar predio.
     *
     * @return componente {@link ButtonAction}
     */
    public ButtonAction getBtn_register() {
        return btn_register;
    }

    /**
     * Obtiene el componente botón para regresar al punto 1.
     *
     * @return componente {@link ButtonBadges}
     */
    public ButtonBadges getBtn_returnPoint1() {
        return btn_returnPoint1;
    }

    /**
     * Obtiene el componente botón para regresar al punto 2.
     *
     * @return componente {@link ButtonBadges}
     */
    public ButtonBadges getBtn_returnPoint2() {
        return btn_returnPoint2;
    }

    /**
     * Obtiene el componente botón para regresar al punto 3.
     *
     * @return componente {@link ButtonBadges}
     */
    public ButtonBadges getBtn_returnPoint3() {
        return btn_returnPoint3;
    }

    /**
     * Obtiene el componente botón para seleccionar beneficiario.
     *
     * @return componente {@link ButtonAction}
     */
    public ButtonAction getBtn_selectBeneficiary() {
        return btn_selectBeneficiary;
    }

    /**
     * Obtiene el componente panel contenedor de los puntos geográficos.
     *
     * @return componente {@link JPanel}
     */
    public JPanel getJpl_contentPoints() {
        return jpl_contentPoints;
    }

    /**
     * Obtiene el componente panel del punto 1.
     *
     * @return componente {@link JPanel}
     */
    public JPanel getJpl_point1() {
        return jpl_point1;
    }

    /**
     * Obtiene el componente panel del punto 2.
     *
     * @return componente {@link JPanel}
     */
    public JPanel getJpl_point2() {
        return jpl_point2;
    }

    /**
     * Obtiene el componente panel del punto 3.
     *
     * @return componente {@link JPanel}
     */
    public JPanel getJpl_point3() {
        return jpl_point3;
    }

    /**
     * Obtiene el componente panel del punto 4.
     *
     * @return componente {@link JPanel}
     */
    public JPanel getJpl_point4() {
        return jpl_point4;
    }

    /**
     * Obtiene el componente campo de texto del área del predio.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_area() {
        return txt_area;
    }

    /**
     * Obtiene el componente campo de texto del código de beneficiario.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_beneficiaryCode() {
        return txt_beneficiaryCode;
    }

    /**
     * Obtiene el componente campo de texto de la cédula catastral.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_cadastralId() {
        return txt_cadastralId;
    }

    /**
     * Obtiene el componente campo de texto de distancia del punto 1.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_distance1() {
        return txt_distance1;
    }

    /**
     * Obtiene el componente campo de texto de distancia del punto 2.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_distance2() {
        return txt_distance2;
    }

    /**
     * Obtiene el componente campo de texto de distancia del punto 3.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_distance3() {
        return txt_distance3;
    }

    /**
     * Obtiene el componente campo de texto de distancia del punto 4.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_distance4() {
        return txt_distance4;
    }

    /**
     * Obtiene el componente campo de texto de coordenada este del punto 1.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_eastCoordinate1() {
        return txt_eastCoordinate1;
    }

    /**
     * Obtiene el componente campo de texto de coordenada este del punto 2.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_eastCoordinate2() {
        return txt_eastCoordinate2;
    }

    /**
     * Obtiene el componente campo de texto de coordenada este del punto 3.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_eastCoordinate3() {
        return txt_eastCoordinate3;
    }

    /**
     * Obtiene el componente campo de texto de coordenada este del punto 4.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_eastCoordinate4() {
        return txt_eastCoordinate4;
    }

    /**
     * Obtiene el componente campo de texto de colindero del punto 1.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_hillside1() {
        return txt_hillside1;
    }

    /**
     * Obtiene el componente campo de texto de colindero del punto 2.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_hillside2() {
        return txt_hillside2;
    }

    /**
     * Obtiene el componente campo de texto de colindero del punto 3.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_hillside3() {
        return txt_hillside3;
    }

    /**
     * Obtiene el componente campo de texto de colindero del punto 4.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_hillside4() {
        return txt_hillside4;
    }

    /**
     * Obtiene el componente campo de texto de coordenada norte del punto 1.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_northCoordinate1() {
        return txt_northCoordinate1;
    }

    /**
     * Obtiene el componente campo de texto de coordenada norte del punto 2.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_northCoordinate2() {
        return txt_northCoordinate2;
    }

    /**
     * Obtiene el componente campo de texto de coordenada norte del punto 3.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_northCoordinate3() {
        return txt_northCoordinate3;
    }

    /**
     * Obtiene el componente campo de texto de coordenada norte del punto 4.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_northCoordinate4() {
        return txt_northCoordinate4;
    }

    /**
     * Limpia todos los campos del formulario de registro de predios.
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
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_register;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint1;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint2;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint3;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_selectBeneficiary;
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
