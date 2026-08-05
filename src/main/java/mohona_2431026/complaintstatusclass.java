package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class complaintstatusclass {
    private int complaintId;
    private String title;
    private LocalDate date;
    private String status;
    private String details;

    public complaintstatusclass() {
    }

    public complaintstatusclass(int complaintId, LocalDate date, String title, String status, String details) {
        this.complaintId = complaintId;
        this.date = date;
        this.title = title;
        this.status = status;
        this.details = details;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "complaintstatusclass{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
