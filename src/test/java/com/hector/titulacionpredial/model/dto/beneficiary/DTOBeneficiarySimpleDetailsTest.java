package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.enums.MaritalStatus;

@DisplayName("DTOBeneficiarySimpleDetails Tests")
class DTOBeneficiarySimpleDetailsTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
        assertEquals(0, dto.getCode());
        assertEquals(0, dto.getId());
        assertNull(dto.getFullName());
        //assertNull(dto.getCadastralRef());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
        dto.setCode(10);
        dto.setId(123456L);
        dto.setFullName("Pedro Martínez");
        //dto.setCadastralRef("REF-999");

        assertEquals(10, dto.getCode());
        assertEquals(123456L, dto.getId());
        assertEquals("Pedro Martínez", dto.getFullName());
        //assertEquals("REF-999", dto.getCadastralRef());
    }

    @Test
    @DisplayName("Builder debe crear DTOBeneficiarySimpleDetails correctamente")
    void builderShouldCreateCorrectly() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails.Builder()
                .code(1)
                .id(999L)
                .fullName("Test Name")
                //.cadastralRef("CAD-001")
                //.department(Department.ATLANTICO)
                //.municipality(Municipalities.BARRANQUILLA)
                .maritalStatus(MaritalStatus.MARRIED)
                .build();

        assertEquals(1, dto.getCode());
        assertEquals(999L, dto.getId());
        assertEquals("Test Name", dto.getFullName());
        /*assertEquals("CAD-001", dto.getCadastralRef());
        assertEquals(Department.ATLANTICO, dto.getDepartment());
        assertEquals(Municipalities.BARRANQUILLA, dto.getMunicipality());*/
        assertEquals(MaritalStatus.MARRIED, dto.getMaritalStatus());
    }

    @Test
    @DisplayName("Builder debe heredar campos de DTOBeneficiary.Builder")
    void builderShouldInheritAllBeneficiaryFields() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails.Builder()
                .code(2)
                .id(555L)
                .fullName("Inherited Test")
                .phone(3109876543L)
                .expeditionLocation("Bogotá")
                .maritalStatus(MaritalStatus.WIDOWER)
                .affectation("Parcial")
                .build();

        assertEquals(2, dto.getCode());
        assertEquals(555L, dto.getId());
        assertEquals("Inherited Test", dto.getFullName());
        assertEquals(MaritalStatus.WIDOWER, dto.getMaritalStatus());
        assertEquals(3109876543L, dto.getPhone());
        assertEquals("Bogotá", dto.getExpeditionLocation());
        assertEquals("Parcial", dto.getAffectation());
    }
}
