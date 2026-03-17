package com.hector.titulacionpredial.utils;

import java.net.InetSocketAddress;
import java.net.Socket;

public class NetworkUtils {

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
