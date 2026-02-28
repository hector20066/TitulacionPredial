package com.hector.titulacionpredial.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Property Entity Tests")
class PropertyTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe inicializar listas y arrays")
        void defaultConstructorShouldInitializeCollections() {
            Property property = new Property();

            assertEquals(0, property.getCode());
            assertNull(property.getCadastralId());
            assertNull(property.getArea());
            assertNotNull(property.getBeneficiaries());
            assertTrue(property.getBeneficiaries().isEmpty());
            assertNotNull(property.getPoints());
            assertEquals(4, property.getPoints().length);
        }

        @Test
        @DisplayName("Builder debe crear propiedad con todos los campos")
        void builderShouldCreateWithAllFields() {
            List<Beneficiary> beneficiaries = new ArrayList<>();
            beneficiaries.add(new Beneficiary());
            Point[] points = new Point[4];

            Property property = new Property.Builder()
                    .code(100L)
                    .cadastralId("CAD-001")
                    .area(250.5)
                    .beneficiaries(beneficiaries)
                    .points(points)
                    .build();

            assertEquals(100L, property.getCode());
            assertEquals("CAD-001", property.getCadastralId());
            assertEquals(250.5, property.getArea());
            assertEquals(1, property.getBeneficiaries().size());
            assertEquals(4, property.getPoints().length);
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setCode y getCode deben funcionar correctamente")
        void setAndGetCodeShouldWork() {
            Property p = new Property();
            p.setCode(42L);
            assertEquals(42L, p.getCode());
        }

        @Test
        @DisplayName("setCadastralId y getCadastralId deben funcionar correctamente")
        void setAndGetCadastralIdShouldWork() {
            Property p = new Property();
            p.setCadastralId("CATASTRO-123");
            assertEquals("CATASTRO-123", p.getCadastralId());
        }

        @Test
        @DisplayName("setArea y getArea deben funcionar correctamente")
        void setAndGetAreaShouldWork() {
            Property p = new Property();
            p.setArea(500.75);
            assertEquals(500.75, p.getArea());
        }

        @Test
        @DisplayName("setBeneficiaries y getBeneficiaries deben funcionar correctamente")
        void setAndGetBeneficiariesShouldWork() {
            Property p = new Property();
            List<Beneficiary> beneficiaries = new ArrayList<>();
            beneficiaries.add(new Beneficiary());
            beneficiaries.add(new Beneficiary());
            p.setBeneficiaries(beneficiaries);
            assertEquals(2, p.getBeneficiaries().size());
        }

        @Test
        @DisplayName("setPoints y getPoints deben funcionar correctamente")
        void setAndGetPointsShouldWork() {
            Property p = new Property();
            Point[] points = new Point[]{new Point(), new Point()};
            p.setPoints(points);
            assertEquals(2, p.getPoints().length);
        }
    }

    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString debe contener la información de la propiedad")
        void toStringShouldContainInfo() {
            Property property = new Property.Builder()
                    .code(1L)
                    .cadastralId("CAD-001")
                    .area(100.0)
                    .build();

            String result = property.toString();
            assertTrue(result.contains("CAD-001"));
            assertTrue(result.contains("100.0"));
        }
    }
}
