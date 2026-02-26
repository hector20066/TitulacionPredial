package com.hector.titulacionpredial.view.swing.chart.blankchart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SeriesSize Tests")
class SeriesSizeTest {

    @Test
    @DisplayName("Constructor vacío debe crear con valores por defecto (0.0)")
    void defaultConstructorShouldWork() {
        SeriesSize size = new SeriesSize();
        assertEquals(0.0, size.getX());
        assertEquals(0.0, size.getY());
        assertEquals(0.0, size.getWidth());
        assertEquals(0.0, size.getHeight());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores")
    void paramConstructorShouldWork() {
        SeriesSize size = new SeriesSize(10.0, 20.0, 100.0, 50.0);

        assertEquals(10.0, size.getX());
        assertEquals(20.0, size.getY());
        assertEquals(100.0, size.getWidth());
        assertEquals(50.0, size.getHeight());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        SeriesSize size = new SeriesSize();
        size.setX(5.5);
        size.setY(15.3);
        size.setWidth(200.0);
        size.setHeight(150.0);

        assertEquals(5.5, size.getX());
        assertEquals(15.3, size.getY());
        assertEquals(200.0, size.getWidth());
        assertEquals(150.0, size.getHeight());
    }

    @Test
    @DisplayName("Debe aceptar valores negativos")
    void shouldAcceptNegativeValues() {
        SeriesSize size = new SeriesSize(-10.0, -20.0, -5.0, -15.0);

        assertEquals(-10.0, size.getX());
        assertEquals(-20.0, size.getY());
        assertEquals(-5.0, size.getWidth());
        assertEquals(-15.0, size.getHeight());
    }
}
