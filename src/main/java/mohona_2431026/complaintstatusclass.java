package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;


public class complaintstatusclass implements Serializable {
    private int complaintId;
    private String title;
    private String description;
    private String location;
    private String citizenName;
    private LocalDate submissionDate;
    private String status;

    public complaintstatusclass() {
    }

    public complaintstatusclass(int complaintId, String title, String description, String location, String citizenName, LocalDate submissionDate, String status) {
        this.complaintId = complaintId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.citizenName = citizenName;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "complaintstatusclass{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", citizenName='" + citizenName + '\'' +
                ", submissionDate=" + submissionDate +
                ", status='" + status + '\'' +
                '}';
    }
}