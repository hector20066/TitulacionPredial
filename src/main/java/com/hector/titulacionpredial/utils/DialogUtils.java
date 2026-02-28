package com.hector.titulacionpredial.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * Clase utilitaria para operaciones comunes con diálogos:
 * diálogos de carga, selectores de archivos y ejecución
 * de tareas en segundo plano con indicador de progreso.
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DialogUtils {

    /**
     * Constructor privado para evitar instanciación.
     */
    private DialogUtils() {

    }

    /**
     * Crea un diálogo modal de carga con una barra de progreso indeterminada.
     *
     * @param parent  componente padre para centrar el diálogo
     * @param message mensaje a mostrar (ej. «Exportando reporte, por favor espere...»)
     * @return diálogo configurado (aún no visible)
     */
    public static JDialog createLoadDialog(JComponent parent, String message) {
        Window parentWindow = SwingUtilities.getWindowAncestor(parent);

        JDialog dialog = new JDialog(parentWindow, "Procesando", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(350, 120);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(message);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(new Color(60, 60, 60));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setPreferredSize(new Dimension(0, 8));
        progress.setBorderPainted(false);
        progress.setForeground(new Color(70, 130, 180));
        progress.setBackground(new Color(230, 230, 230));

        panel.add(label, BorderLayout.CENTER);
        panel.add(progress, BorderLayout.SOUTH);

        dialog.setContentPane(panel);
        dialog.setLocationRelativeTo(parent);

        return dialog;
    }

    /**
     * Ejecuta una tarea en segundo plano mostrando un diálogo de carga.
     * Al completarse, muestra un mensaje de éxito o error.
     *
     * @param parent         componente padre para posicionar el diálogo
     * @param loadingMessage mensaje del diálogo de carga
     * @param successMessage mensaje mostrado al completarse exitosamente
     * @param task           tarea a ejecutar en segundo plano
     */
    public static void executeWithDialog(JComponent parent, String loadingMessage, String successMessage, Callable<Void> task) {
        executeWithDialog(parent, loadingMessage, successMessage, task, null);
    }

    /**
     * Ejecuta una tarea en segundo plano mostrando un diálogo de carga.
     * Al completarse, muestra un mensaje de éxito o error, y opcionalmente
     * ejecuta un callback.
     *
     * @param parent         componente padre para posicionar el diálogo
     * @param loadingMessage mensaje del diálogo de carga
     * @param successMessage mensaje mostrado al completarse exitosamente
     * @param task           tarea a ejecutar en segundo plano
     * @param onSuccess      callback opcional al éxito (en EDT), puede ser {@code null}
     */
    public static void executeWithDialog(JComponent parent, String loadingMessage, String successMessage,
                                         Callable<Void> task, Runnable onSuccess) {
        JDialog dialog = createLoadDialog(parent, loadingMessage);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                task.call();
                return null;
            }

            @Override
            protected void done() {
                dialog.dispose();

                try {
                    get();
                    MessageUtils.informationMessage(successMessage, parent);

                    if (onSuccess != null) {
                        onSuccess.run();
                    }
                } catch (Exception e) {
                    String msg = (e.getCause() != null) ? e.getCause().getMessage() : e.getMessage();
                    MessageUtils.errorMessage("Ha ocurrido un error.\nError: " + msg, parent);
                }
            }
        };

        worker.execute();
        dialog.setVisible(true);
    }

    /**
     * Abre un selector de directorios y retorna la ruta seleccionada.
     *
     * @param parent componente padre para el selector
     * @return ruta absoluta del directorio seleccionado, o {@code null} si se cancela
     */
    public static String selectRoute(JComponent parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();

            if (selectedDirectory == null || selectedDirectory.getAbsolutePath().isEmpty()) {
                MessageUtils.errorMessage("Error al seleccionar la carpeta", parent);
                return null;
            } else {
                return selectedDirectory.getAbsolutePath();
            }
        }

        return null;
    }

}
