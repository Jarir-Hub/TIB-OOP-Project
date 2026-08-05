package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;
public class Complaint implements Serializable {

    private int complaintId;
    private String complaintTitle;
    private String category;
    private LocalDate date;
    private String status;
    private String location;
    private String citizenInfo;
    private String description;


    public Complaint() {
    }

    public Complaint(int complaintId, String complaintTitle, String category, LocalDate date, String status, String location, String citizenInfo, String description) {
        this.complaintId = complaintId;
        this.complaintTitle = complaintTitle;
        this.category = category;
        this.date = date;
        this.status = status;
        this.location = location;
        this.citizenInfo = citizenInfo;
        this.description = description;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCitizenInfo() {
        return citizenInfo;
    }

    public void setCitizenInfo(String citizenInfo) {
        this.citizenInfo = citizenInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", citizenInfo='" + citizenInfo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
