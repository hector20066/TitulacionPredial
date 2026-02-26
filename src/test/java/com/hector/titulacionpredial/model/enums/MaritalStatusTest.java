package com.hector.titulacionpredial.model.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("MaritalStatus Enum Tests")
class MaritalStatusTest {

    @Test
    @DisplayName("Debe tener exactamente 5 valores")
    void shouldHaveFiveValues() {
        assertEquals(5, MaritalStatus.values().length);
    }

    @Test
    @DisplayName("SOLTERO debe tener el valor 'Soltero'")
    void solteroShouldHaveCorrectValue() {
        assertEquals("Soltero", MaritalStatus.SOLTERO.getValue());
    }

    @Test
    @DisplayName("CASADO debe tener el valor 'Casado'")
    void casadoShouldHaveCorrectValue() {
        assertEquals("Casado", MaritalStatus.CASADO.getValue());
    }

    @Test
    @DisplayName("UNION_LIBRE debe tener el valor 'Union Libre'")
    void unionLibreShouldHaveCorrectValue() {
        assertEquals("Union Libre", MaritalStatus.UNION_LIBRE.getValue());
    }

    @Test
    @DisplayName("DIVORCIADO debe tener el valor 'Divorciado'")
    void divorciadoShouldHaveCorrectValue() {
        assertEquals("Divorciado", MaritalStatus.DIVORCIADO.getValue());
    }

    @Test
    @DisplayName("VIUDO debe tener el valor 'Viudo'")
    void viudoShouldHaveCorrectValue() {
        assertEquals("Viudo", MaritalStatus.VIUDO.getValue());
    }

    @ParameterizedTest
    @EnumSource(MaritalStatus.class)
    @DisplayName("Todos los valores deben tener un valor no vacío")
    void allValuesShouldHaveNonEmptyValue(MaritalStatus status) {
        assertNotNull(status.getValue());
        assertFalse(status.getValue().isEmpty());
    }

    @Test
    @DisplayName("valueOf debe retornar el enum correcto")
    void valueOfShouldReturnCorrectEnum() {
        assertEquals(MaritalStatus.SOLTERO, MaritalStatus.valueOf("SOLTERO"));
        assertEquals(MaritalStatus.CASADO, MaritalStatus.valueOf("CASADO"));
        assertEquals(MaritalStatus.UNION_LIBRE, MaritalStatus.valueOf("UNION_LIBRE"));
        assertEquals(MaritalStatus.DIVORCIADO, MaritalStatus.valueOf("DIVORCIADO"));
        assertEquals(MaritalStatus.VIUDO, MaritalStatus.valueOf("VIUDO"));
    }

    @Test
    @DisplayName("valueOf con valor inválido debe lanzar IllegalArgumentException")
    void valueOfWithInvalidShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> MaritalStatus.valueOf("INVALIDO"));
    }
}
