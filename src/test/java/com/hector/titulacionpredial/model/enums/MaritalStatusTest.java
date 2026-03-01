package com.hector.titulacionpredial.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("Soltero", MaritalStatus.SINGLE.getValue());
    }

    @Test
    @DisplayName("CASADO debe tener el valor 'Casado'")
    void casadoShouldHaveCorrectValue() {
        assertEquals("Casado", MaritalStatus.MARRIED.getValue());
    }

    @Test
    @DisplayName("UNION_LIBRE debe tener el valor 'Union Libre'")
    void unionLibreShouldHaveCorrectValue() {
        assertEquals("Union Libre", MaritalStatus.FREE_UNION.getValue());
    }

    @Test
    @DisplayName("DIVORCIADO debe tener el valor 'Divorciado'")
    void divorciadoShouldHaveCorrectValue() {
        assertEquals("Divorciado", MaritalStatus.DIVORCED.getValue());
    }

    @Test
    @DisplayName("VIUDO debe tener el valor 'Viudo'")
    void viudoShouldHaveCorrectValue() {
        assertEquals("Viudo", MaritalStatus.WIDOWER.getValue());
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
        assertEquals(MaritalStatus.SINGLE, MaritalStatus.valueOf("SOLTERO"));
        assertEquals(MaritalStatus.MARRIED, MaritalStatus.valueOf("CASADO"));
        assertEquals(MaritalStatus.FREE_UNION, MaritalStatus.valueOf("UNION_LIBRE"));
        assertEquals(MaritalStatus.DIVORCED, MaritalStatus.valueOf("DIVORCIADO"));
        assertEquals(MaritalStatus.WIDOWER, MaritalStatus.valueOf("VIUDO"));
    }

    @Test
    @DisplayName("valueOf con valor inválido debe lanzar IllegalArgumentException")
    void valueOfWithInvalidShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> MaritalStatus.valueOf("INVALIDO"));
    }
}
