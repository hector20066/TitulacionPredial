package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

/**
 *
 * @author hectoracevedo
 */
public class ControllerDashboard implements Observer {

    private final Dashboard dashboard;
    private final Subject subject;

    public ControllerDashboard(Dashboard dashboard, Subject subject) {
        this.dashboard = dashboard;
        this.subject = subject;

        this.subject.register(this);
    }

    @Override
    public void update() {

    }

}
