package com.hector.titulacionpredial.utils;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Utility class for network connectivity checks.
 *
 * <p>
 * It provides methods to verify network availability
 * and internet connectivity of the host machine.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class NetworkUtils {

    /**
     * Check if the host machine has internet connectivity.
     *
     * <p>
     * Attempts to connect to Google's public DNS server (8.8.8.8) on port 53
     * with a 2-second timeout to determine internet availability.
     * </p>
     *
     * @return {@code true} if internet connection is available,
     * {@code false} otherwise
     */
    public static boolean hasInternetConnection() {
        try (Socket socket = new Socket()) {
            // Trying to connect to Google DNS using port 53
            socket.connect(new InetSocketAddress("8.8.8.8", 53), 2000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
