package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.model.dao.interfaces.ICountable;
import com.hector.titulacionpredial.model.dao.interfaces.IListable;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;

import java.time.LocalDate;

/**
 * Fachada que define las operaciones de alto nivel para la
 * gestión de resoluciones en el sistema.
 *
 * <p>
 * Extiende {@link IListable} e {@link ICountable} para ofrecer
 * listado y conteo de resoluciones, además de operaciones
 * de creación, búsqueda y modificación.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ResolutionImplFacade
 * @since 1.0
 */
public interface ResolutionFacade extends IListable<DTOResolutionDetails>, ICountable {

    /**
     * Registra una nueva resolución en el sistema.
     *
     * @param resolutionNumber número de la resolución
     * @param notification     fecha de notificación
     * @param executory        fecha de ejecutoria
     * @param fmi              folio de matrícula inmobiliaria
     * @param act              acta
     * @param publicWriting    escritura pública
     * @param notary           notaría
     * @param propertyCode     código del predio asociado
     * @param beneficiaryName  nombre del beneficiario
     * @throws DAOException si ocurre un error en la operación
     */
    void add(long resolutionNumber, LocalDate notification, LocalDate executory, String fmi, String act,
             String publicWriting, String notary, int propertyCode, String beneficiaryName) throws DAOException;

    /**
     * Busca una resolución por su número.
     *
     * @param numResolution número de la resolución
     * @return DTO con los datos detallados de la resolución
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOResolutionDetails findByCode(int numResolution) throws DAOException;

    /**
     * Modifica los datos de una resolución existente.
     *
     * @param code          código de la resolución a modificar
     * @param executory     fecha de ejecutoria actualizada
     * @param act           acta actualizada
     * @param publicWriting escritura pública actualizada
     * @param numResolution número de resolución actualizado
     * @param notification  fecha de notificación actualizada
     * @param fmi           FMI actualizado
     * @param notary        notaría actualizada
     * @return {@code true} si la modificación fue exitosa
     * @throws DAOException si ocurre un error en la operación
     */
    boolean modify(int code, LocalDate executory, String act, String publicWriting, long numResolution,
                   LocalDate notification, String fmi, String notary) throws DAOException;

}
