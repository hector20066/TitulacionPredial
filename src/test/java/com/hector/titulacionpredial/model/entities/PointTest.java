package com.hector.titulacionpredial.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Point Entity Tests")
class PointTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear punto con valores por defecto")
        void defaultConstructorShouldCreateWithDefaults() {
            Point point = new Point();

            assertEquals(0, point.getCode());
            assertEquals(0, point.getNumberPoint());
            assertNull(point.getNorthCoordinate());
            assertNull(point.getEastCoordinate());
            assertNull(point.getDistance());
            assertNull(point.getHillside());
        }

        @Test
        @DisplayName("Builder debe crear punto con todos los campos")
        void builderShouldCreateWithAllFields() {
            Point point = new Point.Builder()
                    .code(1)
                    .numberPoint(2)
                    .northCoordinate(10.5)
                    .eastCoordinate(20.3)
                    .distance(15.7)
                    .hillside("Norte")
                    .build();

            assertEquals(1, point.getCode());
            assertEquals(2, point.getNumberPoint());
            assertEquals(10.5, point.getNorthCoordinate());
            assertEquals(20.3, point.getEastCoordinate());
            assertEquals(15.7, point.getDistance());
            assertEquals("Norte", point.getHillside());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setCode y getCode deben funcionar correctamente")
        void setAndGetCodeShouldWork() {
            Point p = new Point();
            p.setCode(5);
            assertEquals(5, p.getCode());
        }

        @Test
        @DisplayName("setNumberPoint y getNumberPoint deben funcionar correctamente")
        void setAndGetNumberPointShouldWork() {
            Point p = new Point();
            p.setNumberPoint(3);
            assertEquals(3, p.getNumberPoint());
        }

        @Test
        @DisplayName("setNorthCoordinate y getNorthCoordinate deben funcionar correctamente")
        void setAndGetNorthCoordinateShouldWork() {
            Point p = new Point();
            p.setNorthCoordinate(45.123);
            assertEquals(45.123, p.getNorthCoordinate());
        }

        @Test
        @DisplayName("setEastCoordinate y getEastCoordinate deben funcionar correctamente")
        void setAndGetEastCoordinateShouldWork() {
            Point p = new Point();
            p.setEastCoordinate(75.456);
            assertEquals(75.456, p.getEastCoordinate());
        }

        @Test
        @DisplayName("setDistance y getDistance deben funcionar correctamente")
        void setAndGetDistanceShouldWork() {
            Point p = new Point();
            p.setDistance(100.0);
            assertEquals(100.0, p.getDistance());
        }

        @Test
        @DisplayName("setHillside y getHillside deben funcionar correctamente")
        void setAndGetHillsideShouldWork() {
            Point p = new Point();
            p.setHillside("Sur");
            assertEquals("Sur", p.getHillside());
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe contener toda la información del punto")
        void toStringShouldContainAllFields() {
            Point point = new Point.Builder()
                    .code(1)
                    .numberPoint(2)
                    .northCoordinate(10.5)
                    .eastCoordinate(20.3)
                    .distance(15.7)
                    .hillside("Norte")
                    .build();

            String result = point.toString();
            assertTrue(result.contains("10.5"));
            assertTrue(result.contains("20.3"));
            assertTrue(result.contains("15.7"));
            assertTrue(result.contains("Norte"));
        }
    }
}
