package com.hector.titulacionpredial.app;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.hector.titulacionpredial.controller.Coordinator;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author hectoracevedo
 */
public class Main {

    public static void main(String[] args) {
        try {
            FlatIntelliJLaf.setup();

            UIManager.put("ComboBox.selectionBackground", new Color(0x8cb79b));
            UIManager.put("ComboBox.selectionForeground", Color.WHITE);
            UIManager.put("Component.focusColor", new Color(0x8cb79b));
            UIManager.put("Component.focusedBorderColor", new Color(0x8cb79b));
            //UIManager.put("Table.selectionBackground", new Color(0x8cb79b));
            UIManager.put("Table.selectionBackground", new Color(0x8cb79b));
            UIManager.put("Table.selectionForeground", Color.WHITE);

            new Coordinator().startApp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
