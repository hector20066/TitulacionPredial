package com.hector.titulacionpredial.view.swing.menu;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EventMenuSelected Tests")
class EventMenuSelectedTest {

    @Test
    @DisplayName("Debe ser una interfaz funcional implementable con lambda")
    void shouldBeImplementableWithLambda() {
        EventMenuSelected event = (index, indexSubmenu) -> {};
        assertNotNull(event);
    }

    @Test
    @DisplayName("Lambda debe recibir parámetros correctos")
    void lambdaShouldReceiveCorrectParameters() {
        AtomicInteger capturedIndex = new AtomicInteger(-1);
        AtomicInteger capturedSubIndex = new AtomicInteger(-1);

        EventMenuSelected event = (index, indexSubmenu) -> {
            capturedIndex.set(index);
            capturedSubIndex.set(indexSubmenu);
        };

        event.menuSelected(3, 5);

        assertEquals(3, capturedIndex.get());
        assertEquals(5, capturedSubIndex.get());
    }

    @Test
    @DisplayName("Debe poder invocarse múltiples veces con diferentes valores")
    void shouldBeInvocableMultipleTimes() {
        AtomicInteger callCount = new AtomicInteger(0);

        EventMenuSelected event = (index, indexSubmenu) -> callCount.incrementAndGet();

        event.menuSelected(0, 0);
        event.menuSelected(1, 2);
        event.menuSelected(5, 10);

        assertEquals(3, callCount.get());
    }

    @Test
    @DisplayName("Debe manejar valores negativos")
    void shouldHandleNegativeValues() {
        AtomicInteger capturedIndex = new AtomicInteger(0);
        AtomicInteger capturedSubIndex = new AtomicInteger(0);

        EventMenuSelected event = (index, indexSubmenu) -> {
            capturedIndex.set(index);
            capturedSubIndex.set(indexSubmenu);
        };

        event.menuSelected(-1, -1);

        assertEquals(-1, capturedIndex.get());
        assertEquals(-1, capturedSubIndex.get());
    }

    @Test
    @DisplayName("Debe ser asignable desde referencia de método")
    void shouldWorkWithMethodReference() {
        EventMenuSelectedTest instance = new EventMenuSelectedTest();
        EventMenuSelected event = instance::handleMenuSelection;
        assertDoesNotThrow(() -> event.menuSelected(1, 2));
    }

    // Método auxiliar para la prueba de referencia de método
    void handleMenuSelection(int index, int indexSubmenu) {
        // No-op para prueba
    }
}
