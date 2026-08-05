package Jarir_Bin_Rakib_2431984;

import java.io.Serializable;
import java.time.LocalDate;

public class Campaign implements Serializable {
    private String campaignTitle;
    private String description;
    private String location;
    private LocalDate campaignDate;
    private int participantLimit;
    private int availableSlots;


    public Campaign() {
    }

    public Campaign(String campaignTitle, String description, String location, LocalDate campaignDate, int participantLimit) {
        this.campaignTitle = campaignTitle;
        this.description = description;
        this.location = location;
        this.campaignDate = campaignDate;
        this.participantLimit = participantLimit;
        this.availableSlots = participantLimit;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(LocalDate campaignDate) {
        this.campaignDate = campaignDate;
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "campaignTitle='" + campaignTitle + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", campaignDate=" + campaignDate +
                ", participantLimit=" + participantLimit +
                ", availableSlots=" + availableSlots +
                '}';
    }

}
