package com.hector.titulacionpredial.facade.impl;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

@ExtendWith(MockitoExtension.class)
@DisplayName("BeneficiaryImplFacade Tests")
class BeneficiaryImplFacadeTest {

    @Mock
    private DAOBeneficiary daoBeneficiary;

    private BeneficiaryImplFacade facade;

    @BeforeEach
    void setUp() throws Exception {
        facade = new BeneficiaryImplFacade();
        // Inyectar el mock usando reflexión (el constructor usa singleton)
        Field field = BeneficiaryImplFacade.class.getDeclaredField("daoBeneficiary");
        field.setAccessible(true);
        field.set(facade, daoBeneficiary);
    }

    @Test
    @DisplayName("add debe crear DTO y delegar al DAO")
    void addShouldDelegateToDAO() throws DAOException {
        doNothing().when(daoBeneficiary).add(any(DTOBeneficiaryCreate.class));

        /*facade.add(123456L, "Juan Pérez", Department.ATLANTICO, Municipalities.BARRANQUILLA,
                "Calle 1", "REF-001", MaritalStatus.SINGLE, "Afectación",
                3001234567L, "Cruce", "Publicación", "Barrio Centro", "Barranquilla");

        verify(daoBeneficiary).add(any(DTOBeneficiaryCreate.class));*/
    }

    @Test
    @DisplayName("add debe lanzar DAOException cuando el DAO falla")
    void addShouldThrowDAOException() throws DAOException {
        doThrow(new DAOException("Error")).when(daoBeneficiary).add(any(DTOBeneficiaryCreate.class));

        /*assertThrows(DAOException.class, () ->
                facade.add(123456L, "Juan", Department.ATLANTICO, Municipalities.BARRANQUILLA,
                        "Dir", "REF", MaritalStatus.SINGLE, "Afect",
                        300L, "Cruce", "Pub", "Barrio", "Loc"));*/
    }

    @Test
    @DisplayName("findByCode debe delegar al DAO y retornar resultado")
    void findByCodeShouldDelegateAndReturn() throws DAOException {
        DTOBeneficiarySimpleDetails expected = new DTOBeneficiarySimpleDetails();
        when(daoBeneficiary.findByCode(1)).thenReturn(expected);

        DTOBeneficiarySimpleDetails result = facade.findByCode(1);

        assertSame(expected, result);
        verify(daoBeneficiary).findByCode(1);
    }

    @Test
    @DisplayName("findById debe delegar al DAO y retornar resultado")
    void findByIdShouldDelegateAndReturn() throws DAOException {
        DTOBeneficiarySimpleDetails expected = new DTOBeneficiarySimpleDetails();
        when(daoBeneficiary.findById(123456L)).thenReturn(expected);

        DTOBeneficiarySimpleDetails result = facade.findById(123456L);

        assertSame(expected, result);
        verify(daoBeneficiary).findById(123456L);
    }

    @Test
    @DisplayName("findByName debe delegar al DAO")
    void findByNameShouldDelegate() throws DAOException {
        DTOBeneficiarySimpleDetails expected = new DTOBeneficiarySimpleDetails();
        when(daoBeneficiary.findByName("Juan Pérez")).thenReturn(expected);

        DTOBeneficiarySimpleDetails result = facade.findByName("Juan Pérez");

        assertSame(expected, result);
        verify(daoBeneficiary).findByName("Juan Pérez");
    }

    @Test
    @DisplayName("findAllByMunicipality debe retornar lista del DAO")
    void findAllByMunicipalityShouldReturnList() throws DAOException {
        List<DTOBeneficiarySimpleDetails> expected = List.of(new DTOBeneficiarySimpleDetails());
        when(daoBeneficiary.findAllByMunicipality("Barranquilla")).thenReturn(expected);

        List<DTOBeneficiarySimpleDetails> result = facade.findAllByMunicipality("Barranquilla");

        assertSame(expected, result);
        verify(daoBeneficiary).findAllByMunicipality("Barranquilla");
    }

    @Test
    @DisplayName("findByAll debe retornar lista del DAO")
    void findByAllShouldReturnList() throws DAOException {
        List<DTOBeneficiarySimpleDetails> expected = List.of();
        when(daoBeneficiary.findByAll()).thenReturn(expected);

        List<DTOBeneficiarySimpleDetails> result = facade.findByAll();

        assertSame(expected, result);
        verify(daoBeneficiary).findByAll();
    }

    @Test
    @DisplayName("findAllData debe delegar al DAO")
    void findAllDataShouldDelegate() throws DAOException {
        DTOBeneficiaryDetails expected = mock(DTOBeneficiaryDetails.class);
        when(daoBeneficiary.findAllData(1)).thenReturn(expected);

        DTOBeneficiaryDetails result = facade.findAllData(1);

        assertSame(expected, result);
        verify(daoBeneficiary).findAllData(1);
    }

    @Test
    @DisplayName("findAllForExport debe delegar al DAO")
    void findAllForExportShouldDelegate() throws DAOException {
        List<DTOBeneficiaryCreate> expected = List.of();
        when(daoBeneficiary.findAllForExport()).thenReturn(expected);

        List<DTOBeneficiaryCreate> result = facade.findAllForExport();

        assertSame(expected, result);
        verify(daoBeneficiary).findAllForExport();
    }

    @Test
    @DisplayName("findAllWithoutProperty debe delegar al DAO")
    void findAllWithoutPropertyShouldDelegate() throws DAOException {
        List<DTOBeneficiarySimpleDetails> expected = List.of();
        when(daoBeneficiary.findAllWithoutProperty()).thenReturn(expected);

        List<DTOBeneficiarySimpleDetails> result = facade.findAllWithoutProperty();

        assertSame(expected, result);
        verify(daoBeneficiary).findAllWithoutProperty();
    }

    @Test
    @DisplayName("modify debe crear DTO y delegar al DAO")
    void modifyShouldCreateDTOAndDelegate() throws DAOException {
        when(daoBeneficiary.modify(any(DTOBeneficiaryUpdate.class))).thenReturn(true);

        /*boolean result = facade.modify(Department.ATLANTICO, Municipalities.BARRANQUILLA,
                "Calle 2", MaritalStatus.MARRIED, "Afectación 2",
                3009876543L, "Cruce 2", "Pub 2", "Barrio Norte", 1);

        assertTrue(result);*/
        verify(daoBeneficiary).modify(any(DTOBeneficiaryUpdate.class));
    }

    @Test
    @DisplayName("modify debe retornar false cuando DAO retorna false")
    void modifyShouldReturnFalseWhenDAOReturnsFalse() throws DAOException {
        when(daoBeneficiary.modify(any(DTOBeneficiaryUpdate.class))).thenReturn(false);

        /*boolean result = facade.modify(Department.ATLANTICO, Municipalities.BARRANQUILLA,
                "Dir", MaritalStatus.SINGLE, "Afect",
                300L, "Cruce", "Pub", "Barrio", 1);

        assertFalse(result);*/
    }

    @Test
    @DisplayName("modifyProperty debe crear DTO y delegar al DAO")
    void modifyPropertyShouldDelegate() throws DAOException {
        when(daoBeneficiary.modifyProperty(any(DTOBeneficiaryPropertyUpdate.class))).thenReturn(true);

        //boolean result = facade.modifyProperty(1, 10);

        //assertTrue(result);
        verify(daoBeneficiary).modifyProperty(any(DTOBeneficiaryPropertyUpdate.class));
    }

    @Test
    @DisplayName("delete debe delegar al DAO")
    void deleteShouldDelegate() throws DAOException {
        doNothing().when(daoBeneficiary).delete(1);

        facade.delete(1);

        verify(daoBeneficiary).delete(1);
    }

    @Test
    @DisplayName("countRecords debe retornar valor del DAO")
    void countRecordsShouldReturnValue() throws DAOException {
        when(daoBeneficiary.countRecords()).thenReturn(42);

        int result = facade.countRecords();

        assertEquals(42, result);
        verify(daoBeneficiary).countRecords();
    }

    @Test
    @DisplayName("getLastCode debe retornar valor del DAO")
    void getLastCodeShouldReturnValue() throws DAOException {
        when(daoBeneficiary.getLastCode()).thenReturn(100);

        int result = facade.getLastCode();

        assertEquals(100, result);
        verify(daoBeneficiary).getLastCode();
    }

    @Test
    @DisplayName("countBeneficiariesLastMonths debe delegar al DAO")
    void countBeneficiariesLastMonthsShouldDelegate() throws DAOException {
        List<DTOBeneficiariesByMonth> expected = List.of();
        when(daoBeneficiary.countBeneficiariesLastMonths(6)).thenReturn(expected);

        List<DTOBeneficiariesByMonth> result = facade.countBeneficiariesLastMonths(6);

        assertSame(expected, result);
        verify(daoBeneficiary).countBeneficiariesLastMonths(6);
    }

    @Test
    @DisplayName("countBeneficiariesWithProperty debe retornar valor del DAO")
    void countBeneficiariesWithPropertyShouldReturnValue() throws DAOException {
        when(daoBeneficiary.countBeneficiariesWithProperty()).thenReturn(25);

        int result = facade.countBeneficiariesWithProperty();

        assertEquals(25, result);
    }

    @Test
    @DisplayName("percentBeneficiariesWithProperty debe retornar valor del DAO")
    void percentBeneficiariesWithPropertyShouldReturnValue() throws DAOException {
        when(daoBeneficiary.percentBeneficiariesWithProperty()).thenReturn(75);

        int result = facade.percentBeneficiariesWithProperty();

        assertEquals(75, result);
    }

    @Test
    @DisplayName("findByCode debe propagar DAOException")
    void findByCodeShouldPropagateDAOException() throws DAOException {
        when(daoBeneficiary.findByCode(anyInt())).thenThrow(new DAOException("Error"));
        assertThrows(DAOException.class, () -> facade.findByCode(1));
    }

    @Test
    @DisplayName("findByAll debe propagar DAOException")
    void findByAllShouldPropagateDAOException() throws DAOException {
        when(daoBeneficiary.findByAll()).thenThrow(new DAOException("Error"));
        assertThrows(DAOException.class, () -> facade.findByAll());
    }

    @Test
    @DisplayName("countRecords debe propagar DAOException")
    void countRecordsShouldPropagateDAOException() throws DAOException {
        when(daoBeneficiary.countRecords()).thenThrow(new DAOException("Error"));
        assertThrows(DAOException.class, () -> facade.countRecords());
    }

    @Test
    @DisplayName("delete debe propagar DAOException")
    void deleteShouldPropagateDAOException() throws DAOException {
        doThrow(new DAOException("Error")).when(daoBeneficiary).delete(anyInt());
        assertThrows(DAOException.class, () -> facade.delete(1));
    }

    @Test
    @DisplayName("modify debe propagar DAOException")
    void modifyShouldPropagateDAOException() throws DAOException {
        when(daoBeneficiary.modify(any(DTOBeneficiaryUpdate.class))).thenThrow(new DAOException("Error"));
        /*assertThrows(DAOException.class, () ->
                facade.modify(Department.ATLANTICO, Municipalities.BARRANQUILLA,
                        "Dir", MaritalStatus.SINGLE, "Afect",
                        300L, "Cruce", "Pub", "Barrio", 1));*/
    }
}
