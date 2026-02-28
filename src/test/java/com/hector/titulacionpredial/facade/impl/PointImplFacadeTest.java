package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PointImplFacade Tests")
class PointImplFacadeTest {

    @Mock
    private DAOPoint daoPoint;

    private PointImplFacade facade;

    @BeforeEach
    void setUp() throws Exception {
        facade = new PointImplFacade();
        Field field = PointImplFacade.class.getDeclaredField("daoPoint");
        field.setAccessible(true);
        field.set(facade, daoPoint);
    }

    @Test
    @DisplayName("add debe crear DTOPoint y delegar al DAO")
    void addShouldCreateDTOAndDelegate() throws DAOException {
        doNothing().when(daoPoint).add(any(DTOPoint.class));

        facade.add(1, 10.5, 20.3, 15.0, "Norte", 5);

        verify(daoPoint).add(any(DTOPoint.class));
    }

    @Test
    @DisplayName("add debe lanzar DAOException cuando el DAO falla")
    void addShouldThrowDAOExceptionOnFailure() throws DAOException {
        doThrow(new DAOException("Error")).when(daoPoint).add(any(DTOPoint.class));

        assertThrows(DAOException.class, () ->
                facade.add(1, 10.0, 20.0, 5.0, "Sur", 1));
    }

    @Test
    @DisplayName("findByCode debe delegar al DAO y retornar resultado")
    void findByCodeShouldDelegate() throws DAOException {
        DTOPoint expected = mock(DTOPoint.class);
        when(daoPoint.findByCode(5)).thenReturn(expected);

        DTOPoint result = facade.findByCode(5);

        assertSame(expected, result);
        verify(daoPoint).findByCode(5);
    }

    @Test
    @DisplayName("findByCode debe lanzar DAOException cuando no existe")
    void findByCodeShouldThrowWhenNotFound() throws DAOException {
        when(daoPoint.findByCode(999)).thenThrow(new DAOException("No encontrado"));

        assertThrows(DAOException.class, () -> facade.findByCode(999));
    }

    @Test
    @DisplayName("add con coordenadas null debe funcionar")
    void addWithNullCoordinatesShouldWork() throws DAOException {
        doNothing().when(daoPoint).add(any(DTOPoint.class));

        facade.add(1, null, null, null, "Este", 3);

        verify(daoPoint).add(any(DTOPoint.class));
    }
}
