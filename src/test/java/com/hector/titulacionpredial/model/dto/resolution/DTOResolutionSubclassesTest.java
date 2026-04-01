package com.hector.titulacionpredial.model.dto.resolution;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.dto.DTOResolution;

@DisplayName("DTOResolution Subclasses Tests")
class DTOResolutionSubclassesTest {

    @Nested
    @DisplayName("DTOResolutionCreate Tests")
    class DTOResolutionCreateTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOResolutionCreate dto = new DTOResolutionCreate();
            assertEquals(0, dto.getCodeBeneficiaries());
            assertNull(dto.getBeneficiaryName());
        }

        @Test
        @DisplayName("Builder debe crear DTOResolutionCreate correctamente")
        void builderShouldWork() {
            DTOResolutionCreate dto = new DTOResolutionCreate.Builder()
                    .resolutionNumber(100L)
                    .notification(LocalDate.of(2025, 1, 1))
                    .executory(LocalDate.of(2025, 2, 1))
                    .fmi("FMI-001")
                    .act("Acto 1")
                    .publicWriting("EP-001")
                    .notary("Notaría 1")
                    .propertyCode(10)
                    .beneficiaryName("Juan Pérez")
                    .build();

            assertEquals(100L, dto.getResolutionNumber());
            assertEquals(10, dto.getCodeBeneficiaries());
            assertEquals("Juan Pérez", dto.getBeneficiaryName());
            assertEquals("FMI-001", dto.getFmi());
            assertEquals(LocalDate.of(2025, 1, 1), dto.getNotification());
            assertEquals(LocalDate.of(2025, 2, 1), dto.getExecutory());
            assertEquals("Acto 1", dto.getAct());
            assertEquals("EP-001", dto.getPublicWriting());
            assertEquals("Notaría 1", dto.getNotary());
        }

        @Test
        @DisplayName("setPropertyCode debe funcionar correctamente")
        void setPropertyCodeShouldWork() {
            DTOResolutionCreate dto = new DTOResolutionCreate();
            dto.setPropertyCode(25);
            assertEquals(25, dto.getCodeBeneficiaries());
        }

        @Test
        @DisplayName("Debe heredar de DTOResolution")
        void shouldExtendDTOResolution() {
            DTOResolutionCreate dto = new DTOResolutionCreate();
            assertInstanceOf(DTOResolution.class, dto);
        }
    }

    @Nested
    @DisplayName("DTOResolutionDetails Tests")
    class DTOResolutionDetailsTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOResolutionDetails dto = new DTOResolutionDetails();
            assertEquals(0, dto.getCode());
            assertNull(dto.getBeneficiaryName());
        }

        @Test
        @DisplayName("Builder debe crear DTOResolutionDetails correctamente")
        void builderShouldWork() {
            DTOResolutionDetails dto = new DTOResolutionDetails.Builder()
                    .code(5)
                    .beneficiaryName("Ana López")
                    .resolutionNumber(200L)
                    .fmi("FMI-002")
                    .notification(LocalDate.of(2025, 3, 1))
                    .executory(LocalDate.of(2025, 4, 1))
                    .act("Acto Details")
                    .publicWriting("EP-Details")
                    .notary("Notaría Details")
                    .build();

            assertEquals(5, dto.getCode());
            assertEquals("Ana López", dto.getBeneficiaryName());
            assertEquals(200L, dto.getResolutionNumber());
            assertEquals("FMI-002", dto.getFmi());
            assertEquals(LocalDate.of(2025, 3, 1), dto.getNotification());
            assertEquals(LocalDate.of(2025, 4, 1), dto.getExecutory());
            assertEquals("Acto Details", dto.getAct());
            assertEquals("EP-Details", dto.getPublicWriting());
            assertEquals("Notaría Details", dto.getNotary());
        }

        @Test
        @DisplayName("Setters deben funcionar correctamente")
        void settersShouldWork() {
            DTOResolutionDetails dto = new DTOResolutionDetails();
            dto.setCode(99);
            dto.setBeneficiaryName("Test");
            assertEquals(99, dto.getCode());
            assertEquals("Test", dto.getBeneficiaryName());
        }
    }

    @Nested
    @DisplayName("DTOResolutionUpdate Tests")
    class DTOResolutionUpdateTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOResolutionUpdate dto = new DTOResolutionUpdate();
            assertEquals(0, dto.getCode());
        }

        @Test
        @DisplayName("Builder debe crear DTOResolutionUpdate correctamente")
        void builderShouldWork() {
            DTOResolutionUpdate dto = new DTOResolutionUpdate.Builder()
                    .code(15)
                    .resolutionNumber(300L)
                    .executory(LocalDate.of(2025, 5, 1))
                    .act("Acto Update")
                    .publicWriting("EP-Update")
                    .fmi("FMI-Update")
                    .notary("Notaría Update")
                    .build();

            assertEquals(15, dto.getCode());
            assertEquals(300L, dto.getResolutionNumber());
            assertEquals("Acto Update", dto.getAct());
            assertEquals(LocalDate.of(2025, 5, 1), dto.getExecutory());
            assertEquals("EP-Update", dto.getPublicWriting());
            assertEquals("FMI-Update", dto.getFmi());
            assertEquals("Notaría Update", dto.getNotary());
        }

        @Test
        @DisplayName("setCode y getCode deben funcionar")
        void setAndGetCodeShouldWork() {
            DTOResolutionUpdate dto = new DTOResolutionUpdate();
            dto.setCode(77);
            assertEquals(77, dto.getCode());
        }
    }
}
