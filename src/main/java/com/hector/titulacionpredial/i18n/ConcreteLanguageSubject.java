package com.hector.titulacionpredial.i18n;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class ConcreteLanguageSubject implements LanguageSubject {

    private final List<LanguageObserver> observers;
    private static ConcreteLanguageSubject instance;

    private ConcreteLanguageSubject() {
        this.observers = new ArrayList<>();
    }

    public static ConcreteLanguageSubject getInstance() {
        if (instance == null) {
            instance = new ConcreteLanguageSubject();
        }

        return instance;
    }


    @Override
    public void register(LanguageObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void remove(LanguageObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(LanguageObserver::updateLanguage);
    }

}
