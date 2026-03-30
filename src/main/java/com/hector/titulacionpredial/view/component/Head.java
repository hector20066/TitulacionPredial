package com.hector.titulacionpredial.view.component;

import com.hector.titulacionpredial.view.swing.button.WinButton;
import com.hector.titulacionpredial.view.swing.panel.PanelShadow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Custom title bar for the main window.
 *
 * <p>
 * Extends {@link PanelShadow} and includes window control buttons
 * (minimize, maximize, close) and support for dragging to move the window.
 * </p>
 *
 * @author Eng. Hector Acevedo
 * @since 1.0
 * @see PanelShadow
 * @see WinButton
 */
public class Head extends PanelShadow {

    int xMouse;
    int yMouse;

    /**
     * Creates the title bar with the window buttons.
     */
    public Head() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /**     * init components.     */
    private void initComponents() {

        winButton1 = new com.hector.titulacionpredial.view.swing.button.WinButton();

        winButton1.setBackground(new java.awt.Color(242, 246, 253));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 956, Short.MAX_VALUE)
                .addComponent(winButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(winButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Configures the bar to allow moving the main window.
     *
     @param frame main program window.
     */
    public void initMoving(JFrame frame) {
        this.addMouseListener(new MouseAdapter() {
            @Override
    /**     * mouse pressed.     * @param evt the evt     */
            public void mousePressed(MouseEvent evt) {
                if (frame.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(evt)) {
                    xMouse = evt.getXOnScreen() - frame.getX();
                    yMouse = evt.getYOnScreen() - frame.getY();
                }
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
    /**     * mouse dragged.     * @param evt the evt     */
            public void mouseDragged(MouseEvent evt) {
                if (frame.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(evt)) {
                    frame.setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
                }
            }
        });
    }
    

    /**     * get win button.     * @return the get win button     */
    public WinButton getWinButton() {
        return winButton1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.WinButton winButton1;
    // End of variables declaration//GEN-END:variables
}
