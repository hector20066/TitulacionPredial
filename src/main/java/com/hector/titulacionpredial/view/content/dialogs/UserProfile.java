package com.hector.titulacionpredial.view.content.dialogs;

import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.view.i18n.dto.dialogs.DTOUserProfileText;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import java.awt.*;

/**
 * Diálogo modal para visualizar el perfil detallado
 * de un beneficiario.
 *
 * <p>
 * Muestra la información personal del beneficiario en un
 * diálogo animado con transición de entrada y salida
 * utilizando la librería TimingFramework.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class UserProfile extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;

    private LanguageManager lang =  LanguageManager.getInstance();

    /**
     * Crea un nuevo diálogo para visualizar el perfil de un beneficiario.
     *
     * <p>Inicializa los componentes gráficos, configura el scroll,
     * habilita el ajuste de línea en las áreas de texto y establece
     * la animación de opacidad.</p>
     *
     * @param parent ventana padre del diálogo
     * @param modal  {@code true} para bloquear la ventana padre mientras se muestra
     */
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
        jlb_idText = new javax.swing.JLabel();
        jlb_id = new javax.swing.JLabel();
        jlb_phoneText = new javax.swing.JLabel();
        jlb_phone = new javax.swing.JLabel();
        jlb_addressText = new javax.swing.JLabel();
        jlb_address = new javax.swing.JLabel();
        jlb_departmentText = new javax.swing.JLabel();
        jlb_department = new javax.swing.JLabel();
        jlb_municipalityText = new javax.swing.JLabel();
        jlb_municipality = new javax.swing.JLabel();
        jlb_residenceData = new javax.swing.JLabel();
        jlb_expeditionText = new javax.swing.JLabel();
        jlb_expeditionLocation = new javax.swing.JLabel();
        jlb_maritalStatusText = new javax.swing.JLabel();
        jlb_maritalStatus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlb_cadastralRefText = new javax.swing.JLabel();
        jlb_cadastralRef = new javax.swing.JLabel();
        jlb_crossingText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_crossing = new javax.swing.JTextArea();
        jlb_affectationText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txa_affectation = new javax.swing.JTextArea();
        jlb_spouseData = new javax.swing.JLabel();
        jlb_spouseNameText = new javax.swing.JLabel();
        jlb_spouseName = new javax.swing.JLabel();
        jlb_spouseIdText = new javax.swing.JLabel();
        jlb_spouseId = new javax.swing.JLabel();
        jlb_spouseExpeditionText = new javax.swing.JLabel();
        jlb_spouseExpeditionSite = new javax.swing.JLabel();
        jlb_spouseAddressText = new javax.swing.JLabel();
        jlb_spouseAddress = new javax.swing.JLabel();
        jlb_spousePhoneText = new javax.swing.JLabel();
        jlb_phoneSpouse = new javax.swing.JLabel();
        jlb_neighborhoodText = new javax.swing.JLabel();
        jlb_neighborhood = new javax.swing.JLabel();
        jlb_publicationText = new javax.swing.JLabel();
        jlb_publication = new javax.swing.JLabel();
        jlb_title = new javax.swing.JLabel();
        jlb_codeText = new javax.swing.JLabel();
        jlb_code = new javax.swing.JLabel();
        jlb_name = new javax.swing.JLabel();
        btn_exit = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(116, 198, 157), 1, true));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlb_idText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_idText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_idText.setText("Cedula");

        jlb_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_id.setForeground(new java.awt.Color(33, 37, 41));
        jlb_id.setText("1066726477");

        jlb_phoneText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_phoneText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phoneText.setText("Telefono");

        jlb_phone.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_phone.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phone.setText("3137762626");

        jlb_addressText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_addressText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_addressText.setText("Direccion");

        jlb_address.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_address.setForeground(new java.awt.Color(33, 37, 41));
        jlb_address.setText("Tr 24 16-25");

        jlb_departmentText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_departmentText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_departmentText.setText("Departamento");

        jlb_department.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_department.setForeground(new java.awt.Color(33, 37, 41));
        jlb_department.setText("Cordoba");

        jlb_municipalityText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_municipalityText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_municipalityText.setText("Municipio");

        jlb_municipality.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_municipality.setForeground(new java.awt.Color(33, 37, 41));
        jlb_municipality.setText("Sahagun");

        jlb_residenceData.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_residenceData.setForeground(new java.awt.Color(33, 37, 41));
        jlb_residenceData.setText("Datos de residencia");

        jlb_expeditionText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_expeditionText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_expeditionText.setText("Lugar de expedicion");

        jlb_expeditionLocation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_expeditionLocation.setForeground(new java.awt.Color(33, 37, 41));
        jlb_expeditionLocation.setText("Sahagun");

        jlb_maritalStatusText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_maritalStatusText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_maritalStatusText.setText("Estado Civil");

        jlb_maritalStatus.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_maritalStatus.setForeground(new java.awt.Color(33, 37, 41));
        jlb_maritalStatus.setText("Soltero");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jlb_cadastralRefText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_cadastralRefText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_cadastralRefText.setText("Referencia Catastral");

        jlb_cadastralRef.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_cadastralRef.setForeground(new java.awt.Color(33, 37, 41));
        jlb_cadastralRef.setText("10093794739749379343434");

        jlb_crossingText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_crossingText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_crossingText.setText("Cruce");

        txa_crossing.setEditable(false);
        txa_crossing.setColumns(20);
        txa_crossing.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txa_crossing.setRows(5);
        jScrollPane2.setViewportView(txa_crossing);

        jlb_affectationText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_affectationText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_affectationText.setText("Afectacion");

        txa_affectation.setEditable(false);
        txa_affectation.setColumns(20);
        txa_affectation.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txa_affectation.setRows(5);
        jScrollPane3.setViewportView(txa_affectation);

        jlb_spouseData.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_spouseData.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseData.setText("Datos del conyuge");

        jlb_spouseNameText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_spouseNameText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseNameText.setText("Nombre:");

        jlb_spouseName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseName.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseName.setText("No aplica");

        jlb_spouseIdText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_spouseIdText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseIdText.setText("Cedula:");

        jlb_spouseId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseId.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseId.setText("No aplica");

        jlb_spouseExpeditionText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_spouseExpeditionText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseExpeditionText.setText("Lugar de expedicion:");

        jlb_spouseExpeditionSite.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseExpeditionSite.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseExpeditionSite.setText("No aplica");

        jlb_spouseAddressText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_spouseAddressText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseAddressText.setText("Direccion:");

        jlb_spouseAddress.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_spouseAddress.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spouseAddress.setText("No aplica");

        jlb_spousePhoneText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_spousePhoneText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_spousePhoneText.setText("Telefono:");

        jlb_phoneSpouse.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_phoneSpouse.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phoneSpouse.setText("No aplica");

        jlb_neighborhoodText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_neighborhoodText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_neighborhoodText.setText("Barrio");

        jlb_neighborhood.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlb_neighborhood.setForeground(new java.awt.Color(33, 37, 41));
        jlb_neighborhood.setText("Andres Rodriguez");

        jlb_publicationText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_publicationText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_publicationText.setText("Publicacion");

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
                                    .addComponent(jlb_expeditionText)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_expeditionLocation)))
                                .addGap(261, 261, 261)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_maritalStatusText)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_maritalStatus))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_idText)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_id)))
                                .addGap(261, 261, 261)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_phoneText)
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
                                    .addComponent(jlb_addressText)
                                    .addComponent(jlb_neighborhoodText)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_address)
                                            .addComponent(jlb_neighborhood))))
                                .addGap(153, 153, 153)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_departmentText)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_department)))
                                .addGap(156, 156, 156)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_municipality))
                                    .addComponent(jlb_municipalityText)))
                            .addComponent(jlb_residenceData)
                            .addComponent(jlb_crossingText)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlb_affectationText)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_cadastralRefText)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_cadastralRef)))
                                .addGap(217, 217, 217)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlb_publication))
                                    .addComponent(jlb_publicationText)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_spouseData))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlb_spouseExpeditionText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseExpeditionSite)
                                .addGap(154, 154, 154)
                                .addComponent(jlb_spouseAddressText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseAddress))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlb_spouseNameText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseName)
                                .addGap(157, 157, 157)
                                .addComponent(jlb_spouseIdText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_spouseId))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlb_spousePhoneText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_phoneSpouse)))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_idText)
                    .addComponent(jlb_phoneText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_id)
                    .addComponent(jlb_phone))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_expeditionText)
                    .addComponent(jlb_maritalStatusText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_expeditionLocation)
                    .addComponent(jlb_maritalStatus))
                .addGap(37, 37, 37)
                .addComponent(jlb_spouseData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_spouseNameText)
                    .addComponent(jlb_spouseName)
                    .addComponent(jlb_spouseIdText)
                    .addComponent(jlb_spouseId))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_spouseExpeditionText)
                    .addComponent(jlb_spouseExpeditionSite)
                    .addComponent(jlb_spouseAddressText)
                    .addComponent(jlb_spouseAddress))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_spousePhoneText)
                    .addComponent(jlb_phoneSpouse))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jlb_residenceData)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_addressText)
                    .addComponent(jlb_departmentText)
                    .addComponent(jlb_municipalityText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_address)
                    .addComponent(jlb_department)
                    .addComponent(jlb_municipality))
                .addGap(18, 18, 18)
                .addComponent(jlb_neighborhoodText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_neighborhood)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_cadastralRefText)
                    .addComponent(jlb_publicationText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_cadastralRef)
                    .addComponent(jlb_publication))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_crossingText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jlb_affectationText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        scroll.setViewportView(jPanel2);

        jlb_title.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Perfil del Beneficiario");

        jlb_codeText.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jlb_codeText.setForeground(new java.awt.Color(33, 37, 41));
        jlb_codeText.setText("Codigo:");

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
                        .addComponent(jlb_title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jlb_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlb_codeText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_code)
                        .addGap(181, 181, 181)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_codeText)
                    .addComponent(jlb_code)
                    .addComponent(jlb_name))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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

    public void updateLanguage() {
        jlb_title.setText(lang.app("user.profile.title"));
        jlb_codeText.setText(lang.app("user.profile.code"));
        jlb_idText.setText(lang.app("user.profile.id"));
        jlb_phoneText.setText(lang.app("user.profile.phone"));
        jlb_addressText.setText(lang.app("user.profile.address"));
        jlb_departmentText.setText(lang.app("user.profile.department"));
        jlb_municipalityText.setText(lang.app("user.profile.municipality"));
        jlb_neighborhoodText.setText(lang.app("user.profile.neighborhood"));
        jlb_residenceData.setText(lang.app("user.profile.residence.data"));
        jlb_expeditionText.setText(lang.app("user.profile.expeditionLocation"));
        jlb_maritalStatusText.setText(lang.app("user.profile.maritalStatus"));
        jlb_cadastralRefText.setText(lang.app("user.profile.cadastralRef"));
        jlb_crossingText.setText(lang.app("user.profile.crossing"));
        jlb_affectationText.setText(lang.app("user.profile.affectation"));
        jlb_publicationText.setText(lang.app("user.profile.publication"));
        jlb_spouseData.setText(lang.app("user.profile.spouse.data"));
        jlb_spouseNameText.setText(lang.app("user.profile.spouse.name"));
        jlb_spouseIdText.setText(lang.app("user.profile.spouse.id"));
        jlb_spouseExpeditionText.setText(lang.app("user.profile.spouse.expeditionLocation"));
        jlb_spouseAddressText.setText(lang.app("user.profile.spouse.address"));
        jlb_spousePhoneText.setText(lang.app("user.profile.spouse.phone"));
        btn_exit.setText(lang.app("user.profile.exit.btn"));
    }

    /**
     * Conecta el evento del botón de salida para cerrar el diálogo.
     */
    private void connectEvents() {
        btn_exit.addActionListener(e -> {
            dispose();
            closeMenu();
        });
    }

    /**
     * Cierra el diálogo con una animación de desvanecimiento.
     *
     * <p>Detiene cualquier animación en curso antes de iniciar
     * la animación de cierre.</p>
     */
    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        
        show = false;
        animator.start();
    }
    
    /**
     * Carga los datos del beneficiario en los campos del diálogo.
     *
     * <p>Si el beneficiario no tiene cónyuge registrado, los campos
     * correspondientes mostrarán «No aplica».</p>
     *
     * @param beneficiary DTO con los datos completos del beneficiario a mostrar
     */
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
            jlb_spouseName.setText(lang.app("user.profile.not.apply"));
            jlb_spouseId.setText(lang.app("user.profile.not.apply"));
            jlb_spouseExpeditionSite.setText(lang.app("user.profile.not.apply"));
            jlb_spouseAddress.setText(lang.app("user.profile.not.apply"));
            jlb_phoneSpouse.setText(lang.app("user.profile.not.apply"));
        } else {
            jlb_spouseName.setText(beneficiary.getFullNameSpouse());
            jlb_spouseId.setText(String.valueOf(beneficiary.getIdSpouse()));
            jlb_spouseExpeditionSite.setText(beneficiary.getExpeditionLocationSpouse());
            jlb_spouseAddress.setText(beneficiary.getAddressSpouse());
            jlb_phoneSpouse.setText(String.valueOf(beneficiary.getPhoneSpouse()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlb_address;
    private javax.swing.JLabel jlb_addressText;
    private javax.swing.JLabel jlb_affectationText;
    private javax.swing.JLabel jlb_cadastralRef;
    private javax.swing.JLabel jlb_cadastralRefText;
    private javax.swing.JLabel jlb_code;
    private javax.swing.JLabel jlb_codeText;
    private javax.swing.JLabel jlb_crossingText;
    private javax.swing.JLabel jlb_department;
    private javax.swing.JLabel jlb_departmentText;
    private javax.swing.JLabel jlb_expeditionLocation;
    private javax.swing.JLabel jlb_expeditionText;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JLabel jlb_idText;
    private javax.swing.JLabel jlb_maritalStatus;
    private javax.swing.JLabel jlb_maritalStatusText;
    private javax.swing.JLabel jlb_municipality;
    private javax.swing.JLabel jlb_municipalityText;
    private javax.swing.JLabel jlb_name;
    private javax.swing.JLabel jlb_neighborhood;
    private javax.swing.JLabel jlb_neighborhoodText;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JLabel jlb_phoneSpouse;
    private javax.swing.JLabel jlb_phoneText;
    private javax.swing.JLabel jlb_publication;
    private javax.swing.JLabel jlb_publicationText;
    private javax.swing.JLabel jlb_residenceData;
    private javax.swing.JLabel jlb_spouseAddress;
    private javax.swing.JLabel jlb_spouseAddressText;
    private javax.swing.JLabel jlb_spouseData;
    private javax.swing.JLabel jlb_spouseExpeditionSite;
    private javax.swing.JLabel jlb_spouseExpeditionText;
    private javax.swing.JLabel jlb_spouseId;
    private javax.swing.JLabel jlb_spouseIdText;
    private javax.swing.JLabel jlb_spouseName;
    private javax.swing.JLabel jlb_spouseNameText;
    private javax.swing.JLabel jlb_spousePhoneText;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea txa_affectation;
    private javax.swing.JTextArea txa_crossing;
    // End of variables declaration//GEN-END:variables
}
