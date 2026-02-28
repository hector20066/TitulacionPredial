package com.hector.titulacionpredial.view.swing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ModelMenuItem Tests")
class ModelMenuItemTest {

    @Test
    @DisplayName("Constructor vacío debe crear modelo con valores nulos")
    void defaultConstructorShouldWork() {
        ModelMenuItem model = new ModelMenuItem();
        assertNull(model.getIcon());
        assertNull(model.getMenuName());
        assertNull(model.getSubMenu());
    }

    @Test
    @DisplayName("Constructor con parámetros debe asignar valores")
    void paramConstructorShouldWork() {
        ModelMenuItem model = new ModelMenuItem("icon.svg", "Dashboard", "Sub1", "Sub2", "Sub3");

        assertEquals("icon.svg", model.getIcon());
        assertEquals("Dashboard", model.getMenuName());
        assertNotNull(model.getSubMenu());
        assertEquals(3, model.getSubMenu().length);
        assertEquals("Sub1", model.getSubMenu()[0]);
        assertEquals("Sub2", model.getSubMenu()[1]);
        assertEquals("Sub3", model.getSubMenu()[2]);
    }

    @Test
    @DisplayName("Constructor sin submenú debe funcionar")
    void constructorWithoutSubMenuShouldWork() {
        ModelMenuItem model = new ModelMenuItem("icon.svg", "About");

        assertEquals("icon.svg", model.getIcon());
        assertEquals("About", model.getMenuName());
        assertNotNull(model.getSubMenu());
        assertEquals(0, model.getSubMenu().length);
    }

    @Test
    @DisplayName("Setters y getters deben funcionar correctamente")
    void settersAndGettersShouldWork() {
        ModelMenuItem model = new ModelMenuItem();
        model.setIcon("new-icon.svg");
        model.setMenuName("Nuevo Menú");
        model.setSubMenu(new String[]{"A", "B"});

        assertEquals("new-icon.svg", model.getIcon());
        assertEquals("Nuevo Menú", model.getMenuName());
        assertEquals(2, model.getSubMenu().length);
    }
}
