package com.hector.titulacionpredial.view.content.dialogs;

import com.hector.titulacionpredial.model.dto.DTOSpouse;
import java.awt.Color;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author hectoracevedo
 */
public class SpouseData extends javax.swing.JDialog {

    private boolean confirmed = false;
    private final Animator animator;
    private boolean show = true;

    public SpouseData(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        connectEvents();
        getContentPane().setBackground(Color.WHITE);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_lastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_expeditionLocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        btn_save = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_cancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(116, 198, 157), 1, true));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 28, 21));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos Del Conyuge");

        jLabel2.setBackground(new java.awt.Color(33, 37, 41));
        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 37, 41));
        jLabel2.setText("Nombre:");

        txt_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_name.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 37, 41));
        jLabel3.setText("Apellido:");

        txt_lastName.setBackground(new java.awt.Color(255, 255, 255));
        txt_lastName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_lastName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 37, 41));
        jLabel4.setText("Cedula:");

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 37, 41));
        jLabel5.setText("Lugar Expedicion:");

        txt_expeditionLocation.setBackground(new java.awt.Color(255, 255, 255));
        txt_expeditionLocation.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_expeditionLocation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel6.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 37, 41));
        jLabel6.setText("Direccion:");

        txt_address.setBackground(new java.awt.Color(255, 255, 255));
        txt_address.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_address.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel7.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 37, 41));
        jLabel7.setText("Telefono:");

        txt_phone.setBackground(new java.awt.Color(255, 255, 255));
        txt_phone.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_phone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                    .addComponent(txt_lastName)
                                    .addComponent(txt_id)
                                    .addComponent(txt_expeditionLocation)
                                    .addComponent(txt_address)
                                    .addComponent(txt_phone))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_expeditionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        
        show = false;
        animator.start();
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }

    public DTOSpouse getSpouse() {
        if (!confirmed) {
            return null;
        }

        return new DTOSpouse.Builder()
                .fullName(txt_name.getText().trim() + " " + txt_lastName.getText().trim())
                .id(Long.parseLong(txt_id.getText().trim()))
                .expeditionLocation(txt_expeditionLocation.getText().trim())
                .address(txt_address.getText().trim())
                .phone(Long.parseLong(txt_phone.getText().trim()))
                .build();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_cancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_expeditionLocation;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
