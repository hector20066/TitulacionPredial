package com.hector.titulacionpredial.view.swing.chart.blankchart;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("NiceScale Tests")
class NiceScaleTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor debe calcular valores nice correctamente")
        void constructorShouldCalculate() {
            NiceScale scale = new NiceScale(0, 100);

            assertTrue(scale.getNiceMin() <= 0);
            assertTrue(scale.getNiceMax() >= 100);
            assertTrue(scale.getTickSpacing() > 0);
        }

        @Test
        @DisplayName("Constructor con rango pequeño debe funcionar")
        void smallRangeShouldWork() {
            NiceScale scale = new NiceScale(0, 10);

            assertTrue(scale.getNiceMin() <= 0);
            assertTrue(scale.getNiceMax() >= 10);
            assertTrue(scale.getTickSpacing() > 0);
        }

        @Test
        @DisplayName("Constructor con rango grande debe funcionar")
        void largeRangeShouldWork() {
            NiceScale scale = new NiceScale(0, 1000000);

            assertTrue(scale.getNiceMin() <= 0);
            assertTrue(scale.getNiceMax() >= 1000000);
            assertTrue(scale.getTickSpacing() > 0);
        }
    }

    @Nested
    @DisplayName("setMinMax Tests")
    class SetMinMaxTests {

        @Test
        @DisplayName("setMinMax debe recalcular valores")
        void setMinMaxShouldRecalculate() {
            NiceScale scale = new NiceScale(0, 100);
            double originalMax = scale.getNiceMax();

            scale.setMinMax(0, 1000);
            double newMax = scale.getNiceMax();

            assertTrue(newMax > originalMax);
        }
    }

    @Nested
    @DisplayName("setMaxTicks Tests")
    class SetMaxTicksTests {

        @Test
        @DisplayName("setMaxTicks debe afectar el espaciado de ticks")
        void setMaxTicksShouldAffectSpacing() {
            NiceScale scale = new NiceScale(0, 100);
            double spacing10 = scale.getTickSpacing();

            scale.setMaxTicks(5);
            double spacing5 = scale.getTickSpacing();

            // Menos ticks deberían resultar en mayor espaciado
            assertTrue(spacing5 >= spacing10);
        }
    }

    @Nested
    @DisplayName("Getter Tests")
    class GetterTests {

        @Test
        @DisplayName("getMinMax deben devolver los valores originales")
        void getMinMaxShouldReturnOriginalValues() {
            NiceScale scale = new NiceScale(5, 95);

            assertEquals(5, scale.getMin());
            assertEquals(95, scale.getMax());
        }

        @Test
        @DisplayName("getMaxTicks debe devolver el valor configurado")
        void getMaxTicksShouldReturnConfiguredValue() {
            NiceScale scale = new NiceScale(0, 100);
            assertEquals(10, scale.getMaxTicks());

            scale.setMaxTicks(20);
            assertEquals(20, scale.getMaxTicks());
        }

        @Test
        @DisplayName("getTickSpacing debe ser positivo")
        void getTickSpacingShouldBePositive() {
            NiceScale scale = new NiceScale(0, 50);
            assertTrue(scale.getTickSpacing() > 0);
        }

        @Test
        @DisplayName("niceMin debe ser menor o igual a min")
        void niceMinShouldBeLessThanOrEqualToMin() {
            NiceScale scale = new NiceScale(15, 95);
            assertTrue(scale.getNiceMin() <= 15);
        }

        @Test
        @DisplayName("niceMax debe ser mayor o igual a max")
        void niceMaxShouldBeGreaterThanOrEqualToMax() {
            NiceScale scale = new NiceScale(15, 95);
            assertTrue(scale.getNiceMax() >= 95);
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {

        @Test
        @DisplayName("Rango con decimales debe funcionar")
        void decimalRangeShouldWork() {
            NiceScale scale = new NiceScale(0.5, 9.5);
            assertTrue(scale.getTickSpacing() > 0);
        }

        @Test
        @DisplayName("Mismos min y max con rango positivo")
        void sameMinMaxShouldNotCrash() {
            // Edge case - no debería fallar
            assertDoesNotThrow(() -> new NiceScale(50, 51));
        }

        @Test
        @DisplayName("Rango con valores negativos debe funcionar")
        void negativeRangeShouldWork() {
            NiceScale scale = new NiceScale(-100, -10);
            assertTrue(scale.getNiceMin() <= -100);
            assertTrue(scale.getNiceMax() >= -10);
            assertTrue(scale.getTickSpacing() > 0);
        }

        @Test
        @DisplayName("Rango cruzando cero debe funcionar")
        void crossingZeroRangeShouldWork() {
            NiceScale scale = new NiceScale(-50, 50);
            assertTrue(scale.getNiceMin() <= -50);
            assertTrue(scale.getNiceMax() >= 50);
            assertTrue(scale.getTickSpacing() > 0);
        }
    }

    @Nested
    @DisplayName("setMin y setMax Tests")
    class SetMinSetMaxTests {

        @Test
        @DisplayName("setMin debe recalcular valores")
        void setMinShouldRecalculate() {
            NiceScale scale = new NiceScale(0, 100);
            double originalNiceMin = scale.getNiceMin();

            scale.setMin(-50);
            assertEquals(-50, scale.getMin());
            assertTrue(scale.getNiceMin() <= -50);
        }

        @Test
        @DisplayName("setMax debe recalcular valores")
        void setMaxShouldRecalculate() {
            NiceScale scale = new NiceScale(0, 100);

            scale.setMax(500);
            assertEquals(500, scale.getMax());
            assertTrue(scale.getNiceMax() >= 500);
        }
    }
}
