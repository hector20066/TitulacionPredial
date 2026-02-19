package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

/**
 *
 * @author hectoracevedo
 */
public class ControllerGenerateResolution {

    private final GenerateResolution generateResolution;
    private final Subject subject;

    public ControllerGenerateResolution(GenerateResolution generateResolution, Subject subject) {
        this.generateResolution = generateResolution;
        this.subject = subject;

        connectEvents();
    }

    private void connectEvents() {
        generateResolution.setControllerGenerate(e -> generateResolution());
        generateResolution.setControllerPreview(e -> preview());
    }

    private void generateResolution() {
        try {

        } catch (Exception e) {

        }
    }

    private void preview() {
        try {

        } catch (Exception e) {

        }
    }

}
