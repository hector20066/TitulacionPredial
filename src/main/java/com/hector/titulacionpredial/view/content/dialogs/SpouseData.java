package com.hector.titulacionpredial.view.content.dialogs;

import java.awt.Color;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dto.DTOSpouseController;

/**
 * Modal dialog for registering spouse's data of a beneficiary.
 *
 * <p>
 * It is shown when the beneficiary's marital status
 * It is «married», allowing you to enter first and last
 * name. and spouse's ID. Includes entrance animation.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SpouseData extends javax.swing.JDialog {

    private boolean confirmed = false;
    private final Animator animator;
    private boolean show = true;

    private final LanguageManager lang = LanguageManager.getInstance();
    private int idBeneficiary;

    /**
     * Creates a new dialog to register spouse's data.
     *
     * <p>
     * Initializes the graphical components, connects the button
     * events, and configures the opacity animation.
     * </p>
     *
     * @param parent dialog parent window
     * @param modal  {@code true} to lock the parent
     *                           window while it is displayed
     */
    public SpouseData(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        connectEvents();
        getContentPane().setBackground(Color.WHITE);
        
        TimingTarget target = new TimingTargetAdapter() {
            /**
             * Timing event handler for animation progress.
             *
             * @param fraction the animation progress fraction (0.0 to 1.0)
             */
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            /**
             * Animation end handler.
             */
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

    /**     * set id beneficiary.     * @param idBeneficiary the id beneficiary     */
    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    /**     * get id beneficiary.     * @return the get id beneficiary     */
    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        jlb_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jlb_lastName = new javax.swing.JLabel();
        txt_lastName = new javax.swing.JTextField();
        jlb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jlb_expeditionLocation = new javax.swing.JLabel();
        txt_expeditionLocation = new javax.swing.JTextField();
        jlb_phone = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        btn_save = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_cancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(116, 198, 157), 1, true));

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_title.setText("Datos Del Conyuge");

        jlb_name.setBackground(new java.awt.Color(33, 37, 41));
        jlb_name.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_name.setForeground(new java.awt.Color(33, 37, 41));
        jlb_name.setText("Nombre:");

        txt_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_name.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_lastName.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_lastName.setForeground(new java.awt.Color(33, 37, 41));
        jlb_lastName.setText("Apellido:");

        txt_lastName.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_id.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_id.setForeground(new java.awt.Color(33, 37, 41));
        jlb_id.setText("Cedula:");

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_expeditionLocation.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_expeditionLocation.setForeground(new java.awt.Color(33, 37, 41));
        jlb_expeditionLocation.setText("Lugar Expedicion:");

        txt_expeditionLocation.setBackground(new java.awt.Color(255, 255, 255));
        txt_expeditionLocation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jlb_phone.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_phone.setForeground(new java.awt.Color(33, 37, 41));
        jlb_phone.setText("Telefono:");

        txt_phone.setBackground(new java.awt.Color(255, 255, 255));
        txt_phone.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        btn_save.setBackground(new java.awt.Color(64, 145, 108));
        btn_save.setText("Guardar");
        btn_save.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btn_save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_cancel.setBackground(new java.awt.Color(149, 213, 178));
        btn_cancel.setForeground(new java.awt.Color(5, 31, 32));
        btn_cancel.setText("Cancelar");
        btn_cancel.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btn_cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_phone)
                            .addComponent(jlb_expeditionLocation)
                            .addComponent(jlb_name)
                            .addComponent(jlb_lastName)
                            .addComponent(jlb_id)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_expeditionLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                    .addComponent(txt_id, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_lastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_phone))))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_lastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlb_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jlb_expeditionLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_expeditionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jlb_phone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Update the «SpouseData» texts with the provided translations.
     */
    public void updateLanguage() {
        jlb_title.setText(lang.app("spouse.data.title"));
        jlb_name.setText(lang.app("spouse.data.name"));
        jlb_lastName.setText(lang.app("spouse.data.lastname"));
        jlb_id.setText(lang.app("spouse.data.id"));
        jlb_expeditionLocation.setText(lang.app("spouse.data.expeditionLocation"));
        jlb_phone.setText(lang.app("spouse.data.phone"));
        btn_save.setText(lang.app("spouse.data.save.btn"));
        btn_cancel.setText(lang.app("spouse.data.cancel.btn"));
    }

    /**
     * Connects the events of the save and cancel buttons.
     *
     * <p>
     * When saving, it's marked as confirmed; when canceling,
     * it's discarded.
     * </p>
     */
    private void connectEvents() {
        btn_save.addActionListener(e -> {
            confirmed = true;
            closeMenu();
            dispose();
        });

        btn_cancel.addActionListener(e -> {
            confirmed = false;
            closeMenu();
            dispose();
        });
    }

    /**
     * Closes the dialogue with a fade-out animation.
     *
     * <p>
     * Stops any ongoing animation before starting the
     * closing animation.
     * </p>
     */
    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        
        show = false;
        animator.start();
    }

    /**
     * Indicates whether the user confirmed the spouse's registration.
     *
     * @return {@code true} if save was pressed,
     *         {@code false} if it was canceled
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Construye y devuelve el DTO del cónyuge con los datos ingresados.
     *
     * @return instancia de {@link DTOSpouseController} con los datos del formulario,
     *         o {@code null} si el diálogo no fue confirmado
     */
    public DTOSpouseController getSpouse() {
        if (!confirmed) {
            return null;
        }

        return new DTOSpouseController.Builder()
                .fullName(txt_name.getText().trim() + " " + txt_lastName.getText().trim())
                .id(Long.parseLong(txt_id.getText().trim()))
                .expeditionLocation(txt_expeditionLocation.getText().trim())
                .phone(Long.parseLong(txt_phone.getText().trim()))
                .beneficiaryCode(getIdBeneficiary())
                .build();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_cancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_save;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb_expeditionLocation;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JLabel jlb_lastName;
    private javax.swing.JLabel jlb_name;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JTextField txt_expeditionLocation;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
