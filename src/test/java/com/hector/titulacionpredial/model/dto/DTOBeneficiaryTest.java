package com.hector.titulacionpredial.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

@DisplayName("DTOBeneficiary Tests")
class DTOBeneficiaryTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            assertNull(dto.getDepartment());
            assertNull(dto.getMunicipality());
            assertNull(dto.getNeighborhood());
            assertNull(dto.getCrossing());
            assertNull(dto.getPublication());
            assertNull(dto.getMaritalStatus());
            assertNull(dto.getAffectation());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setDepartment y getDepartment deben funcionar")
        void setAndGetDepartmentShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setDepartment(Department.ATLANTICO);
            assertEquals(Department.ATLANTICO, dto.getDepartment());
        }

        @Test
        @DisplayName("setMunicipality y getMunicipality deben funcionar")
        void setAndGetMunicipalityShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setMunicipality(Municipalities.BARRANQUILLA);
            assertEquals(Municipalities.BARRANQUILLA, dto.getMunicipality());
        }

        @Test
        @DisplayName("setNeighborhood y getNeighborhood deben funcionar")
        void setAndGetNeighborhoodShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setNeighborhood("Centro");
            assertEquals("Centro", dto.getNeighborhood());
        }

        @Test
        @DisplayName("setCrossing y getCrossing deben funcionar")
        void setAndGetCrossingShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setCrossing("Cruce A");
            assertEquals("Cruce A", dto.getCrossing());
        }

        @Test
        @DisplayName("setPublication y getPublication deben funcionar")
        void setAndGetPublicationShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setPublication("Pub-1");
            assertEquals("Pub-1", dto.getPublication());
        }

        @Test
        @DisplayName("setMaritalStatus y getMaritalStatus deben funcionar")
        void setAndGetMaritalStatusShouldWork() {
            DTOBeneficiary dto = new DTOBeneficiary();
            dto.setMaritalStatus(MaritalStatus.CASADO);
            assertEquals(MaritalStatus.CASADO, dto.getMaritalStatus());
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
            dto.setAddress("Calle Test");
            dto.setPhone(123456L);
            assertEquals("Calle Test", dto.getAddress());
            assertEquals(123456L, dto.getPhone());
        }
    }
}
