package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.model.dto.beneficiary.*;

import java.util.List;

/**
 * Interfaz DAO para la gestión de beneficiarios en la base de datos.
 *
 * <p>
 * Extiende las interfaces base para ofrecer operaciones CRUD completas,
 * listado, conteo y búsquedas especializadas sobre la entidad
 * {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Operaciones específicas incluyen:
 * </p>
 * <ul>
 *   <li>Búsqueda por cédula, nombre y municipio</li>
 *   <li>Obtención de datos completos con cónyuge y predio</li>
 *   <li>Exportación masiva de registros</li>
 *   <li>Estadísticas mensuales y porcentajes con predio</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBase
 * @see IListable
 * @see IModifiable
 * @see IRemovable
 * @see ICountable
 * @since 1.0
 */
public interface DAOBeneficiary extends DAOBase<DTOBeneficiaryCreate, DTOBeneficiarySimpleDetails>,
        IListable<DTOBeneficiarySimpleDetails>,
        IModifiable<DTOBeneficiaryUpdate>,
        IRemovable,
        ICountable {

    /**
     * Busca un beneficiario por su número de cédula.
     *
     * @param id número de cédula del beneficiario
     * @return DTO con los datos básicos del beneficiario
     * @throws DAOException si ocurre un error o no se encuentra el registro
     */
    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;

    /**
     * Busca un beneficiario por su nombre.
     *
     * @param name nombre del beneficiario
     * @return DTO con los datos básicos del beneficiario
     * @throws DAOException si ocurre un error o no se encuentra el registro
     */
    DTOBeneficiarySimpleDetails findByName(String name) throws DAOException;

    /**
     * Obtiene todos los beneficiarios de un municipio específico.
     *
     * @param municipality nombre del municipio
     * @return lista de DTOs con los datos de los beneficiarios
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException;

    /**
     * Obtiene todos los datos de un beneficiario, incluyendo
     * cónyuge y predio asociado.
     *
     * @param code código único del beneficiario
     * @return DTO con los datos completos del beneficiario
     * @throws DAOException si ocurre un error o no se encuentra el registro
     */
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;

    /**
     * Obtiene todos los beneficiarios con formato para exportación.
     *
     * @return lista de DTOs con datos completos para exportar
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiaryCreate> findAllForExport() throws DAOException;

    /**
     * Obtiene los beneficiarios que aún no tienen un predio asignado.
     *
     * @return lista de DTOs de beneficiarios sin predio
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiarySimpleDetails> findAllWithoutProperty() throws DAOException;

    /**
     * Modifica la relación entre un beneficiario y su predio.
     *
     * @param dto objeto con los datos de la asociación beneficiario-predio
     * @return {@code true} si la modificación fue exitosa
     * @throws DAOException si ocurre un error en la operación
     */
    boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws DAOException;

    /**
     * Obtiene el último código de beneficiario registrado.
     *
     * @return último código secuencial del beneficiario
     * @throws DAOException si ocurre un error en la consulta
     */
    int getLastCode() throws DAOException;

    /**
     * Obtiene el conteo de beneficiarios registrados por mes
     * durante los últimos {@code months} meses.
     *
     * @param months cantidad de meses a consultar
     * @return lista de DTOs con el conteo mensual de beneficiarios
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException;

    /**
     * Cuenta los beneficiarios que tienen un predio asociado.
     *
     * @return cantidad de beneficiarios con predio
     * @throws DAOException si ocurre un error en la consulta
     */
    int countBeneficiariesWithProperty() throws DAOException;

    /**
     * Calcula el porcentaje de beneficiarios que tienen
     * un predio asociado respecto al total.
     *
     * @return porcentaje de beneficiarios con predio (0–100)
     * @throws DAOException si ocurre un error en la consulta
     */
    int percentBeneficiariesWithProperty() throws DAOException;

}
