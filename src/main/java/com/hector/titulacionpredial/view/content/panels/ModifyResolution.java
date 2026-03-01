package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOModifyResolutionText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Formulario para la modificación de una resolución existente.
 *
 * <p>
 * Permite editar los campos de número de resolución,
 * notificación, ejecutoria, FMI, acta, escritura pública
 * y observaciones de una resolución previamente registrada.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModifyResolution extends javax.swing.JPanel {

    /**
     * Crea el formulario de modificación de resoluciones.
     */
    public ModifyResolution() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new com.hector.titulacionpredial.view.swing.panel.PanelShadow();
        jlb_title = new javax.swing.JLabel();
        jlb_code = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        jlb_numResolution = new javax.swing.JLabel();
        txt_numResolution = new javax.swing.JTextField();
        jlb_fmi = new javax.swing.JLabel();
        txt_fmi = new javax.swing.JTextField();
        jlb_act = new javax.swing.JLabel();
        txt_act = new javax.swing.JTextField();
        jlb_publicWriting = new javax.swing.JLabel();
        txt_publicWriting = new javax.swing.JTextField();
        jlb_notary = new javax.swing.JLabel();
        txt_note = new javax.swing.JTextField();
        btn_modify = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jlb_executory = new javax.swing.JLabel();
        jlb_notification = new javax.swing.JLabel();
        ftx_notification = new javax.swing.JFormattedTextField();
        ftx_executory = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setBackground(new java.awt.Color(255, 255, 255));
        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Modificar Resolucion");

        jlb_code.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_code.setForeground(new java.awt.Color(33, 37, 41));
        jlb_code.setText("Codigo:");

        txt_code.setBackground(new java.awt.Color(242, 246, 253));
        txt_code.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_code.setEnabled(false);

        jlb_numResolution.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_numResolution.setForeground(new java.awt.Color(33, 37, 41));
        jlb_numResolution.setText("Num. Resolucion:");

        txt_numResolution.setBackground(new java.awt.Color(242, 246, 253));
        txt_numResolution.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_numResolution.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_fmi.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_fmi.setForeground(new java.awt.Color(33, 37, 41));
        jlb_fmi.setText("FMI:");

        txt_fmi.setBackground(new java.awt.Color(242, 246, 253));
        txt_fmi.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_fmi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_act.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_act.setForeground(new java.awt.Color(33, 37, 41));
        jlb_act.setText("Acto:");

        txt_act.setBackground(new java.awt.Color(242, 246, 253));
        txt_act.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_act.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_publicWriting.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_publicWriting.setForeground(new java.awt.Color(33, 37, 41));
        jlb_publicWriting.setText("Esc. Publica:");

        txt_publicWriting.setBackground(new java.awt.Color(242, 246, 253));
        txt_publicWriting.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_publicWriting.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jlb_notary.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_notary.setForeground(new java.awt.Color(33, 37, 41));
        jlb_notary.setText("Notaria:");

        txt_note.setBackground(new java.awt.Color(242, 246, 253));
        txt_note.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txt_note.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        btn_modify.setBackground(new java.awt.Color(64, 145, 108));
        btn_modify.setForeground(new java.awt.Color(255, 255, 255));
        btn_modify.setText("Modificar Resolucion");
        btn_modify.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_modify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlb_executory.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_executory.setForeground(new java.awt.Color(33, 37, 41));
        jlb_executory.setText("Ejecutoria:");

        jlb_notification.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
        jlb_notification.setForeground(new java.awt.Color(33, 37, 41));
        jlb_notification.setText("Notificacion:");

        ftx_notification.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG))));
        ftx_notification.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        ftx_executory.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG))));
        ftx_executory.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlb_title))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_act)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jlb_notification)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftx_notification, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jlb_executory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftx_executory, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlb_publicWriting)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jlb_code)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jlb_numResolution)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_numResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jlb_fmi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fmi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlb_notary)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_note, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_publicWriting, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_act, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlb_title)
                .addGap(29, 29, 29)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_numResolution)
                    .addComponent(txt_numResolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_code)
                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_notification)
                    .addComponent(jlb_executory)
                    .addComponent(ftx_notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftx_executory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_fmi)
                    .addComponent(txt_fmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_act)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_publicWriting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_publicWriting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_notary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateLanguage(DTOModifyResolutionText texts) {
        jlb_title.setText(texts.getTitle());
        jlb_code.setText(texts.getCode());
        jlb_numResolution.setText(texts.getNumResolution());
        jlb_fmi.setText(texts.getFmi());
        jlb_act.setText(texts.getAct());
        jlb_publicWriting.setText(texts.getPublicWriting());
        jlb_notary.setText(texts.getNotary());
        jlb_executory.setText(texts.getExecutory());
        jlb_notification.setText(texts.getNotification());
        btn_modify.setText(texts.getModifyBtn());
    }

    /**
     * Asigna el listener para el botón de modificar.
     *
     * @param action listener del botón
     */
    public void setControllerModify(ActionListener action) {
        btn_modify.addActionListener(action);
    }

    public ButtonAction getBtn_modify() {
        return btn_modify;
    }

    public JTextField getTxt_act() {
        return txt_act;
    }

    public JTextField getTxt_code() {
        return txt_code;
    }

    public JTextField getTxt_fmi() {
        return txt_fmi;
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

    public JFormattedTextField getFtx_executory() {
        return ftx_executory;
    }

    public JFormattedTextField getFtx_notification() {
        return ftx_notification;
    }

    /**
     * Carga los datos de la resolución en el formulario.
     *
     * @param dto          datos de la resolución
     * @param notification fecha de notificación formateada
     * @param executory    fecha de ejecutoria formateada
     * @throws ParseException si las fechas no se pueden parsear
     */
    public void loadData(DTOResolutionDetails dto, String notification, String executory) throws ParseException {
        txt_code.setText(String.valueOf(dto.getCode()));
        txt_act.setText(dto.getAct());
        txt_fmi.setText(dto.getFmi());
        txt_note.setText(dto.getNotary());
        txt_numResolution.setText(String.valueOf(dto.getResolutionNumber()));
        txt_publicWriting.setText(dto.getPublicWriting());

        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));

        Date notifDate = sdf.parse(notification);
        Date execDate = sdf.parse(executory);

        ftx_notification.setValue(notifDate);
        ftx_executory.setValue(execDate);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_modify;
    private javax.swing.JFormattedTextField ftx_executory;
    private javax.swing.JFormattedTextField ftx_notification;
    private javax.swing.JLabel jlb_act;
    private javax.swing.JLabel jlb_code;
    private javax.swing.JLabel jlb_executory;
    private javax.swing.JLabel jlb_fmi;
    private javax.swing.JLabel jlb_notary;
    private javax.swing.JLabel jlb_notification;
    private javax.swing.JLabel jlb_numResolution;
    private javax.swing.JLabel jlb_publicWriting;
    private javax.swing.JLabel jlb_title;
    private com.hector.titulacionpredial.view.swing.panel.PanelShadow panelShadow1;
    private javax.swing.JTextField txt_act;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_fmi;
    private javax.swing.JTextField txt_note;
    private javax.swing.JTextField txt_numResolution;
    private javax.swing.JTextField txt_publicWriting;
    // End of variables declaration//GEN-END:variables
}
