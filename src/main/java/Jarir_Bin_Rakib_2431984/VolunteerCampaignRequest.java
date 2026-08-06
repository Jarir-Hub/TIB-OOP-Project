package Jarir_Bin_Rakib_2431984;

import java.io.Serializable;
import java.time.LocalDate;

public class VolunteerCampaignRequest implements Serializable {
    private int volunteerId;
    private String volunteerName;
    private String campaignTitle;
    private String requestMessage;
    private String status;
    private LocalDate requestDate;

    public VolunteerCampaignRequest() {
    }

    public VolunteerCampaignRequest(int volunteerId, String volunteerName, String campaignTitle, String requestMessage, String status, LocalDate requestDate) {
        this.volunteerId = volunteerId;
        this.volunteerName = volunteerName;
        this.campaignTitle = campaignTitle;
        this.requestMessage = requestMessage;
        this.status = status;
        this.requestDate = requestDate;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "VolunteerCampaignRequest{" +
                "volunteerId=" + volunteerId +
                ", volunteerName='" + volunteerName + '\'' +
                ", campaignTitle='" + campaignTitle + '\'' +
                ", requestMessage='" + requestMessage + '\'' +
                ", status='" + status + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }


}
