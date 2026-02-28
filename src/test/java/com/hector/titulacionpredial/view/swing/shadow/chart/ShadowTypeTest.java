package com.hector.titulacionpredial.view.swing.shadow.chart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("ShadowType Tests")
class ShadowTypeTest {

    @Test
    @DisplayName("Debe tener exactamente 7 valores")
    void shouldHaveSevenValues() {
        assertEquals(7, ShadowType.values().length);
    }

    @ParameterizedTest
    @EnumSource(ShadowType.class)
    @DisplayName("valueOf debe funcionar para todos los valores")
    void valueOfShouldWorkForAllValues(ShadowType type) {
        assertNotNull(ShadowType.valueOf(type.name()));
        assertEquals(type, ShadowType.valueOf(type.name()));
    }

    @Test
    @DisplayName("Debe contener todos los valores esperados")
    void shouldContainExpectedValues() {
        assertNotNull(ShadowType.CENTER);
        assertNotNull(ShadowType.TOP_RIGHT);
        assertNotNull(ShadowType.TOP_LEFT);
        assertNotNull(ShadowType.BOT_RIGHT);
        assertNotNull(ShadowType.BOT_LEFT);
        assertNotNull(ShadowType.BOT);
        assertNotNull(ShadowType.TOP);
    }

    @Test
    @DisplayName("valueOf con nombre inválido debe lanzar IllegalArgumentException")
    void valueOfInvalidNameShouldThrow() {
        assertThrows(IllegalArgumentException.class,
                () -> ShadowType.valueOf("INVALID_VALUE"));
    }

    @Test
    @DisplayName("Los ordinales deben ser consecutivos")
    void ordinalsShouldBeConsecutive() {
        ShadowType[] values = ShadowType.values();
        for (int i = 0; i < values.length; i++) {
            assertEquals(i, values[i].ordinal());
        }
    }
}
