package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.panel.RoundedPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hectoracevedo
 */
public class SeeProperties extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    
    public SeeProperties() {
        initComponents();
        
        String[] titles = {"Nombre", "Cedula", "N. Resolucion", "Notificacion", "Ejecutoria", "FMI", "Acto", "Esc. Publica", "Notaria", "Ref. Catastral", "Direccion", "Barrio", "MCORE1", "MCORN1", "MDISN", "MCOLN", "MCORE2", "MCORN2", "MDISE", "MCOLE", "MCORE3", "MCORN3", "MDISS", "MCOLS", "MCORE4", "MCORN4", "MDISO", "MLINDO", "AMAT"};
        model.setColumnIdentifiers(titles);
        jtbl_properties.setModel(model);
        
        JTableHeader header = jtbl_properties.getTableHeader();
        header.setBackground(new Color(187, 222, 251));
        header.setForeground(new Color(0, 18, 25));
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        jscp_scrollContent.getHorizontalScrollBar().setUnitIncrement(15);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roundedPanel3 = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jLabel1 = new javax.swing.JLabel();
        jscp_scrollContent = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_properties = new javax.swing.JTable();
        btn_generate = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_delete = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        roundedPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel3.setBorderColor(new java.awt.Color(102, 102, 102));

        txt_search.setBackground(new java.awt.Color(255, 255, 255));
        txt_search.setText("Buscar");
        txt_search.setBorder(null);

        btn_search.setBackground(new java.awt.Color(255, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Predios");

        jscp_scrollContent.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jtbl_properties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Cedula", "N. Resolucion", "Notificacion", "Ejecutoria", "FMI", "Acto", "Esc. Publica", "Notaria", "Ref. Catastral", "Direccion", "Barrio", "MCORE1", "MCORN1", "MDISN", "MCOLN", "MCORE2", "MCORN2", "MDISE", "MCOLE", "MCORE3", "MCORN3", "MDISS", "MCOLS", "MCORE4", "MCORN4", "MDISO", "MLINDO", "AMAT"
            }
        ));
        jScrollPane2.setViewportView(jtbl_properties);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 3339, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jscp_scrollContent.setViewportView(jPanel2);

        btn_generate.setText("Generar Resolucion");
        btn_generate.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_generate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_delete.setText("Eliminar");
        btn_delete.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jscp_scrollContent, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jscp_scrollContent, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setControllerGenerate(ActionListener action) {
        btn_generate.addActionListener(action);
    }
    
    public void setControllerDelete(ActionListener action) {
        btn_delete.addActionListener(action);
    }
    
    public void setControllerSearch(ActionListener action) {
        btn_search.addActionListener(action);
    }
    
    public void setControllerTxt_searchDocument(DocumentListener listen) {
        txt_search.getDocument().addDocumentListener(listen);
    }
    
    public void setControllerTxt_searchMouseListener(MouseListener listen) {
        txt_search.addMouseListener(listen);
    }
    
    public void setControllerTxt_searchFocus(FocusListener listen) {
        txt_search.addFocusListener(listen);
    }
    
    public DefaultTableModel getModel() {
        return model;
    }

    public ButtonAction getBtn_delete() {
        return btn_delete;
    }

    public ButtonAction getBtn_generate() {
        return btn_generate;
    }

    public ButtonAction getBtn_search() {
        return btn_search;
    }

    public JScrollPane getJscp_scrollContent() {
        return jscp_scrollContent;
    }

    public JTable getJtbl_properties() {
        return jtbl_properties;
    }

    public RoundedPanel getRoundedPanel3() {
        return roundedPanel3;
    }

    public JTextField getTxt_search() {
        return txt_search;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_delete;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_generate;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jscp_scrollContent;
    private javax.swing.JTable jtbl_properties;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
