package mohona_2431026;

import java.io.Serializable;

public class rejectivalidclass  implements Serializable{
    private String complaintId;
    private String complaintTitle;
    private String citizenInformation;
    private String location;
    private String description;
    private String currentStatus;

    public rejectivalidclass() {
    }

    public rejectivalidclass(String complaintId, String complaintTitle, String citizenInformation, String location, String description, String currentStatus) {
        this.complaintId = complaintId;
        this.complaintTitle = complaintTitle;
        this.citizenInformation = citizenInformation;
        this.location = location;
        this.description = description;
        this.currentStatus = currentStatus;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public String getCitizenInformation() {
        return citizenInformation;
    }

    public void setCitizenInformation(String citizenInformation) {
        this.citizenInformation = citizenInformation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "rejectivalidclass{" +
                "complaintId='" + complaintId + '\'' +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", citizenInformation='" + citizenInformation + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }

}
