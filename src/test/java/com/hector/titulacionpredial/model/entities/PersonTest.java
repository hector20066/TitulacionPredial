package com.hector.titulacionpredial.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person Entity Tests")
class PersonTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear persona con valores por defecto")
        void defaultConstructorShouldCreatePersonWithDefaults() {
            Person person = new Person();

            assertEquals(0, person.getId());
            assertNull(person.getFullName());
            assertNull(person.getAddress());
            assertNull(person.getExpeditionLocation());
            assertEquals(0, person.getPhone());
        }

        @Test
        @DisplayName("Builder debe crear persona con todos los campos")
        void builderShouldCreatePersonWithAllFields() {
            Person person = new Person.Builder<>()
                    .id(123456789L)
                    .fullName("Juan Pérez")
                    .address("Calle 10 #5-20")
                    .expeditionLocation("Bogotá")
                    .phone(3001234567L)
                    .build();

            assertEquals(123456789L, person.getId());
            assertEquals("Juan Pérez", person.getFullName());
            assertEquals("Calle 10 #5-20", person.getAddress());
            assertEquals("Bogotá", person.getExpeditionLocation());
            assertEquals(3001234567L, person.getPhone());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setId y getId deben funcionar correctamente")
        void setAndGetIdShouldWork() {
            Person person = new Person();
            person.setId(999L);
            assertEquals(999L, person.getId());
        }

        @Test
        @DisplayName("setFullName y getFullName deben funcionar correctamente")
        void setAndGetFullNameShouldWork() {
            Person person = new Person();
            person.setFullName("María García");
            assertEquals("María García", person.getFullName());
        }

        @Test
        @DisplayName("setAddress y getAddress deben funcionar correctamente")
        void setAndGetAddressShouldWork() {
            Person person = new Person();
            person.setAddress("Carrera 15 #30-40");
            assertEquals("Carrera 15 #30-40", person.getAddress());
        }

        @Test
        @DisplayName("setExpeditionLocation y getExpeditionLocation deben funcionar correctamente")
        void setAndGetExpeditionLocationShouldWork() {
            Person person = new Person();
            person.setExpeditionLocation("Medellín");
            assertEquals("Medellín", person.getExpeditionLocation());
        }

        @Test
        @DisplayName("setPhone y getPhone deben funcionar correctamente")
        void setAndGetPhoneShouldWork() {
            Person person = new Person();
            person.setPhone(3109876543L);
            assertEquals(3109876543L, person.getPhone());
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe contener toda la información de la persona")
        void toStringShouldContainAllFields() {
            Person person = new Person.Builder<>()
                    .id(123456789L)
                    .fullName("Juan Pérez")
                    .address("Calle 10")
                    .expeditionLocation("Bogotá")
                    .phone(3001234567L)
                    .build();

            String result = person.toString();
            assertTrue(result.contains("123456789"));
            assertTrue(result.contains("Juan Pérez"));
            assertTrue(result.contains("Calle 10"));
            assertTrue(result.contains("Bogotá"));
            assertTrue(result.contains("3001234567"));
        }
    }

    @Nested
    @DisplayName("Builder Pattern Tests")
    class BuilderPatternTests {

        @Test
        @DisplayName("Builder debe soportar encadenamiento fluido")
        void builderShouldSupportFluentChaining() {
            Person.Builder<?> builder = new Person.Builder<>()
                    .id(1L)
                    .fullName("Test")
                    .address("Address")
                    .expeditionLocation("Location")
                    .phone(123L);

            Person person = builder.build();
            assertNotNull(person);
            assertEquals(1L, person.getId());
        }

        @Test
        @DisplayName("Builder con valores parciales debe crear persona con campos nulos")
        void builderWithPartialValuesShouldCreatePersonWithNullFields() {
            Person person = new Person.Builder<>()
                    .id(100L)
                    .fullName("Solo nombre")
                    .build();

            assertEquals(100L, person.getId());
            assertEquals("Solo nombre", person.getFullName());
            assertNull(person.getAddress());
            assertNull(person.getExpeditionLocation());
            assertEquals(0, person.getPhone());
        }
    }
}
