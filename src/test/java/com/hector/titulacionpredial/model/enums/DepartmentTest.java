package com.hector.titulacionpredial.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Department Enum Tests")
class DepartmentTest {

    @Test
    @DisplayName("Debe contener departamento ATLANTICO")
    void shouldContainAtlantico() {
        assertNotNull(Department.ATLANTICO);
        assertEquals("Atlántico", Department.ATLANTICO.getValue());
    }

    @Test
    @DisplayName("Debe contener departamento ANTIOQUIA")
    void shouldContainAntioquia() {
        assertNotNull(Department.ANTIOQUIA);
        assertEquals("Antioquia", Department.ANTIOQUIA.getValue());
    }

    @Test
    @DisplayName("ATLANTICO debe tener municipios correctos incluyendo BARRANQUILLA")
    void atlanticoShouldContainBarranquilla() {
        List<Municipalities> municipalities = Department.ATLANTICO.getMunicipalities();
        assertNotNull(municipalities);
        assertFalse(municipalities.isEmpty());
        assertTrue(municipalities.contains(Municipalities.BARRANQUILLA));
    }

    @Test
    @DisplayName("ANTIOQUIA debe contener MEDELLIN entre sus municipios")
    void antioquiaShouldContainMedellin() {
        List<Municipalities> municipalities = Department.ANTIOQUIA.getMunicipalities();
        assertTrue(municipalities.contains(Municipalities.MEDELLIN));
    }

    @ParameterizedTest
    @EnumSource(Department.class)
    @DisplayName("Todos los departamentos deben tener un valor no vacío")
    void allDepartmentsShouldHaveNonEmptyValue(Department department) {
        assertNotNull(department.getValue());
        assertFalse(department.getValue().isEmpty());
    }

    @ParameterizedTest
    @EnumSource(Department.class)
    @DisplayName("Todos los departamentos deben tener al menos un municipio (excepto San Andrés)")
    void allDepartmentsShouldHaveAtLeastOneMunicipality(Department department) {
        assertNotNull(department.getMunicipalities());
        if (department == Department.SAN_ANDRES_Y_PROVIDENCIA) {
            // San Andrés y Providencia no tiene municipios definidos en el enum
            assertTrue(department.getMunicipalities().isEmpty(),
                    "San Andrés y Providencia no tiene municipios definidos");
        } else {
            assertFalse(department.getMunicipalities().isEmpty(),
                    "El departamento " + department.getValue() + " debe tener al menos un municipio");
        }
    }

    @Test
    @DisplayName("La lista de municipios debe ser inmutable")
    void municipalitiesListShouldBeImmutable() {
        List<Municipalities> municipalities = Department.ATLANTICO.getMunicipalities();
        assertThrows(UnsupportedOperationException.class, () -> municipalities.add(Municipalities.MEDELLIN));
    }

    @Test
    @DisplayName("valueOf debe funcionar con nombres válidos")
    void valueOfShouldWork() {
        assertEquals(Department.ATLANTICO, Department.valueOf("ATLANTICO"));
        assertEquals(Department.ANTIOQUIA, Department.valueOf("ANTIOQUIA"));
    }

    @Test
    @DisplayName("valueOf con valor inválido debe lanzar excepción")
    void valueOfWithInvalidShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Department.valueOf("INVALIDO"));
    }
}
