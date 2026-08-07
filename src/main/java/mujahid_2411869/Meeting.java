package mujahid_2411869;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Meeting implements Serializable {
    private final long meetingId;
    private String meetingTitle;
    private final LocalDate scheduledDate;
    private  LocalTime scheduledTime;
    private String agendaPoints;
    private int participantCount;
    private String status;

    public Meeting(String meetingTitle, LocalDate scheduledDate, LocalTime scheduledTime, String agendaPoints, Integer participantCount, String status) {
        this.meetingId = System.currentTimeMillis();
        this.meetingTitle = meetingTitle;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
        this.agendaPoints = agendaPoints;
        this.participantCount = participantCount;
        this.status = status;
    }

    public Meeting(String meetingTitle, LocalDate scheduledDate, String agendaPoints, int participantCount) {
        this.meetingId = System.currentTimeMillis();
        this.meetingTitle = meetingTitle;
        this.scheduledDate = scheduledDate;
        this.agendaPoints = agendaPoints;
        this.participantCount = participantCount;
    }

    public long getMeetingId() {
        return meetingId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }


    public String getAgendaPoints() {
        return agendaPoints;
    }

    public void setAgendaPoints(String agendaPoints) {
        this.agendaPoints = agendaPoints;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean initializeMeeting(String title, LocalDate date, LocalTime time, ArrayList<String> participants, String agenda) {
        // TODO: Implement logic
        return false;
    }

    public boolean saveMeetingToDB() {
        // TODO: Implement logic
        return false;
    }

    public boolean checkTitleNotEmpty(String title) {
        // TODO: Implement logic
        return false;
    }

    public boolean validateDateGreaterThanCurrent(LocalDate date) {
        // TODO: Implement logic
        return false;
    }
}