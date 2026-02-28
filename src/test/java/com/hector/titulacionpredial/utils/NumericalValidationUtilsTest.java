package com.hector.titulacionpredial.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("NumericalValidationUtils Tests")
class NumericalValidationUtilsTest {

    @Nested
    @DisplayName("isNumeric Tests")
    class IsNumericTests {

        @ParameterizedTest
        @ValueSource(strings = {"123", "0", "999999", "1234567890", "00123"})
        @DisplayName("Debe retornar true para cadenas numéricas válidas")
        void shouldReturnTrueForValidNumericStrings(String value) {
            assertTrue(NumericalValidationUtils.isNumeric(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "12.5", "12,5", "-1", "1 2", " ", "a1b2", "12-34", ""})
        @DisplayName("Debe retornar false para cadenas no numéricas")
        void shouldReturnFalseForNonNumericStrings(String value) {
            assertFalse(NumericalValidationUtils.isNumeric(value));
        }

        @Test
        @DisplayName("Debe retornar true para un solo dígito")
        void shouldReturnTrueForSingleDigit() {
            assertTrue(NumericalValidationUtils.isNumeric("5"));
        }

        @Test
        @DisplayName("Debe retornar false para cadena con espacios")
        void shouldReturnFalseForStringWithSpaces() {
            assertFalse(NumericalValidationUtils.isNumeric("123 456"));
        }

        @Test
        @DisplayName("Debe retornar false para cadena con caracteres especiales")
        void shouldReturnFalseForSpecialChars() {
            assertFalse(NumericalValidationUtils.isNumeric("123!"));
        }

        @Test
        @DisplayName("Debe lanzar excepción para null")
        void shouldThrowForNull() {
            assertThrows(NullPointerException.class, () -> NumericalValidationUtils.isNumeric(null));
        }
    }

    @Nested
    @DisplayName("Utility Class Tests")
    class UtilityClassTests {

        @Test
        @DisplayName("La clase debe tener un constructor por defecto")
        void defaultConstructorShouldExist() {
            assertDoesNotThrow(NumericalValidationUtils::new,
                    "La clase debe tener constructor por defecto");
        }
    }
}
