package com.example.hospitalManagemente.utility;

import com.example.hospitalManagemente.model.PatientList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class PdfGenerator {

    public static void generatePdf(List<PatientList> patients, String name, String filePath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(20, 700);
                contentStream.showText("Patient List for Doctor: " + name);
                contentStream.newLineAtOffset(0, -20);

                for (PatientList patient : patients) {
                    contentStream.showText("Patient ID: " + patient.getId() + ", Name: " + patient.getName());
                    contentStream.newLineAtOffset(0, -15);
                }

                contentStream.endText();
            }

            document.save(filePath);
        }
    }
}
