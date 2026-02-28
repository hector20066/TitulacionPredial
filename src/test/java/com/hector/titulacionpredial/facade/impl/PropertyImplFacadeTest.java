package com.hector.titulacionpredial.facade.impl;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

@ExtendWith(MockitoExtension.class)
@DisplayName("PropertyImplFacade Tests")
class PropertyImplFacadeTest {

    @Mock
    private DAOProperty daoProperty;

    private PropertyImplFacade facade;

    @BeforeEach
    void setUp() throws Exception {
        facade = new PropertyImplFacade();
        Field field = PropertyImplFacade.class.getDeclaredField("daoProperty");
        field.setAccessible(true);
        field.set(facade, daoProperty);
    }

    @Test
    @DisplayName("add debe crear DTO y delegar al DAO, retornando el código")
    void addShouldCreateDTOAndDelegate() throws DAOException {
        when(daoProperty.add(any(DTOPropertyCreate.class))).thenReturn(1);

        int result = facade.add("CAD-001", 150.5);

        assertEquals(1, result);
        verify(daoProperty).add(any(DTOPropertyCreate.class));
    }

    @Test
    @DisplayName("add debe lanzar DAOException cuando el DAO falla")
    void addShouldThrowDAOExceptionOnFailure() throws DAOException {
        when(daoProperty.add(any(DTOPropertyCreate.class))).thenThrow(new DAOException("Error"));

        assertThrows(DAOException.class, () -> facade.add("CAD-002", 200.0));
    }

    @Test
    @DisplayName("findByCode debe delegar al DAO con el cadastralId")
    void findByCodeShouldDelegate() throws DAOException {
        DTOPropertyDetails expected = mock(DTOPropertyDetails.class);
        when(daoProperty.findByCode("CAD-001")).thenReturn(expected);

        DTOPropertyDetails result = facade.findByCode("CAD-001");

        assertSame(expected, result);
        verify(daoProperty).findByCode("CAD-001");
    }

    @Test
    @DisplayName("findByAll debe retornar lista del DAO")
    void findByAllShouldReturnList() throws DAOException {
        List<DTOPropertyDetails> expected = List.of();
        when(daoProperty.findByAll()).thenReturn(expected);

        List<DTOPropertyDetails> result = facade.findByAll();

        assertSame(expected, result);
        verify(daoProperty).findByAll();
    }

    @Test
    @DisplayName("findByAllForExport debe delegar al DAO")
    void findByAllForExportShouldDelegate() throws DAOException {
        List<DTOPropertyDetails> expected = List.of(mock(DTOPropertyDetails.class));
        when(daoProperty.findByAllForExport()).thenReturn(expected);

        List<DTOPropertyDetails> result = facade.findByAllForExport();

        assertSame(expected, result);
        verify(daoProperty).findByAllForExport();
    }

    @Test
    @DisplayName("delete debe delegar al DAO")
    void deleteShouldDelegate() throws DAOException {
        doNothing().when(daoProperty).delete(1);

        facade.delete(1);

        verify(daoProperty).delete(1);
    }

    @Test
    @DisplayName("delete debe lanzar DAOException cuando el DAO falla")
    void deleteShouldThrowDAOException() throws DAOException {
        doThrow(new DAOException("No encontrado")).when(daoProperty).delete(999);

        assertThrows(DAOException.class, () -> facade.delete(999));
    }

    @Test
    @DisplayName("countRecords debe retornar valor del DAO")
    void countRecordsShouldReturnValue() throws DAOException {
        when(daoProperty.countRecords()).thenReturn(10);

        assertEquals(10, facade.countRecords());
        verify(daoProperty).countRecords();
    }

    @Test
    @DisplayName("percentPropertiesWithResolutions debe retornar valor del DAO")
    void percentPropertiesWithResolutionsShouldReturn() throws DAOException {
        when(daoProperty.percentPropertiesWithResolutions()).thenReturn(80);

        assertEquals(80, facade.percentPropertiesWithResolutions());
        verify(daoProperty).percentPropertiesWithResolutions();
    }

    @Test
    @DisplayName("countPropertyWithResolution debe retornar valor del DAO")
    void countPropertyWithResolutionShouldReturn() throws DAOException {
        when(daoProperty.countPropertyWithResolution()).thenReturn(8);

        assertEquals(8, facade.countPropertyWithResolution());
        verify(daoProperty).countPropertyWithResolution();
    }

    @Test
    @DisplayName("findByCode debe propagar DAOException")
    void findByCodeShouldPropagateDAOException() throws DAOException {
        when(daoProperty.findByCode(anyString())).thenThrow(new DAOException("Error"));
        assertThrows(DAOException.class, () -> facade.findByCode("CAD-XXX"));
    }

    @Test
    @DisplayName("findByAll debe propagar DAOException")
    void findByAllShouldPropagateDAOException() throws DAOException {
        when(daoProperty.findByAll()).thenThrow(new DAOException("Error"));
        assertThrows(DAOException.class, () -> facade.findByAll());
    }

    @Test
    @DisplayName("countRecords debe propagar DAOException")
    void countRecordsShouldPropagateDAOException() throws DAOException {
        when(daoProperty.countRecords()).thenThrow(new DAOException("Error"));
        assertThrows(DAOException.class, () -> facade.countRecords());
    }
}
