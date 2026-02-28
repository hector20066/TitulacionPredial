package com.hector.titulacionpredial.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("SQLRepository Tests")
class SQLRepositoryTest {

    @Nested
    @DisplayName("get() Tests")
    class GetTests {

        @Test
        @DisplayName("Debe cargar un archivo SQL válido desde el classpath")
        void shouldLoadValidSQLFile() {
            String sql = SQLRepository.get("sql/beneficiary/countRecords.sql");
            assertNotNull(sql);
            assertFalse(sql.isEmpty());
        }

        @Test
        @DisplayName("Debe retornar el mismo contenido en llamadas consecutivas (caché)")
        void shouldReturnCachedContent() {
            String first = SQLRepository.get("sql/beneficiary/findByAll.sql");
            String second = SQLRepository.get("sql/beneficiary/findByAll.sql");
            assertSame(first, second, "La segunda llamada debe retornar la misma instancia (caché)");
        }

        @Test
        @DisplayName("Debe lanzar RuntimeException para archivo SQL inexistente")
        void shouldThrowForNonExistentFile() {
            RuntimeException ex = assertThrows(RuntimeException.class,
                    () -> SQLRepository.get("sql/nonexistent/query.sql"));
            assertTrue(ex.getMessage().contains("SQL file not found"));
        }

        @Test
        @DisplayName("Debe cargar distintos archivos SQL correctamente")
        void shouldLoadDifferentFiles() {
            String beneficiary = SQLRepository.get("sql/beneficiary/insert.sql");
            String spouse = SQLRepository.get("sql/spouse/insert.sql");

            assertNotNull(beneficiary);
            assertNotNull(spouse);
            assertNotEquals(beneficiary, spouse, "Archivos diferentes deben tener contenido diferente");
        }

        @Test
        @DisplayName("El contenido SQL debe ser legible como UTF-8")
        void contentShouldBeReadableUTF8() {
            String sql = SQLRepository.get("sql/beneficiary/countRecords.sql");
            // Los archivos SQL deben contener palabras clave SQL
            assertTrue(sql.toLowerCase().contains("select") || sql.toLowerCase().contains("insert")
                    || sql.toLowerCase().contains("count") || sql.toLowerCase().contains("from"),
                    "El archivo SQL debe contener palabras clave SQL válidas");
        }
    }

    @Nested
    @DisplayName("Utility Class Tests")
    class UtilityClassTests {

        @Test
        @DisplayName("El constructor privado debe impedir instanciación")
        void privateConstructorShouldPreventInstantiation() throws Exception {
            var constructor = SQLRepository.class.getDeclaredConstructor();
            assertFalse(constructor.canAccess(null), "El constructor debe ser privado");
            constructor.setAccessible(true);
            assertDoesNotThrow(() -> constructor.newInstance());
        }
    }
}
