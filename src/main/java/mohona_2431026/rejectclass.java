package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class rejectclass {
    private int complaintId;
    private String title;
    private String category;
    private LocalDate date;
    private String status;
    private String reason;

    public rejectclass() {
    }

    public rejectclass(int complaintId, String title, LocalDate date, String category, String status, String reason) {
        this.complaintId = complaintId;
        this.title = title;
        this.date = date;
        this.category = category;
        this.status = status;
        this.reason = reason;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "rejectclass{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
