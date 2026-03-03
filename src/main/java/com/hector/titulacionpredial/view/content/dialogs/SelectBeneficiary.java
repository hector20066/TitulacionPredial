package com.hector.titulacionpredial.view.content.dialogs;

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

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.hector.titulacionpredial.controller.ControllerSelectDialog;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.view.i18n.dto.dialogs.DTOSelectBeneficiaryText;

/**
 * Diálogo modal para seleccionar un beneficiario
 * desde una tabla con búsqueda integrada.
 *
 * <p>
 * Utilizado al registrar predios o generar resoluciones
 * para asociar un beneficiario existente. Incluye filtrado
 * en tiempo real y animación de entrada.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see ControllerSelectDialog
 */
public class SelectBeneficiary extends javax.swing.JDialog {

    private String code = "Código";
    private String name = "Nombre";
    private String id = "Cédula";
    private String cadastralRef = "Ref. Catastral";

    private boolean confirmed = false;
    private final Animator animator;
    private boolean show = true;
    DefaultTableModel model = new DefaultTableModel();
    private String searchPlaceholder = "Buscar";

    private final ControllerSelectDialog controllerSearchDialog;

    /**
     * Crea un nuevo diálogo de selección de beneficiario.
     *
     * <p>Inicializa la tabla con sus encabezados, configura el controlador
     * de búsqueda, conecta eventos y establece la animación de opacidad.</p>
     *
     * @param parent ventana padre del diálogo
     * @param modal  {@code true} para bloquear la ventana padre mientras se muestra
     */
    public SelectBeneficiary(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.controllerSearchDialog =  new ControllerSelectDialog(this);

        String[] titles = {code, name, id, cadastralRef};
        model.setColumnIdentifiers(titles);
        jtbl_beneficiaries.setModel(model);

        tableHeader();

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

    /**
     * Configura el estilo visual del encabezado de la tabla de beneficiarios.
     */
    private void tableHeader() {
        JTableHeader header = jtbl_beneficiaries.getTableHeader();
        header.setBackground(new Color(0x8cb79b));
        header.setForeground(new Color(0x051f20));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_beneficiaries = new javax.swing.JTable();
        jlb_title = new javax.swing.JLabel();
        roundedPanel = new com.hector.titulacionpredial.view.swing.panel.RoundedPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_searchCancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_select = new com.hector.titulacionpredial.view.swing.button.ButtonAction();
        btn_cancel = new com.hector.titulacionpredial.view.swing.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(116, 198, 157), 1, true));

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

        jlb_title.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(8, 28, 21));
        jlb_title.setText("Seleccionar beneficiario");

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
                    .addComponent(jlb_title)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlb_title)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
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

    public void updateLanguage(DTOSelectBeneficiaryText texts) {
        jlb_title.setText(texts.getTitle());
        code = texts.getBeneficiaryCode();
        name = texts.getBeneficiaryName();
        id = texts.getBeneficiaryId();
        cadastralRef = texts.getBeneficiaryCadastralRef();
        searchPlaceholder = texts.getSearch();
        txt_search.setText(searchPlaceholder);
    }

    /**
     * Conecta los eventos de los botones de buscar, seleccionar,
     * cancelar y cancelar búsqueda, además de los listeners del campo de texto.
     */
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
            txt_search.setText(searchPlaceholder);
            btn_searchCancel.setVisible(false);
            btn_search.setVisible(true);
            controllerSearchDialog.loadUsers();
        });

        addDocumentListener();
        addFocusListener();
        addMouseListener();
    }

    /**
     * Ejecuta la búsqueda de beneficiarios por el parámetro ingresado
     * en el campo de texto y alterna la visibilidad de los botones.
     */
    private void searchBeneficiary() {
        btn_searchCancel.setVisible(true);
        btn_search.setVisible(false);

        String param = txt_search.getText().trim();
        controllerSearchDialog.searchBeneficiary(param);
    }

    /**
     * Agrega un {@link DocumentListener} al campo de búsqueda
     * para filtrar la tabla en tiempo real.
     */
    private void addDocumentListener() {
        txt_search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(txt_search, jtbl_beneficiaries, searchPlaceholder);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(txt_search, jtbl_beneficiaries, searchPlaceholder);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(txt_search, jtbl_beneficiaries, searchPlaceholder);
            }
        });
    }

    /**
     * Agrega un listener de foco al campo de búsqueda
     * que restaura el texto placeholder al perder el foco.
     */
    private void addFocusListener() {
        txt_search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txt_search.getText().isBlank()) {
                    txt_search.setText(searchPlaceholder);
                }
            }
        });
    }

    /**
     * Agrega un listener de ratón al campo de búsqueda
     * que limpia el texto placeholder al hacer clic.
     */
    private void addMouseListener() {
        txt_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txt_search.getText().equals(searchPlaceholder)) {
                    txt_search.setText("");
                }
            }
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
     * Carga una lista de beneficiarios en la tabla del diálogo.
     *
     * @param listBeneficiaries lista de beneficiarios a mostrar
     */
    public void loadBeneficiaries(List<DTOBeneficiarySimpleDetails> listBeneficiaries) {
        model.setRowCount(0);

        listBeneficiaries.forEach(e -> {
            Object[] data = new Object[]{e.getCode(), e.getFullName(), e.getId(), e.getCadastralReference()};
            model.addRow(data);
        });
    }

    /**
     * Carga un único beneficiario en la tabla del diálogo.
     *
     * @param dto datos del beneficiario a mostrar
     */
    public void loadBeneficiary(DTOBeneficiarySimpleDetails dto) {
        model.setRowCount(0);

        int code = dto.getCode();
        String name = dto.getFullName();
        long id = dto.getId();
        String cadastralReference = dto.getCadastralReference();

        Object[] data = new Object[]{code, name, id, cadastralReference};
        model.addRow(data);
    }

    /**
     * Obtiene el código del beneficiario seleccionado en la tabla.
     *
     * @return código del beneficiario seleccionado, o {@code 0} si no hay selección
     */
    public int codeBeneficiarySelected() {
        int code = 0;

        if (jtbl_beneficiaries.getSelectedRow() > -1) {
            code = Integer.parseInt(jtbl_beneficiaries.getValueAt(jtbl_beneficiaries.getSelectedRow(), 0).toString());
        }

        return code;
    }

    /**
     * Indica si el usuario confirmó la selección de un beneficiario.
     *
     * @return {@code true} si se presionó seleccionar, {@code false} si se canceló
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_cancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_search;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_searchCancel;
    private com.hector.titulacionpredial.view.swing.button.ButtonAction btn_select;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JTable jtbl_beneficiaries;
    private com.hector.titulacionpredial.view.swing.panel.RoundedPanel roundedPanel;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
