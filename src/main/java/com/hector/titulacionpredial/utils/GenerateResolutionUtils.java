package com.hector.titulacionpredial.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

/**
 * Utility class for generating Word documents of resolutions
 * from a template.
 *
 * <p>
 * Use the POI-TL library to replace variables in a Word
 * template ({@code .docx}) with beneficiary data, geographic
 * points, and other information from the resolution.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see XWPFTemplate
 * @since 1.0
 */
public class GenerateResolutionUtils {

    /**
     * Generate the Word document resolution with the provided data.
     *
     * @param beneficiariesList list of associated beneficiaries
     * @param points            list of geographical points of the property
     * @param address           property address
     * @param cadastralId       cadastral certificate
     * @param fmi               real estate registration number
     * @param area              area of the property
     * @param notificacion      notification date
     * @param path              destination directory path
     * @throws IOException if an error occurs while writing the document
     */
    public static void generateResolution(List<DTOBeneficiarySimpleDetails> beneficiariesList, List<DTOPoint> points,
                                          String address, String cadastralId, String fmi, String area,
                                          String notificacion, String path) throws IOException {

        StringBuilder beneficiaries = new StringBuilder();
        defineTemplate(beneficiaries, beneficiariesList);

        Map<String, Object> data = new HashMap<>();
        data.put("BENEFICIARIES", beneficiaries.toString());
        data.put("FMI", fmi);
        data.put("ADDRESS", address);
        data.put("AREA", area);
        data.put("CADASTRAL_ID", cadastralId);
        data.put("NOTIFICATION", notificacion);

        for (DTOPoint point : points) {
            switch (point.getNumberPoint()) {
                case 1 -> {
                    data.put("MCORN1", String.valueOf(point.getNorthCoordinate()));
                    data.put("MCORE1", String.valueOf(point.getEastCoordinate()));
                    data.put("MDISN", String.valueOf(point.getDistance()));
                    data.put("MCOLN", point.getHillside());
                }
                case 2 -> {
                    data.put("MCORN2", String.valueOf(point.getNorthCoordinate()));
                    data.put("MCORE2", String.valueOf(point.getEastCoordinate()));
                    data.put("MDISE", String.valueOf(point.getDistance()));
                    data.put("MCOLE", point.getHillside());
                }
                case 3 -> {
                    data.put("MCORN3", String.valueOf(point.getNorthCoordinate()));
                    data.put("MCORE3", String.valueOf(point.getEastCoordinate()));
                    data.put("MDISS", String.valueOf(point.getDistance()));
                    data.put("MCOLS", point.getHillside());
                }
                case 4 -> {
                    data.put("MCORN4", String.valueOf(point.getNorthCoordinate()));
                    data.put("MCORE4", String.valueOf(point.getEastCoordinate()));
                    data.put("MDISO", String.valueOf(point.getDistance()));
                    data.put("MLINDO", point.getHillside());
                }
                default -> throw new IllegalArgumentException("Invalid point number: " + point.getNumberPoint() + ". Valid range: 1-4");
            }
        }

        Configure config = Configure.builder()
                .buildGramer("${", "}")
                .build();

        InputStream templateStream = GenerateResolution.class.getClassLoader().
                getResourceAsStream("resolution/MINUTA - RES FISCALES.docx");

        if (templateStream == null) {
            throw new IOException("Template not found: resolution/MINUTA - RES FISCALES.docx");
        }

        XWPFTemplate template = XWPFTemplate.compile(templateStream, config).render(data);
        template.writeToFile(path + File.separator + "MINUTA - RES FISCALES-" + cadastralId + ".docx");
        template.close();
    }

    /**
     * Create the text for the beneficiaries in the resolution template.
     *
     * <p>
     * If all beneficiaries share the same marital status, it is added
     * at the end; otherwise, it is included next to each beneficiary.
     * </p>
     *
     * @param sb                {@link StringBuilder} where the generated
     *                          text is accumulated
     * @param beneficiariesList list of beneficiaries with their details
     */
    private static void defineTemplate(StringBuilder sb, List<DTOBeneficiarySimpleDetails> beneficiariesList) {
        String identifyingText = " identificad(o)(a) con cedula de ciudadanía N° ";

        if (beneficiariesList.isEmpty()) {
            return;
        }

        int numDistinctMaritalStatuses = verifyMaritalStatus(beneficiariesList);

        if (numDistinctMaritalStatuses > 1) {
            String names = beneficiariesList.stream()
                    .map(b -> b.getFullName() + identifyingText + b.getId())
                    .collect(Collectors.joining(", "));

            sb.append(names);
        } else {
            for (DTOBeneficiarySimpleDetails beneficiary : beneficiariesList) {
                sb.append(beneficiary.getFullName()).append(identifyingText).append(beneficiary.getId()).append(", ");
            }

            if (!beneficiariesList.isEmpty() && numDistinctMaritalStatuses == 1) {
                beneficiariesList.stream()
                        .findFirst()
                        .ifPresent(b -> sb.append(" estado civil ").append(b.getMaritalStatus().getValue()));
            } else {
                sb.append(" estado civil ").append(beneficiariesList.getFirst().getMaritalStatus().getValue()).append("s");
            }
        }
    }

    /**
     * Check the number of different marital statuses among the beneficiaries.
     *
     * @param beneficiariesList list of beneficiaries to be evaluated
     * @return number of different marital statuses found
     */
    private static int verifyMaritalStatus(List<DTOBeneficiarySimpleDetails> beneficiariesList) {
        Map<MaritalStatus, String> status = new HashMap<>();

        beneficiariesList.forEach(dto -> {
            if (!status.containsKey(dto.getMaritalStatus())) {
                status.put(dto.getMaritalStatus(), dto.getMaritalStatus().getValue());
            }
        });

        return status.size();
    }

}
