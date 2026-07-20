package mujahid_2411869;

import java.time.LocalDate;
import java.io.File;

public class ResearchDataset {
    private String datasetID; // {unique}
    private String datasetName;
    private String associatedProjectName;
    private LocalDate uploadDate;
    private int recordCount;

    public boolean validateDatasetNameNotEmpty(String name) {
        // TODO: Implement logic
        return false;
    }

    public boolean validateFileExtensionCsv(String fileName) {
        // TODO: Implement logic
        return false;
    }

    public int parseCsvAndCountRecords(File file) {
        // TODO: Implement logic
        return 0;
    }

    public String saveDatasetMetadata() {
        // TODO: Implement logic
        return "";
    }
}
