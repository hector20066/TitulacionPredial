package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DTOResolution Tests")
class DTOResolutionTest {

    @Test
    @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
    void defaultConstructorShouldWork() {
        DTOResolution dto = new DTOResolution();
        assertEquals(0, dto.getResolutionNumber());
        assertNull(dto.getExecutory());
        assertNull(dto.getAct());
        assertNull(dto.getPublicWriting());
        assertNull(dto.getNotification());
        assertNull(dto.getFmi());
        assertNull(dto.getNotary());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        DTOResolution dto = new DTOResolution();
        LocalDate execDate = LocalDate.of(2025, 3, 15);
        LocalDate notifDate = LocalDate.of(2025, 2, 1);

        dto.setResolutionNumber(54321L);
        dto.setExecutory(execDate);
        dto.setAct("Acto Test");
        dto.setPublicWriting("EP-001");
        dto.setNotification(notifDate);
        dto.setFmi("FMI-TEST");
        dto.setNotary("Notaría Segunda");

        assertEquals(54321L, dto.getResolutionNumber());
        assertEquals(execDate, dto.getExecutory());
        assertEquals("Acto Test", dto.getAct());
        assertEquals("EP-001", dto.getPublicWriting());
        assertEquals(notifDate, dto.getNotification());
        assertEquals("FMI-TEST", dto.getFmi());
        assertEquals("Notaría Segunda", dto.getNotary());
    }
}
