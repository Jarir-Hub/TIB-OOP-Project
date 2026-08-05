package mohona_2431026;

import java.io.Serializable;

public class complaintcontroll implements Serializable {
    private String complaintTitle;
    private String location;
    private String citizenInfo;
    private String description;


    public complaintcontroll() {
    }

    public complaintcontroll(String complaintTitle, String location, String description, String citizenInfo) {
        this.complaintTitle = complaintTitle;
        this.location = location;
        this.description = description;
        this.citizenInfo = citizenInfo;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
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

    public String getCitizenInfo() {
        return citizenInfo;
    }

    public void setCitizenInfo(String citizenInfo) {
        this.citizenInfo = citizenInfo;
    }

    @Override
    public String toString() {
        return "complaintcontroll{" +
                "complaintTitle='" + complaintTitle + '\'' +
                ", location='" + location + '\'' +
                ", citizenInfo='" + citizenInfo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
