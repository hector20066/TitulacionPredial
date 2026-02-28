package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.SpouseImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.IRemovable;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 * Fachada que define las operaciones de alto nivel para la
 * gestión de cónyuges en el sistema.
 *
 * <p>
 * Extiende {@link IRemovable} para permitir la eliminación
 * de registros de cónyuges. Simplifica la construcción de
 * {@link DTOSpouse} y encapsula las llamadas al DAO.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SpouseImplFacade
 * @since 1.0
 */
public interface SpouseFacade extends IRemovable {

    /**
     * Registra un nuevo cónyuge asociado a un beneficiario.
     *
     * @param id                 número de cédula del cónyuge
     * @param fullName           nombre completo
     * @param expeditionLocation lugar de expedición del documento
     * @param address            dirección
     * @param phone              número de teléfono
     * @param beneficiaryCode    código del beneficiario asociado
     * @throws DAOException si ocurre un error en la operación
     */
    void add(long id, String fullName, String expeditionLocation, String address, long phone,
             int beneficiaryCode) throws DAOException;

    /**
     * Busca un cónyuge por el código del beneficiario.
     *
     * @param id código del beneficiario asociado
     * @return DTO con los datos del cónyuge
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOSpouse findByCode(int id) throws DAOException;

}
