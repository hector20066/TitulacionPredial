package com.hector.titulacionpredial.utils;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Utility class to display messages and dialogs to the
 * user using {@link JOptionPane}.
 *
 * <p>
 * It centralizes the presentation of information, error,
 * warning, confirmation, and plain messages.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see JOptionPane
 * @since 1.0
 */
public class MessageUtils {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Displays an information message.
     *
     * @param message   message text
     * @param container parent component of the dialogue
     */
    public static void informationMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, lang.message("message.utils.information"),
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * It displays an error message.
     *
     * @param message   message text
     * @param container parent component of the dialogue
     */
    public static void errorMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, lang.message("message.utils.error"), JOptionPane.ERROR_MESSAGE);
    }

    /**
     * It displays a warning message.
     *
     * @param message   message text
     * @param container parent component of the dialogue
     */
    public static void warningMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, lang.message("message.utils.warning"), JOptionPane.WARNING_MESSAGE);
    }

    /**
     * It displays a plain message without a type icon.
     *
     * @param message   message text
     * @param container parent component of the dialogue
     */
    public static void plainMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, lang.message("message.utils.info"), JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Displays a confirmation dialog with Yes/No options.
     *
     * @param message   question text
     * @param container parent component of the dialogue
     * @return {@link JOptionPane#YES_OPTION} if the user accepts,
     *         {@link JOptionPane#NO_OPTION} otherwise
     */
    public static int confirmDialog(String message, JComponent container) {
        return JOptionPane.showConfirmDialog(container, message, lang.message("message.utils.confirmation"),
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Returns the constant value of the "Yes" option.
     *
     * @return {@link JOptionPane#YES_OPTION}
     */
    public static int yesOption() {
        return JOptionPane.YES_OPTION;
    }

    /**
     * Show an input dialog to request user input.
     *
     * @param message   the message to display
     * @param container the parent component
     * @return the user's input or null if cancelled
     */
    public static String inputDialog(String message, JComponent container) {
        return JOptionPane.showInputDialog(container, message, lang.message("message.utils.changePassword"),
                JOptionPane.PLAIN_MESSAGE);
    }

}
