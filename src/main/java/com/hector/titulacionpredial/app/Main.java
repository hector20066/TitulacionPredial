package com.hector.titulacionpredial.app;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.hector.titulacionpredial.controller.Coordinator;

/**
 *
 * @author hectoracevedo
 */
public class Main {

    public static void main(String[] args) {
        try {
            FlatIntelliJLaf.setup();

            new Coordinator().startApp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
