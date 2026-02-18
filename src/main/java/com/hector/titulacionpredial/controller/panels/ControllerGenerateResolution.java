package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

/**
 *
 * @author hectoracevedo
 */
public class ControllerGenerateResolution {

    private final GenerateResolution generateResolution;

    public ControllerGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;

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
