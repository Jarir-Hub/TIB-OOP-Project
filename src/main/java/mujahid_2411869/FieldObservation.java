package mujahid_2411869;

import java.time.LocalDate;

public class FieldObservation {
    private String observationID; // {unique}
    private String associatedProject;
    private String incidentType;
    private LocalDate observationDate;
    private String location;
    private String fieldNotes;
    private String notesSnippet;

    public boolean validateLocationNotEmpty(String loc) {
        // TODO: Implement logic
        return false;
    }

    public boolean validateFieldNotesLengthGreaterThan10(String notes) {
        // TODO: Implement logic
        return false;
    }

    public String commitObservationRecord() {
        // TODO: Implement logic
        return "";
    }
}
