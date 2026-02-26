package com.hector.titulacionpredial.observer;

/**
 *
 * @author hectoracevedo
 */
public interface Subject {

    void register(Observer observer);

    void remove(Observer observer);

    void notifyObservers();

}
