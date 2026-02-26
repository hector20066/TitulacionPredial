package com.hector.titulacionpredial.view.swing.model;

import javax.swing.Icon;
import javax.swing.UIManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CardModel Tests")
class CardModelTest {

    @Test
    @DisplayName("Constructor vacío debe crear instancia con campos nulos")
    void defaultConstructorShouldCreateNullFields() {
        CardModel card = new CardModel();
        assertNull(card.getIcon());
        assertNull(card.getTitle());
        assertNull(card.getValues());
        assertNull(card.getDescription());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores")
    void paramConstructorShouldAssignValues() {
        Icon icon = UIManager.getIcon("FileView.fileIcon");
        CardModel card = new CardModel(icon, "Título", "100", "Descripción de prueba");

        assertEquals(icon, card.getIcon());
        assertEquals("Título", card.getTitle());
        assertEquals("100", card.getValues());
        assertEquals("Descripción de prueba", card.getDescription());
    }

    @Test
    @DisplayName("Constructor con icon null debe funcionar")
    void constructorWithNullIconShouldWork() {
        CardModel card = new CardModel(null, "Título", "50", "Desc");

        assertNull(card.getIcon());
        assertEquals("Título", card.getTitle());
        assertEquals("50", card.getValues());
        assertEquals("Desc", card.getDescription());
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        CardModel card = new CardModel();

        card.setTitle("Nuevo Título");
        card.setValues("200");
        card.setDescription("Nueva Descripción");

        assertEquals("Nuevo Título", card.getTitle());
        assertEquals("200", card.getValues());
        assertEquals("Nueva Descripción", card.getDescription());
    }

    @Test
    @DisplayName("setIcon debe establecer el icono")
    void setIconShouldWork() {
        CardModel card = new CardModel();
        Icon icon = UIManager.getIcon("FileView.directoryIcon");
        card.setIcon(icon);
        assertEquals(icon, card.getIcon());
    }

    @Test
    @DisplayName("Debe permitir establecer valores vacíos")
    void shouldAllowEmptyValues() {
        CardModel card = new CardModel(null, "", "", "");

        assertEquals("", card.getTitle());
        assertEquals("", card.getValues());
        assertEquals("", card.getDescription());
    }
}
