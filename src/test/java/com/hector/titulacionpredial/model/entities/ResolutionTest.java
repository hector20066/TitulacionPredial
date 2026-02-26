package com.hector.titulacionpredial.model.entities;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Resolution Entity Tests")
class ResolutionTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear resolución con valores por defecto")
        void defaultConstructorShouldCreateWithDefaults() {
            Resolution resolution = new Resolution();

            assertEquals(0, resolution.getCode());
            assertEquals(0, resolution.getResolutionNumber());
            assertNull(resolution.getNotification());
            assertNull(resolution.getExecutory());
            assertNull(resolution.getFmi());
            assertNull(resolution.getAct());
            assertNull(resolution.getPublicWriting());
            assertNull(resolution.getNotary());
            assertNull(resolution.getProperty());
            assertNull(resolution.getBeneficiary());
        }

        @Test
        @DisplayName("Builder debe crear resolución con todos los campos")
        void builderShouldCreateWithAllFields() {
            LocalDate notificationDate = LocalDate.of(2025, 1, 15);
            LocalDate executoryDate = LocalDate.of(2025, 2, 15);
            Property property = new Property();
            Beneficiary beneficiary = new Beneficiary();

            Resolution resolution = new Resolution.Builder()
                    .code(1)
                    .resolutionNumber(12345L)
                    .notification(notificationDate)
                    .executory(executoryDate)
                    .fmi("FMI-001")
                    .act("Acto 123")
                    .publicWriting("EP-456")
                    .notary("Notaría Primera")
                    .property(property)
                    .beneficiary(beneficiary)
                    .build();

            assertEquals(1, resolution.getCode());
            assertEquals(12345L, resolution.getResolutionNumber());
            assertEquals(notificationDate, resolution.getNotification());
            assertEquals(executoryDate, resolution.getExecutory());
            assertEquals("FMI-001", resolution.getFmi());
            assertEquals("Acto 123", resolution.getAct());
            assertEquals("EP-456", resolution.getPublicWriting());
            assertEquals("Notaría Primera", resolution.getNotary());
            assertNotNull(resolution.getProperty());
            assertNotNull(resolution.getBeneficiary());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setCode y getCode deben funcionar correctamente")
        void setAndGetCodeShouldWork() {
            Resolution r = new Resolution();
            r.setCode(10);
            assertEquals(10, r.getCode());
        }

        @Test
        @DisplayName("setResolutionNumber y getResolutionNumber deben funcionar")
        void setAndGetResolutionNumberShouldWork() {
            Resolution r = new Resolution();
            r.setResolutionNumber(99999L);
            assertEquals(99999L, r.getResolutionNumber());
        }

        @Test
        @DisplayName("setNotification y getNotification deben funcionar")
        void setAndGetNotificationShouldWork() {
            Resolution r = new Resolution();
            LocalDate date = LocalDate.of(2025, 6, 1);
            r.setNotification(date);
            assertEquals(date, r.getNotification());
        }

        @Test
        @DisplayName("setExecutory y getExecutory deben funcionar")
        void setAndGetExecutoryShouldWork() {
            Resolution r = new Resolution();
            LocalDate date = LocalDate.of(2025, 7, 1);
            r.setExecutory(date);
            assertEquals(date, r.getExecutory());
        }

        @Test
        @DisplayName("setFmi y getFmi deben funcionar correctamente")
        void setAndGetFmiShouldWork() {
            Resolution r = new Resolution();
            r.setFmi("FMI-TEST");
            assertEquals("FMI-TEST", r.getFmi());
        }

        @Test
        @DisplayName("setAct y getAct deben funcionar correctamente")
        void setAndGetActShouldWork() {
            Resolution r = new Resolution();
            r.setAct("Acto Test");
            assertEquals("Acto Test", r.getAct());
        }

        @Test
        @DisplayName("setPublicWriting y getPublicWriting deben funcionar")
        void setAndGetPublicWritingShouldWork() {
            Resolution r = new Resolution();
            r.setPublicWriting("EP-Test");
            assertEquals("EP-Test", r.getPublicWriting());
        }

        @Test
        @DisplayName("setNotary y getNotary deben funcionar correctamente")
        void setAndGetNotaryShouldWork() {
            Resolution r = new Resolution();
            r.setNotary("Notaría Test");
            assertEquals("Notaría Test", r.getNotary());
        }

        @Test
        @DisplayName("setProperty y getProperty deben funcionar correctamente")
        void setAndGetPropertyShouldWork() {
            Resolution r = new Resolution();
            Property p = new Property();
            r.setProperty(p);
            assertNotNull(r.getProperty());
        }

        @Test
        @DisplayName("setBeneficiary y getBeneficiary deben funcionar correctamente")
        void setAndGetBeneficiaryShouldWork() {
            Resolution r = new Resolution();
            Beneficiary b = new Beneficiary();
            r.setBeneficiary(b);
            assertNotNull(r.getBeneficiary());
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe contener la información de la resolución")
        void toStringShouldContainAllFields() {
            Resolution resolution = new Resolution.Builder()
                    .code(1)
                    .resolutionNumber(12345L)
                    .fmi("FMI-001")
                    .act("Acto 123")
                    .notary("Notaría Primera")
                    .build();

            String result = resolution.toString();
            assertTrue(result.contains("12345"));
            assertTrue(result.contains("FMI-001"));
            assertTrue(result.contains("Acto 123"));
            assertTrue(result.contains("Notaría Primera"));
        }
    }
}
