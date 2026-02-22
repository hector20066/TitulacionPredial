package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.swing.model.ModelChart;

import java.awt.*;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author hectoracevedo
 */
public class ControllerDashboard implements Observer {

    private final Dashboard dashboard;
    private final Subject subject;

    private final BeneficiaryFacade daoBeneficiary;

    public ControllerDashboard(Dashboard dashboard, Subject subject) {
        this.dashboard = dashboard;
        this.subject = subject;

        this.daoBeneficiary = new BeneficiaryImplFacade();

        this.subject.register(this);
    }

    @Override
    public void update() {
        loadInfo();
    }

    private void loadInfo() {
        try {
            List<DTOBeneficiariesByMonth> datos = daoBeneficiary.countBeneficiariesLastMonths(12);

            dashboard.getLineChart1().clear();
            dashboard.getLineChart1().addLegend("Beneficiarios Registrados", new Color(149,213,178), new Color(45,106,79));

            for (DTOBeneficiariesByMonth dto : datos) {
                String nombreMes = Month.of(dto.getMonth()).getDisplayName(TextStyle.FULL, Locale.of("es"));

                dashboard.getLineChart1().addData(new ModelChart(nombreMes, new double[]{dto.getTotal()}));
            }

            dashboard.getLineChart1().start();
        } catch (Exception e) {
            MessageUtils.errorMessage("Error al cargar la información del gráfico", dashboard);
        }
    }

}
