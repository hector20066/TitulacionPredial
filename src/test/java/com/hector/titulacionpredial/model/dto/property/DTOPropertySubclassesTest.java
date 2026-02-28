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
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;

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
        DTOPropertyCreate dto = new DTOPropertyCreate("CAD-001", 300.0);
        assertEquals("CAD-001", dto.getCadastralId());
        assertEquals(300.0, dto.getArea());
    }

    @Test
    @DisplayName("DTOPropertyDetails constructor vacío debe inicializar listas")
    void detailsDefaultConstructorShouldInitializeLists() {
        DTOPropertyDetails dto = new DTOPropertyDetails();
        assertNotNull(dto.getBeneficiaries());
        assertNotNull(dto.getPoints());
        assertTrue(dto.getBeneficiaries().isEmpty());
        assertTrue(dto.getPoints().isEmpty());
    }

    @Test
    @DisplayName("DTOPropertyDetails Builder debe construir con todos los campos")
    void detailsBuilderShouldBuildWithAllFields() {
        LocalDate notifDate = LocalDate.of(2025, 1, 15);
        LocalDate execDate = LocalDate.of(2025, 2, 15);
        List<DTOBeneficiaryPropertyDetails> beneficiaries = new ArrayList<>();
        List<DTOPoint> points = new ArrayList<>();

        DTOPropertyDetails dto = new DTOPropertyDetails.Builder()
                .propertyCode(1)
                .cadastralId("CAD-100")
                .area(500.0)
                .beneficiaries(beneficiaries)
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
        assertEquals("CAD-100", dto.getCadastralId());
        assertEquals(500.0, dto.getArea());
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
        List<DTOBeneficiaryPropertyDetails> beneficiaries = List.of(
                new DTOBeneficiaryPropertyDetails("Test", 1L, null, null));
        List<DTOPoint> points = List.of(new DTOPoint());

        dto.setPropertyCode(42);
        dto.setNumResolution(999L);
        dto.setFmi("FMI-TEST");
        dto.setAct("Acto Test");
        dto.setPublicWriting("EP-Test");
        dto.setNotary("Notaría Test");
        dto.setNotification(notifDate);
        dto.setExecutory(execDate);
        dto.setBeneficiaries(beneficiaries);
        dto.setPoints(points);

        assertEquals(42, dto.getPropertyCode());
        assertEquals(999L, dto.getNumResolution());
        assertEquals("FMI-TEST", dto.getFmi());
        assertEquals("Acto Test", dto.getAct());
        assertEquals("EP-Test", dto.getPublicWriting());
        assertEquals("Notaría Test", dto.getNotary());
        assertEquals(notifDate, dto.getNotification());
        assertEquals(execDate, dto.getExecutory());
        assertEquals(1, dto.getBeneficiaries().size());
        assertEquals(1, dto.getPoints().size());
    }

    @Test
    @DisplayName("DTOPropertyDetails Builder debe verificar beneficiaries y points")
    void detailsBuilderShouldVerifyListFields() {
        DTOBeneficiaryPropertyDetails ben = new DTOBeneficiaryPropertyDetails(
                "Juan", 100L, null, "Calle 1");
        DTOPoint point = new DTOPoint();

        DTOPropertyDetails dto = new DTOPropertyDetails.Builder()
                .propertyCode(5)
                .beneficiaries(List.of(ben))
                .points(List.of(point))
                .build();

        assertEquals(1, dto.getBeneficiaries().size());
        assertEquals("Juan", dto.getBeneficiaries().get(0).getFullName());
        assertEquals(1, dto.getPoints().size());
    }
}
