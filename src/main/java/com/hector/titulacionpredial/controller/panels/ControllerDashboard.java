package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.builder.ControllerDashboardBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.i18n.*;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesByMonth;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.UserConfig;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTODashboardText;
import com.hector.titulacionpredial.view.swing.model.ModelChart;

import javax.swing.*;
import java.awt.*;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

/**
 * Dashboard panel controller.
 *
 * <p>
 * Implement {@link Observer} and {@link LanguageObserver} to
 * automatically update the Dashboard panel when changes occur
 * in the data or the application language.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Dashboard
 * @see Observer
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerDashboard implements Observer, LanguageObserver {

    private final Dashboard dashboard;
    private final LanguageManager lang;

    private final BeneficiaryFacade daoBeneficiary;
    private final PropertyFacade daoProperty;
    private final ResolutionFacade daoResolution;

    /**
     * Create the controller and register it as an observer.
     *
     * @param builder constructor with configured views
     */
    public ControllerDashboard(ControllerDashboardBuilder builder) {
        this.dashboard = builder.getDashboard();
        this.lang = builder.getLang();

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoProperty = new PropertyImplFacade();
        this.daoResolution = new ResolutionImplFacade();

        builder.getSubject().register(this);
        builder.getLanguageSubject().register(this);
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

    /**
     * Load the line chart data with the monthly trend of registered
     * beneficiaries.
     *
     * <p>
     * Clean up the existing chart, set up the legend, and add each
     * month with its corresponding amount.
     * </p>
     *
     * @param list List of data with the number of beneficiaries per month
     */
    private void loadInfo(List<DTOBeneficiariesByMonth> list) {
        dashboard.getLineChart1().clear();
        dashboard.getLineChart1().addLegend(lang.app("controller.dashboard.beneficiaries.registers"),
                new Color(149, 213, 178),
                new Color(45, 106, 79));

        list.forEach(dto -> {
            String monthName = Month.of(dto.month()).getDisplayName(TextStyle.FULL, Locale.of(UserConfig.get("app.language")));
            dashboard.getLineChart1().addData(new ModelChart(monthName, new double[]{dto.total()}));
        });

        dashboard.getLineChart1().start();
    }

    /**
     * Load the total number of each type of record
     *
     * @param totalBeneficiaries total number of registered beneficiaries
     * @param totalProperties    total number of registered properties.
     * @param totalResolutions   total number of resolutions registered
     */
    public void loadCards(int totalBeneficiaries, int totalProperties, int totalResolutions) {
        dashboard.updateCards(totalBeneficiaries, totalProperties, totalResolutions);
    }

    /**
     * Load the percentages into the gauge graphs.
     *
     * @param percentBeneficiaries percentage of beneficiaries with property
     * @param percentProperties    percentage of properties with resolution
     */
    private void loadDataPercent(int percentBeneficiaries, int percentProperties) {
        dashboard.updateGaugeCharts(percentBeneficiaries, percentProperties);
    }

    /**
     * Upload the beneficiary data related to the properties
     *
     * @param withProperty    beneficiaries with properties
     * @param withoutProperty beneficiaries without land
     * @param total           total number of beneficiaries
     */
    private void loadDataBeneficiaries(int withProperty, int withoutProperty, int total) {
        dashboard.loadDataBeneficiaries(withProperty, withoutProperty, total);
    }

    /**
     * Upload the property data in relation to the resolutions
     *
     * @param withResolution    properties with resolution
     * @param withoutResolution properties without resolution
     * @param total             total number of properties
     */
    private void loadDataProperties(int withResolution, int withoutResolution, int total) {
        dashboard.loadDataProperties(withResolution, withoutResolution, total);
    }

    @Override
    public void updateLanguage() {
        DTODashboardText dto = new DTODashboardText.Builder()
                .beneficiaries(lang.app("dashboard.beneficiaries"))
                .beneficiariesDesc(lang.app("dashboard.beneficiaries.desc"))
                .properties(lang.app("dashboard.properties"))
                .propertiesDesc(lang.app("dashboard.properties.desc"))
                .resolutions(lang.app("dashboard.resolutions"))
                .resolutionsDesc(lang.app("dashboard.resolutions.desc"))
                .withProperty(lang.app("dashboard.with.property"))
                .withoutProperty(lang.app("dashboard.without.property"))
                .total(lang.app("dashboard.total"))
                .withResolution(lang.app("dashboard.with.resolution"))
                .withoutResolution(lang.app("dashboard.without.resolution"))
                .totalRegisters(lang.app("dashboard.total.registers"))
                .percentWorks(lang.app("dashboard.percent.works"))
                .registersMonth(lang.app("dashboard.beneficiaries.registers.month"))
                .build();

        dashboard.updateLanguage(dto);
    }

}
