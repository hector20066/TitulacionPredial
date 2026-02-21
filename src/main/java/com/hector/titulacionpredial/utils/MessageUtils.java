package com.hector.titulacionpredial.utils;

import javax.swing.*;

/**
 *
 * @author hectoracevedo
 */
public class MessageUtils {

    public static void informationMessage(String message, JComponent container){
        JOptionPane.showMessageDialog(container, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorMessage(String message, JComponent container){
        JOptionPane.showMessageDialog(container, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void warningMessage(String message, JComponent container){
        JOptionPane.showMessageDialog(container, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public static void plainMessage(String message, JComponent container){
        JOptionPane.showMessageDialog(container, message, "Info", JOptionPane.PLAIN_MESSAGE);
    }

    public static int confirmDialog(String message, JComponent container) {
        return JOptionPane.showConfirmDialog(container, message, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public static int yesOption(){
        return JOptionPane.YES_OPTION;
    }

}
