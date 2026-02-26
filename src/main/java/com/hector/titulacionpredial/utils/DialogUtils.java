package com.hector.titulacionpredial.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * Utility class for common dialog operations:
 * loading dialogs, file choosers, and background task execution with progress.
 *
 * @author hectoracevedo
 */
public class DialogUtils {

    private DialogUtils() {

    }

    /**
     * Creates a modal loading dialog with an indeterminate progress bar.
     *
     * @param parent  the component to center the dialog on
     * @param message the message to display (e.g. "Exportando reporte, por favor espere...")
     * @return the configured JDialog (not yet visible)
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
     * Executes a background task while showing a loading dialog with a progress bar.
     * On completion, shows a success or error message.
     *
     * @param parent         the parent component for dialog positioning and messages
     * @param loadingMessage the message shown in the loading dialog
     * @param successMessage the message shown on successful completion
     * @param task           the background task to execute
     */
    public static void executeWithDialog(JComponent parent, String loadingMessage, String successMessage, Callable<Void> task) {
        executeWithDialog(parent, loadingMessage, successMessage, task, null);
    }

    /**
     * Executes a background task while showing a loading dialog with a progress bar.
     * On completion, shows a success or error message, and optionally runs a callback.
     *
     * @param parent         the parent component for dialog positioning and messages
     * @param loadingMessage the message shown in the loading dialog
     * @param successMessage the message shown on successful completion
     * @param task           the background task to execute
     * @param onSuccess      optional callback to run on success (on EDT), can be null
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
     * Opens a directory chooser dialog and returns the selected path.
     *
     * @param parent the parent component for the file chooser
     * @return the absolute path of the selected directory, or null if cancelled/invalid
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
