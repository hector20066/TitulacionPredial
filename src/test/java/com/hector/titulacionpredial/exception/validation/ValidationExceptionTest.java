package com.hector.titulacionpredial.exception.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.i18n.AppLanguage;
import com.hector.titulacionpredial.i18n.LanguageManager;

@DisplayName("Validation Exception Tests")
class ValidationExceptionTest {

    @BeforeAll
    static void setup() {
        LanguageManager.getInstance().setLanguage(AppLanguage.ES);
    }

    @Nested
    @DisplayName("InvalidInputException Tests")
    class InvalidInputExceptionTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            InvalidInputException ex = new InvalidInputException();
            assertEquals("Campo invalido", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            InvalidInputException ex = new InvalidInputException("Error de validación");
            assertEquals("Error de validación", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa");
            InvalidInputException ex = new InvalidInputException("Error", cause);
            assertEquals("Error", ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("Debe extender Exception")
        void shouldExtendException() {
            InvalidInputException ex = new InvalidInputException();
            assertInstanceOf(Exception.class, ex);
        }
    }

    @Nested
    @DisplayName("EmptyFieldException Tests")
    class EmptyFieldExceptionTests {

        @Test
        @DisplayName("Constructor con nombre de campo debe generar mensaje descriptivo")
        void fieldNameConstructorShouldGenerateMessage() {
            EmptyFieldException ex = new EmptyFieldException("Nombre, Cédula");
            assertTrue(ex.getMessage().contains("Nombre, Cédula"));
            assertTrue(ex.getMessage().contains("no pueden estar"));
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa");
            EmptyFieldException ex = new EmptyFieldException("Error", cause);
            assertEquals("Error", ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("Debe extender InvalidInputException")
        void shouldExtendInvalidInputException() {
            EmptyFieldException ex = new EmptyFieldException("Campo");
            assertInstanceOf(InvalidInputException.class, ex);
        }
    }

    @Nested
    @DisplayName("InvalidNumberInputException Tests")
    class InvalidNumberInputExceptionTests {

        @Test
        @DisplayName("Constructor con nombre de campo debe generar mensaje descriptivo")
        void fieldNameConstructorShouldGenerateMessage() {
            InvalidNumberInputException ex = new InvalidNumberInputException("Teléfono");
            assertTrue(ex.getMessage().contains("Teléfono"));
            assertTrue(ex.getMessage().contains("debe tener un valor num"));
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa");
            InvalidNumberInputException ex = new InvalidNumberInputException("Error", cause);
            assertEquals("Error", ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("Debe extender InvalidInputException")
        void shouldExtendInvalidInputException() {
            InvalidNumberInputException ex = new InvalidNumberInputException("Campo");
            assertInstanceOf(InvalidInputException.class, ex);
        }
    }

    @Nested
    @DisplayName("MaxLengthExceededException Tests")
    class MaxLengthExceededExceptionTests {

        @Test
        @DisplayName("Constructor con campo y máximo debe generar mensaje descriptivo")
        void constructorShouldGenerateMessage() {
            MaxLengthExceededException ex = new MaxLengthExceededException("Dirección", "100");
            assertTrue(ex.getMessage().contains("Dirección"));
            assertTrue(ex.getMessage().contains("100"));
            assertTrue(ex.getMessage().contains("debe tener un valor m"));
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa");
            MaxLengthExceededException ex = new MaxLengthExceededException("Error", cause);
            assertEquals("Error", ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("Debe extender InvalidInputException")
        void shouldExtendInvalidInputException() {
            MaxLengthExceededException ex = new MaxLengthExceededException("Campo", "50");
            assertInstanceOf(InvalidInputException.class, ex);
        }
    }
}
