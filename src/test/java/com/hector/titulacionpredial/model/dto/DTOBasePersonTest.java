package com.hector.titulacionpredial.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("DTOBasePerson Tests")
class DTOBasePersonTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOBasePerson dto = new DTOBasePerson();
            assertNull(dto.getAddress());
            assertEquals(0, dto.getPhone());
        }

        @Test
        @DisplayName("Constructor con parámetros debe asignar correctamente")
        void paramConstructorShouldWork() {
            DTOBasePerson dto = new DTOBasePerson.Builder()
                    .fullName("Miguel Enrique Hoyos Ruiz")
                    .id(1068675432L)
                    .address("Calle 10")
                    .phone(3001234567L)
                    .build();
            assertEquals("Miguel Enrique Hoyos Ruiz", dto.getFullName());
            assertEquals(1068675432L, dto.getId());
            assertEquals("Calle 10", dto.getAddress());
            assertEquals(3001234567L, dto.getPhone());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setAddress y getAddress deben funcionar")
        void setAndGetAddressShouldWork() {
            DTOBasePerson dto = new DTOBasePerson();
            dto.setAddress("Carrera 5");
            assertEquals("Carrera 5", dto.getAddress());
        }

        @Test
        @DisplayName("setPhone y getPhone deben funcionar")
        void setAndGetPhoneShouldWork() {
            DTOBasePerson dto = new DTOBasePerson();
            dto.setPhone(3109999999L);
            assertEquals(3109999999L, dto.getPhone());
        }
    }
}
