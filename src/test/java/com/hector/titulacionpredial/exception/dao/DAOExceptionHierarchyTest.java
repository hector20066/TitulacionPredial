package com.hector.titulacionpredial.exception.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException;
import com.hector.titulacionpredial.exception.dao.notfound.PropertyNotFoundException;
import com.hector.titulacionpredial.exception.dao.notfound.ResolutionNotFoundException;
import com.hector.titulacionpredial.exception.dao.notfound.SpouseNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.BeneficiaryPersistenceException;
import com.hector.titulacionpredial.exception.dao.persistence.PointPersistenceException;
import com.hector.titulacionpredial.exception.dao.persistence.PropertyPersistenceException;
import com.hector.titulacionpredial.exception.dao.persistence.ResolutionPersistenceException;
import com.hector.titulacionpredial.exception.dao.persistence.SpousePersistenceException;

@DisplayName("DAO Exception Hierarchy Tests")
class DAOExceptionHierarchyTest {

    // ===================== DAOException =====================

    @Nested
    @DisplayName("DAOException Tests")
    class DAOExceptionTests {

        @Test
        @DisplayName("Constructor vacío debe crear excepción con mensaje por defecto")
        void defaultConstructorShouldHaveDefaultMessage() {
            DAOException ex = new DAOException();
            assertEquals("Ha ocurrido un error en la capa de persistencia del sistema", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje debe asignar mensaje personalizado")
        void messageConstructorShouldWork() {
            DAOException ex = new DAOException("Error personalizado");
            assertEquals("Error personalizado", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa raíz");
            DAOException ex = new DAOException("Error con causa", cause);
            assertEquals("Error con causa", ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("DAOException debe extender Exception")
        void shouldExtendException() {
            DAOException ex = new DAOException();
            assertInstanceOf(Exception.class, ex);
        }
    }

    // ===================== DataNotFoundException =====================

    @Nested
    @DisplayName("DataNotFoundException Tests")
    class DataNotFoundExceptionTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            DataNotFoundException ex = new DataNotFoundException();
            assertEquals("No se han encontrado registros", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            DataNotFoundException ex = new DataNotFoundException("No encontrado");
            assertEquals("No encontrado", ex.getMessage());
        }

        @Test
        @DisplayName("Debe extender DAOException")
        void shouldExtendDAOException() {
            DataNotFoundException ex = new DataNotFoundException();
            assertInstanceOf(DAOException.class, ex);
        }
    }

    // ===================== PersistenceException =====================

    @Nested
    @DisplayName("PersistenceException Tests")
    class PersistenceExceptionTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            PersistenceException ex = new PersistenceException();
            assertEquals("Error en la capa de persistencia.", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            PersistenceException ex = new PersistenceException("Error persistencia");
            assertEquals("Error persistencia", ex.getMessage());
        }

        @Test
        @DisplayName("Debe extender DAOException")
        void shouldExtendDAOException() {
            PersistenceException ex = new PersistenceException();
            assertInstanceOf(DAOException.class, ex);
        }
    }

    // ===================== NotFound Subclasses =====================

    @Nested
    @DisplayName("BeneficiaryNotFoundException Tests")
    class BeneficiaryNotFoundTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            BeneficiaryNotFoundException ex = new BeneficiaryNotFoundException();
            assertEquals("No se han encontrado registros de Beneficiarios", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con parámetro debe incluirlo en el mensaje")
        void paramConstructorShouldIncludeParam() {
            BeneficiaryNotFoundException ex = new BeneficiaryNotFoundException("12345");
            assertTrue(ex.getMessage().contains("12345"));
        }

        @Test
        @DisplayName("Debe extender DataNotFoundException")
        void shouldExtendDataNotFoundException() {
            BeneficiaryNotFoundException ex = new BeneficiaryNotFoundException();
            assertInstanceOf(DataNotFoundException.class, ex);
        }
    }

    @Nested
    @DisplayName("PropertyNotFoundException Tests")
    class PropertyNotFoundTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            PropertyNotFoundException ex = new PropertyNotFoundException();
            assertEquals("No se han encontrado registros de Predios", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con parámetro debe incluirlo en el mensaje")
        void paramConstructorShouldIncludeParam() {
            PropertyNotFoundException ex = new PropertyNotFoundException("CAD-001");
            assertTrue(ex.getMessage().contains("CAD-001"));
        }

        @Test
        @DisplayName("Debe extender DataNotFoundException")
        void shouldExtendDataNotFoundException() {
            PropertyNotFoundException ex = new PropertyNotFoundException();
            assertInstanceOf(DataNotFoundException.class, ex);
        }
    }

    @Nested
    @DisplayName("ResolutionNotFoundException Tests")
    class ResolutionNotFoundTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            ResolutionNotFoundException ex = new ResolutionNotFoundException();
            assertEquals("No se han encontrado registros de Resoluciones", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con parámetro debe incluirlo en el mensaje")
        void paramConstructorShouldIncludeParam() {
            ResolutionNotFoundException ex = new ResolutionNotFoundException("99999");
            assertTrue(ex.getMessage().contains("99999"));
        }

        @Test
        @DisplayName("Debe extender DataNotFoundException")
        void shouldExtendDataNotFoundException() {
            ResolutionNotFoundException ex = new ResolutionNotFoundException();
            assertInstanceOf(DataNotFoundException.class, ex);
        }
    }

    @Nested
    @DisplayName("SpouseNotFoundException Tests")
    class SpouseNotFoundTests {

        @Test
        @DisplayName("Constructor vacío debe tener mensaje por defecto")
        void defaultConstructorShouldWork() {
            SpouseNotFoundException ex = new SpouseNotFoundException();
            assertEquals("No se han encontrado registros de cónyuges", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con parámetro debe incluirlo en el mensaje")
        void paramConstructorShouldIncludeParam() {
            SpouseNotFoundException ex = new SpouseNotFoundException("5");
            assertTrue(ex.getMessage().contains("5"));
        }

        @Test
        @DisplayName("Debe extender DataNotFoundException")
        void shouldExtendDataNotFoundException() {
            SpouseNotFoundException ex = new SpouseNotFoundException();
            assertInstanceOf(DataNotFoundException.class, ex);
        }
    }

    // ===================== Persistence Subclasses =====================

    @Nested
    @DisplayName("BeneficiaryPersistenceException Tests")
    class BeneficiaryPersistenceTests {

        @Test
        @DisplayName("Constructor vacío debe funcionar")
        void defaultConstructorShouldWork() {
            BeneficiaryPersistenceException ex = new BeneficiaryPersistenceException();
            assertNotNull(ex);
        }

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            BeneficiaryPersistenceException ex = new BeneficiaryPersistenceException("Error beneficiario");
            assertEquals("Error beneficiario", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa");
            BeneficiaryPersistenceException ex = new BeneficiaryPersistenceException("Error", cause);
            assertEquals("Error", ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("Debe extender PersistenceException")
        void shouldExtendPersistenceException() {
            BeneficiaryPersistenceException ex = new BeneficiaryPersistenceException();
            assertInstanceOf(PersistenceException.class, ex);
        }
    }

    @Nested
    @DisplayName("PropertyPersistenceException Tests")
    class PropertyPersistenceTests {

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            PropertyPersistenceException ex = new PropertyPersistenceException("Error propiedad");
            assertEquals("Error propiedad", ex.getMessage());
        }

        @Test
        @DisplayName("Constructor con mensaje y causa debe funcionar")
        void messageAndCauseConstructorShouldWork() {
            RuntimeException cause = new RuntimeException("causa");
            PropertyPersistenceException ex = new PropertyPersistenceException("Error", cause);
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("Debe extender PersistenceException")
        void shouldExtendPersistenceException() {
            PropertyPersistenceException ex = new PropertyPersistenceException("test");
            assertInstanceOf(PersistenceException.class, ex);
        }
    }

    @Nested
    @DisplayName("ResolutionPersistenceException Tests")
    class ResolutionPersistenceTests {

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            ResolutionPersistenceException ex = new ResolutionPersistenceException("Error resolución");
            assertEquals("Error resolución", ex.getMessage());
        }

        @Test
        @DisplayName("Debe extender PersistenceException")
        void shouldExtendPersistenceException() {
            ResolutionPersistenceException ex = new ResolutionPersistenceException("test");
            assertInstanceOf(PersistenceException.class, ex);
        }
    }

    @Nested
    @DisplayName("SpousePersistenceException Tests")
    class SpousePersistenceTests {

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            SpousePersistenceException ex = new SpousePersistenceException("Error cónyuge");
            assertEquals("Error cónyuge", ex.getMessage());
        }

        @Test
        @DisplayName("Debe extender PersistenceException")
        void shouldExtendPersistenceException() {
            SpousePersistenceException ex = new SpousePersistenceException("test");
            assertInstanceOf(PersistenceException.class, ex);
        }
    }

    @Nested
    @DisplayName("PointPersistenceException Tests")
    class PointPersistenceTests {

        @Test
        @DisplayName("Constructor con mensaje debe funcionar")
        void messageConstructorShouldWork() {
            PointPersistenceException ex = new PointPersistenceException("Error punto");
            assertEquals("Error punto", ex.getMessage());
        }

        @Test
        @DisplayName("Debe extender PersistenceException")
        void shouldExtendPersistenceException() {
            PointPersistenceException ex = new PointPersistenceException("test");
            assertInstanceOf(PersistenceException.class, ex);
        }
    }
}
