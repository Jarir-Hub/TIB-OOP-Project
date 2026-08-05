package mohona_2431026;
import java.io.Serializable;

public class updatecomplaintclass implements Serializable {
    private int complaintId;
    private String citizen;
    private String title;
    private String status;


    public updatecomplaintclass() {
    }

    public updatecomplaintclass(int complaintId, String citizen, String title, String status) {
        this.complaintId = complaintId;
        this.citizen = citizen;
        this.title = title;
        this.status = status;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "updatecomplaintclass{" +
                "complaintId=" + complaintId +
                ", citizen='" + citizen + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

