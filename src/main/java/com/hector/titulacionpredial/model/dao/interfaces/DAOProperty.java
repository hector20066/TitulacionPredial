package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.util.List;

/**
 * Interfaz DAO para la gestión de predios en la base de datos.
 *
 * <p>
 * A diferencia de los demás DAOs, no extiende {@link DAOBase}
 * directamente porque el método {@code add} retorna el código
 * del predio insertado. Incluye operaciones de listado,
 * eliminación, conteo y estadísticas.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see IListable
 * @see IRemovable
 * @see ICountable
 * @since 1.0
 */
public interface DAOProperty extends IListable<DTOPropertyDetails>,
        IRemovable,
        ICountable {

    /**
     * Inserta un nuevo predio en la base de datos.
     *
     * @param dto objeto con los datos del predio a registrar
     * @return código del predio recién insertado
     * @throws DAOException si ocurre un error en la operación
     */
    int add(DTOPropertyCreate dto) throws DAOException;

    /**
     * Busca un predio por su cédula catastral.
     *
     * @param cadastralId cédula catastral del predio
     * @return DTO con los datos detallados del predio
     * @throws DAOException si ocurre un error o no se encuentra el registro
     */
    DTOPropertyDetails findByCode(String cadastralId) throws DAOException;

    /**
     * Obtiene todos los predios con formato para exportación.
     *
     * @return lista de DTOs con datos completos de cada predio
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOPropertyDetails> findByAllForExport() throws DAOException;

    /**
     * Calcula el porcentaje de predios que tienen
     * una resolución asociada respecto al total.
     *
     * @return porcentaje de predios con resolución (0–100)
     * @throws DAOException si ocurre un error en la consulta
     */
    int percentPropertiesWithResolutions() throws DAOException;

    /**
     * Cuenta los predios que tienen una resolución asociada.
     *
     * @return cantidad de predios con resolución
     * @throws DAOException si ocurre un error en la consulta
     */
    int countPropertyWithResolution() throws DAOException;

}
