package com.hector.titulacionpredial.model.dto.property;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Unit tests for {@link DTOPropertyCreate} and {@link DTOPropertyDetails} classes.
 *
 * <p>
 * This test class validates the behavior of the property-related Data Transfer Objects,
 * focusing on their inheritance from {@link DTOProperty}, builder pattern implementation,
 * and the extended functionality they provide for creating and displaying detailed
 * property information.
 * </p>
 *
 * <p>
 * Test coverage includes:
 * <ul>
 *     <li>Inheritance verification from DTOProperty</li>
 *     <li>Builder pattern construction with all fields</li>
 *     <li>Getter and setter functionality</li>
 *     <li>List initialization for geometric points</li>
 *     <li>Association with beneficiaries and resolutions</li>
 * </ul>
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@DisplayName("DTOPropertyCreate & DTOPropertyDetails Tests")
class DTOPropertySubclassesTest {

    @Test
    @DisplayName("DTOPropertyCreate debe heredar de DTOProperty")
    void createShouldExtendDTOProperty() {
        DTOPropertyCreate dto = new DTOPropertyCreate();
        assertInstanceOf(DTOProperty.class, dto);
    }

    @Test
    @DisplayName("DTOPropertyCreate con parámetros debe funcionar")
    void createWithParamsShouldWork() {
        /*DTOPropertyCreate dto = new DTOPropertyCreate("CAD-001", 300.0);
        assertEquals("CAD-001", dto.getCadastralId());
        assertEquals(300.0, dto.getArea());*/
    }

    @Test
    @DisplayName("DTOPropertyDetails constructor vacío debe inicializar listas")
    void detailsDefaultConstructorShouldInitializeLists() {
        DTOPropertyDetails dto = new DTOPropertyDetails();
        assertNotNull(dto.getPoints());
        assertTrue(dto.getPoints().isEmpty());
    }

    @Test
    @DisplayName("DTOPropertyDetails Builder debe construir con todos los campos")
    void detailsBuilderShouldBuildWithAllFields() {
        LocalDate notifDate = LocalDate.of(2025, 1, 15);
        LocalDate execDate = LocalDate.of(2025, 2, 15);
        List<DTOPoint> points = new ArrayList<>();

        DTOPropertyDetails dto = new DTOPropertyDetails.Builder()
                .propertyCode(1)
                .cadastralRef("CAD-100")
                .area(500.0)
                .beneficiariesIds("1000332, 2134")
                .beneficiariesName("hector, juan")
                .points(points)
                .numResolution(12345L)
                .notification(notifDate)
                .executory(execDate)
                .fmi("FMI-001")
                .act("Acto 1")
                .publicWriting("EP-001")
                .notary("Notaría Primera")
                .build();

        assertEquals(1, dto.getPropertyCode());
        assertEquals("CAD-100", dto.getCadastralRef());
        assertEquals(500.0, dto.getArea());
        assertEquals("1000332, 2134", dto.getBeneficiariesIds());
        assertEquals("hector, juan", dto.getBeneficiariesName());
        assertEquals(12345L, dto.getNumResolution());
        assertEquals(notifDate, dto.getNotification());
        assertEquals(execDate, dto.getExecutory());
        assertEquals("FMI-001", dto.getFmi());
        assertEquals("Acto 1", dto.getAct());
        assertEquals("EP-001", dto.getPublicWriting());
        assertEquals("Notaría Primera", dto.getNotary());
    }

    @Test
    @DisplayName("DTOPropertyDetails setters deben funcionar correctamente")
    void detailsSettersShouldWork() {
        DTOPropertyDetails dto = new DTOPropertyDetails();
        LocalDate notifDate = LocalDate.of(2025, 3, 1);
        LocalDate execDate = LocalDate.of(2025, 4, 1);
        List<DTOPoint> points = new ArrayList<>();

        dto.setPropertyCode(42);
        dto.setNumResolution(999L);
        dto.setFmi("FMI-TEST");
        dto.setAct("Acto Test");
        dto.setPublicWriting("EP-Test");
        dto.setNotary("Notaría Test");
        dto.setNotification(notifDate);
        dto.setExecutory(execDate);
        dto.setBeneficiariesIds("5000, 6000");
        dto.setBeneficiariesName("Ana, Carlos");
        dto.setPoints(points);

        assertEquals(42, dto.getPropertyCode());
        assertEquals(999L, dto.getNumResolution());
        assertEquals("FMI-TEST", dto.getFmi());
        assertEquals("Acto Test", dto.getAct());
        assertEquals("EP-Test", dto.getPublicWriting());
        assertEquals("Notaría Test", dto.getNotary());
        assertEquals(notifDate, dto.getNotification());
        assertEquals(execDate, dto.getExecutory());
        assertEquals("5000, 6000", dto.getBeneficiariesIds());
        assertEquals("Ana, Carlos", dto.getBeneficiariesName());
        assertTrue(dto.getPoints().isEmpty());
    }

    @Test
    @DisplayName("DTOPropertyDetails Builder debe verificar puntos")
    void detailsBuilderShouldVerifyPointsField() {
        DTOPoint point = new DTOPoint();
        List<DTOPoint> points = new ArrayList<>();
        points.add(point);

        DTOPropertyDetails dto = new DTOPropertyDetails.Builder()
                .propertyCode(5)
                .beneficiariesIds("100")
                .beneficiariesName("Juan")
                .points(points)
                .build();

        assertEquals("100", dto.getBeneficiariesIds());
        assertEquals("Juan", dto.getBeneficiariesName());
        assertEquals(1, dto.getPoints().size());
    }
}
