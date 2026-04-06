package com.hector.titulacionpredial.model.security;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class that provides methods for password encryption and
 * verification using the BCrypt hashing algorithm.
 *
 * <p>
 * This class is part of the security layer of the application and
 * is responsible for protecting user credentials by hashing passwords
 * before they are stored in the system.
 * </p>
 *
 * <p>
 * It also provides functionality to verify plaintext passwords
 * against previously generated BCrypt hashes during authentication
 * processes such as user login.
 * </p>
 *
 * <p>
 * All methods in this class are static, allowing them to be used
 * without creating an instance of the class.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class BCryptEncryption {

    /**
     * Encrypting a password using the BCrypt library
     *
     * @param plainPassword password in plain text
     * @return encrypted password
     */
    public static String encryptPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    /**
     * Verifies whether a plaintext password matches a previously
     * encrypted password using the BCrypt algorithm.
     *
     * <p>
     * Returns {@code true} if the passwords match,
     * and {@code false} otherwise.
     * </p>
     *
     * @param plainPassword   password in plain text
     * @param encryptPassword encrypted password
     * @return {@code true} if the password matches the hash, otherwise {@code false}
     */
    public static boolean verifyPassword(String plainPassword, String encryptPassword) {
        return BCrypt.checkpw(plainPassword, encryptPassword);
    }

}
