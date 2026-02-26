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
 *
 * @author hectoracevedo
 */
public class GenerateResolutionUtils {

    public static void generateResolution(List<DTOBeneficiarySimpleDetails> beneficiariesList, List<DTOPoint> points, String address,
                                          String cadastralId, String fmi, String area, String path) throws IOException {
        StringBuilder beneficiaries = new StringBuilder();
        String file = defineTemplate(beneficiaries, beneficiariesList);

        // Construir el mapa de datos para el template
        Map<String, Object> data = new HashMap<>();
        data.put("BENEFICIARIES", beneficiaries.toString());
        data.put("FMI", fmi);
        data.put("ADDRESS", address);
        data.put("AREA", area);
        data.put("CADASTRAL_ID", cadastralId);

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

        // Configurar para usar la sintaxis ${VARIABLE} en lugar del default {{VARIABLE}}
        Configure config = Configure.builder()
                .buildGramer("${", "}")
                .build();

        InputStream templateStream = GenerateResolution.class.getClassLoader().getResourceAsStream(file);
        XWPFTemplate template = XWPFTemplate.compile(templateStream, config).render(data);
        template.writeToFile(path + File.separator + "MINUTA - RES FISCALES-PRUEBAS.docx");
        template.close();
    }

    private static String defineTemplate(StringBuilder sb, List<DTOBeneficiarySimpleDetails> beneficiariesList) {
        String file = "resolution/MINUTA - RES FISCALES-1.docx";
        String identifyingText = " identificad(o)(a) con cedula de ciudadanía N° ";

        if (verifyMaritalStatus(beneficiariesList) > 1) {
            file = "resolution/MINUTA - RES FISCALES-2.docx";

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

            sb.append(" estado civil ").append(beneficiariesList.getFirst().getMaritalStatus().getValue()).append("s");
        }

        return file;
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
