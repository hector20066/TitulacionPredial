package com.hector.titulacionpredial.view.content.dialogs;

import com.hector.titulacionpredial.controller.ControllerSearchDialog;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.ConcreteSubject;
import com.hector.titulacionpredial.utils.FilterUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.hector.titulacionpredial.view.swing.panel.PanelShadowCard;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author hectoracevedo
 */
public class SelectBeneficiary extends javax.swing.JDialog {

    private boolean confirmed = false;
    private final Animator animator;
    private boolean show = true;
    DefaultTableModel model = new DefaultTableModel();

    private ControllerSearchDialog controllerSearchDialog;

    public SelectBeneficiary(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.controllerSearchDialog =  new ControllerSearchDialog(this);

        String[] titles = {"Código", "Nombre", "Cedula", "Ref. Catastral"};
        model.setColumnIdentifiers(titles);
        jtbl_beneficiaries.setModel(model);

        JTableHeader header = jtbl_beneficiaries.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);

        btn_searchCancel.setVisible(false);

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

        jPanel1 = new PanelShadowCard();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_beneficiaries = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        roundedPanel = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_searchCancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_select = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_cancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtbl_beneficiaries.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jtbl_beneficiaries.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_beneficiaries);

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 28, 21));
        jLabel1.setText("Seleccionar beneficiario");

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel.setBorderColor(new java.awt.Color(116, 198, 157));

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

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_select.setBackground(new java.awt.Color(64, 145, 108));
        btn_select.setText("Seleccionar");
        btn_select.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_select.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_cancel.setBackground(new java.awt.Color(149, 213, 178));
        btn_cancel.setForeground(new java.awt.Color(5, 31, 32));
        btn_cancel.setText("Cancelar");
        btn_cancel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_select, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
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
        btn_search.addActionListener(e -> {
            searchBeneficiary();
        });

        btn_select.addActionListener(e -> {
            confirmed = true;
            codeBeneficiarySelected();
            closeMenu();
        });

        btn_cancel.addActionListener(e -> {
            confirmed = false;
            dispose();
            closeMenu();
        });

        btn_searchCancel.addActionListener(e -> {
            txt_search.setText("Buscar");
            btn_searchCancel.setVisible(false);
            btn_search.setVisible(true);
            controllerSearchDialog.loadUsers();
        });

        addDocumentListener();
        addFocusListener();
        addMouseListener();
    }

    private void searchBeneficiary() {
        btn_searchCancel.setVisible(true);
        btn_search.setVisible(false);

        String param = txt_search.getText().trim();
        controllerSearchDialog.searchBeneficiary(param);
    }

    private void addDocumentListener() {
        txt_search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(txt_search, jtbl_beneficiaries, "Buscar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(txt_search, jtbl_beneficiaries, "Buscar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(txt_search, jtbl_beneficiaries, "Buscar");
            }
        });
    }

    private void addFocusListener() {
        txt_search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_search.getText().isBlank()) {
                    txt_search.setText("Buscar");
                }
            }
        });
    }

    private void addMouseListener() {
        txt_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txt_search.getText().equals("Buscar")) {
                    txt_search.setText("");
                }
            }
        });
    }

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }

        show = false;
        animator.start();
    }

    public void loadBeneficiaries(List<DTOBeneficiarySimpleDetails> listBeneficiaries) {
        model.setRowCount(0);

        listBeneficiaries.forEach(e -> {
            Object[] data = new Object[]{e.getCode(), e.getFullName(), e.getId(), e.getCadastralReference()};
            model.addRow(data);
        });
    }

    public void loadBeneficiary(DTOBeneficiarySimpleDetails dto) {
        model.setRowCount(0);

        int code = dto.getCode();
        String name = dto.getFullName();
        long id = dto.getId();
        long cadastralReference = dto.getCadastralReference();

        Object[] data = new Object[]{code, name, id, cadastralReference};
        model.addRow(data);
    }

    public int codeBeneficiarySelected() {
        int code = 0;

        if (jtbl_beneficiaries.getSelectedRow() > -1) {
            code = Integer.parseInt(jtbl_beneficiaries.getValueAt(jtbl_beneficiaries.getSelectedRow(), 0).toString());
        }

        return code;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_cancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchCancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_select;
    private javax.swing.JLabel jLabel1;
    private PanelShadowCard jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbl_beneficiaries;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
