package mujahid_2411869;

import java.time.LocalDate;

public class MoU {
    private String mouId; // {unique}
    private String partnerOrganizationName;
    private String mouSubjectDomain;
    private int durationInYears;
    private LocalDate expiryDate;
    private String status;

    public boolean registerAgreement(String partner, String domain, int duration, LocalDate expiry) {
        // TODO: Implement logic
        return false;
    }

    public boolean commitToDB() {
        // TODO: Implement logic
        return false;
    }

    public boolean checkForNonEmptyFields(String partner, String domain) {
        // TODO: Implement logic
        return false;
    }

    public boolean enforceNumericDuration(int duration) {
        // TODO: Implement logic
        return false;
    }
}
