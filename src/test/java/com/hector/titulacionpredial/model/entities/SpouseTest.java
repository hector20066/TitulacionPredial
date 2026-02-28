package com.hector.titulacionpredial.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
            assertNull(spouse.getBeneficiary());
        }

        @Test
        @DisplayName("Builder debe crear cónyuge con todos los campos")
        void builderShouldCreateWithAllFields() {
            Beneficiary beneficiary = new Beneficiary.Builder()
                    .id(111L)
                    .fullName("Juan")
                    .code(1)
                    .build();

            Spouse spouse = new Spouse.Builder()
                    .id(222L)
                    .fullName("María García")
                    .address("Calle 20")
                    .expeditionLocation("Cartagena")
                    .phone(3001111111L)
                    .beneficiary(beneficiary)
                    .build();

            assertEquals(222L, spouse.getId());
            assertEquals("María García", spouse.getFullName());
            assertEquals("Calle 20", spouse.getAddress());
            assertEquals("Cartagena", spouse.getExpeditionLocation());
            assertEquals(3001111111L, spouse.getPhone());
            assertNotNull(spouse.getBeneficiary());
            assertEquals(111L, spouse.getBeneficiary().getId());
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
        @DisplayName("setBeneficiary y getBeneficiary deben funcionar correctamente")
        void setAndGetBeneficiaryShouldWork() {
            Spouse spouse = new Spouse();
            Beneficiary b = new Beneficiary();
            b.setCode(5);
            spouse.setBeneficiary(b);

            assertNotNull(spouse.getBeneficiary());
            assertEquals(5, spouse.getBeneficiary().getCode());
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe incluir información de Person y Spouse")
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
