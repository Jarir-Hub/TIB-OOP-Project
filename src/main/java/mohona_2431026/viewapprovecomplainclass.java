package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class viewapprovecomplainclass implements Serializable {
    private int complaintId;
    private String title;
    private String category;
    private LocalDate date;
    private String status;

    public viewapprovecomplainclass() {
    }

    public viewapprovecomplainclass(int complaintId, String title, String category, LocalDate date, String status) {
        this.complaintId = complaintId;
        this.title = title;
        this.category = category;
        this.date = date;
        this.status = status;
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

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
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

    @Override
    public String toString() {
        return "viewapprovecomplainclass{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
