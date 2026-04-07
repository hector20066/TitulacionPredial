package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.i18n.LanguageManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * Utility class for common operations with dialogs: loading dialogs,
 * file selectors, and running background tasks with a progress indicator.
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DialogUtils {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Private builder to avoid instantiation.
     */
    private DialogUtils() {

    }

    /**
     * Creates a loading modal dialog with an indeterminate
     * progress bar.
     *
     * @param parent  parent component to center the dialogue
     * @param message message to display (in. «Exporting report, please wait...»)
     * @return dialog configured (not yet visible)
     */
    public static JDialog createLoadDialog(JComponent parent, String message) {
        Window parentWindow = SwingUtilities.getWindowAncestor(parent);
        JDialog dialog = new JDialog(parentWindow, lang.message("dialog.utils.processing"),
                Dialog.ModalityType.APPLICATION_MODAL);
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
     * It runs a task in the background, displaying a loading dialog.
     * Upon completion, it displays a success or error message.
     *
     * @param parent         parent component to position the dialogue
     * @param loadingMessage loading dialog message
     * @param successMessage message displayed upon successful completion
     * @param task           task to run in the background
     */
    public static void executeWithDialog(JComponent parent, String loadingMessage, String successMessage, Callable<Void> task) {
        executeWithDialog(parent, loadingMessage, successMessage, task, null);
    }

    /**
     * It executes a task in the background, displaying a loading dialog.
     * Upon completion, it displays a success or error message, and
     * optionally executes a callback.
     *
     * @param parent         parent component to position the dialogue
     * @param loadingMessage loading dialog message
     * @param successMessage message displayed upon successful completion
     * @param task           task to run in the background
     * @param onSuccess      Optional callback on success (in EDT), can
     *                       be {@code null}
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
                    MessageUtils.errorMessage(lang.message("dialog.utils.error1") + "\n" + lang.message("dialog.utils.error2") + " " + msg, parent);
                }
            }
        };

        worker.execute();
        dialog.setVisible(true);
    }

    /**
     * Opens a directory selector and returns the selected path.
     *
     * @param parent parent component for the selector
     * @return Absolute path of the selected directory, or
     * {@code null} if canceled
     */
    public static String selectRoute(JComponent parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();

            if (selectedDirectory == null || selectedDirectory.getAbsolutePath().isEmpty()) {
                MessageUtils.errorMessage(lang.message("dialog.utils.error.select.folder"), parent);
                return null;
            } else {
                return selectedDirectory.getAbsolutePath();
            }
        }

        return null;
    }

}
