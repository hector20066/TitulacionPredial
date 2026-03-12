package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;

import javax.swing.*;

/**
 * @author Ing. Hector Acevedo
 */
public interface IManageAccounts {

    void modifyAccount(DTOUserDetails account);
    void deleteAccount(long id, JPanel panel);

}
