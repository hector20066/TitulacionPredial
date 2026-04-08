package com.hector.titulacionpredial.app;

import java.awt.Color;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.hector.titulacionpredial.controller.Coordinator;

/**
 * Application Start-up Class Land Titling
 *
 * <p>
 * Is in charge of:
 * </p>
 * <ul>
 *     <li>Configure the global Look &amp; Feel using {@link FlatIntelliJLaf}.</li>
 *     <li>Customize visual properties of {@link UIManager}.</li>
 *     <li>Initialize the main flow by delegating control to {@link Coordinator}.</li>
 * </ul>
 *
 * <p>
 * This class contains no business logic. Its sole responsibility is the initial
 * configuration and bootstrapping of the system.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Main {

    /**
     * Official application entry point
     *
     * <p>
     * Initializes the system's visual configuration and delegates the
     * creation and initialization of dependencies to{@link Coordinator}.
     * </p>
     *
     * @param args command line arguments (not currently used)
     * @throws RuntimeException if an error occurs during the initialization
     *                          of the graphical environment or the coordinator.
     */
    public static void main(String[] args) {
        try {
            FlatIntelliJLaf.setup();

            UIManager.put("ComboBox.selectionBackground", new Color(0x8cb79b));
            UIManager.put("ComboBox.selectionForeground", Color.WHITE);
            UIManager.put("Component.focusColor", new Color(0x8cb79b));
            UIManager.put("Component.focusedBorderColor", new Color(0x8cb79b));

            UIManager.put("Table.selectionBackground", new Color(0x8cb79b));
            UIManager.put("Table.selectionForeground", Color.WHITE);

            new Coordinator().startApp();
        } catch (Exception e) {
            throw new RuntimeException("Error al inicializar la aplicación", e);
        }
    }

}
