package com.hector.titulacionpredial.view.content.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSeeResolutionsText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.panel.RoundedPanel;

/**
 * Panel para la visualización de resoluciones registradas
 * en formato de tabla.
 *
 * <p>
 * Permite buscar y modificar resoluciones existentes.
 * Muestra información como número de resolución, código
 * de predio, FMI, fechas de notificación y ejecutoria.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SeeResolutions extends javax.swing.JPanel {

    private String code = "Código";
    private String number = "Num. Resolución";
    private String notification = "Notificación";
    private String executory = "Ejecutora";
    private String notary = "Notaria";
    private String fmi = "FMI";
    private String act = "Acto";
    private String publicWriting = "Esc. Pública";

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Crea el panel de consulta de resoluciones y configura la tabla.
     */
    public SeeResolutions() {
        initComponents();
        
        String[] titles = {code, number, notification, executory, notary, fmi, act, publicWriting};
        model.setColumnIdentifiers(titles);
        jtbl_resolutions.setModel(model);
        
        JTableHeader header = jtbl_resolutions.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);
        btn_searchCancel.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_resolutions = new javax.swing.JTable();
        jlb_title = new javax.swing.JLabel();
        roundedPanel3 = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_searchCancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_modify = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setBackground(new java.awt.Color(255, 255, 255));

        jtbl_resolutions.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jtbl_resolutions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbl_resolutions);

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Resoluciones");

        roundedPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel3.setBorderColor(new java.awt.Color(116, 198, 157));

        txt_search.setBackground(new java.awt.Color(255, 255, 255));
        txt_search.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_search.setForeground(new java.awt.Color(64, 145, 108));
        txt_search.setText("Buscar");
        txt_search.setBorder(null);

        btn_search.setBackground(new java.awt.Color(255, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_searchCancel.setBackground(new java.awt.Color(255, 255, 255));
        btn_searchCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/x.png"))); // NOI18N
        btn_searchCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_searchCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_modify.setBackground(new java.awt.Color(64, 145, 108));
        btn_modify.setForeground(new java.awt.Color(255, 255, 255));
        btn_modify.setText("Modificar");
        btn_modify.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_modify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addGap(26, 26, 26)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actualiza los textos del panel según el idioma seleccionado.
     *
     * @param texts DTO con los textos traducidos
     */
    public void updateLanguage(DTOSeeResolutionsText texts) {
        jlb_title.setText(texts.getTitle());
        code = texts.getCode();
        number = texts.getNumber();
        notification = texts.getNotification();
        executory = texts.getExecutory();
        notary = texts.getNotary();
        fmi = texts.getFmi();
        act = texts.getAct();
        publicWriting = texts.getPublicWriting();
        txt_search.setText(texts.getSearch());
        btn_modify.setText(texts.getModifyBtn());

        jtbl_resolutions.getColumnModel().getColumn(0).setHeaderValue(code);
        jtbl_resolutions.getColumnModel().getColumn(1).setHeaderValue(number);
        jtbl_resolutions.getColumnModel().getColumn(2).setHeaderValue(notification);
        jtbl_resolutions.getColumnModel().getColumn(3).setHeaderValue(executory);
        jtbl_resolutions.getColumnModel().getColumn(4).setHeaderValue(notary);
        jtbl_resolutions.getColumnModel().getColumn(5).setHeaderValue(fmi);
        jtbl_resolutions.getColumnModel().getColumn(6).setHeaderValue(act);
        jtbl_resolutions.getColumnModel().getColumn(7).setHeaderValue(publicWriting);
        jtbl_resolutions.getTableHeader().repaint();
    }

    /**
     * Asigna el listener para el botón de modificar.
     *
     * @param action listener del botón
     */
    public void setControllerModify(ActionListener action) {
        btn_modify.addActionListener(action);
    }

    /**
     * Asigna el listener para el botón de buscar.
     *
     * @param action listener del botón
     */
    public void setControllerSearch(ActionListener action) {
        btn_search.addActionListener(action);
    }

    /**
     * Asigna el listener para cancelar búsqueda.
     *
     * @param action listener del botón
     */
    public void setControllerSearchCancel(ActionListener action) {
        btn_searchCancel.addActionListener(action);
    }

    /**
     * Asigna el listener de documento al campo de búsqueda.
     *
     * @param listen listener de cambios de documento
     */
    public void setControllerTxt_searchDocument(DocumentListener listen) {
        txt_search.getDocument().addDocumentListener(listen);
    }

    /**
     * Asigna el listener de mouse al campo de búsqueda.
     *
     * @param listen listener de mouse
     */
    public void setControllerTxt_searchMouseListener(MouseListener listen) {
        txt_search.addMouseListener(listen);
    }

    /**
     * Asigna el listener de foco al campo de búsqueda.
     *
     * @param listen listener de foco
     */
    public void setControllerTxt_searchFocus(FocusListener listen) {
        txt_search.addFocusListener(listen);
    }

    /**
     * Obtiene el modelo de datos de la tabla de resoluciones.
     *
     * @return componente {@link DefaultTableModel}
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * Obtiene el componente botón de modificar.
     *
     * @return componente {@link ButtonAction}
     */
    public ButtonAction getBtn_modify() {
        return btn_modify;
    }

    /**
     * Obtiene el componente botón de buscar.
     *
     * @return componente {@link ButtonAction}
     */
    public ButtonAction getBtn_search() {
        return btn_search;
    }

    /**
     * Obtiene el componente botón de cancelar búsqueda.
     *
     * @return componente {@link ButtonAction}
     */
    public ButtonAction getBtn_searchCancel() {
        return btn_searchCancel;
    }

    /**
     * Obtiene el componente tabla de resoluciones.
     *
     * @return componente {@link JTable}
     */
    public JTable getJtbl_resolutions() {
        return jtbl_resolutions;
    }

    /**
     * Obtiene el componente panel redondeado de búsqueda.
     *
     * @return componente {@link RoundedPanel}
     */
    public RoundedPanel getRoundedPanel3() {
        return roundedPanel3;
    }

    /**
     * Obtiene el componente campo de texto de búsqueda.
     *
     * @return componente {@link JTextField}
     */
    public JTextField getTxt_search() {
        return txt_search;
    }

    /**
     * Carga una resolución en la tabla.
     *
     * @param dto datos de la resolución
     */
    public void loadData(DTOResolutionDetails dto) {
        int code = dto.getCode();
        long numResolution = dto.getResolutionNumber();
        LocalDate notification = dto.getNotification();
        LocalDate executory = dto.getExecutory();
        String notary = dto.getNotary();
        String fmi = dto.getFmi();
        String act = dto.getAct();
        String publicWriting = dto.getPublicWriting();

        Object[] data = new Object[]{code, numResolution, notification, executory, notary, fmi, act, publicWriting};
        model.addRow(data);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_modify;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchCancel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JTable jtbl_resolutions;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
