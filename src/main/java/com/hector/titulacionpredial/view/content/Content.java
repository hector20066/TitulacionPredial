package com.hector.titulacionpredial.view.content;

import javax.swing.JPanel;

import com.hector.titulacionpredial.view.swing.menu.EventMenuSelected;
import com.hector.titulacionpredial.view.swing.menu.Menu;

/**
 * Ventana principal ({@code JFrame}) de la aplicación
 * Titulación Predial.
 *
 * <p>
 * Contiene el menú lateral ({@link com.hector.titulacionpredial.view.swing.menu.Menu}),
 * la barra de título ({@link com.hector.titulacionpredial.view.component.Head})
 * y el panel de contenido dinámico donde se cargan los diferentes
 * formularios de la aplicación.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Content extends javax.swing.JFrame {
    
    /**
     * Crea la ventana principal e inicializa menú, cabecera y contenido.
     */
    public Content() {
        initComponents();

        head.initMoving(this);
        head.getWinButton().initEvent(this, jpl_body);

        menu.setSelectedIndex(0, 0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpl_body = new javax.swing.JPanel();
        jpl_menu = new javax.swing.JPanel();
        menu = new com.hector.titulacionpredial.view.swing.menu.Menu();
        jpl_content = new javax.swing.JPanel();
        head = new com.hector.titulacionpredial.view.component.Head();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpl_body.setBackground(new java.awt.Color(255, 255, 255));

        jpl_menu.setBackground(new java.awt.Color(255, 255, 255));
        jpl_menu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(64, 145, 108)));

        menu.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jpl_menuLayout = new javax.swing.GroupLayout(jpl_menu);
        jpl_menu.setLayout(jpl_menuLayout);
        jpl_menuLayout.setHorizontalGroup(
            jpl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        jpl_menuLayout.setVerticalGroup(
            jpl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_menuLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpl_content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpl_contentLayout = new javax.swing.GroupLayout(jpl_content);
        jpl_content.setLayout(jpl_contentLayout);
        jpl_contentLayout.setHorizontalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpl_contentLayout.setVerticalGroup(
            jpl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpl_bodyLayout = new javax.swing.GroupLayout(jpl_body);
        jpl_body.setLayout(jpl_bodyLayout);
        jpl_bodyLayout.setHorizontalGroup(
            jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl_bodyLayout.createSequentialGroup()
                .addComponent(jpl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addComponent(head, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        jpl_bodyLayout.setVerticalGroup(
            jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpl_bodyLayout.createSequentialGroup()
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jpl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpl_bodyLayout.createSequentialGroup()
                        .addComponent(jpl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jpl_bodyLayout.createSequentialGroup()
                        .addComponent(jpl_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Asigna el controlador para los eventos de selección del menú.
     *
     * @param evt listener de selección de menú
     */
    public void setControllerMenu(EventMenuSelected evt) {
        menu.addEvent(evt);
    }

    /**
     * Obtiene el panel de contenido dinámico donde se cargan los formularios.
     *
     * @return panel de contenido principal
     */
    public static JPanel getJpl_content() {
        return jpl_content;
    }

    /**
     * Obtiene el componente de menú lateral de la ventana.
     *
     * @return instancia del menú lateral
     */
    public Menu getMenu() {
        return menu;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.component.Head head;
    private javax.swing.JPanel jpl_body;
    private static javax.swing.JPanel jpl_content;
    private javax.swing.JPanel jpl_menu;
    private com.hector.titulacionpredial.view.swing.menu.Menu menu;
    // End of variables declaration//GEN-END:variables
}
