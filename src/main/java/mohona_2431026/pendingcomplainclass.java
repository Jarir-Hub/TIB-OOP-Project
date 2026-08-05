package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class pendingcomplainclass implements Serializable{
    private String complaintId;
    private String citizenName;
    private String complaintTitle;
    private LocalDate submissionDate;

    public pendingcomplainclass() {
    }

    public pendingcomplainclass(String complaintId, String citizenName, String complaintTitle, LocalDate submissionDate) {
        this.complaintId = complaintId;
        this.citizenName = citizenName;
        this.complaintTitle = complaintTitle;
        this.submissionDate = submissionDate;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "pendingcomplainclass{" +
                "complaintId='" + complaintId + '\'' +
                ", citizenName='" + citizenName + '\'' +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
