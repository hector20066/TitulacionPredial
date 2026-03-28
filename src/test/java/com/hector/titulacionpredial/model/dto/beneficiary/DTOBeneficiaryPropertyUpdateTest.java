package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DTOBeneficiaryPropertyUpdate Tests")
class DTOBeneficiaryPropertyUpdateTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate();
        assertNull(dto.getCodeBeneficiaries());
        assertEquals(0, dto.getPropertyCode());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores correctamente")
    void paramConstructorShouldWork() {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate("BEN-001", 10);
        assertEquals("BEN-001", dto.getCodeBeneficiaries());
        assertEquals(10, dto.getPropertyCode());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate();
        dto.setCodeBeneficiaries("BEN-005");
        dto.setPropertyCode(25);

        assertEquals("BEN-005", dto.getCodeBeneficiaries());
        assertEquals(25, dto.getPropertyCode());
    }
}
