package com.hector.titulacionpredial.view.content.dialogs;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import java.awt.Color;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author hectoracevedo
 */
public class UserProfile extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;

    public UserProfile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        
        txa_affectation.setLineWrap(true);
        txa_affectation.setWrapStyleWord(true);
        txa_crossing.setLineWrap(true);
        txa_crossing.setWrapStyleWord(true);
        
        connectEvents();
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (!show) {
                    setVisible(false);
                }
            }
        };
        
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlb_id = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlb_phone = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlb_address = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlb_department = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlb_municipality = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlb_expeditionLocation = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlb_maritalStatus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jlb_cadastralRef = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_crossing = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txa_affectation = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_spouseName = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jlb_spouseId = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jlb_spouseExpeditionSite = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jlb_spouseAddress = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jlb_phoneSpouse = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jlb_neighborhood = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jlb_publication = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlb_code = new javax.swing.JLabel();
        jlb_name = new javax.swing.JLabel();
        btn_exit = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 37, 41));
        jLabel3.setText("Cedula");

        jlb_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_id.setForeground(new java.awt.Color(33, 37, 41));
        jlb_id.setText("1066726477");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 37, 41));
        jLabel7.setText("Telefono");

        jlb_phone.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_phone.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phone.setText("3137762626");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 37, 41));
        jLabel14.setText("Direccion");

        jlb_address.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_address.setForeground(new java.awt.Color(33, 37, 41));
        jlb_address.setText("Tr 24 16-25");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(33, 37, 41));
        jLabel16.setText("Departamento");

        jlb_department.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_department.setForeground(new java.awt.Color(33, 37, 41));
        jlb_department.setText("Cordoba");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(33, 37, 41));
        jLabel18.setText("Municipio");

        jlb_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_municipality.setForeground(new java.awt.Color(33, 37, 41));
        jlb_municipality.setText("Sahagun");

        jLabel13.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(33, 37, 41));
        jLabel13.setText("Datos de residencia");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(33, 37, 41));
        jLabel9.setText("Lugar de expedicion");

        jlb_expeditionLocation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_expeditionLocation.setForeground(new java.awt.Color(33, 37, 41));
        jlb_expeditionLocation.setText("Sahagun");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(33, 37, 41));
        jLabel11.setText("Estado Civil");

        jlb_maritalStatus.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_maritalStatus.setForeground(new java.awt.Color(33, 37, 41));
        jlb_maritalStatus.setText("Soltero");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(33, 37, 41));
        jLabel20.setText("Referencia Catastral");

        jlb_cadastralRef.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_cadastralRef.setForeground(new java.awt.Color(33, 37, 41));
        jlb_cadastralRef.setText("10093794739749379343434");

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(33, 37, 41));
        jLabel22.setText("Cruce");

        txa_crossing.setEditable(false);
        txa_crossing.setColumns(20);
        txa_crossing.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txa_crossing.setRows(5);
        jScrollPane2.setViewportView(txa_crossing);

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(33, 37, 41));
        jLabel23.setText("Afectacion");

        txa_affectation.setEditable(false);
        txa_affectation.setColumns(20);
        txa_affectation.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txa_affectation.setRows(5);
        jScrollPane3.setViewportView(txa_affectation);

        jLabel24.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(33, 37, 41));
        jLabel24.setText("Datos del conyuge");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(33, 37, 41));
        jLabel25.setText("Nombre:");

        txt_spouseName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_spouseName.setForeground(new java.awt.Color(33, 37, 41));
        txt_spouseName.setText("No aplica");

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(33, 37, 41));
        jLabel27.setText("Cedula:");

        jlb_spouseId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseId.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseId.setText("No aplica");

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(33, 37, 41));
        jLabel29.setText("Lugar de expedicion:");

        jlb_spouseExpeditionSite.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseExpeditionSite.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseExpeditionSite.setText("No aplica");

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(33, 37, 41));
        jLabel31.setText("Direccion:");

        jlb_spouseAddress.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseAddress.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseAddress.setText("No aplica");

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(33, 37, 41));
        jLabel33.setText("Telefono:");

        jlb_phoneSpouse.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_phoneSpouse.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phoneSpouse.setText("No aplica");

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(33, 37, 41));
        jLabel35.setText("Barrio");

        jlb_neighborhood.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_neighborhood.setForeground(new java.awt.Color(33, 37, 41));
        jlb_neighborhood.setText("Andres Rodriguez");

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(33, 37, 41));
        jLabel37.setText("Publicacion");

        jlb_publication.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_publication.setForeground(new java.awt.Color(33, 37, 41));
        jlb_publication.setText("#ND");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_expeditionLocation)))
                                .addGap(261, 261, 261)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_maritalStatus))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_id)))
                                .addGap(261, 261, 261)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_phone))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel35)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_address)
                                            .addComponent(jlb_neighborhood))))
                                .addGap(153, 153, 153)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_department)))
                                .addGap(156, 156, 156)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_municipality))
                                    .addComponent(jLabel18)))
                            .addComponent(jLabel13)
                            .addComponent(jLabel22)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_cadastralRef)))
                                .addGap(217, 217, 217)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_publication))
                                    .addComponent(jLabel37)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseExpeditionSite)
                                .addGap(154, 154, 154)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseAddress))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_spouseName)
                                .addGap(157, 157, 157)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseId))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_phoneSpouse)))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_id)
                    .addComponent(jlb_phone))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_expeditionLocation)
                    .addComponent(jlb_maritalStatus))
                .addGap(37, 37, 37)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_spouseName)
                    .addComponent(jLabel27)
                    .addComponent(jlb_spouseId))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jlb_spouseExpeditionSite)
                    .addComponent(jLabel31)
                    .addComponent(jlb_spouseAddress))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jlb_phoneSpouse))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_address)
                    .addComponent(jlb_department)
                    .addComponent(jlb_municipality))
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_neighborhood)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_cadastralRef)
                    .addComponent(jlb_publication))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        scroll.setViewportView(jPanel2);

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 28, 21));
        jLabel1.setText("Perfil del Beneficiario");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 37, 41));
        jLabel5.setText("Codigo:");

        jlb_code.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_code.setForeground(new java.awt.Color(33, 37, 41));
        jlb_code.setText("F3000");

        jlb_name.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_name.setForeground(new java.awt.Color(33, 37, 41));
        jlb_name.setText("Hector Luis Acevedo Contreras");

        btn_exit.setBackground(new java.awt.Color(64, 145, 108));
        btn_exit.setText("Cerrar");
        btn_exit.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jlb_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_code)
                        .addGap(181, 181, 181)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlb_code)
                    .addComponent(jlb_name))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectEvents() {
        btn_exit.addActionListener(e -> {
            dispose();
            closeMenu();
        });
    }
    
    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        
        show = false;
        animator.start();
    }
    
    public void loadBeneficiary(DTOBeneficiaryDetails beneficiary) {
        jlb_name.setText(beneficiary.getFullName());
        jlb_code.setText("F" + beneficiary.getCode());
        jlb_id.setText(String.valueOf(beneficiary.getId()));
        jlb_phone.setText(String.valueOf(beneficiary.getPhone()));
        jlb_expeditionLocation.setText(beneficiary.getExpeditionLocation());
        jlb_maritalStatus.setText(beneficiary.getMaritalStatus().name());
        jlb_address.setText(beneficiary.getAddress());
        jlb_department.setText(beneficiary.getDepartment().name());
        jlb_municipality.setText(beneficiary.getMunicipality().name());
        jlb_neighborhood.setText(beneficiary.getNeighborhood());
        jlb_cadastralRef.setText(String.valueOf(beneficiary.getCadastralReference()));
        jlb_publication.setText(beneficiary.getPublication());
        txa_crossing.setText(beneficiary.getCrossing());
        txa_affectation.setText(beneficiary.getAffectation());

        if (beneficiary.getFullNameSpouse() == null) {
            txt_spouseName.setText("No aplica");
            jlb_spouseId.setText("No aplica");
            jlb_spouseExpeditionSite.setText("No aplica");
            jlb_spouseAddress.setText("No aplica");
        } else {
            txt_spouseName.setText(beneficiary.getFullNameSpouse());
            jlb_spouseId.setText(String.valueOf(beneficiary.getIdSpouse()));
            jlb_spouseExpeditionSite.setText(beneficiary.getExpeditionLocationSpouse());
            jlb_spouseAddress.setText(beneficiary.getAddressSpouse());
            jlb_phoneSpouse.setText(String.valueOf(beneficiary.getPhoneSpouse()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlb_address;
    private javax.swing.JLabel jlb_cadastralRef;
    private javax.swing.JLabel jlb_code;
    private javax.swing.JLabel jlb_department;
    private javax.swing.JLabel jlb_expeditionLocation;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JLabel jlb_maritalStatus;
    private javax.swing.JLabel jlb_municipality;
    private javax.swing.JLabel jlb_name;
    private javax.swing.JLabel jlb_neighborhood;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JLabel jlb_phoneSpouse;
    private javax.swing.JLabel jlb_publication;
    private javax.swing.JLabel jlb_spouseAddress;
    private javax.swing.JLabel jlb_spouseExpeditionSite;
    private javax.swing.JLabel jlb_spouseId;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea txa_affectation;
    private javax.swing.JTextArea txa_crossing;
    private javax.swing.JLabel txt_spouseName;
    // End of variables declaration//GEN-END:variables
}
