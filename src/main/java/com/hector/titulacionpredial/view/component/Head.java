package com.hector.titulacionpredial.view.component;

import com.hector.titulacionpredial.view.swing.button.WinButton;
import com.hector.titulacionpredial.view.swing.panel.PanelShadow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Barra de título personalizada de la ventana principal.
 *
 * <p>
 * Extiende {@link PanelShadow} e incluye los botones de control
 * de ventana (minimizar, maximizar, cerrar) y el soporte de
 * arrastre para mover la ventana.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 * @see PanelShadow
 * @see WinButton
 */
public class Head extends PanelShadow {

    int xMouse;
    int yMouse;

    public Head() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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

    public void initMoving(JFrame frame) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (frame.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(evt)) {
                    xMouse = evt.getXOnScreen() - frame.getX();
                    yMouse = evt.getYOnScreen() - frame.getY();
                }
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                if (frame.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(evt)) {
                    frame.setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
                }
            }
        });
    }
    
    public WinButton getWinButton() {
        return winButton1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.button.WinButton winButton1;
    // End of variables declaration//GEN-END:variables
}
