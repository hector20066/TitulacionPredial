package com.hector.titulacionpredial.view.content.panels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.hector.titulacionpredial.view.swing.chart.Card;
import com.hector.titulacionpredial.view.swing.chart.GaugeChart;
import com.hector.titulacionpredial.view.swing.chart.LineChart;
import com.hector.titulacionpredial.view.swing.model.CardModel;

/**
 * Panel principal del tablero de control (Dashboard).
 *
 * <p>
 * Presenta tarjetas de resumen ({@link Card}), gráficos de calibre
 * ({@link GaugeChart}) y gráficos de líneas ({@link LineChart})
 * con estadísticas de beneficiarios, predios y resoluciones.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 * @see Card
 * @see GaugeChart
 * @see LineChart
 */
public class Dashboard extends javax.swing.JPanel {

    public Dashboard() {
        initComponents();
        
        scroll.getVerticalScrollBar().setUnitIncrement(15);
    }
    
    public void updateCards(int totalBeneficiaries, int totalProperties, int totalResolutions) {
        card1.setData(new CardModel(
                new FlatSVGIcon(getClass().getResource("/image/users-round.svg")),
                "Beneficiarios",
                String.valueOf(totalBeneficiaries),
                "Beneficiarios registrados"));

        card2.setData(new CardModel(
                new FlatSVGIcon(getClass().getResource("/image/house.svg")),
                "Predios",
                String.valueOf(totalProperties),
                "Predios Registrados"));

        card3.setData(new CardModel(
                new FlatSVGIcon(getClass().getResource("/image/file-text.svg")),
                "Resoluciones",
                String.valueOf(totalResolutions),
                "Resoluciones hechas"));
    }

    public void updateGaugeCharts(int percentBeneficiaries, int percentProperties) {
        gaugeChart1.setValueWithAnimation(percentBeneficiaries);
        gaugeChart2.setValueWithAnimation(percentProperties);
    }

    public void loadDataBeneficiaries(int withProperty, int withoutProperty, int total) {
        jlb_withProperty.setText("# " + withProperty);
        jlb_withoutProperty.setText("# " + withoutProperty);
        jlb_totalBeneficiaries.setText("# " + total);
    }

    public void loadDataProperties(int withResolution, int withoutResolution, int total) {
        jlb_withResolution.setText("# " + withResolution);
        jlb_withoutResolution.setText("# " + withoutResolution);
        jlb_totalProperties.setText("# " + total);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        panelShadowCard1 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlb_totalBeneficiaries = new javax.swing.JLabel();
        jlb_withoutProperty = new javax.swing.JLabel();
        jlb_withProperty = new javax.swing.JLabel();
        gaugeChart1 = new com.hector.titulacionpredial.view.swing.chart.GaugeChart();
        panelShadowCard2 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlb_totalProperties = new javax.swing.JLabel();
        jlb_withoutResolution = new javax.swing.JLabel();
        jlb_withResolution = new javax.swing.JLabel();
        gaugeChart2 = new com.hector.titulacionpredial.view.swing.chart.GaugeChart();
        panelShadowCard4 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        card1 = new com.hector.titulacionpredial.view.swing.chart.Card();
        card2 = new com.hector.titulacionpredial.view.swing.chart.Card();
        card3 = new com.hector.titulacionpredial.view.swing.chart.Card();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        panelShadowCard3 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        lineChart1 = new com.hector.titulacionpredial.view.swing.chart.LineChart();
        jLabel16 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 28, 21));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionamos Urbano Rural S.A.S");

        scroll.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 97, 97));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Beneficiarios");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(133, 133, 133));
        jLabel3.setText("Con predio");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(133, 133, 133));
        jLabel4.setText("Sin predio");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(133, 133, 133));
        jLabel7.setText("Total");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_totalBeneficiaries.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_totalBeneficiaries.setForeground(new java.awt.Color(80, 116, 253));
        jlb_totalBeneficiaries.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_totalBeneficiaries.setText("# 15");
        jlb_totalBeneficiaries.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_withoutProperty.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withoutProperty.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withoutProperty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_withoutProperty.setText("# 10");
        jlb_withoutProperty.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_withProperty.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withProperty.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withProperty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_withProperty.setText("# 5");
        jlb_withProperty.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        gaugeChart1.setColor1(new java.awt.Color(216, 243, 220));
        gaugeChart1.setColor2(new java.awt.Color(64, 145, 108));
        gaugeChart1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelShadowCard1Layout = new javax.swing.GroupLayout(panelShadowCard1);
        panelShadowCard1.setLayout(panelShadowCard1Layout);
        panelShadowCard1Layout.setHorizontalGroup(
            panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadowCard1Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_withProperty)
                    .addComponent(jlb_withoutProperty)
                    .addComponent(jlb_totalBeneficiaries))
                .addGap(28, 28, 28))
        );
        panelShadowCard1Layout.setVerticalGroup(
            panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowCard1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadowCard1Layout.createSequentialGroup()
                        .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jlb_withProperty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jlb_withoutProperty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jlb_totalBeneficiaries)))
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(97, 97, 97));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Predios");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(133, 133, 133));
        jLabel10.setText("Con resolucion");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(133, 133, 133));
        jLabel11.setText("Sin resolucion");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(133, 133, 133));
        jLabel12.setText("Total");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_totalProperties.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_totalProperties.setForeground(new java.awt.Color(150, 56, 248));
        jlb_totalProperties.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_totalProperties.setText("# 70");
        jlb_totalProperties.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_withoutResolution.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withoutResolution.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withoutResolution.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_withoutResolution.setText("# 20");
        jlb_withoutResolution.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_withResolution.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withResolution.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withResolution.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_withResolution.setText("# 50");
        jlb_withResolution.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        gaugeChart2.setColor1(new java.awt.Color(237, 242, 251));
        gaugeChart2.setColor2(new java.awt.Color(69, 71, 252));
        gaugeChart2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelShadowCard2Layout = new javax.swing.GroupLayout(panelShadowCard2);
        panelShadowCard2.setLayout(panelShadowCard2Layout);
        panelShadowCard2Layout.setHorizontalGroup(
            panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadowCard2Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_withResolution)
                    .addComponent(jlb_withoutResolution)
                    .addComponent(jlb_totalProperties))
                .addGap(25, 25, 25))
        );
        panelShadowCard2Layout.setVerticalGroup(
            panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowCard2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadowCard2Layout.createSequentialGroup()
                        .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jlb_withResolution))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jlb_withoutResolution))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jlb_totalProperties)))
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        card1.setColor1(new java.awt.Color(149, 213, 178));
        card1.setColor2(new java.awt.Color(45, 106, 79));

        card2.setColor1(new java.awt.Color(100, 223, 223));
        card2.setColor2(new java.awt.Color(78, 168, 222));

        card3.setColor1(new java.awt.Color(206, 212, 218));
        card3.setColor2(new java.awt.Color(108, 117, 125));

        javax.swing.GroupLayout panelShadowCard4Layout = new javax.swing.GroupLayout(panelShadowCard4);
        panelShadowCard4.setLayout(panelShadowCard4Layout);
        panelShadowCard4Layout.setHorizontalGroup(
            panelShadowCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowCard4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panelShadowCard4Layout.setVerticalGroup(
            panelShadowCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowCard4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelShadowCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(8, 28, 21));
        jLabel23.setText("Total de Registro Guardados");

        jLabel24.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(8, 28, 21));
        jLabel24.setText("Porcentaje de trabajos terminados");

        javax.swing.GroupLayout panelShadowCard3Layout = new javax.swing.GroupLayout(panelShadowCard3);
        panelShadowCard3.setLayout(panelShadowCard3Layout);
        panelShadowCard3Layout.setHorizontalGroup(
            panelShadowCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowCard3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelShadowCard3Layout.setVerticalGroup(
            panelShadowCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadowCard3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(lineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel16.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(8, 28, 21));
        jLabel16.setText("Beneficiarios Registrados durante los ultimos meses");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadowCard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(panelShadowCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(panelShadowCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(panelShadowCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(panelShadowCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadowCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadowCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(panelShadowCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        scroll.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
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

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public Card getCard3() {
        return card3;
    }

    public GaugeChart getGaugeChart1() {
        return gaugeChart1;
    }

    public GaugeChart getGaugeChart2() {
        return gaugeChart2;
    }

    public LineChart getLineChart1() {
        return lineChart1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.chart.Card card1;
    private com.hector.titulacionpredial.view.swing.chart.Card card2;
    private com.hector.titulacionpredial.view.swing.chart.Card card3;
    private com.hector.titulacionpredial.view.swing.chart.GaugeChart gaugeChart1;
    private com.hector.titulacionpredial.view.swing.chart.GaugeChart gaugeChart2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlb_totalBeneficiaries;
    private javax.swing.JLabel jlb_totalProperties;
    private javax.swing.JLabel jlb_withProperty;
    private javax.swing.JLabel jlb_withResolution;
    private javax.swing.JLabel jlb_withoutProperty;
    private javax.swing.JLabel jlb_withoutResolution;
    private com.hector.titulacionpredial.view.swing.chart.LineChart lineChart1;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard1;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard2;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard3;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard4;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
