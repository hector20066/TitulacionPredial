package com.hector.titulacionpredial.view.content.panels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTODashboardText;
import com.hector.titulacionpredial.view.swing.chart.Card;
import com.hector.titulacionpredial.view.swing.chart.GaugeChart;
import com.hector.titulacionpredial.view.swing.chart.LineChart;
import com.hector.titulacionpredial.view.swing.model.CardModel;

/**
 * Main Dashboard Panel
 *
 * <p>
 * Displays summary cards ({@link Card}), gauge charts
 * ({@link GaugeChart}), and line charts ({@link LineChart})
 * with statistics on beneficiaries, properties, and resolutions.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Card
 * @see GaugeChart
 * @see LineChart
 * @since 1.0
 */
public class Dashboard extends javax.swing.JPanel {

    private String beneficiaries = "Beneficiarios";
    private String beneficiariesDesc = "Beneficiarios registrados";
    private String properties = "Predios";
    private String propertiesDesc = "Predios Registrados";
    private String resolutions = "Resoluciones";
    private String resolutionsDesc = "Resoluciones hechas";

    /**
     * Create the dashboard panel and initialize the graphical components.
     */
    public Dashboard() {
        initComponents();
        
        scroll.getVerticalScrollBar().setUnitIncrement(15);
    }

    /**
     * Updates the summary cards with the indicated totals.
     *
     @param totalBeneficiaries total number of beneficiaries
     @param totalProperties    total number of properties
     @param totalResolutions   total number of resolutions
     */
    public void updateCards(int totalBeneficiaries, int totalProperties, int totalResolutions) {
        card1.setData(new CardModel(
                new FlatSVGIcon(getClass().getResource("/image/users-round.svg")),
                beneficiaries,
                String.valueOf(totalBeneficiaries),
                beneficiariesDesc));

        card2.setData(new CardModel(
                new FlatSVGIcon(getClass().getResource("/image/house.svg")),
                properties,
                String.valueOf(totalProperties),
                propertiesDesc));

        card3.setData(new CardModel(
                new FlatSVGIcon(getClass().getResource("/image/file-text.svg")),
                resolutions,
                String.valueOf(totalResolutions),
                resolutionsDesc));
    }

    /**
     * Animate the semicircular gauges with the percentages.
     *
     @param percentBeneficiaries percentage of beneficiaries
     @param percentProperties    percentage of properties
     */
    public void updateGaugeCharts(int percentBeneficiaries, int percentProperties) {
        gaugeChart1.setValueWithAnimation(percentBeneficiaries);
        gaugeChart2.setValueWithAnimation(percentProperties);
    }

    /**
     * Loads beneficiary statistics.
     *
     * @param withProperty    quantity with assigned property
     * @param withoutProperty quantity without assigned property
     * @param total           total number of beneficiaries
     */
    public void loadDataBeneficiaries(int withProperty, int withoutProperty, int total) {
        jlb_withProperty.setText("# " + withProperty);
        jlb_withoutProperty.setText("# " + withoutProperty);
        jlb_totalBeneficiaries.setText("# " + total);
    }

    /**
     * Loads property statistics.
     *
     * @param withResolution    Number with resolution
     * @param withoutResolution Number without resolution
     * @param total             Total number of properties
     */
    public void loadDataProperties(int withResolution, int withoutResolution, int total) {
        jlb_withResolution.setText("# " + withResolution);
        jlb_withoutResolution.setText("# " + withoutResolution);
        jlb_totalProperties.setText("# " + total);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        panelShadowCard1 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        jlb_beneficiaries = new javax.swing.JLabel();
        jlb_withPropertyText = new javax.swing.JLabel();
        jlb_withoutPropertyText = new javax.swing.JLabel();
        jlb_totalBenenficiariesText = new javax.swing.JLabel();
        jlb_totalBeneficiaries = new javax.swing.JLabel();
        jlb_withoutProperty = new javax.swing.JLabel();
        jlb_withProperty = new javax.swing.JLabel();
        gaugeChart1 = new com.hector.titulacionpredial.view.swing.chart.GaugeChart();
        panelShadowCard2 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        jlb_properties = new javax.swing.JLabel();
        jlb_withResolutionText = new javax.swing.JLabel();
        jlb_withoutResolutionText = new javax.swing.JLabel();
        jlb_totalPropertiesText = new javax.swing.JLabel();
        jlb_totalProperties = new javax.swing.JLabel();
        jlb_withoutResolution = new javax.swing.JLabel();
        jlb_withResolution = new javax.swing.JLabel();
        gaugeChart2 = new com.hector.titulacionpredial.view.swing.chart.GaugeChart();
        panelShadowCard4 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        card1 = new com.hector.titulacionpredial.view.swing.chart.Card();
        card2 = new com.hector.titulacionpredial.view.swing.chart.Card();
        card3 = new com.hector.titulacionpredial.view.swing.chart.Card();
        jlb_subtitle1 = new javax.swing.JLabel();
        jlb_subtitle2 = new javax.swing.JLabel();
        panelShadowCard3 = new com.hector.titulacionpredial.view.swing.panel.PanelShadowCard();
        lineChart1 = new com.hector.titulacionpredial.view.swing.chart.LineChart();
        jlb_subtitle3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_title.setText("Gestionamos Urbano Rural S.A.S");

        scroll.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlb_beneficiaries.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jlb_beneficiaries.setForeground(new java.awt.Color(97, 97, 97));
        jlb_beneficiaries.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_beneficiaries.setText("Beneficiarios");

        jlb_withPropertyText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withPropertyText.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withPropertyText.setText("Con predio");
        jlb_withPropertyText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_withoutPropertyText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withoutPropertyText.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withoutPropertyText.setText("Sin predio");
        jlb_withoutPropertyText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_totalBenenficiariesText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_totalBenenficiariesText.setForeground(new java.awt.Color(133, 133, 133));
        jlb_totalBenenficiariesText.setText("Total");
        jlb_totalBenenficiariesText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

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
                    .addComponent(jlb_beneficiaries, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_totalBenenficiariesText)
                    .addComponent(jlb_withoutPropertyText)
                    .addComponent(jlb_withPropertyText))
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
                .addComponent(jlb_beneficiaries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadowCard1Layout.createSequentialGroup()
                        .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_withPropertyText)
                            .addComponent(jlb_withProperty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_withoutPropertyText)
                            .addComponent(jlb_withoutProperty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_totalBenenficiariesText)
                            .addComponent(jlb_totalBeneficiaries)))
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jlb_properties.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jlb_properties.setForeground(new java.awt.Color(97, 97, 97));
        jlb_properties.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_properties.setText("Predios");

        jlb_withResolutionText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withResolutionText.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withResolutionText.setText("Con resolucion");
        jlb_withResolutionText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_withoutResolutionText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_withoutResolutionText.setForeground(new java.awt.Color(133, 133, 133));
        jlb_withoutResolutionText.setText("Sin resolucion");
        jlb_withoutResolutionText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jlb_totalPropertiesText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_totalPropertiesText.setForeground(new java.awt.Color(133, 133, 133));
        jlb_totalPropertiesText.setText("Total");
        jlb_totalPropertiesText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

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
                    .addComponent(jlb_properties, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_totalPropertiesText)
                    .addComponent(jlb_withoutResolutionText)
                    .addComponent(jlb_withResolutionText))
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
                .addComponent(jlb_properties)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadowCard2Layout.createSequentialGroup()
                        .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_withResolutionText)
                            .addComponent(jlb_withResolution))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_withoutResolutionText)
                            .addComponent(jlb_withoutResolution))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadowCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_totalPropertiesText)
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
                .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
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

        jlb_subtitle1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_subtitle1.setForeground(new java.awt.Color(8, 28, 21));
        jlb_subtitle1.setText("Total de Registro Guardados");

        jlb_subtitle2.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jlb_subtitle2.setForeground(new java.awt.Color(8, 28, 21));
        jlb_subtitle2.setText("Porcentaje de trabajos terminados");

        javax.swing.GroupLayout panelShadowCard3Layout = new javax.swing.GroupLayout(panelShadowCard3);
        panelShadowCard3.setLayout(panelShadowCard3Layout);
        panelShadowCard3Layout.setHorizontalGroup(
            panelShadowCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowCard3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        panelShadowCard3Layout.setVerticalGroup(
            panelShadowCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadowCard3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(lineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jlb_subtitle3.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jlb_subtitle3.setForeground(new java.awt.Color(8, 28, 21));
        jlb_subtitle3.setText("Beneficiarios Registrados durante los ultimos meses");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadowCard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jlb_subtitle1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelShadowCard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_subtitle2)
                                    .addComponent(jlb_subtitle3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(51, 51, 51))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadowCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadowCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlb_subtitle1)
                .addGap(18, 18, 18)
                .addComponent(panelShadowCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jlb_subtitle2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadowCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadowCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_subtitle3)
                .addGap(18, 18, 18)
                .addComponent(panelShadowCard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        scroll.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
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
     * Updates the dashboard texts with the provided translations.
     *
     * @param texts DTO with the translated dashboard texts
     */
    public void updateLanguage(DTODashboardText texts) {
        jlb_subtitle1.setText(texts.getTotalRegisters());
        beneficiaries = texts.getBeneficiaries();
        beneficiariesDesc = texts.getBeneficiariesDesc();
        properties = texts.getProperties();
        propertiesDesc = texts.getPropertiesDesc();
        resolutions = texts.getResolutions();
        resolutionsDesc = texts.getResolutionsDesc();
        jlb_subtitle2.setText(texts.getPercentWorks());
        jlb_beneficiaries.setText(texts.getBeneficiaries());
        jlb_properties.setText(texts.getProperties());
        jlb_withPropertyText.setText(texts.getWithProperty());
        jlb_withoutPropertyText.setText(texts.getWithoutProperty());
        jlb_withResolutionText.setText(texts.getWithResolution());
        jlb_withoutResolutionText.setText(texts.getWithoutResolution());
        jlb_totalBenenficiariesText.setText(texts.getTotal());
        jlb_totalPropertiesText.setText(texts.getTotal());
        jlb_subtitle3.setText(texts.getRegistersMonth());
    }

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlb_beneficiaries;
    private javax.swing.JLabel jlb_properties;
    private javax.swing.JLabel jlb_subtitle1;
    private javax.swing.JLabel jlb_subtitle2;
    private javax.swing.JLabel jlb_subtitle3;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JLabel jlb_totalBeneficiaries;
    private javax.swing.JLabel jlb_totalBenenficiariesText;
    private javax.swing.JLabel jlb_totalProperties;
    private javax.swing.JLabel jlb_totalPropertiesText;
    private javax.swing.JLabel jlb_withProperty;
    private javax.swing.JLabel jlb_withPropertyText;
    private javax.swing.JLabel jlb_withResolution;
    private javax.swing.JLabel jlb_withResolutionText;
    private javax.swing.JLabel jlb_withoutProperty;
    private javax.swing.JLabel jlb_withoutPropertyText;
    private javax.swing.JLabel jlb_withoutResolution;
    private javax.swing.JLabel jlb_withoutResolutionText;
    private com.hector.titulacionpredial.view.swing.chart.LineChart lineChart1;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard1;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard2;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard3;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadowCard panelShadowCard4;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
