package Jarir_Bin_Rakib_2431984;


import java.io.Serializable;
import java.time.LocalDate;

public class AssignedActivities implements Serializable {
    private int volunteerID;
    private String campaignTitle;
    private String activity;
    private String location;
    private LocalDate dateOfCampaign;
    private String status;

    public AssignedActivities() {
    }

    public AssignedActivities(int volunteerID, String campaignTitle, String activity, String location, LocalDate dateOfCampaign, String status) {
        this.volunteerID = volunteerID;
        this.campaignTitle = campaignTitle;
        this.activity = activity;
        this.location = location;
        this.dateOfCampaign = dateOfCampaign;
        this.status = status;
    }

    public int getVolunteerID() {
        return volunteerID;
    }

    public void setVolunteerID(int volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateOfCampaign() {
        return dateOfCampaign;
    }

    public void setDateOfCampaign(LocalDate dateOfCampaign) {
        this.dateOfCampaign = dateOfCampaign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "AssignedActivities{" +
                "campaignTitle='" + campaignTitle + '\'' +
                ", activity='" + activity + '\'' +
                ", location='" + location + '\'' +
                ", dateOfCampaign=" + dateOfCampaign +
                ", status='" + status + '\'' +
                '}';
    }
}
