package com.hector.titulacionpredial.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.enums.MaritalStatus;

@DisplayName("DTOBeneficiary Tests")
class DTOBeneficiaryTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            assertNull(dto.getMaritalStatus());
            assertNull(dto.getAffectation());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setMaritalStatus y getMaritalStatus deben funcionar")
        void setAndGetMaritalStatusShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setMaritalStatus(MaritalStatus.MARRIED);
            assertEquals(MaritalStatus.MARRIED, dto.getMaritalStatus());
        }

        @Test
        @DisplayName("setAffectation y getAffectation deben funcionar")
        void setAndGetAffectationShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setAffectation("Ninguna");
            assertEquals("Ninguna", dto.getAffectation());
        }
    }

    @Nested
    @DisplayName("Builder Tests")
    class BuilderTests {

        @Test
        @DisplayName("Builder debe construir DTOBeneficiary con todos los campos")
        void builderShouldBuildWithAllFields() {
            DTOBeneficiary dto = new DTOBeneficiary.Builder<>()
                    .phone(3001234567L)
                    .maritalStatus(MaritalStatus.MARRIED)
                    .affectation("Ninguna")
                    .build();

            assertEquals(3001234567L, dto.getPhone());
            assertEquals(MaritalStatus.MARRIED, dto.getMaritalStatus());
            assertEquals("Ninguna", dto.getAffectation());
        }

        @Test
        @DisplayName("Builder con campos parciales debe dejar los demás en default")
        void builderWithPartialFieldsShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary.Builder<>()
                    .maritalStatus(MaritalStatus.SINGLE)
                    .build();

            assertEquals(MaritalStatus.SINGLE, dto.getMaritalStatus());
            assertEquals(0L, dto.getPhone());
            assertNull(dto.getAffectation());
        }
    }

    @Nested
    @DisplayName("Herencia Tests")
    class InheritanceTests {

        @Test
        @DisplayName("DTOBeneficiary debe heredar de DTOBasePerson")
        void shouldExtendDTOBasePerson() {
            DTOBeneficiary dto = new DTOBeneficiary();
            assertInstanceOf(DTOBasePerson.class, dto);
        }

        @Test
        @DisplayName("Debe heredar address y phone de DTOBasePerson")
        void shouldInheritBasePersonFields() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setPhone(123456L);
            assertEquals(123456L, dto.getPhone());
        }
    }
}
