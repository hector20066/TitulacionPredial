package com.hector.titulacionpredial.view.swing.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("ModelChart Tests")
class ModelChartTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor vacío debe crear modelo con valores nulos")
        void defaultConstructorShouldWork() {
            ModelChart model = new ModelChart();
            assertNull(model.getLabel());
            assertNull(model.getValues());
        }

        @Test
        @DisplayName("Constructor con parámetros debe asignar valores")
        void paramConstructorShouldWork() {
            double[] values = {10.0, 20.0, 30.0};
            ModelChart model = new ModelChart("Mes", values);

            assertEquals("Mes", model.getLabel());
            assertArrayEquals(values, model.getValues());
        }
    }

    @Nested
    @DisplayName("getMaxValues Tests")
    class GetMaxValuesTests {

        @Test
        @DisplayName("getMaxValues debe retornar el valor máximo del array")
        void shouldReturnMaxValue() {
            ModelChart model = new ModelChart("Test", new double[]{5.0, 15.0, 10.0, 3.0});
            assertEquals(15.0, model.getMaxValues());
        }

        @Test
        @DisplayName("getMaxValues con un solo valor debe retornar ese valor")
        void shouldReturnSingleValue() {
            ModelChart model = new ModelChart("Test", new double[]{42.0});
            assertEquals(42.0, model.getMaxValues());
        }

        @Test
        @DisplayName("getMaxValues con todos ceros debe retornar 0")
        void shouldReturnZeroForAllZeros() {
            ModelChart model = new ModelChart("Test", new double[]{0.0, 0.0, 0.0});
            assertEquals(0.0, model.getMaxValues());
        }

        @Test
        @DisplayName("getMaxValues con el máximo al final debe funcionar")
        void shouldFindMaxAtEnd() {
            ModelChart model = new ModelChart("Test", new double[]{1.0, 2.0, 3.0, 100.0});
            assertEquals(100.0, model.getMaxValues());
        }

        @Test
        @DisplayName("getMaxValues con el máximo al inicio debe funcionar")
        void shouldFindMaxAtStart() {
            ModelChart model = new ModelChart("Test", new double[]{100.0, 2.0, 3.0, 1.0});
            assertEquals(100.0, model.getMaxValues());
        }
    }

    @Nested
    @DisplayName("Getter y Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("setLabel y getLabel deben funcionar")
        void setAndGetLabelShouldWork() {
            ModelChart model = new ModelChart();
            model.setLabel("Etiqueta");
            assertEquals("Etiqueta", model.getLabel());
        }

        @Test
        @DisplayName("setValues y getValues deben funcionar")
        void setAndGetValuesShouldWork() {
            ModelChart model = new ModelChart();
            double[] values = {1.0, 2.0, 3.0};
            model.setValues(values);
            assertArrayEquals(values, model.getValues());
        }
    }
}
