package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

@DisplayName("DTOBeneficiaryDetails Tests")
class DTOBeneficiaryDetailsTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            assertEquals(0, dto.getCode());
            assertEquals(0L, dto.getIdSpouse());
            assertNull(dto.getFullNameSpouse());
            assertNull(dto.getExpeditionLocationSpouse());
            assertEquals(0L, dto.getPhoneSpouse());
            assertEquals(0, dto.getSpouseBeneficiaryCode());
        }

        @Test
        @DisplayName("Debe heredar de DTOBeneficiaryCreate")
        void shouldExtendDTOBeneficiaryCreate() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            assertInstanceOf(DTOBeneficiaryCreate.class, dto);
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setCode y getCode deben funcionar")
        void setAndGetCodeShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            dto.setCode(42);
            assertEquals(42, dto.getCode());
        }

        @Test
        @DisplayName("setIdSpouse y getIdSpouse deben funcionar")
        void setAndGetIdSpouseShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            dto.setIdSpouse(987654321L);
            assertEquals(987654321L, dto.getIdSpouse());
        }

        @Test
        @DisplayName("setFullNameSpouse y getFullNameSpouse deben funcionar")
        void setAndGetFullNameSpouseShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            dto.setFullNameSpouse("Ana María López");
            assertEquals("Ana María López", dto.getFullNameSpouse());
        }

        @Test
        @DisplayName("setExpeditionLocationSpouse y getExpeditionLocationSpouse deben funcionar")
        void setAndGetExpeditionLocationSpouseShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            dto.setExpeditionLocationSpouse("Medellín");
            assertEquals("Medellín", dto.getExpeditionLocationSpouse());
        }

        @Test
        @DisplayName("setPhoneSpouse y getPhoneSpouse deben funcionar")
        void setAndGetPhoneSpouseShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            dto.setPhoneSpouse(3109876543L);
            assertEquals(3109876543L, dto.getPhoneSpouse());
        }

        @Test
        @DisplayName("setSpouseBeneficiaryCode y getSpouseBeneficiaryCode deben funcionar")
        void setAndGetSpouseBeneficiaryCodeShouldWork() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails();
            dto.setSpouseBeneficiaryCode(15);
            assertEquals(15, dto.getSpouseBeneficiaryCode());
        }
    }

    @Nested
    @DisplayName("Builder Tests")
    class BuilderTests {

        @Test
        @DisplayName("Builder debe construir con todos los campos propios")
        void builderShouldBuildWithOwnFields() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails.Builder()
                    .code(10)
                    .idSpouse(555L)
                    .fullNameSpouse("Carmen Rodríguez")
                    .expeditionLocationSpouse("Cali")
                    .phoneSpouse(3201234567L)
                    .spouseBeneficiaryCode(10)
                    .build();

            assertEquals(10, dto.getCode());
            assertEquals(555L, dto.getIdSpouse());
            assertEquals("Carmen Rodríguez", dto.getFullNameSpouse());
            assertEquals("Cali", dto.getExpeditionLocationSpouse());
            assertEquals(3201234567L, dto.getPhoneSpouse());
            assertEquals(10, dto.getSpouseBeneficiaryCode());
        }

        @Test
        @DisplayName("Builder debe heredar campos de DTOBeneficiaryCreate.AbstractBuilder")
        void builderShouldInheritCreateFields() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails.Builder()
                    .code(1)
                    .id(123456L)
                    .fullName("Juan Pérez")
                    .expeditionLocation("Barranquilla")
                    //.cadastralReference("REF-001")
                    .build();

            assertEquals(1, dto.getCode());
            assertEquals(123456L, dto.getId());
            assertEquals("Juan Pérez", dto.getFullName());
            assertEquals("Barranquilla", dto.getExpeditionLocation());
            //assertEquals("REF-001", dto.getCadastralReference());
        }

        @Test
        @DisplayName("Builder debe heredar campos de DTOBeneficiary.Builder")
        void builderShouldInheritBeneficiaryFields() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails.Builder()
                    .code(1)
                    .municipality(Municipalities.BARRANQUILLA)
                    .address("Calle 72")
                    .phone(3001111111L)
                    .maritalStatus(MaritalStatus.MARRIED)
                    .affectation("Ninguna")
                    .build();

            assertEquals(Municipalities.BARRANQUILLA, dto.getMunicipality());
            assertEquals("Calle 72", dto.getAddress());
            assertEquals(3001111111L, dto.getPhone());
            assertEquals(MaritalStatus.MARRIED, dto.getMaritalStatus());
            assertEquals("Ninguna", dto.getAffectation());
        }

        @Test
        @DisplayName("Builder completo con todos los niveles de herencia")
        void fullBuilderShouldSetAllLevels() {
            DTOBeneficiaryDetails dto = new DTOBeneficiaryDetails.Builder()
                    // Propios de DTOBeneficiaryDetails
                    .code(99)
                    .department(com.hector.titulacionpredial.model.enums.Department.ANTIOQUIA)
                    .municipality(Municipalities.MEDELLIN)
                    .address("Calle 50")
                    .cadastralRef("CAD-123")
                    .crossing("Cruce Test")
                    .publication("Pub Test")
                    .neighborhood("Barrio Test")
                    .idSpouse(777L)
                    .fullNameSpouse("Spouse Name")
                    .expeditionLocationSpouse("Bogotá")
                    .phoneSpouse(3005555555L)
                    .spouseBeneficiaryCode(99)
                    // De DTOBeneficiaryCreate
                    .id(12345L)
                    .fullName("Beneficiary Name")
                    .expeditionLocation("Medellín")
                    // De DTOBeneficiary
                    .codeBeneficiaries("BEN-001")
                    .maritalStatus(MaritalStatus.FREE_UNION)
                    .affectation("Afect Test")
                    // De DTOBasePerson
                    .phone(3009999999L)
                    .build();

            // Verificar todos los niveles
            assertEquals(99, dto.getCode());
            assertEquals(com.hector.titulacionpredial.model.enums.Department.ANTIOQUIA, dto.getDepartment());
            assertEquals(Municipalities.MEDELLIN, dto.getMunicipality());
            assertEquals("Calle 50", dto.getAddress());
            assertEquals("CAD-123", dto.getCadastralRef());
            assertEquals("Cruce Test", dto.getCrossing());
            assertEquals("Pub Test", dto.getPublication());
            assertEquals("Barrio Test", dto.getNeighborhood());
            assertEquals(777L, dto.getIdSpouse());
            assertEquals("Spouse Name", dto.getFullNameSpouse());
            assertEquals("Bogotá", dto.getExpeditionLocationSpouse());
            assertEquals(3005555555L, dto.getPhoneSpouse());
            assertEquals(99, dto.getSpouseBeneficiaryCode());
            assertEquals(12345L, dto.getId());
            assertEquals("Beneficiary Name", dto.getFullName());
            assertEquals("Medellín", dto.getExpeditionLocation());
            assertEquals("BEN-001", dto.getCodeBeneficiaries());
            assertEquals(MaritalStatus.FREE_UNION, dto.getMaritalStatus());
            assertEquals("Afect Test", dto.getAffectation());
            assertEquals(3009999999L, dto.getPhone());
        }
    }
}
