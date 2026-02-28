package com.hector.titulacionpredial.i18n;

/**
 *
 * @author hectoracevedo
 */
public interface LanguageSubject {

    void register(LanguageObserver observer);
    void remove(LanguageObserver observer);
    void notifyObserver();

}
