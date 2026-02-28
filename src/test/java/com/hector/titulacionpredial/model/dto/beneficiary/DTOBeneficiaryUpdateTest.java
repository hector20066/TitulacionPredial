package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DTOBeneficiaryUpdate Tests")
class DTOBeneficiaryUpdateTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOBeneficiaryUpdate dto = new DTOBeneficiaryUpdate();
        assertEquals(0, dto.getCode());
    }

    @Test
    @DisplayName("Builder debe crear DTOBeneficiaryUpdate con todos los campos")
    void builderShouldCreateWithAllFields() {
        DTOBeneficiaryUpdate dto = new DTOBeneficiaryUpdate.Builder()
                .code(5)
                .department(Department.ANTIOQUIA)
                .municipality(Municipalities.MEDELLIN)
                .address("Calle 80")
                .maritalStatus(MaritalStatus.SOLTERO)
                .affectation("Ninguna")
                .phone(3001234567L)
                .crossing("Cruce B")
                .publication("Pub 2")
                .neighborhood("El Poblado")
                .build();

        assertEquals(5, dto.getCode());
        assertEquals(Department.ANTIOQUIA, dto.getDepartment());
        assertEquals(Municipalities.MEDELLIN, dto.getMunicipality());
        assertEquals("Calle 80", dto.getAddress());
        assertEquals(MaritalStatus.SOLTERO, dto.getMaritalStatus());
    }

    @Test
    @DisplayName("setCode y getCode deben funcionar correctamente")
    void setAndGetCodeShouldWork() {
        DTOBeneficiaryUpdate dto = new DTOBeneficiaryUpdate();
        dto.setCode(42);
        assertEquals(42, dto.getCode());
    }
}
