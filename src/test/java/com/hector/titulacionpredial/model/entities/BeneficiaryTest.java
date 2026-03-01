package com.hector.titulacionpredial.model.entities;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Beneficiary Entity Tests")
class BeneficiaryTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear beneficiario con valores por defecto")
        void defaultConstructorShouldCreateWithDefaults() {
            Beneficiary beneficiary = new Beneficiary();

            assertEquals(0, beneficiary.getCode());
            assertNull(beneficiary.getDepartment());
            assertNull(beneficiary.getMunicipality());
            assertNull(beneficiary.getCadastralReference());
            assertNull(beneficiary.getMaritalStatus());
            assertNull(beneficiary.getAffectation());
            assertNull(beneficiary.getCrossing());
            assertNull(beneficiary.getPublication());
            assertNull(beneficiary.getNeighborhood());
        }

        @Test
        @DisplayName("Builder debe crear beneficiario con todos los campos")
        void builderShouldCreateWithAllFields() {
            Beneficiary beneficiary = new Beneficiary.Builder()
                    .id(123456789L)
                    .fullName("Juan Pérez")
                    .address("Calle 10 #5-20")
                    .expeditionLocation("Bogotá")
                    .phone(3001234567L)
                    .code(1)
                    .department(Department.ATLANTICO)
                    .municipality(Municipalities.BARRANQUILLA)
                    .cadastralReference("REF-001")
                    .maritalStatus(MaritalStatus.MARRIED)
                    .affectation("Ninguna")
                    .crossing("Cruce A")
                    .publication("Pub-001")
                    .neighborhood("Centro")
                    .build();

            assertEquals(123456789L, beneficiary.getId());
            assertEquals("Juan Pérez", beneficiary.getFullName());
            assertEquals("Calle 10 #5-20", beneficiary.getAddress());
            assertEquals("Bogotá", beneficiary.getExpeditionLocation());
            assertEquals(3001234567L, beneficiary.getPhone());
            assertEquals(1, beneficiary.getCode());
            assertEquals(Department.ATLANTICO, beneficiary.getDepartment());
            assertEquals(Municipalities.BARRANQUILLA, beneficiary.getMunicipality());
            assertEquals("REF-001", beneficiary.getCadastralReference());
            assertEquals(MaritalStatus.MARRIED, beneficiary.getMaritalStatus());
            assertEquals("Ninguna", beneficiary.getAffectation());
            assertEquals("Cruce A", beneficiary.getCrossing());
            assertEquals("Pub-001", beneficiary.getPublication());
            assertEquals("Centro", beneficiary.getNeighborhood());
        }
    }

    @Nested
    @DisplayName("Herencia Tests")
    class InheritanceTests {

        @Test
        @DisplayName("Beneficiary debe ser instancia de Person")
        void beneficiaryShouldBeInstanceOfPerson() {
            Beneficiary beneficiary = new Beneficiary();
            assertInstanceOf(Person.class, beneficiary);
        }

        @Test
        @DisplayName("Builder debe heredar campos de Person.Builder")
        void builderShouldInheritPersonFields() {
            Beneficiary beneficiary = new Beneficiary.Builder()
                    .id(999L)
                    .fullName("Test Person")
                    .code(5)
                    .build();

            assertEquals(999L, beneficiary.getId());
            assertEquals("Test Person", beneficiary.getFullName());
            assertEquals(5, beneficiary.getCode());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setCode y getCode deben funcionar correctamente")
        void setAndGetCodeShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setCode(42);
            assertEquals(42, b.getCode());
        }

        @Test
        @DisplayName("setDepartment y getDepartment deben funcionar correctamente")
        void setAndGetDepartmentShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setDepartment(Department.ANTIOQUIA);
            assertEquals(Department.ANTIOQUIA, b.getDepartment());
        }

        @Test
        @DisplayName("setMunicipality y getMunicipality deben funcionar correctamente")
        void setAndGetMunicipalityShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setMunicipality(Municipalities.MEDELLIN);
            assertEquals(Municipalities.MEDELLIN, b.getMunicipality());
        }

        @Test
        @DisplayName("setMaritalStatus y getMaritalStatus deben funcionar correctamente")
        void setAndGetMaritalStatusShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setMaritalStatus(MaritalStatus.SINGLE);
            assertEquals(MaritalStatus.SINGLE, b.getMaritalStatus());
        }

        @Test
        @DisplayName("setCadastralReference y getCadastralReference deben funcionar")
        void setAndGetCadastralReferenceShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setCadastralReference("CAD-123");
            assertEquals("CAD-123", b.getCadastralReference());
        }

        @Test
        @DisplayName("setAffectation y getAffectation deben funcionar correctamente")
        void setAndGetAffectationShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setAffectation("Tipo A");
            assertEquals("Tipo A", b.getAffectation());
        }

        @Test
        @DisplayName("setCrossing y getCrossing deben funcionar correctamente")
        void setAndGetCrossingShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setCrossing("Cruce 1");
            assertEquals("Cruce 1", b.getCrossing());
        }

        @Test
        @DisplayName("setPublication y getPublication deben funcionar correctamente")
        void setAndGetPublicationShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setPublication("Pub X");
            assertEquals("Pub X", b.getPublication());
        }

        @Test
        @DisplayName("setNeighborhood y getNeighborhood deben funcionar correctamente")
        void setAndGetNeighborhoodShouldWork() {
            Beneficiary b = new Beneficiary();
            b.setNeighborhood("Barrio Sur");
            assertEquals("Barrio Sur", b.getNeighborhood());
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe incluir campos de Person y Beneficiary")
        void toStringShouldContainAllFields() {
            Beneficiary beneficiary = new Beneficiary.Builder()
                    .id(1234L)
                    .fullName("Ana López")
                    .code(10)
                    .department(Department.ATLANTICO)
                    .municipality(Municipalities.SOLEDAD)
                    .maritalStatus(MaritalStatus.FREE_UNION)
                    .build();

            String result = beneficiary.toString();
            assertTrue(result.contains("1234"));
            assertTrue(result.contains("Ana López"));
            assertTrue(result.contains("10"));
            assertTrue(result.contains("ATLANTICO"));
            assertTrue(result.contains("SOLEDAD"));
            assertTrue(result.contains("FREE_UNION"));
        }
    }
}
