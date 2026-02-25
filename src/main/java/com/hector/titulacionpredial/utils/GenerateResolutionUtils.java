package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
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

        String northCoordinate1 = "";
        String eastCoordinate1 = "";
        String distance1 = "";
        String hillside1 = "";

        String northCoordinate2 = "";
        String eastCoordinate2 = "";
        String distance2 = "";
        String hillside2 = "";

        String northCoordinate3 = "";
        String eastCoordinate3 = "";
        String distance3 = "";
        String hillside3 = "";

        String northCoordinate4 = "";
        String eastCoordinate4 = "";
        String distance4 = "";
        String hillside4 = "";

        for (DTOPoint point : points) {
            switch(point.getNumberPoint()) {
                case 1 -> {
                    northCoordinate1 = String.valueOf(point.getNorthCoordinate());
                    eastCoordinate1 = String.valueOf(point.getEastCoordinate());
                    distance1 = String.valueOf(point.getDistance());
                    hillside1 = point.getHillside();
                }
                case 2 -> {
                    northCoordinate2 = String.valueOf(point.getNorthCoordinate());
                    eastCoordinate2 = String.valueOf(point.getEastCoordinate());
                    distance2 = String.valueOf(point.getDistance());
                    hillside2 = point.getHillside();
                }
                case 3 -> {
                    northCoordinate3 = String.valueOf(point.getNorthCoordinate());
                    eastCoordinate3 = String.valueOf(point.getEastCoordinate());
                    distance3 = String.valueOf(point.getDistance());
                    hillside3 = point.getHillside();
                }
                case 4 -> {
                    northCoordinate4 = String.valueOf(point.getNorthCoordinate());
                    eastCoordinate4 = String.valueOf(point.getEastCoordinate());
                    distance4 = String.valueOf(point.getDistance());
                    hillside4 = point.getHillside();
                }
            }
        }

        InputStream read = GenerateResolution.class.getClassLoader().getResourceAsStream(file);
        XWPFDocument doc = new XWPFDocument(read);

        for (XWPFParagraph p : doc.getParagraphs()) {
            for (XWPFRun run : p.getRuns()) {
                String text = run.getText(0);

                if (text != null) {
                    text = text.replace("${BENEFICIARIES}", beneficiaries.toString());
                    text = text.replace("${FMI}", fmi);
                    text = text.replace("${ADDRESS}", address);
                    text = text.replace("${AREA}", area);
                    text = text.replace("${CADASTRAL_ID}", cadastralId);

                    text = text.replace("${MCORN1}", northCoordinate1);
                    text = text.replace("${MCORE1}", eastCoordinate1);
                    text = text.replace("${MDISN}", distance1);
                    text = text.replace("${MCOLN}", hillside1);

                    text = text.replace("${MCORN2}", northCoordinate2);
                    text = text.replace("${MCORE2}", eastCoordinate2);
                    text = text.replace("${MDISE}", distance2);
                    text = text.replace("${MCOLE}", hillside2);

                    text = text.replace("${MCORN3}", northCoordinate3);
                    text = text.replace("${MCORE3}", eastCoordinate3);
                    text = text.replace("${MDISS}", distance3);
                    text = text.replace("${MCOLS}", hillside3);

                    text = text.replace("${MCORN4}", northCoordinate4);
                    text = text.replace("${MCORE4}", eastCoordinate4);
                    text = text.replace("${MDISO}", distance4);
                    text = text.replace("${MLINDO}", hillside4);

                    run.setText(text, 0);
                }
            }
        }

        FileOutputStream write = new FileOutputStream(path + File.separator + "MINUTA - RES FISCALES-1.docx");
        doc.write(write);
        write.close();
        doc.close();
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
                sb.append(beneficiary.getFullName()).append(identifyingText).append(beneficiary.getId()).append(",");
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
