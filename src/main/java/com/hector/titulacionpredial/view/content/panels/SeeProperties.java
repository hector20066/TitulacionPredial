package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;
import com.hector.titulacionpredial.view.swing.panel.RoundedPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hectoracevedo
 */
public class SeeProperties extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    
    public SeeProperties() {
        initComponents();
        
        String[] titles = {"Codigo Propiedad", "Nombre", "Cedula", "N. Resolución", "Notificación", "Ejecutoria", "FMI", "Acto", "Esc. Publica", "Notaria", "Ref. Catastral", "Direccion", "Municipio", "MCORE1", "MCORN1", "MDISN", "MCOLN", "MCORE2", "MCORN2", "MDISE", "MCOLE", "MCORE3", "MCORN3", "MDISS", "MCOLS", "MCORE4", "MCORN4", "MDISO", "MLINDO", "AMAT"};
        model.setColumnIdentifiers(titles);
        jtbl_properties.setModel(model);
        
        JTableHeader header = jtbl_properties.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);

        jscp_scrollContent.getHorizontalScrollBar().setUnitIncrement(15);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        roundedPanel3 = new RoundedPanel();
        txt_search = new JTextField();
        btn_search = new ButtonAction();
        jLabel1 = new JLabel();
        jscp_scrollContent = new JScrollPane();
        jPanel2 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jtbl_properties = new JTable();
        btn_generate = new ButtonAction();
        btn_delete = new ButtonAction();

        jPanel1.setBackground(new Color(255, 255, 255));

        roundedPanel3.setBackground(new Color(255, 255, 255));
        roundedPanel3.setBorderColor(new Color(116, 198, 157));

        txt_search.setBackground(new Color(255, 255, 255));
        txt_search.setForeground(new Color(64, 145, 108));
        txt_search.setText("Buscar");
        txt_search.setBorder(null);

        btn_search.setBackground(new Color(255, 255, 255));
        btn_search.setIcon(new ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_search.setHorizontalAlignment(SwingConstants.CENTER);
        btn_search.setHorizontalTextPosition(SwingConstants.CENTER);

        GroupLayout roundedPanel3Layout = new GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txt_search, GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(8, 28, 21));
        jLabel1.setText("Predios");

        jscp_scrollContent.setBackground(new Color(255, 255, 255));

        jPanel2.setBackground(new Color(255, 255, 255));

        jtbl_properties.setModel(new DefaultTableModel(
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

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 3568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jscp_scrollContent.setViewportView(jPanel2);

        btn_generate.setBackground(new Color(64, 145, 108));
        btn_generate.setForeground(new Color(255, 255, 255));
        btn_generate.setText("Generar Resolucion");
        btn_generate.setFont(new Font("SansSerif", 1, 15)); // NOI18N
        btn_generate.setHorizontalAlignment(SwingConstants.CENTER);

        btn_delete.setBackground(new Color(149, 213, 178));
        btn_delete.setForeground(new Color(5, 31, 32));
        btn_delete.setText("Eliminar");
        btn_delete.setFont(new Font("SansSerif", 1, 15)); // NOI18N
        btn_delete.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jscp_scrollContent, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roundedPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_generate, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jscp_scrollContent, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_generate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    public void loadData(DTOPropertyDetails dto) {
        int propertyCode = dto.getPropertyCode();
        StringBuilder beneficiaries = new StringBuilder();
        StringBuilder idBeneficiaries = new StringBuilder();

        dto.getBeneficiaries().forEach(beneficiary -> {
            beneficiaries.append(beneficiary.getFullName()).append(" - ");
            idBeneficiaries.append(beneficiary.getId()).append(" - ");
        });

        String beneficiariesName = beneficiaries.toString();
        String addressBeneficiary = dto.getBeneficiaries().getFirst().getAddress();
        String neighborhood = dto.getBeneficiaries().getFirst().getNeighborhood();
        String beneficiaryId = idBeneficiaries.toString();

        long resolutionNumber = dto.getNumResolution();
        LocalDate notification = dto.getNotification();
        LocalDate executory = dto.getExecutory();
        String fmi = dto.getFmi();
        String act = dto.getAct();
        String publicWriting = dto.getPublicWriting();
        String notary = dto.getNotary();
        String cadastralReference = dto.getCadastralId();
        double area = dto.getArea();

        double northCoordinate1 = 0;
        double eastCoordinate1 = 0;
        double distance1 = 0;
        String hillside1 = "";

        double northCoordinate2 = 0;
        double eastCoordinate2 = 0;
        double distance2 = 0;
        String hillside2 = "";

        double northCoordinate3 = 0;
        double eastCoordinate3 = 0;
        double distance3 = 0;
        String hillside3 = "";

        double northCoordinate4 = 0;
        double eastCoordinate4 = 0;
        double distance4 = 0;
        String hillside4 = "";

        for (DTOPointDetails point : dto.getPoints()) {
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

        Object[] addData = new Object[]{propertyCode, beneficiariesName, beneficiaryId, resolutionNumber, notification, executory, fmi, act, publicWriting, notary, cadastralReference, addressBeneficiary, neighborhood, eastCoordinate1, northCoordinate1, distance1, hillside1, eastCoordinate2, northCoordinate2, distance2, hillside2, eastCoordinate3, northCoordinate3, distance3, hillside3, eastCoordinate4, northCoordinate4, distance4, hillside4, area};
        model.addRow(addData);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonAction btn_delete;
    private ButtonAction btn_generate;
    private ButtonAction btn_search;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JScrollPane jscp_scrollContent;
    private JTable jtbl_properties;
    private RoundedPanel roundedPanel3;
    private JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
