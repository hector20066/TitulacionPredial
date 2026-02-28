package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("DTOBeneficiarySimpleDetails Tests")
class DTOBeneficiarySimpleDetailsTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
        assertEquals(0, dto.getCode());
        assertEquals(0, dto.getId());
        assertNull(dto.getFullName());
        assertNull(dto.getCadastralReference());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
        dto.setCode(10);
        dto.setId(123456L);
        dto.setFullName("Pedro Martínez");
        dto.setCadastralReference("REF-999");

        assertEquals(10, dto.getCode());
        assertEquals(123456L, dto.getId());
        assertEquals("Pedro Martínez", dto.getFullName());
        assertEquals("REF-999", dto.getCadastralReference());
    }

    @Test
    @DisplayName("Builder debe crear DTOBeneficiarySimpleDetails correctamente")
    void builderShouldCreateCorrectly() {
        DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails.Builder()
                .code(1)
                .id(999L)
                .fullName("Test Name")
                .cadastralReference("CAD-001")
                .department(Department.ATLANTICO)
                .municipality(Municipalities.BARRANQUILLA)
                .maritalStatus(MaritalStatus.CASADO)
                .build();

        assertEquals(1, dto.getCode());
        assertEquals(999L, dto.getId());
        assertEquals("Test Name", dto.getFullName());
        assertEquals("CAD-001", dto.getCadastralReference());
        assertEquals(Department.ATLANTICO, dto.getDepartment());
        assertEquals(Municipalities.BARRANQUILLA, dto.getMunicipality());
        assertEquals(MaritalStatus.CASADO, dto.getMaritalStatus());
    }
}
