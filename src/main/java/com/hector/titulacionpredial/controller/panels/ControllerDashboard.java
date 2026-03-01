package com.hector.titulacionpredial.controller.panels;

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
import com.hector.titulacionpredial.observer.Subject;
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
 * Controlador del panel Dashboard.
 *
 * <p>
 * Implementa {@link Observer} y {@link LanguageObserver} para actualizar
 * automáticamente el panel del Dashboard cuando se producen cambios
 * en los datos o en el idioma de la aplicación.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Dashboard
 * @see Observer
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerDashboard implements Observer, LanguageObserver {

    /**
     * Vista del dashboard.
     */
    private final Dashboard dashboard;

    /**
     * Acceso al gestor de los idiomas.
     */
    private final LanguageManager lang;

    /**
     * Fachada de acceso a datos de beneficiarios.
     */
    private final BeneficiaryFacade daoBeneficiary;

    /**
     * Fachada de acceso a datos de predios.
     */
    private final PropertyFacade daoProperty;

    /**
     * Fachada de acceso a datos de resoluciones.
     */
    private final ResolutionFacade daoResolution;

    /**
     * Crea el controlador y lo registra como observador.
     *
     * @param dashboard       vista del dashboard
     * @param subject         sujeto para registro del observador
     * @param languageSubject sujeto para notificar cambios de idioma
     * @param lang            acceso al gestor de los idiomas
     */
    public ControllerDashboard(Dashboard dashboard, Subject subject, LanguageSubject languageSubject, LanguageManager lang) {
        this.dashboard = dashboard;
        this.lang = lang;

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoProperty = new PropertyImplFacade();
        this.daoResolution = new ResolutionImplFacade();

        subject.register(this);
        languageSubject.register(this);
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
     * Carga los datos del gráfico de línea con la tendencia mensual
     * de beneficiarios registrados.
     *
     * <p>
     * Limpia el gráfico existente, configura la leyenda y agrega
     * cada mes con su cantidad correspondiente.
     * </p>
     *
     * @param list lista de DTOs con la cantidad de beneficiarios por mes
     */
    private void loadInfo(List<DTOBeneficiariesByMonth> list) {
        dashboard.getLineChart1().clear();
        dashboard.getLineChart1().addLegend("Beneficiarios Registrados", new Color(149, 213, 178), new Color(45, 106, 79));

        list.forEach(dto -> {
            String nombreMes = Month.of(dto.month()).getDisplayName(TextStyle.FULL, Locale.of("es"));
            dashboard.getLineChart1().addData(new ModelChart(nombreMes, new double[]{dto.total()}));
        });

        dashboard.getLineChart1().start();
    }

    /**
     * Carga el número total de cada tipo de registros
     *
     * @param totalBeneficiaries numero total de beneficiarios registrados
     * @param totalProperties    numero total de predios registrados.
     * @param totalResolutions   número total de resoluciones registradas
     */
    public void loadCards(int totalBeneficiaries, int totalProperties, int totalResolutions) {
        dashboard.updateCards(totalBeneficiaries, totalProperties, totalResolutions);
    }

    /**
     * Carga los porcentajes en los gráficos de medidor (gauge).
     *
     * @param percentBeneficiaries porcentaje de beneficiarios con predio
     * @param percentProperties    porcentaje de predios con resolución
     */
    private void loadDataPercent(int percentBeneficiaries, int percentProperties) {
        dashboard.updateGaugeCharts(percentBeneficiaries, percentProperties);
    }

    /**
     * Carga los datos de los beneficiarios con relación a los predios
     *
     * @param withProperty    beneficiarios con predios
     * @param withoutProperty beneficiarios sin predios
     * @param total           total de beneficiarios
     */
    private void loadDataBeneficiaries(int withProperty, int withoutProperty, int total) {
        dashboard.loadDataBeneficiaries(withProperty, withoutProperty, total);
    }

    /**
     * Carga los datos de los predios con relacion a las resoluciones
     *
     * @param withResolution    predios con resolucion
     * @param withoutResolution predios sin resolucion
     * @param total             total de predios
     */
    private void loadDataProperties(int withResolution, int withoutResolution, int total) {
        dashboard.loadDataProperties(withResolution, withoutResolution, total);
    }

    @Override
    public void updateLanguage() {

    }

}
