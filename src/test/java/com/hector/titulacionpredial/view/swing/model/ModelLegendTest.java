package com.hector.titulacionpredial.view.swing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("ModelLegend Tests")
class ModelLegendTest {

    @Test
    @DisplayName("Constructor vacío debe crear instancia con campos nulos")
    void defaultConstructorShouldCreateNullFields() {
        ModelLegend legend = new ModelLegend();
        assertNull(legend.getName());
        assertNull(legend.getColor());
        assertNull(legend.getColorLight());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores")
    void paramConstructorShouldAssignValues() {
        Color color = new Color(255, 0, 0);
        Color colorLight = new Color(255, 100, 100);
        ModelLegend legend = new ModelLegend("Ventas", color, colorLight);

        assertEquals("Ventas", legend.getName());
        assertEquals(color, legend.getColor());
        assertEquals(colorLight, legend.getColorLight());
    }

    @Test
    @DisplayName("setNombre debe establecer el nombre")
    void setNombreShouldSetName() {
        ModelLegend legend = new ModelLegend();
        legend.setName("Ingresos");
        assertEquals("Ingresos", legend.getName());
    }

    @Test
    @DisplayName("setColor debe establecer el color")
    void setColorShouldWork() {
        ModelLegend legend = new ModelLegend();
        Color color = Color.BLUE;
        legend.setColor(color);
        assertEquals(Color.BLUE, legend.getColor());
    }

    @Test
    @DisplayName("setColorLight debe establecer el color claro")
    void setColorLightShouldWork() {
        ModelLegend legend = new ModelLegend();
        Color colorLight = Color.CYAN;
        legend.setColorLight(colorLight);
        assertEquals(Color.CYAN, legend.getColorLight());
    }

    @Test
    @DisplayName("Debe poder actualizar todos los campos después de creación")
    void shouldUpdateAllFieldsAfterCreation() {
        ModelLegend legend = new ModelLegend("Original", Color.RED, Color.PINK);

        legend.setName("Actualizado");
        legend.setColor(Color.GREEN);
        legend.setColorLight(Color.YELLOW);

        assertEquals("Actualizado", legend.getName());
        assertEquals(Color.GREEN, legend.getColor());
        assertEquals(Color.YELLOW, legend.getColorLight());
    }
}
