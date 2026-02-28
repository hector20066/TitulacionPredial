package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.util.List;

/**
 * Fachada que define las operaciones de alto nivel para la
 * gestión de beneficiarios en el sistema.
 *
 * <p>
 * Actúa como capa intermedia entre los controladores y el DAO,
 * simplificando la construcción de DTOs y encapsulando la
 * lógica de acceso a datos. Extiende {@link IListable},
 * {@link IRemovable} e {@link ICountable}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see BeneficiaryImplFacade
 * @since 1.0
 */
public interface BeneficiaryFacade extends IListable<DTOBeneficiarySimpleDetails>, IRemovable, ICountable {

    /**
     * Registra un nuevo beneficiario en el sistema.
     *
     * @param id                 número de cédula
     * @param fullName           nombre completo
     * @param department         departamento de residencia
     * @param municipality       municipio de residencia
     * @param address            dirección
     * @param cadastralReference referencia catastral
     * @param maritalStatus      estado civil
     * @param affectation        tipo de afectación
     * @param phone              número de teléfono
     * @param crossing           cruce de calles
     * @param publication        publicación
     * @param neighborhood       barrio
     * @param expeditionLocation lugar de expedición del documento
     * @throws DAOException si ocurre un error en la operación
     */
    void add(long id, String fullName, Department department, Municipalities municipality, String address,
             String cadastralReference, MaritalStatus maritalStatus, String affectation, long phone, String crossing,
             String publication, String neighborhood, String expeditionLocation) throws DAOException;

    /**
     * Busca un beneficiario por su código único.
     *
     * @param code código del beneficiario
     * @return DTO con los datos básicos
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException;

    /**
     * Busca un beneficiario por su número de cédula.
     *
     * @param id número de cédula
     * @return DTO con los datos básicos
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOBeneficiarySimpleDetails findById(long id) throws DAOException;

    /**
     * Busca un beneficiario por su nombre completo.
     *
     * @param fullName nombre del beneficiario
     * @return DTO con los datos básicos
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOBeneficiarySimpleDetails findByName(String fullName) throws DAOException;

    /**
     * Obtiene todos los beneficiarios de un municipio.
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
     * @param code código del beneficiario
     * @return DTO con datos completos
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOBeneficiaryDetails findAllData(int code) throws DAOException;

    /**
     * Obtiene todos los beneficiarios con formato para exportación.
     *
     * @return lista de DTOs completos
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiaryCreate> findAllForExport() throws DAOException;

    /**
     * Obtiene los beneficiarios sin predio asignado.
     *
     * @return lista de DTOs de beneficiarios sin predio
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiarySimpleDetails> findAllWithoutProperty() throws DAOException;

    /**
     * Modifica los datos de un beneficiario existente.
     *
     * @param department    departamento actualizado
     * @param municipality  municipio actualizado
     * @param address       dirección actualizada
     * @param maritalStatus estado civil actualizado
     * @param affectation   afectación actualizada
     * @param phone         teléfono actualizado
     * @param crossing      cruce actualizado
     * @param publication   publicación actualizada
     * @param neighborhood  barrio actualizado
     * @param code          código del beneficiario a modificar
     * @return {@code true} si la modificación fue exitosa
     * @throws DAOException si ocurre un error en la operación
     */
    boolean modify(Department department, Municipalities municipality, String address, MaritalStatus maritalStatus,
                   String affectation, long phone, String crossing, String publication, String neighborhood,
                   int code) throws DAOException;

    /**
     * Asocia un predio a un beneficiario.
     *
     * @param code         código del beneficiario
     * @param propertyCode código del predio a asociar
     * @return {@code true} si la asociación fue exitosa
     * @throws DAOException si ocurre un error en la operación
     */
    boolean modifyProperty(int code, int propertyCode) throws DAOException;

    /**
     * Obtiene el último código de beneficiario registrado.
     *
     * @return último código secuencial
     * @throws DAOException si ocurre un error en la consulta
     */
    int getLastCode() throws DAOException;

    /**
     * Obtiene el conteo mensual de beneficiarios registrados.
     *
     * @param months cantidad de meses a consultar
     * @return lista con el conteo por mes
     * @throws DAOException si ocurre un error en la consulta
     */
    List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException;

    /**
     * Cuenta los beneficiarios que tienen predio asociado.
     *
     * @return cantidad de beneficiarios con predio
     * @throws DAOException si ocurre un error en la consulta
     */
    int countBeneficiariesWithProperty() throws DAOException;

    /**
     * Calcula el porcentaje de beneficiarios con predio.
     *
     * @return porcentaje (0–100)
     * @throws DAOException si ocurre un error en la consulta
     */
    int percentBeneficiariesWithProperty() throws DAOException;

}
