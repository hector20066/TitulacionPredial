package com.hector.titulacionpredial.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DTOSpouse Tests")
class DTOSpouseTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOSpouse dto = new DTOSpouse();
        assertEquals(0, dto.getId());
        assertNull(dto.getFullName());
        assertNull(dto.getExpeditionLocation());
        assertEquals(0, dto.getBeneficiaryCode());
    }

    @Test
    @DisplayName("Builder debe crear DTOSpouse con todos los campos")
    void builderShouldCreateWithAllFields() {
        DTOSpouse dto = new DTOSpouse.Builder()
                .id(123456L)
                .fullName("Ana López")
                .expeditionLocation("Bogotá")
                //.address("Calle 50")
                .phone(3001112222L)
                .beneficiaryCode(10)
                .build();

        assertEquals(123456L, dto.getId());
        assertEquals("Ana López", dto.getFullName());
        assertEquals("Bogotá", dto.getExpeditionLocation());
        //assertEquals("Calle 50", dto.getAddress());
        assertEquals(3001112222L, dto.getPhone());
        assertEquals(10, dto.getBeneficiaryCode());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOSpouse dto = new DTOSpouse();
        dto.setId(999L);
        dto.setFullName("Test Name");
        dto.setExpeditionLocation("Cali");
        dto.setBeneficiaryCode(5);

        assertEquals(999L, dto.getId());
        assertEquals("Test Name", dto.getFullName());
        assertEquals("Cali", dto.getExpeditionLocation());
        assertEquals(5, dto.getBeneficiaryCode());
    }

    @Test
    @DisplayName("DTOSpouse debe heredar de DTOBasePerson")
    void shouldExtendDTOBasePerson() {
        DTOSpouse dto = new DTOSpouse();
        assertInstanceOf(DTOBasePerson.class, dto);
    }
}
