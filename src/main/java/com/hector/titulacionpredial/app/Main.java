package com.hector.titulacionpredial.app;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.hector.titulacionpredial.controller.Coordinator;

import javax.swing.*;
import java.awt.*;

/**
 * Clase de arranque de la aplicación Titulación Predial.
 *
 * <p>
 * Se encarga de:
 * </p>
 * <ul>
 *     <li>Configurar el Look & Feel global mediante {@link FlatIntelliJLaf}.</li>
 *     <li>Personalizar propiedades visuales del {@link UIManager}.</li>
 *     <li>Inicializar el flujo principal delegando el control al {@link Coordinator}.</li>
 * </ul>
 *
 * <p>
 * Esta clase no contiene lógica de negocio. Su única responsabilidad
 * es la configuración inicial y el bootstrap del sistema.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class Main {

    /**
     * Punto de entrada oficial de la aplicación.
     *
     * <p>
     * Inicializa la configuración visual del sistema y delega la
     * creación e inicialización de dependencias al {@link Coordinator}.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados actualmente)
     * @throws RuntimeException sí ocurre un error durante la inicialización
     *                          del entorno gráfico o del coordinador.
     */
    static void main(String[] args) {
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
            throw new RuntimeException(e);
        }
    }

}
