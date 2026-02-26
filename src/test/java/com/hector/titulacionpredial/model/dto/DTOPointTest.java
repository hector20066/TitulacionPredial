package com.hector.titulacionpredial.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("DTOPoint Tests")
class DTOPointTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear DTO con valores por defecto")
        void defaultConstructorShouldWork() {
            DTOPoint dto = new DTOPoint();
            assertEquals(0, dto.getNumberPoint());
            assertNull(dto.getNorthCoordinate());
            assertNull(dto.getEastCoordinate());
            assertNull(dto.getDistance());
            assertNull(dto.getHillside());
            assertEquals(0, dto.getPropertyCode());
        }

        @Test
        @DisplayName("Builder debe crear DTOPoint con todos los campos")
        void builderShouldCreateWithAllFields() {
            DTOPoint dto = new DTOPoint.Builder()
                    .numberPoint(1)
                    .northCoordinate(10.5)
                    .eastCoordinate(20.3)
                    .distance(15.7)
                    .hillside("Norte")
                    .propertyCode(100)
                    .build();

            assertEquals(1, dto.getNumberPoint());
            assertEquals(10.5, dto.getNorthCoordinate());
            assertEquals(20.3, dto.getEastCoordinate());
            assertEquals(15.7, dto.getDistance());
            assertEquals("Norte", dto.getHillside());
            assertEquals(100, dto.getPropertyCode());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("Todos los setters y getters deben funcionar")
        void allGettersAndSettersShouldWork() {
            DTOPoint dto = new DTOPoint();
            dto.setNumberPoint(3);
            dto.setNorthCoordinate(45.0);
            dto.setEastCoordinate(75.0);
            dto.setDistance(100.5);
            dto.setHillside("Sur");
            dto.setPropertyCode(50);

            assertEquals(3, dto.getNumberPoint());
            assertEquals(45.0, dto.getNorthCoordinate());
            assertEquals(75.0, dto.getEastCoordinate());
            assertEquals(100.5, dto.getDistance());
            assertEquals("Sur", dto.getHillside());
            assertEquals(50, dto.getPropertyCode());
        }
    }

    @Nested
    @DisplayName("Builder Tests")
    class BuilderTests {

        @Test
        @DisplayName("Builder con valores parciales debe funcionar")
        void builderWithPartialValuesShouldWork() {
            DTOPoint dto = new DTOPoint.Builder()
                    .numberPoint(2)
                    .propertyCode(10)
                    .build();

            assertEquals(2, dto.getNumberPoint());
            assertEquals(10, dto.getPropertyCode());
            assertNull(dto.getNorthCoordinate());
            assertNull(dto.getEastCoordinate());
        }
    }
}
