package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.util.List;

/**
 * Fachada que define las operaciones de alto nivel para la
 * gestión de predios en el sistema.
 *
 * <p>
 * Extiende {@link IListable}, {@link IRemovable} e {@link ICountable}
 * para ofrecer listado, eliminación y conteo de predios,
 * además de operaciones específicas como exportación y estadísticas.
 * </p>
 *
 * @author Hector Acevedo
 * @see PropertyImplFacade
 * @since 1.0
 */
public interface PropertyFacade extends IListable<DTOPropertyDetails>, IRemovable, ICountable {

    /**
     * Registra un nuevo predio en el sistema.
     *
     * @param cadastralId cédula catastral del predio
     * @param area        área del predio en metros cuadrados
     * @return código del predio recién insertado
     * @throws DAOException si ocurre un error en la operación
     */
    int add(String cadastralId, Double area) throws DAOException;

    /**
     * Busca un predio por su cédula catastral.
     *
     * @param cadastralId cédula catastral
     * @return DTO con los datos detallados del predio
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOPropertyDetails findByCode(String cadastralId) throws DAOException;

    /**
     * Obtiene todos los predios con formato para exportación.
     *
     * @return lista de DTOs con datos completos
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOPropertyDetails> findByAllForExport() throws DAOException;

    /**
     * Calcula el porcentaje de predios con resolución.
     *
     * @return porcentaje (0–100)
     * @throws DAOException si ocurre un error en la consulta
     */
    int percentPropertiesWithResolutions() throws DAOException;

    /**
     * Cuenta los predios que tienen resolución asociada.
     *
     * @return cantidad de predios con resolución
     * @throws DAOException si ocurre un error en la consulta
     */
    int countPropertyWithResolution() throws DAOException;

}
