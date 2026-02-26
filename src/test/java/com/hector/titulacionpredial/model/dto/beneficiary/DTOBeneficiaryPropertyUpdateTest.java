package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DTOBeneficiaryPropertyUpdate Tests")
class DTOBeneficiaryPropertyUpdateTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate();
        assertEquals(0, dto.getBeneficiaryCode());
        assertEquals(0, dto.getPropertyCode());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores correctamente")
    void paramConstructorShouldWork() {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate(5, 10);
        assertEquals(5, dto.getBeneficiaryCode());
        assertEquals(10, dto.getPropertyCode());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOBeneficiaryPropertyUpdate dto = new DTOBeneficiaryPropertyUpdate();
        dto.setBeneficiaryCode(15);
        dto.setPropertyCode(25);

        assertEquals(15, dto.getBeneficiaryCode());
        assertEquals(25, dto.getPropertyCode());
    }
}
