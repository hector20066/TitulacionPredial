package com.hector.titulacionpredial.utils;

import javax.swing.*;

/**
 * Clase utilitaria para mostrar mensajes y diálogos
 * al usuario mediante {@link JOptionPane}.
 *
 * <p>
 * Centraliza la presentación de mensajes de información,
 * error, advertencia, confirmación y mensajes planos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see JOptionPane
 * @since 1.0
 */
public class MessageUtils {

    /**
     * Muestra un mensaje de información.
     *
     * @param message   texto del mensaje
     * @param container componente padre del diálogo
     */
    public static void informationMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de error.
     *
     * @param message   texto del mensaje
     * @param container componente padre del diálogo
     */
    public static void errorMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de advertencia.
     *
     * @param message   texto del mensaje
     * @param container componente padre del diálogo
     */
    public static void warningMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Muestra un mensaje plano sin icono de tipo.
     *
     * @param message   texto del mensaje
     * @param container componente padre del diálogo
     */
    public static void plainMessage(String message, JComponent container) {
        JOptionPane.showMessageDialog(container, message, "Info", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Muestra un diálogo de confirmación con opciones Sí/No.
     *
     * @param message   texto de la pregunta
     * @param container componente padre del diálogo
     * @return {@link JOptionPane#YES_OPTION} si el usuario acepta,
     * {@link JOptionPane#NO_OPTION} en caso contrario
     */
    public static int confirmDialog(String message, JComponent container) {
        return JOptionPane.showConfirmDialog(container, message, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Retorna el valor constante de la opción «Sí».
     *
     * @return {@link JOptionPane#YES_OPTION}
     */
    public static int yesOption() {
        return JOptionPane.YES_OPTION;
    }

}
