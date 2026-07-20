package mujahid_2411869;

import java.time.LocalDate;

public class FieldNote {
    private String noteID; // {unique}
    private String noteSubjectTag;
    private String locationRegion;
    private String detailedObservations;
    private LocalDate dateLogged;
    private String snippet;

    public boolean validateFieldsContainData(String subject, String observations) {
        // TODO: Implement logic
        return false;
    }

    public String commitLocalNotesToTable() {
        // TODO: Implement logic
        return "";
    }
}
