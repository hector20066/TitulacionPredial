package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
