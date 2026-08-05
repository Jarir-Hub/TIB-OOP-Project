package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class generatecomplainreportclass implements Serializable {
    private int complaintId;
    private String citizenName;
    private String complaintTitle;
    private String status;
    private LocalDate complaintDate;
    private String reportType;

    public generatecomplainreportclass() {
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

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    @Override
    public String toString() {
        return "generatecomplainreportclass{" +
                "complaintId=" + complaintId +
                ", citizenName='" + citizenName + '\'' +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", status='" + status + '\'' +
                ", complaintDate=" + complaintDate +
                ", reportType='" + reportType + '\'' +
                '}';
    }
}
