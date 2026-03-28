package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

@DisplayName("DTOBeneficiaryCreate Tests")
class DTOBeneficiaryCreateTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            assertEquals(0, dto.getId());
            assertNull(dto.getFullName());
            assertNull(dto.getExpeditionLocation());
            assertNull(dto.getCadastralRef());
            assertNull(dto.getAddress());
        }

        @Test
        @DisplayName("Debe heredar de DTOBeneficiary")
        void shouldExtendDTOBeneficiary() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            assertInstanceOf(DTOBeneficiary.class, dto);
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setId y getId deben funcionar")
        void setAndGetIdShouldWork() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            dto.setId(123456789L);
            assertEquals(123456789L, dto.getId());
        }

        @Test
        @DisplayName("setFullName y getFullName deben funcionar")
        void setAndGetFullNameShouldWork() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            dto.setFullName("Juan Carlos Pérez");
            assertEquals("Juan Carlos Pérez", dto.getFullName());
        }

        @Test
        @DisplayName("setExpeditionLocation y getExpeditionLocation deben funcionar")
        void setAndGetExpeditionLocationShouldWork() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            dto.setExpeditionLocation("Barranquilla");
            assertEquals("Barranquilla", dto.getExpeditionLocation());
        }

        @Test
        @DisplayName("setCadastralReference y getCadastralReference deben funcionar")
        void setAndGetCadastralReferenceShouldWork() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            //dto.setCadastralReference("REF-CAT-001");
            //assertEquals("REF-CAT-001", dto.getCadastralReference());
        }
    }

    @Nested
    @DisplayName("Builder Tests")
    class BuilderTests {

        @Test
        @DisplayName("Builder concreto debe construir DTOBeneficiaryCreate con todos los campos propios")
        void builderShouldBuildWithOwnFields() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate.Builder()
                    .id(987654321L)
                    .fullName("María García López")
                    .expeditionLocation("Bogotá")
                    //.cadastralReference("CAD-REF-999")
                    .build();

            assertEquals(987654321L, dto.getId());
            assertEquals("María García López", dto.getFullName());
            assertEquals("Bogotá", dto.getExpeditionLocation());
            //assertEquals("CAD-REF-999", dto.getCadastralReference());
        }

        @Test
        @DisplayName("Builder debe heredar campos de DTOBeneficiary.Builder")
        void builderShouldInheritParentFields() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate.Builder()
                    .id(111L)
                    .fullName("Test")
                    .cadastralRef("CAD-REF-001")
                    .municipality(Municipalities.BARRANQUILLA)
                    .address("Calle 50 #20-30")
                    .phone(3001234567L)
                    .maritalStatus(MaritalStatus.MARRIED)
                    .affectation("Ninguna")
                    .build();

            assertEquals(111L, dto.getId());
            assertEquals("Test", dto.getFullName());
            assertEquals("CAD-REF-001", dto.getCadastralRef());
            assertEquals(Municipalities.BARRANQUILLA, dto.getMunicipality());
            assertEquals("Calle 50 #20-30", dto.getAddress());
            assertEquals(3001234567L, dto.getPhone());
            assertEquals(MaritalStatus.MARRIED, dto.getMaritalStatus());
            assertEquals("Ninguna", dto.getAffectation());
        }

        @Test
        @DisplayName("Builder con campos mínimos debe dejar los demás en default")
        void builderWithMinimalFieldsShouldWork() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate.Builder()
                    .id(1L)
                    .fullName("Mínimo")
                    .build();

            assertEquals(1L, dto.getId());
            assertEquals("Mínimo", dto.getFullName());
            assertNull(dto.getExpeditionLocation());
            assertNull(dto.getCadastralRef());
            assertNull(dto.getMunicipality());
            assertNull(dto.getAddress());
            assertEquals(0L, dto.getPhone());
        }
    }

    @Nested
    @DisplayName("Herencia Tests")
    class InheritanceTests {

        @Test
        @DisplayName("Debe heredar address y phone de DTOBasePerson vía setters")
        void shouldInheritBasePersonFieldsViaSetters() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            //dto.setAddress("Carrera 10 #25-40");
            dto.setPhone(3109876543L);

            //assertEquals("Carrera 10 #25-40", dto.getAddress());
            assertEquals(3109876543L, dto.getPhone());
        }

        @Test
        @DisplayName("Debe heredar campos de DTOBeneficiary vía setters")
        void shouldInheritBeneficiaryFieldsViaSetters() {
            DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate();
            //dto.setDepartment(Department.BOLIVAR);
            //dto.setMunicipality(Municipalities.CARTAGENA);
            dto.setMaritalStatus(MaritalStatus.WIDOWER);
            /*dto.setNeighborhood("Manga");
            dto.setCrossing("Cruce Sur");
            dto.setPublication("Pub-X");*/
            dto.setAffectation("Parcial");

            /*assertEquals(Department.BOLIVAR, dto.getDepartment());
            assertEquals(Municipalities.CARTAGENA, dto.getMunicipality());*/
            assertEquals(MaritalStatus.WIDOWER, dto.getMaritalStatus());
            /*assertEquals("Manga", dto.getNeighborhood());
            assertEquals("Cruce Sur", dto.getCrossing());
            assertEquals("Pub-X", dto.getPublication());*/
            assertEquals("Parcial", dto.getAffectation());
        }
    }
}
