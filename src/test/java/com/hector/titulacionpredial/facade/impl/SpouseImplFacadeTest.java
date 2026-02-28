package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
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
@DisplayName("SpouseImplFacade Tests")
class SpouseImplFacadeTest {

    @Mock
    private DAOSpouse daoSpouse;

    private SpouseImplFacade facade;

    @BeforeEach
    void setUp() throws Exception {
        facade = new SpouseImplFacade();
        Field field = SpouseImplFacade.class.getDeclaredField("daoSpouse");
        field.setAccessible(true);
        field.set(facade, daoSpouse);
    }

    @Test
    @DisplayName("add debe crear DTOSpouse y delegar al DAO")
    void addShouldCreateDTOAndDelegate() throws DAOException {
        doNothing().when(daoSpouse).add(any(DTOSpouse.class));

        facade.add(987654L, "María García", "Bogotá", "Calle 10", 3001112233L, 1);

        verify(daoSpouse).add(any(DTOSpouse.class));
    }

    @Test
    @DisplayName("add debe lanzar DAOException cuando el DAO falla")
    void addShouldThrowDAOExceptionOnFailure() throws DAOException {
        doThrow(new DAOException("Error")).when(daoSpouse).add(any(DTOSpouse.class));

        assertThrows(DAOException.class, () ->
                facade.add(123L, "Nombre", "Lugar", "Dir", 300L, 1));
    }

    @Test
    @DisplayName("findByCode debe delegar al DAO y retornar resultado")
    void findByCodeShouldDelegate() throws DAOException {
        DTOSpouse expected = mock(DTOSpouse.class);
        when(daoSpouse.findByCode(1)).thenReturn(expected);

        DTOSpouse result = facade.findByCode(1);

        assertSame(expected, result);
        verify(daoSpouse).findByCode(1);
    }

    @Test
    @DisplayName("findByCode debe lanzar DAOException cuando no existe")
    void findByCodeShouldThrowWhenNotFound() throws DAOException {
        when(daoSpouse.findByCode(999)).thenThrow(new DAOException("No encontrado"));

        assertThrows(DAOException.class, () -> facade.findByCode(999));
    }

    @Test
    @DisplayName("delete debe delegar al DAO")
    void deleteShouldDelegate() throws DAOException {
        doNothing().when(daoSpouse).delete(1);

        facade.delete(1);

        verify(daoSpouse).delete(1);
    }

    @Test
    @DisplayName("delete debe lanzar DAOException cuando el DAO falla")
    void deleteShouldThrowDAOExceptionOnFailure() throws DAOException {
        doThrow(new DAOException("Error al eliminar")).when(daoSpouse).delete(999);

        assertThrows(DAOException.class, () -> facade.delete(999));
    }
}
