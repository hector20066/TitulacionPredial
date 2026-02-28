package com.hector.titulacionpredial.utils;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase utilitaria para la generación de documentos Word
 * de resoluciones a partir de una plantilla.
 *
 * <p>
 * Utiliza la librería POI-TL (Deepoove) para reemplazar
 * variables en una plantilla Word ({@code .docx}) con los
 * datos de los beneficiarios, puntos geográficos y demás
 * información de la resolución.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see XWPFTemplate
 * @since 1.0
 */
public class GenerateResolutionUtils {

    /**
     * Genera el documento Word de resolución con los datos proporcionados.
     *
     * @param beneficiariesList lista de beneficiarios asociados
     * @param points            lista de puntos geográficos del predio
     * @param address           dirección del predio
     * @param cadastralId       cédula catastral
     * @param fmi               folio de matrícula inmobiliaria
     * @param area              área del predio
     * @param notificacion      fecha de notificación
     * @param path              ruta del directorio de destino
     * @throws IOException si ocurre un error al escribir el documento
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
            }
        }

        Configure config = Configure.builder()
                .buildGramer("${", "}")
                .build();

        InputStream templateStream = GenerateResolution.class.getClassLoader().
                getResourceAsStream("resolution/MINUTA - RES FISCALES.docx");
        XWPFTemplate template = XWPFTemplate.compile(templateStream, config).render(data);
        template.writeToFile(path + File.separator + "MINUTA - RES FISCALES.docx");
        template.close();
    }

    private static void defineTemplate(StringBuilder sb, List<DTOBeneficiarySimpleDetails> beneficiariesList) {
        String identifyingText = " identificad(o)(a) con cedula de ciudadanía N° ";

        if (beneficiariesList.isEmpty()) {
            return;
        }

        int numDistinctMaritalStatuses = verifyMaritalStatus(beneficiariesList);

        if (numDistinctMaritalStatuses > 1) {
            for (DTOBeneficiarySimpleDetails beneficiary : beneficiariesList) {
                sb.append(beneficiary.getFullName())
                        .append(identifyingText)
                        .append(beneficiary.getId())
                        .append(" estado civil ")
                        .append(beneficiary.getMaritalStatus().getValue()).append(", ");
            }
        } else {
            for (DTOBeneficiarySimpleDetails beneficiary : beneficiariesList) {
                sb.append(beneficiary.getFullName()).append(identifyingText).append(beneficiary.getId()).append(", ");
            }

            if (numDistinctMaritalStatuses == 1) {
                sb.append(" estado civil ").append(beneficiariesList.getFirst().getMaritalStatus().getValue());
            } else {
                sb.append(" estado civil ").append(beneficiariesList.getFirst().getMaritalStatus().getValue()).append("s");
            }
        }
    }

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
