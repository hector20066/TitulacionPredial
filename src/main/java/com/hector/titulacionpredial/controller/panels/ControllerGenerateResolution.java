package com.hector.titulacionpredial.controller.panels;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import com.hector.titulacionpredial.controller.builder.ControllerGenerateResolutionBuilder;
import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.DialogUtils;
import com.hector.titulacionpredial.utils.GenerateResolutionUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOGenerateResolutionText;

/**
 * Resolution generation panel controller.
 *
 * <p>
 * Manage the validation of form data, the recording of the
 * resolution int the database, and the generation of the
 * Word document using {@link GenerateResolutionUtils}.
 * </p>
 *
 * <p>
 * Implement {@link LanguageObserver} as a concrete observer
 * of the Observer pattern, allowing the view to be automatically
 * updated when the {@link LanguageSubject} notifies a language
 * change.
 * </p>
 *
 * <p>
 * Use {@link LanguageManager} to access internationalized resources
 * using text keys.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see GenerateResolution
 * @see GenerateResolutionUtils
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerGenerateResolution implements LanguageObserver {

    private final GenerateResolution generateResolution;
    private final Subject subject;
    private final LanguageManager lang;

    private final ResolutionFacade daoResolution;
    private final BeneficiaryFacade daoBeneficiary;

    /**
     * Create the controller, register it as an observer,
     * and connect the form events.
     *
     * @param builder constructor with configured views
     */
    public ControllerGenerateResolution(ControllerGenerateResolutionBuilder builder) {
        this.generateResolution = builder.getGenerateResolution();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        this.daoResolution = new ResolutionImplFacade();
        this.daoBeneficiary = new BeneficiaryImplFacade();

        connectEvents();
    }

    /**
     * Connect the generate resolution button to the
     * {@link #generateResolution()}.
     */
    private void connectEvents() {
        generateResolution.setControllerGenerate(e -> generateResolution());
    }

    @Override
    public void updateLanguage() {
        DTOGenerateResolutionText dto = new DTOGenerateResolutionText.Builder()
                .resumeTitle(lang.app("generate.resolution.resume"))
                .beneficiaryData(lang.app("generate.resolution.beneficiary.data"))
                .names(lang.app("generate.resolution.names"))
                .id(lang.app("generate.resolution.id"))
                .address(lang.app("generate.resolution.address"))
                .cadastralRef(lang.app("generate.resolution.cadastralRef"))
                .municipality(lang.app("generate.resolution.municipality"))
                .propertyInfo(lang.app("generate.resolution.property.info"))
                .point(lang.app("generate.resolution.point.num"))
                .northCord(lang.app("generate.resolution.north.cord"))
                .eastCord(lang.app("generate.resolution.east.cord"))
                .distance(lang.app("generate.resolution.distance"))
                .hillside(lang.app("generate.resolution.hillside"))
                .propertyCode(lang.app("generate.resolution.property.code"))
                .area(lang.app("generate.resolution.area"))
                .enterInfo(lang.app("generate.resolution.enter.info"))
                .numResolution(lang.app("generate.resolution.num.resolution"))
                .notification(lang.app("generate.resolution.notify"))
                .executory(lang.app("generate.resolution.executory"))
                .fmi(lang.app("generate.resolution.fmi"))
                .act(lang.app("generate.resolution.act"))
                .publicWriting(lang.app("generate.resolution.publicWriting"))
                .notary(lang.app("generate.resolution.notary"))
                .generateLabel(lang.app("generate.resolution.label"))
                .generateBtn(lang.app("generate.resolution.btn"))
                .build();

        generateResolution.updateLanguage(dto);
    }

    /**
     * Validate the form data and launch the resolution
     * generation process.
     *
     * <p>
     * Extract all fields from the form, ask the user for the save path, delegate
     * the validation action to {@link #validations(Date, Date, String, String, String, String)}
     * and delegate the background execution using {@link #doInBackground}.
     * </p>
     */
    private void generateResolution() {
        try {
            String resolutionNumber = generateResolution.getTxt_numResolution().getText().trim();
            Date executory = (Date) generateResolution.getFtx_executory().getValue();
            String act = generateResolution.getTxt_act().getText().trim();
            String publicWriting = generateResolution.getTxt_publicWriting().getText().trim();
            Date notification = (Date) generateResolution.getFtx_notification().getValue();
            String fmi = generateResolution.getTxt_fmi().getText().trim();
            String notary = generateResolution.getTxt_note().getText().trim();
            int propertyCode = generateResolution.getPropertyCode();
            String beneficiaryName = generateResolution.getTxt_nameBeneficiary().getText().trim();
            String address = generateResolution.getTxt_addressBeneficiary().getText().trim();
            String cadastralId = generateResolution.getTxt_cadastralReference().getText().trim().replace(".", "");
            String area = generateResolution.getTxt_area().getText().trim();
            String idBeneficiaries = generateResolution.getTxt_idBeneficiary().getText().trim();

            String path = DialogUtils.selectRoute(generateResolution);

            validations(executory, notification, path, resolutionNumber, notary, String.valueOf(propertyCode));

            LocalDate executoryLocalDate = executory.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate notificationLocalDate = notification.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            doInBackground(Integer.parseInt(resolutionNumber), executoryLocalDate, act, publicWriting, notificationLocalDate,
                    fmi, notary, propertyCode, beneficiaryName, idBeneficiaries, address, cadastralId, area, path);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), generateResolution);
        }
    }

    /**
     * Perform field validation
     *
     * @param executory        date of execution.
     * @param notification     date of notification.
     * @param path             path where the file will be saved.
     * @param resolutionNumber resolution number
     * @param notary           name of the notary
     * @param propertyCode     property code.
     * @throws InvalidInputException An exception is thrown when
     *                               invalid fields are entered.
     */
    private void validations(Date executory, Date notification, String path, String resolutionNumber, String notary,
                             String propertyCode) throws InvalidInputException {
        if (executory == null || notification == null) {
            throw new EmptyFieldException(lang.message("empty.resolution.executory.and.notify"));
        }

        if (path == null) {
            throw new InvalidInputException(lang.message("invalid.input.resolution.select.route"));
        }

        if (resolutionNumber.isBlank() || notary.isBlank() || propertyCode.isBlank()) {
            throw new EmptyFieldException(lang.message("empty.resolution.number.notary"));
        }

        if (!NumericalValidationUtils.isNumeric(resolutionNumber)) {
            throw new InvalidNumberInputException(lang.message("invalid.number.property.number"));
        }
    }

    /**
     * Executes an asynchronous task by displaying a loading dialog.
     *
     * @param task task to run in the background
     */
    private void executeWithDialog(Callable<Void> task) {
        DialogUtils.executeWithDialog(generateResolution, lang.message("dialog.resolution.generating"),
                lang.message("dialog.resolution.generate"), task, subject::notifyObservers);
    }

    /**
     * It records the resolution in the database and generates the
     * Word document in the background.
     *
     * <p>
     * Verify that there is no duplicate resolution, retrieve the
     * associated beneficiaries, persist the resolution, and generate
     * the document using {@link GenerateResolutionUtils}.
     * </p>
     *
     * @param numResolution   resolution number
     * @param executory       date of execution
     * @param act             act
     * @param publicWriting   public deed
     * @param notification    notification date
     * @param fmi             Real Estate Registration Folio
     * @param notary          name of the notary
     * @param propertyCode    property code
     * @param beneficiaryName beneficiary name
     * @param idBeneficiaries beneficiary ID cards separated by " - "
     * @param address         property address
     * @param cadastralId     cadastral ID
     * @param area            area of the property
     * @param path            path where the document is saved
     */
    private void doInBackground(int numResolution, LocalDate executory, String act, String publicWriting,
                                LocalDate notification, String fmi, String notary, int propertyCode, String beneficiaryName,
                                String idBeneficiaries, String address, String cadastralId, String area, String path) {
        executeWithDialog(() -> {
            if (daoResolution.findByCode((int) numResolution) != null) {
                throw new PersistenceException(lang.message("persistence.resolution.exist"));
            }

            List<DTOBeneficiarySimpleDetails> listDTOBeneficiaries = new ArrayList<>();
            String[] beneficiaries = idBeneficiaries.split(" - ");

            for (String idBeneficiary : beneficiaries) {
                DTOBeneficiarySimpleDetails dto = daoBeneficiary.findById(Long.parseLong(idBeneficiary.replace(" -", "")));
                listDTOBeneficiaries.add(dto);
            }

            daoResolution.add(numResolution, notification, executory, fmi, act, publicWriting, notary, propertyCode, beneficiaryName);
            generateDocument(path, listDTOBeneficiaries, address, cadastralId, fmi, area, String.valueOf(notification));
            return null;
        });
    }

    /**
     * Generate the Word document of the resolution with the data
     * of the property and the beneficiaries.
     *
     * <p>
     * Extract the coordinates of the four geographic points from
     * the form, build the corresponding DTOs and delegate the
     * generation to {@link GenerateResolutionUtils}.
     * </p>
     *
     * @param path              document save path
     * @param beneficiariesList list of associated beneficiaries
     * @param address           property address
     * @param cadastralId       cadastral certificate
     * @param fmi               Real Estate Registration Folio
     * @param area              area of the property
     * @param notification      notification date
     * @throws IOException If an error occurs while writing the file
     */
    private void generateDocument(String path, List<DTOBeneficiarySimpleDetails> beneficiariesList,
                                  String address, String cadastralId, String fmi, String area, String notification) throws IOException {
        String northCoordinate1 = generateResolution.getTxt_northCoordinate1().getText().trim();
        String eastCoordinate1 = generateResolution.getTxt_eastCoordinate1().getText().trim();
        String distance1 = generateResolution.getTxt_distance1().getText().trim();
        String hillside1 = generateResolution.getTxt_hillside1().getText().trim();

        String northCoordinate2 = generateResolution.getTxt_northCoordinate2().getText().trim();
        String eastCoordinate2 = generateResolution.getTxt_eastCoordinate2().getText().trim();
        String distance2 = generateResolution.getTxt_distance2().getText().trim();
        String hillside2 = generateResolution.getTxt_hillside2().getText().trim();

        String northCoordinate3 = generateResolution.getTxt_northCoordinate3().getText().trim();
        String eastCoordinate3 = generateResolution.getTxt_eastCoordinate3().getText().trim();
        String distance3 = generateResolution.getTxt_distance3().getText().trim();
        String hillside3 = generateResolution.getTxt_hillside3().getText().trim();

        String northCoordinate4 = generateResolution.getTxt_northCoordinate4().getText().trim();
        String eastCoordinate4 = generateResolution.getTxt_eastCoordinate4().getText().trim();
        String distance4 = generateResolution.getTxt_distance4().getText().trim();
        String hillside4 = generateResolution.getTxt_hillside4().getText().trim();

        List<DTOPoint> points = new ArrayList<>();
        points.add(new DTOPoint.Builder()
                .numberPoint(1)
                .northCoordinate(Double.parseDouble(northCoordinate1))
                .eastCoordinate(Double.parseDouble(eastCoordinate1))
                .distance(Double.parseDouble(distance1))
                .hillside(hillside1)
                .build());

        points.add(new DTOPoint.Builder()
                .numberPoint(2)
                .northCoordinate(Double.parseDouble(northCoordinate2))
                .eastCoordinate(Double.parseDouble(eastCoordinate2))
                .distance(Double.parseDouble(distance2))
                .hillside(hillside2)
                .build());

        points.add(new DTOPoint.Builder()
                .numberPoint(3)
                .northCoordinate(Double.parseDouble(northCoordinate3))
                .eastCoordinate(Double.parseDouble(eastCoordinate3))
                .distance(Double.parseDouble(distance3))
                .hillside(hillside3)
                .build());

        points.add(new DTOPoint.Builder()
                .numberPoint(4)
                .northCoordinate(Double.parseDouble(northCoordinate4))
                .eastCoordinate(Double.parseDouble(eastCoordinate4))
                .distance(Double.parseDouble(distance4))
                .hillside(hillside4)
                .build());

        GenerateResolutionUtils.generateResolution(beneficiariesList, points, address, cadastralId, fmi, area, notification, path);
    }

}
