package Jarir_Bin_Rakib_2431984;

import java.io.Serializable;
import java.time.LocalDate;

public class Attendance implements Serializable {
    private int volunteerID;
    private  String campaignTitle;
    private LocalDate campaignDate;
    private String location;
    private String attendanceStatus;
    //private int total_Attendance;

    public Attendance() {
    }

    public Attendance(int volunteerID, String campaignTitle, LocalDate campaignDate, String location, String attendanceStatus) {
        this.volunteerID = volunteerID;
        this.campaignTitle = campaignTitle;
        this.campaignDate = campaignDate;
        this.location = location;
        this.attendanceStatus = attendanceStatus;
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

    public LocalDate getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(LocalDate campaignDate) {
        this.campaignDate = campaignDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "campaignTitle='" + campaignTitle + '\'' +
                ", campaignDate=" + campaignDate +
                ", location='" + location + '\'' +
                ", attendanceStatus='" + attendanceStatus + '\'' +
                '}';
    }
}
