package com.hector.titulacionpredial.view.content.panels;

import com.hector.titulacionpredial.controller.IManageAccounts;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.swing.panel.PanelShadow;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.*;

/**
 *
 * @author juanpablobohorquezguerra
 */
public class ManageUsers extends javax.swing.JPanel {

    /**
     * Creates new form ManageUsers
     */
    public ManageUsers() {
        initComponents();

        jpl_content.setLayout(new BoxLayout(jpl_content, BoxLayout.Y_AXIS));
        scroll.getVerticalScrollBar().setUnitIncrement(15);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_title = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        jpl_content = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlb_title.setBackground(new java.awt.Color(255, 255, 255));
        jlb_title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(0, 0, 0));
        jlb_title.setText("Usuarios");

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setBorder(null);

        jpl_content.setBackground(new java.awt.Color(255, 255, 255));
        jpl_content.setLayout(new java.awt.GridLayout(1, 0));
        scroll.setViewportView(jpl_content);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll)
                    .addComponent(jlb_title, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
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

    public void clearPanel() {
        jpl_content.removeAll();
        jpl_content.revalidate();
        jpl_content.repaint();
    }

    public void addAccountsPanel(DTOUserDetails account, IManageAccounts controller) {
        PanelShadow panelAccount = new PanelShadow();
        panelAccount.setLayout(new BorderLayout());
        panelAccount.setBackground(new Color(227, 242, 253));

        JLabel lblTitle = new JLabel("Usuario");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTitle.setForeground(new Color(25, 46, 82));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setOpaque(false);
        titleBar.add(lblTitle, BorderLayout.WEST);
        panelAccount.add(titleBar, BorderLayout.NORTH);

        JPanel content = new JPanel(new GridBagLayout());
        content.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel jlb_name = new JLabel("Nombre:" + " " + account.getName());
        content.add(jlb_name, gbc);

        gbc.gridy++;
        JLabel jlb_user = new JLabel("Usuario:" + " " + account.getUser());
        content.add(jlb_user, gbc);

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        actionPanel.setBackground(new Color(227, 242, 253));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JButton btn_modify = new JButton("Modificar");
        btn_modify.setFocusable(false);
        btn_modify.setBackground(new Color(242, 229, 213));
        btn_modify.addActionListener(e -> controller.modifyAccount(account));

        JButton btn_remove = new JButton("Eliminar");
        btn_remove.setFocusable(false);
        btn_remove.setBackground(new Color(242, 233, 240));

        btn_remove.addActionListener(e -> {
            int confirm = MessageUtils.confirmDialog("\u00bf¿Seguro que deseas eliminar la cuenta de" + " " + account.getName() + " " + "?", this);

            if (confirm == MessageUtils.yesOption()) {
                controller.deleteAccount(account.getId(), panelAccount);
            }
        });

        actionPanel.add(btn_modify);
        actionPanel.add(btn_remove);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        content.add(actionPanel, gbc);

        panelAccount.add(content, BorderLayout.CENTER);
        panelAccount.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

        jpl_content.add(panelAccount);
        jpl_content.add(Box.createVerticalStrut(10));
        jpl_content.revalidate();
        jpl_content.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JPanel jpl_content;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
