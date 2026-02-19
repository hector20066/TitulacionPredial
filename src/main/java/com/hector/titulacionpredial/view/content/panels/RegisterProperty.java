package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.button.ButtonBadges;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hectoracevedo
 */
public class RegisterProperty extends javax.swing.JPanel {

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
        jLabel7 = new javax.swing.JLabel();
        jpl_contentPoints = new javax.swing.JPanel();
        jpl_point1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_goPoint2 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jLabel11 = new javax.swing.JLabel();
        txt_northCoordinate1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_eastCoordinate1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_distance1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_hillside1 = new javax.swing.JTextField();
        jpl_point2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_goPoint3 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        btn_returnPoint1 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jLabel15 = new javax.swing.JLabel();
        txt_northCoordinate2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_distance2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_hillside2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_eastCoordinate2 = new javax.swing.JTextField();
        jpl_point3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_returnPoint2 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        btn_goPoint4 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jLabel19 = new javax.swing.JLabel();
        txt_northCoordinate3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_distance3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_hillside3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_eastCoordinate3 = new javax.swing.JTextField();
        jpl_point4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_returnPoint3 = new com.hector.titulacionpredial.view.swing.button.ButtonBadges();
        jLabel23 = new javax.swing.JLabel();
        txt_northCoordinate4 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_distance4 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_hillside4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_eastCoordinate4 = new javax.swing.JTextField();
        btn_register = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cadastralId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_area = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_beneficiaryCode = new javax.swing.JTextField();
        btn_selectBeneficiary = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 37, 41));
        jLabel7.setText("Registrar Predio");

        jpl_contentPoints.setBackground(new java.awt.Color(255, 255, 255));
        jpl_contentPoints.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jpl_contentPoints.setLayout(new java.awt.CardLayout());

        jpl_point1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 37, 41));
        jLabel5.setText("Punto 1");

        btn_goPoint2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevron-right.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(33, 37, 41));
        jLabel11.setText("Coordenada Norte:");

        txt_northCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(33, 37, 41));
        jLabel12.setText("Coordenada Este:");

        txt_eastCoordinate1.setBackground(new java.awt.Color(255, 255, 255));
        txt_eastCoordinate1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_eastCoordinate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(33, 37, 41));
        jLabel13.setText("Distancia(m):");

        txt_distance1.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 37, 41));
        jLabel14.setText("Colindero:");

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
                        .addComponent(jLabel5))
                    .addGroup(jpl_point1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(222, 222, 222)
                                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpl_point1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_hillside1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14)))
                            .addGroup(jpl_point1Layout.createSequentialGroup()
                                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
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
                                        .addComponent(jLabel12)))))))
                .addContainerGap())
        );
        jpl_point1Layout.setVerticalGroup(
            jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
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

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 37, 41));
        jLabel6.setText("Punto 2");

        btn_goPoint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevron-right.png"))); // NOI18N

        btn_returnPoint1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevron-left.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(33, 37, 41));
        jLabel15.setText("Coordenada Norte:");

        txt_northCoordinate2.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(33, 37, 41));
        jLabel16.setText("Distancia(m):");

        txt_distance2.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(33, 37, 41));
        jLabel17.setText("Colindero:");

        txt_hillside2.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(33, 37, 41));
        jLabel18.setText("Coordenada Este:");

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
                        .addComponent(jLabel6)
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
                        .addComponent(jLabel16)
                        .addGap(222, 222, 222)
                        .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_hillside2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)))
                    .addGroup(jpl_point2Layout.createSequentialGroup()
                        .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
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
                                .addComponent(jLabel18)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jpl_point2Layout.setVerticalGroup(
            jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
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

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(33, 37, 41));
        jLabel8.setText("Punto 3");

        btn_returnPoint2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevron-left.png"))); // NOI18N

        btn_goPoint4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevron-right.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(33, 37, 41));
        jLabel19.setText("Coordenada Norte:");

        txt_northCoordinate3.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 37, 41));
        jLabel20.setText("Distancia(m):");

        txt_distance3.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(33, 37, 41));
        jLabel21.setText("Colindero:");

        txt_hillside3.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 37, 41));
        jLabel22.setText("Coordenada Este:");

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
                        .addComponent(jLabel8)
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
                        .addComponent(jLabel20)
                        .addGap(222, 222, 222)
                        .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_hillside3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21)))
                    .addGroup(jpl_point3Layout.createSequentialGroup()
                        .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
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
                                .addComponent(jLabel22)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jpl_point3Layout.setVerticalGroup(
            jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_point3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
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

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(33, 37, 41));
        jLabel9.setText("Punto 4");

        btn_returnPoint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevron-left.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 37, 41));
        jLabel23.setText("Coordenada Norte:");

        txt_northCoordinate4.setBackground(new java.awt.Color(255, 255, 255));
        txt_northCoordinate4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_northCoordinate4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(33, 37, 41));
        jLabel24.setText("Distancia(m):");

        txt_distance4.setBackground(new java.awt.Color(255, 255, 255));
        txt_distance4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_distance4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(33, 37, 41));
        jLabel25.setText("Colindero:");

        txt_hillside4.setBackground(new java.awt.Color(255, 255, 255));
        txt_hillside4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_hillside4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(33, 37, 41));
        jLabel26.setText("Coordenada Este:");

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
                            .addComponent(jLabel9)
                            .addComponent(btn_returnPoint3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpl_point4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpl_point4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(222, 222, 222)
                                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpl_point4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel25)))
                            .addGroup(jpl_point4Layout.createSequentialGroup()
                                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
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
                                        .addComponent(jLabel26)))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jpl_point4Layout.setVerticalGroup(
            jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_point4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_northCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eastCoordinate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpl_point4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hillside4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btn_returnPoint3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpl_contentPoints.add(jpl_point4, "card5");

        btn_register.setText("REGISTRAR PREDIO");
        btn_register.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Informacion del Predio:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 37, 41));
        jLabel2.setText("Cedula Catastral:");

        txt_cadastralId.setBackground(new java.awt.Color(255, 255, 255));
        txt_cadastralId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_cadastralId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 37, 41));
        jLabel3.setText("Area(m^2):");

        txt_area.setBackground(new java.awt.Color(255, 255, 255));
        txt_area.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_area.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 37, 41));
        jLabel4.setText("Informacion de los puntos:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(33, 37, 41));
        jLabel10.setText("Codigo del Beneficiario:");

        txt_beneficiaryCode.setBackground(new java.awt.Color(255, 255, 255));
        txt_beneficiaryCode.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_beneficiaryCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        btn_selectBeneficiary.setBackground(new java.awt.Color(51, 204, 255));
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
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_beneficiaryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btn_selectBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cadastralId, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jpl_contentPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))))
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
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cadastralId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_beneficiaryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_selectBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
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

    public void setControllerRegister(ActionListener action) {
        btn_register.addActionListener(action);
    }
    
    public void setControllerShowBeneficiaries(ActionListener action) {
        btn_selectBeneficiary.addActionListener(action);
    }
    
    public void setControllerGoPoint2(ActionListener action) {
        btn_goPoint2.addActionListener(action);
    }
    
    public void setControllerGoPoint3(ActionListener action) {
        btn_goPoint3.addActionListener(action);
    }
    
    public void setControllerGoPoint4(ActionListener action) {
        btn_goPoint4.addActionListener(action);
    }
    
    public void setControllerReturnPoint1(ActionListener action) {
        btn_returnPoint1.addActionListener(action);
    }
    
    public void setControllerReturnPoint2(ActionListener action) {
        btn_returnPoint2.addActionListener(action);
    }
    
    public void setControllerReturnPoint3(ActionListener action) {
        btn_returnPoint3.addActionListener(action);
    }
    
    public ButtonBadges getBtn_goPoint2() {
        return btn_goPoint2;
    }

    public ButtonBadges getBtn_goPoint3() {
        return btn_goPoint3;
    }

    public ButtonBadges getBtn_goPoint4() {
        return btn_goPoint4;
    }

    public ButtonAction getBtn_register() {
        return btn_register;
    }

    public ButtonBadges getBtn_returnPoint1() {
        return btn_returnPoint1;
    }

    public ButtonBadges getBtn_returnPoint2() {
        return btn_returnPoint2;
    }

    public ButtonBadges getBtn_returnPoint3() {
        return btn_returnPoint3;
    }

    public JPanel getJpl_contentPoints() {
        return jpl_contentPoints;
    }

    public JPanel getJpl_point1() {
        return jpl_point1;
    }

    public JPanel getJpl_point2() {
        return jpl_point2;
    }

    public JPanel getJpl_point3() {
        return jpl_point3;
    }

    public JPanel getJpl_point4() {
        return jpl_point4;
    }

    public JTextField getTxt_area() {
        return txt_area;
    }

    public JTextField getTxt_beneficiaryCode() {
        return txt_beneficiaryCode;
    }

    public JTextField getTxt_cadastralId() {
        return txt_cadastralId;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_goPoint2;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_goPoint3;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_goPoint4;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_register;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint1;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint2;
    private com.hector.titulacionpredial.view.swing.button.ButtonBadges btn_returnPoint3;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_selectBeneficiary;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
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
