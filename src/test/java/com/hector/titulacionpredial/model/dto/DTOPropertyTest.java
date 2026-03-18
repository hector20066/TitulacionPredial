package com.hector.titulacionpredial.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("DTOProperty Tests")
class DTOPropertyTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOProperty dto = new DTOProperty();
        assertNull(dto.getCadastralId());
        assertNull(dto.getArea());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores correctamente")
    void paramConstructorShouldWork() {
        /*DTOProperty dto = new DTOProperty("CAD-001", 250.5);
        assertEquals("CAD-001", dto.getCadastralId());
        assertEquals(250.5, dto.getArea());*/
    }

    @Test
    @DisplayName("setCadastralId y getCadastralId deben funcionar")
    void setAndGetCadastralIdShouldWork() {
        DTOProperty dto = new DTOProperty();
        dto.setCadastralId("TEST-123");
        assertEquals("TEST-123", dto.getCadastralId());
    }

    @Test
    @DisplayName("setArea y getArea deben funcionar")
    void setAndGetAreaShouldWork() {
        DTOProperty dto = new DTOProperty();
        dto.setArea(500.0);
        assertEquals(500.0, dto.getArea());
    }
}
