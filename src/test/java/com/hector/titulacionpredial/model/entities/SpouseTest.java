package com.hector.titulacionpredial.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Spouse Entity Tests")
class SpouseTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear cónyuge con valores por defecto")
        void defaultConstructorShouldCreateWithDefaults() {
            Spouse spouse = new Spouse();

            assertEquals(0, spouse.getId());
            assertNull(spouse.getFullName());
        }

        @Test
        @DisplayName("Builder debe crear cónyuge con todos los campos heredados de Person")
        void builderShouldCreateWithAllFields() {
            Spouse spouse = new Spouse.Builder()
                    .id(222L)
                    .fullName("María García")
                    .address("Calle 20")
                    .expeditionLocation("Cartagena")
                    .phone(3001111111L)
                    .build();

            assertEquals(222L, spouse.getId());
            assertEquals("María García", spouse.getFullName());
            assertEquals("Calle 20", spouse.getAddress());
            assertEquals("Cartagena", spouse.getExpeditionLocation());
            assertEquals(3001111111L, spouse.getPhone());
        }
    }

    @Nested
    @DisplayName("Herencia Tests")
    class InheritanceTests {

        @Test
        @DisplayName("Spouse debe ser instancia de Person")
        void spouseShouldBeInstanceOfPerson() {
            Spouse spouse = new Spouse();
            assertInstanceOf(Person.class, spouse);
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("Setters y getters heredados de Person deben funcionar")
        void inheritedSettersAndGettersShouldWork() {
            Spouse spouse = new Spouse();
            spouse.setId(555L);
            spouse.setFullName("Test Cónyuge");
            spouse.setAddress("Calle Test");
            spouse.setPhone(3009999999L);
            spouse.setExpeditionLocation("Bogotá");

            assertEquals(555L, spouse.getId());
            assertEquals("Test Cónyuge", spouse.getFullName());
            assertEquals("Calle Test", spouse.getAddress());
            assertEquals(3009999999L, spouse.getPhone());
            assertEquals("Bogotá", spouse.getExpeditionLocation());
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe incluir información de Person")
        void toStringShouldContainInfo() {
            Spouse spouse = new Spouse.Builder()
                    .id(333L)
                    .fullName("Ana López")
                    .build();

            String result = spouse.toString();
            assertTrue(result.contains("333"));
            assertTrue(result.contains("Ana López"));
        }
    }
}
