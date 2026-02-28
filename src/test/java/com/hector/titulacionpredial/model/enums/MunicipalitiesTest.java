package com.hector.titulacionpredial.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Municipalities Enum Tests")
class MunicipalitiesTest {

    @Test
    @DisplayName("BARRANQUILLA debe tener el valor 'Barranquilla'")
    void barranquillaShouldHaveCorrectValue() {
        assertEquals("Barranquilla", Municipalities.BARRANQUILLA.getValue());
    }

    @Test
    @DisplayName("MEDELLIN debe tener el valor 'Medellin'")
    void medellinShouldHaveCorrectValue() {
        assertEquals("Medellin", Municipalities.MEDELLIN.getValue());
    }

    @Test
    @DisplayName("BOGOTA_DC debe tener el valor 'Bogota dc'")
    void bogotaShouldHaveCorrectValue() {
        assertEquals("Bogota dc", Municipalities.BOGOTA_DC.getValue());
    }

    @Test
    @DisplayName("LETICIA debe tener el valor 'Leticia'")
    void leticiaShouldHaveCorrectValue() {
        assertEquals("Leticia", Municipalities.LETICIA.getValue());
    }

    @ParameterizedTest
    @EnumSource(Municipalities.class)
    @DisplayName("Todos los municipios deben tener un valor no vacío")
    void allMunicipalitiesShouldHaveNonEmptyValue(Municipalities municipality) {
        assertNotNull(municipality.getValue());
        assertFalse(municipality.getValue().isEmpty());
    }

    @Test
    @DisplayName("valueOf debe retornar el municipio correcto")
    void valueOfShouldWork() {
        assertEquals(Municipalities.BARRANQUILLA, Municipalities.valueOf("BARRANQUILLA"));
        assertEquals(Municipalities.SOLEDAD, Municipalities.valueOf("SOLEDAD"));
    }

    @Test
    @DisplayName("valueOf con valor inválido debe lanzar excepción")
    void valueOfWithInvalidShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Municipalities.valueOf("CIUDAD_INEXISTENTE"));
    }

    @Test
    @DisplayName("Debe tener un número significativo de municipios")
    void shouldHaveSignificantNumberOfMunicipalities() {
        assertTrue(Municipalities.values().length > 100,
                "Colombia tiene más de 100 municipios registrados");
    }
}
