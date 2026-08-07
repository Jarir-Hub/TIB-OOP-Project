package Jarir_Bin_Rakib_2431984;

import java.io.Serializable;
import java.time.LocalDate;

public class Feedback implements Serializable {
    private int volunteerId;
    private String volunteerName;
    private String campaignTitle;
    private LocalDate campaignDate;
    private String feedbackSummary;

    public Feedback() {
    }

    public Feedback(int volunteerId, String volunteerName, String campaignTitle, LocalDate campaignDate, String feedbackSummary) {
        this.volunteerId = volunteerId;
        this.volunteerName = volunteerName;
        this.campaignTitle = campaignTitle;
        this.campaignDate = campaignDate;
        this.feedbackSummary = feedbackSummary;
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

    public LocalDate getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(LocalDate campaignDate) {
        this.campaignDate = campaignDate;
    }

    public String getFeedbackSummary() {
        return feedbackSummary;
    }

    public void setFeedbackSummary(String feedbackSummary) {
        this.feedbackSummary = feedbackSummary;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "volunteerId=" + volunteerId +
                ", volunteerName='" + volunteerName + '\'' +
                ", campaignTitle='" + campaignTitle + '\'' +
                ", campaignDate=" + campaignDate +
                ", feedbackSummary='" + feedbackSummary + '\'' +
                '}';
    }
}
