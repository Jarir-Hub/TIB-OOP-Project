package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    private int complaintId;
    private String title;
    private String category;
    private String description;
    private String citizenInfo;
    private String location;
    private LocalDate submissionDate;
    private String attachment;
    private String status;


    public Complaint() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getCitizenInfo() {
        return citizenInfo;
    }

    public void setCitizenInfo(String citizenInfo) {
        this.citizenInfo = citizenInfo;
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
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", citizenInfo='" + citizenInfo + '\'' +
                ", location='" + location + '\'' +
                ", submissionDate=" + submissionDate +
                ", attachment='" + attachment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
