package mohona_2431026;

import java.io.Serializable;
import java.time.LocalDate;

public class awarenessmodel implements Serializable {
    private int campaignId;
    private String campaignTitle;
    private String campaignType;
    private LocalDate campaignDate;
    private String venue;
    private String campaignDetails;


    public awarenessmodel() {
    }

    public awarenessmodel(int campaignId, String campaignTitle, String campaignType, LocalDate campaignDate, String venue, String campaignDetails) {
        this.campaignId = campaignId;
        this.campaignTitle = campaignTitle;
        this.campaignType = campaignType;
        this.campaignDate = campaignDate;
        this.venue = venue;
        this.campaignDetails = campaignDetails;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public LocalDate getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(LocalDate campaignDate) {
        this.campaignDate = campaignDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCampaignDetails() {
        return campaignDetails;
    }

    public void setCampaignDetails(String campaignDetails) {
        this.campaignDetails = campaignDetails;
    }

    @Override
    public String toString() {
        return "awarenessmodel{" +
                "campaignId=" + campaignId +
                ", campaignTitle='" + campaignTitle + '\'' +
                ", campaignType='" + campaignType + '\'' +
                ", campaignDate=" + campaignDate +
                ", venue='" + venue + '\'' +
                ", campaignDetails='" + campaignDetails + '\'' +
                '}';
    }

    public String getOrganizer() {
    }
}