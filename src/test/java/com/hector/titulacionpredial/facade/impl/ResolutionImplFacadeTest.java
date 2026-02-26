package com.hector.titulacionpredial.facade.impl;

import java.lang.reflect.Field;
import java.time.LocalDate;
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
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;

@ExtendWith(MockitoExtension.class)
@DisplayName("ResolutionImplFacade Tests")
class ResolutionImplFacadeTest {

    @Mock
    private DAOResolution daoResolution;

    private ResolutionImplFacade facade;

    @BeforeEach
    void setUp() throws Exception {
        facade = new ResolutionImplFacade();
        Field field = ResolutionImplFacade.class.getDeclaredField("daoResolution");
        field.setAccessible(true);
        field.set(facade, daoResolution);
    }

    @Test
    @DisplayName("add debe crear DTOResolutionCreate y delegar al DAO")
    void addShouldCreateDTOAndDelegate() throws DAOException {
        doNothing().when(daoResolution).add(any(DTOResolutionCreate.class));

        LocalDate notification = LocalDate.of(2024, 1, 15);
        LocalDate executory = LocalDate.of(2024, 2, 15);

        facade.add(1001L, notification, executory, "FMI-001", "Acto 1",
                "EP-001", "Notaría 1", 5, "Juan Pérez");

        verify(daoResolution).add(any(DTOResolutionCreate.class));
    }

    @Test
    @DisplayName("add debe lanzar DAOException cuando el DAO falla")
    void addShouldThrowDAOExceptionOnFailure() throws DAOException {
        doThrow(new DAOException("Error")).when(daoResolution).add(any(DTOResolutionCreate.class));

        assertThrows(DAOException.class, () ->
                facade.add(1001L, LocalDate.now(), LocalDate.now(), "FMI", "Acto",
                        "EP", "Notaría", 1, "Nombre"));
    }

    @Test
    @DisplayName("findByCode debe delegar al DAO y retornar resultado")
    void findByCodeShouldDelegate() throws DAOException {
        DTOResolutionDetails expected = mock(DTOResolutionDetails.class);
        when(daoResolution.findByCode(1)).thenReturn(expected);

        DTOResolutionDetails result = facade.findByCode(1);

        assertSame(expected, result);
        verify(daoResolution).findByCode(1);
    }

    @Test
    @DisplayName("findByAll debe retornar lista del DAO")
    void findByAllShouldReturnList() throws DAOException {
        List<DTOResolutionDetails> expected = List.of();
        when(daoResolution.findByAll()).thenReturn(expected);

        List<DTOResolutionDetails> result = facade.findByAll();

        assertSame(expected, result);
        verify(daoResolution).findByAll();
    }

    @Test
    @DisplayName("modify debe crear DTOResolutionUpdate y delegar al DAO")
    void modifyShouldCreateDTOAndDelegate() throws DAOException {
        when(daoResolution.modify(any(DTOResolutionUpdate.class))).thenReturn(true);

        LocalDate executory = LocalDate.of(2024, 3, 1);
        LocalDate notification = LocalDate.of(2024, 2, 1);

        boolean result = facade.modify(1, executory, "Acto 2", "EP-002",
                2002L, notification, "FMI-002", "Notaría 2");

        assertTrue(result);
        verify(daoResolution).modify(any(DTOResolutionUpdate.class));
    }

    @Test
    @DisplayName("modify debe retornar false cuando DAO retorna false")
    void modifyShouldReturnFalseWhenDAOReturnsFalse() throws DAOException {
        when(daoResolution.modify(any(DTOResolutionUpdate.class))).thenReturn(false);

        boolean result = facade.modify(1, LocalDate.now(), "Acto", "EP",
                100L, LocalDate.now(), "FMI", "Notaría");

        assertFalse(result);
    }

    @Test
    @DisplayName("countRecords debe retornar valor del DAO")
    void countRecordsShouldReturnValue() throws DAOException {
        when(daoResolution.countRecords()).thenReturn(15);

        assertEquals(15, facade.countRecords());
        verify(daoResolution).countRecords();
    }
}
