package com.hector.titulacionpredial.view.swing.button;

import javax.swing.*;

/**
 * Panel that groups the window control buttons (minimize, maximize and close).
 *
 * <p>
 * It provides the {@code initEvent(JFrame, JPanel)} method to bind each button's
 * events to the corresponding window actions.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see WindowButton
 */
public class WinButton extends javax.swing.JPanel {

    /**
     * Create the panel with the window control buttons.
     */
    public WinButton() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_minimize = new com.hector.titulacionpredial.view.swing.button.WindowButton();
        btn_maximize = new com.hector.titulacionpredial.view.swing.button.WindowButton();
        btn_exit = new com.hector.titulacionpredial.view.swing.button.WindowButton();

        btn_minimize.setBackground(new java.awt.Color(67, 199, 51));

        btn_maximize.setBackground(new java.awt.Color(227, 226, 68));

        btn_exit.setBackground(new java.awt.Color(240, 61, 61));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_maximize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_maximize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Link button events to window actions.
     *
     * @param frame main window
     * @param panel content panel
     */
    public void initEvent(JFrame frame, JPanel panel) {
        btn_exit.addActionListener((evt) -> System.exit(0));
        btn_minimize.addActionListener((evt) -> frame.setState(JFrame.ICONIFIED));

        /*btn_maximize.addActionListener((evt) -> {
            if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                frame.setExtendedState(JFrame.NORMAL);
            } else {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.WindowButton btn_exit;
    private com.hector.titulacionpredial.view.swing.button.WindowButton btn_maximize;
    private com.hector.titulacionpredial.view.swing.button.WindowButton btn_minimize;
    // End of variables declaration//GEN-END:variables
}
