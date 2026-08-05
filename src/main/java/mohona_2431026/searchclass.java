package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class searchclass implements Serializable {
    private int complaintId;
    private String title;
    private String category;
    private LocalDate date;
    private String status;
    private String citizen;
    private String location;
    private String description;

    public searchclass() {
    }

    public searchclass(int complaintId, String title, String category, LocalDate date, String status, String citizen, String location, String description) {
        this.complaintId = complaintId;
        this.title = title;
        this.category = category;
        this.date = date;
        this.status = status;
        this.citizen = citizen;
        this.location = location;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "searchclass{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", citizen='" + citizen + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
