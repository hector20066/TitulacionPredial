package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

@DisplayName("DTOBeneficiaryPropertyDetails Tests")
class DTOBeneficiaryPropertyDetailsTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOBeneficiaryPropertyDetails dto = new DTOBeneficiaryPropertyDetails();
        assertNull(dto.getFullName());
        assertEquals(0, dto.getId());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores correctamente")
    void paramConstructorShouldWork() {
        DTOBeneficiaryPropertyDetails dto = new DTOBeneficiaryPropertyDetails(
                "Juan Pérez", 12345L, Municipalities.BARRANQUILLA, "Calle 10"
        );

        assertEquals("Juan Pérez", dto.getFullName());
        assertEquals(12345L, dto.getId());
        assertEquals(Municipalities.BARRANQUILLA, dto.getMunicipality());
        assertEquals("Calle 10", dto.getAddress());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOBeneficiaryPropertyDetails dto = new DTOBeneficiaryPropertyDetails();
        dto.setFullName("María García");
        dto.setCode(999L);

        assertEquals("María García", dto.getFullName());
        assertEquals(999L, dto.getId());
    }

    @Test
    @DisplayName("Debe heredar de DTOBeneficiary")
    void shouldExtendDTOBeneficiary() {
        DTOBeneficiaryPropertyDetails dto = new DTOBeneficiaryPropertyDetails();
        assertInstanceOf(DTOBeneficiary.class, dto);
    }

    @Test
    @DisplayName("Debe heredar address y phone de DTOBasePerson")
    void shouldInheritBasePersonFields() {
        DTOBeneficiaryPropertyDetails dto = new DTOBeneficiaryPropertyDetails();
        dto.setAddress("Calle Heredada 20");
        dto.setPhone(3201234567L);

        assertEquals("Calle Heredada 20", dto.getAddress());
        assertEquals(3201234567L, dto.getPhone());
    }

    @Test
    @DisplayName("Debe heredar department y maritalStatus de DTOBeneficiary")
    void shouldInheritBeneficiaryFields() {
        DTOBeneficiaryPropertyDetails dto = new DTOBeneficiaryPropertyDetails();
        dto.setDepartment(Department.ATLANTICO);
        dto.setMaritalStatus(MaritalStatus.MARRIED);
        dto.setNeighborhood("Centro");

        assertEquals(Department.ATLANTICO, dto.getDepartment());
        assertEquals(MaritalStatus.MARRIED, dto.getMaritalStatus());
        assertEquals("Centro", dto.getNeighborhood());
    }
}
