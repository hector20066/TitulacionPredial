package com.hector.titulacionpredial.model.dto.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DTOBeneficiariesByMonth Tests")
class DTOBeneficiariesByMonthTest {

    @Test
    @DisplayName("Record debe almacenar year, month y total correctamente")
    void recordShouldStoreValuesCorrectly() {
        DTOBeneficiariesByMonth dto = new DTOBeneficiariesByMonth(2025, 6, 15);

        assertEquals(2025, dto.year());
        assertEquals(6, dto.month());
        assertEquals(15, dto.total());
    }

    @Test
    @DisplayName("Dos records con mismos valores deben ser iguales")
    void twoRecordsWithSameValuesShouldBeEqual() {
        DTOBeneficiariesByMonth dto1 = new DTOBeneficiariesByMonth(2025, 1, 10);
        DTOBeneficiariesByMonth dto2 = new DTOBeneficiariesByMonth(2025, 1, 10);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    @DisplayName("Dos records con diferentes valores no deben ser iguales")
    void twoRecordsWithDifferentValuesShouldNotBeEqual() {
        DTOBeneficiariesByMonth dto1 = new DTOBeneficiariesByMonth(2025, 1, 10);
        DTOBeneficiariesByMonth dto2 = new DTOBeneficiariesByMonth(2025, 2, 10);

        assertNotEquals(dto1, dto2);
    }

    @Test
    @DisplayName("toString debe contener los valores del record")
    void toStringShouldContainValues() {
        DTOBeneficiariesByMonth dto = new DTOBeneficiariesByMonth(2025, 3, 20);
        String result = dto.toString();

        assertTrue(result.contains("2025"));
        assertTrue(result.contains("3"));
        assertTrue(result.contains("20"));
    }

    @Test
    @DisplayName("Record con valores en cero debe funcionar")
    void recordWithZeroValuesShouldWork() {
        DTOBeneficiariesByMonth dto = new DTOBeneficiariesByMonth(0, 0, 0);

        assertEquals(0, dto.year());
        assertEquals(0, dto.month());
        assertEquals(0, dto.total());
    }
}
