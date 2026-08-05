package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class submissionmodel implements Serializable{

    private static final long serialVersionUID = 1L;

    private int complaintId;
    private String title;
    private String category;
    private String description;
    private String location;
    private LocalDate submissionDate;
    private String attachment;
    private String status;

    public submissionmodel() {
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getStatus() {
        return status;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "submissionmodel{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", submissionDate=" + submissionDate +
                ", attachment='" + attachment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
