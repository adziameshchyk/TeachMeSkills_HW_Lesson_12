package com.tms.collections_and_generic.mandatory_task.models;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DocValidator {

    private static final Path REPORT_DIR = Paths.get("reports");
    private static final File VALIDATE_DOCUMENTS = new File(REPORT_DIR.toFile(), "Validate documents.txt");

    private File sourceOfDocNumbers;
    private final Set<String> docNumbers = new HashSet<>();

    private Map<String, String> validationDocuments = new HashMap<>();

    public DocValidator(File sourceOfDocNumbers) {
        setSourceOfDocNumbers(sourceOfDocNumbers);
        createReportDirAndFiles();
    }

    private void setSourceOfDocNumbers(File sourceOfDocNumbers) {
        if (sourceOfDocNumbers.isFile()) {
            this.sourceOfDocNumbers = sourceOfDocNumbers;
        } else {
            throw new IllegalArgumentException("Invalid source of document numbers");
        }
    }

    private void createReportDirAndFiles() {
        try {
            if (!Files.exists(REPORT_DIR)) {
                Files.createDirectories(REPORT_DIR);
            }
            if (!VALIDATE_DOCUMENTS.exists()) {
                VALIDATE_DOCUMENTS.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creating report directory or files", e);
        }
    }

    private void getDocNumbers() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceOfDocNumbers)))) {
            while (bufferedReader.ready()) {
                docNumbers.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate() {
        getDocNumbers();

        for (String docNumber : docNumbers) {
            String validationMessage = getValidationMessage(docNumber);
            this.validationDocuments.put(docNumber, validationMessage);
        }

        saveValidateDocuments();
    }

    private void saveValidateDocuments() {
        try (BufferedWriter report = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(VALIDATE_DOCUMENTS, true)))) {
            for (Map.Entry<String, String> entry : validationDocuments.entrySet()) {
                report.write(entry.getKey() + " - " + entry.getValue());
                report.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getValidationMessage(String docNumber) {
        if (docNumber.length() != 15) {
            return "invalid. The document title must contain 15 characters.";
        }  else if (!docNumber.startsWith("docnum") && !docNumber.startsWith("contract")) {
            return "invalid. The name of the document must begin with \"contract\" or \"docnum\".";
        }

        return "valid.";
    }

}
