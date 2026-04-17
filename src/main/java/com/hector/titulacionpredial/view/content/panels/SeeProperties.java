package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSeePropertiesText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.panel.RoundedPanel;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;

/**
 * Panel for viewing registered properties in table format with 30 columns.
 *
 * <p>
 * Displays detailed information for each property, including its geographic
 * coordinates (up to 4 points), cadastral data and municipality. Allows
 * searching, creating, deleting, and exporting properties.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SeeProperties extends JPanel {

    private String code = "Código";
    private String name = "Nombre";
    private String id = "Cédula";
    private String numResolution = "N. Resolución";
    private String notification = "Notificación";
    private String executory = "Ejecutoria";
    private String fmi = "FMI";
    private String act = "Acto";
    private String publicWriting = "Esc. Publica";
    private String notary = "Notaria";
    private String cadastralRef = "Ref. Catastral";
    private String address = "Dirección";
    private String municipality = "Municipio";
    private String codeBeneficiaries = "Código Beneficiarios";

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Create the property query panel and configure the table.
     */
    public SeeProperties() {
        initComponents();
        
        String[] titles = {code, codeBeneficiaries, name, id, numResolution, notification,
                executory, fmi, act, publicWriting, notary, cadastralRef, address, municipality,
                "MCORE1", "MCORN1", "MDISN", "MCOLN", "MCORE2", "MCORN2", "MDISE", "MCOLE", "MCORE3", "MCORN3", "MDISS",
                "MCOLS", "MCORE4", "MCORN4", "MDISO", "MLINDO", "AMAT"};

        model.setColumnIdentifiers(titles);
        jtbl_properties.setModel(model);
        
        JTableHeader header = jtbl_properties.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);

        jscp_scrollContent.getHorizontalScrollBar().setUnitIncrement(15);
        btn_searchCancel.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roundedPanel3 = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_searchCancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        jlb_title = new javax.swing.JLabel();
        jscp_scrollContent = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_properties = new javax.swing.JTable();
        btn_generate = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_delete = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_exportToExcel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
                .addGap(8, 8, 8)
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
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
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_search)
                    .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Predios");

        jscp_scrollContent.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jtbl_properties.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 3568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        jscp_scrollContent.setViewportView(jPanel2);

        btn_generate.setBackground(new java.awt.Color(64, 145, 108));
        btn_generate.setForeground(new java.awt.Color(255, 255, 255));
        btn_generate.setText("Generar Resolucion");
        btn_generate.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_generate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_delete.setBackground(new java.awt.Color(149, 213, 178));
        btn_delete.setForeground(new java.awt.Color(5, 31, 32));
        btn_delete.setText("Eliminar");
        btn_delete.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_exportToExcel.setBackground(new java.awt.Color(64, 145, 108));
        btn_exportToExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportToExcel.setText("Exportar a Excel");
        btn_exportToExcel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_exportToExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jscp_scrollContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_exportToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roundedPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jscp_scrollContent, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
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

    /**

     * Updates the panel text according to the selected language.
     *
     * @param texts DTO with the translated text
     */
    public void updateLanguage(DTOSeePropertiesText texts) {
        jlb_title.setText(texts.getProperties());
        code = texts.getCode();
        codeBeneficiaries = texts.getCodeBeneficiaries();
        name = texts.getName();
        id = texts.getId();
        numResolution = texts.getNumResolution();
        notification = texts.getNotify();
        executory = texts.getExecutory();
        fmi = texts.getFmi();
        act = texts.getAct();
        publicWriting = texts.getPublicWriting();
        notary = texts.getNotary();
        cadastralRef = texts.getCadastralRef();
        address = texts.getAddress();
        municipality = texts.getMunicipality();
        txt_search.setText(texts.getSearch());
        btn_generate.setText(texts.getGenerateBtn());
        btn_exportToExcel.setText(texts.getExportExcelBtn());
        btn_delete.setText(texts.getDeleteBtn());

        jtbl_properties.getColumnModel().getColumn(0).setHeaderValue(code);
        jtbl_properties.getColumnModel().getColumn(1).setHeaderValue(codeBeneficiaries);
        jtbl_properties.getColumnModel().getColumn(2).setHeaderValue(name);
        jtbl_properties.getColumnModel().getColumn(3).setHeaderValue(id);
        jtbl_properties.getColumnModel().getColumn(4).setHeaderValue(numResolution);
        jtbl_properties.getColumnModel().getColumn(5).setHeaderValue(notification);
        jtbl_properties.getColumnModel().getColumn(6).setHeaderValue(executory);
        jtbl_properties.getColumnModel().getColumn(7).setHeaderValue(fmi);
        jtbl_properties.getColumnModel().getColumn(8).setHeaderValue(act);
        jtbl_properties.getColumnModel().getColumn(9).setHeaderValue(publicWriting);
        jtbl_properties.getColumnModel().getColumn(10).setHeaderValue(notary);
        jtbl_properties.getColumnModel().getColumn(11).setHeaderValue(cadastralRef);
        jtbl_properties.getColumnModel().getColumn(12).setHeaderValue(address);
        jtbl_properties.getColumnModel().getColumn(13).setHeaderValue(municipality);
        jtbl_properties.getTableHeader().repaint();
    }

    public void setControllerGenerate(ActionListener action) {
        btn_generate.addActionListener(action);
    }

    public void setControllerExportToExcel(ActionListener action) {
        btn_exportToExcel.addActionListener(action);
    }

    public void setControllerDelete(ActionListener action) {
        btn_delete.addActionListener(action);
    }

    public void setControllerSearch(ActionListener action) {
        btn_search.addActionListener(action);
    }

    public void setControllerSearchCancel(ActionListener action) {
        btn_searchCancel.addActionListener(action);
    }

    public ButtonAction getBtn_searchCancel() {
        return btn_searchCancel;
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

    /**
     * Loads a property with all its data into the table.
     *
     * @param dto detailed property data
     */
    public void loadData(DTOPropertyDetails dto) {
        int propertyCode = dto.getPropertyCode();
        String codeBeneficiaries = dto.getCodeBeneficiaries();
        String beneficiariesName = dto.getBeneficiariesName();
        String addressBeneficiary = dto.getAddress();;
        Municipalities municipalities = dto.getMunicipality();
        String beneficiaryId = dto.getBeneficiariesIds();

        long resolutionNumber = dto.getNumResolution();
        LocalDate notification = dto.getNotification();
        LocalDate executory = dto.getExecutory();
        String fmi = dto.getFmi();
        String act = dto.getAct();
        String publicWriting = dto.getPublicWriting();
        String notary = dto.getNotary();
        String cadastralReference = dto.getCadastralRef();
        double area = dto.getArea();

        String northCoordinate1 = "";
        String eastCoordinate1 = "";
        double distance1 = 0;
        String hillside1 = "";

        String northCoordinate2 = "";
        String eastCoordinate2 = "";
        double distance2 = 0;
        String hillside2 = "";

        String northCoordinate3 = "";
        String eastCoordinate3 = "";
        double distance3 = 0;
        String hillside3 = "";

        String northCoordinate4 = "";
        String eastCoordinate4 = "";
        double distance4 = 0;
        String hillside4 = "";

        for (DTOPoint point : dto.getPoints()) {
            switch(point.getNumberPoint()) {
                case 1 -> {
                    northCoordinate1 = point.getNorthCoordinate();
                    eastCoordinate1 = point.getEastCoordinate();
                    distance1 = point.getDistance();
                    hillside1 = point.getHillside();
                }
                case 2 -> {
                    northCoordinate2 = point.getNorthCoordinate();
                    eastCoordinate2 = point.getEastCoordinate();
                    distance2 = point.getDistance();
                    hillside2 = point.getHillside();
                }
                case 3 -> {
                    northCoordinate3 = point.getNorthCoordinate();
                    eastCoordinate3 = point.getEastCoordinate();
                    distance3 = point.getDistance();
                    hillside3 = point.getHillside();
                }
                case 4 -> {
                    northCoordinate4 = point.getNorthCoordinate();
                    eastCoordinate4 = point.getEastCoordinate();
                    distance4 = point.getDistance();
                    hillside4 = point.getHillside();
                }
            }
        }

        Object[] addData = new Object[]{propertyCode, codeBeneficiaries, beneficiariesName, beneficiaryId, resolutionNumber, notification,
                executory, fmi, act, publicWriting, notary, cadastralReference, addressBeneficiary, municipalities,
                eastCoordinate1, northCoordinate1, distance1, hillside1, eastCoordinate2, northCoordinate2, distance2,
                hillside2, eastCoordinate3, northCoordinate3, distance3, hillside3, eastCoordinate4, northCoordinate4,
                distance4, hillside4, area};

        model.addRow(addData);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_delete;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_exportToExcel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_generate;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchCancel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JScrollPane jscp_scrollContent;
    private javax.swing.JTable jtbl_properties;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
