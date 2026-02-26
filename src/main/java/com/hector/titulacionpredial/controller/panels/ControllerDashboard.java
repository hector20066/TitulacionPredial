package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.observer.*;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.swing.model.ModelChart;

import javax.swing.*;
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

    private final BeneficiaryFacade daoBeneficiary;
    private final PropertyFacade daoProperty;
    private final ResolutionFacade daoResolution;

    public ControllerDashboard(Dashboard dashboard, Subject subject) {
        this.dashboard = dashboard;

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoProperty = new PropertyImplFacade();
        this.daoResolution = new ResolutionImplFacade();

        subject.register(this);
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                List<DTOBeneficiariesByMonth> beneficiariesByMonths = daoBeneficiary.countBeneficiariesLastMonths(12);
                int totalBeneficiaries = daoBeneficiary.countRecords();
                int totalProperties = daoProperty.countRecords();
                int totalResolutions = daoResolution.countRecords();

                int percentBeneficiaries = daoBeneficiary.percentBeneficiariesWithProperty();
                int percentProperties = daoProperty.percentPropertiesWithResolutions();

                int beneficiariesWithProperty = daoBeneficiary.countBeneficiariesWithProperty();
                int propertiesWithResolution = daoProperty.countPropertyWithResolution();

                int beneficiariesWithoutProperty = totalBeneficiaries - beneficiariesWithProperty;
                int propertiesWithoutResolution = totalProperties - propertiesWithResolution;

                SwingUtilities.invokeLater(() -> {
                    loadInfo(beneficiariesByMonths);
                    loadCards(totalBeneficiaries, totalProperties, totalResolutions);
                    loadDataPercent(percentBeneficiaries, percentProperties);
                    loadDataBeneficiaries(beneficiariesWithProperty, beneficiariesWithoutProperty, totalBeneficiaries);
                    loadDataProperties(propertiesWithResolution, propertiesWithoutResolution, totalProperties);
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), dashboard));
            }
        }).start();
    }

    private void loadInfo(List<DTOBeneficiariesByMonth> list) {
        dashboard.getLineChart1().clear();
        dashboard.getLineChart1().addLegend("Beneficiarios Registrados", new Color(149,213,178), new Color(45,106,79));

        list.forEach(dto -> {
            String nombreMes = Month.of(dto.getMonth()).getDisplayName(TextStyle.FULL, Locale.of("es"));
            dashboard.getLineChart1().addData(new ModelChart(nombreMes, new double[]{dto.getTotal()}));
        });

        dashboard.getLineChart1().start();
    }

    public void loadCards(int totalBeneficiaries, int totalProperties, int totalResolutions) {
        dashboard.updateCards(totalBeneficiaries, totalProperties, totalResolutions);
    }

    private void loadDataPercent(int percentBeneficiaries, int percentProperties) {
        dashboard.updateGaugeCharts(percentBeneficiaries, percentProperties);
    }

    public void loadDataBeneficiaries(int withProperty, int withoutProperty, int total) {
        dashboard.loadDataBeneficiaries(withProperty, withoutProperty, total);
    }

    public void loadDataProperties(int withResolution, int withoutResolution, int total) {
        dashboard.loadDataProperties(withResolution, withoutResolution, total);
    }

}
