package mujahid_2411869;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Meeting {
    private String meetingId; // {unique}
    private String meetingTitle;
    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private ArrayList<String> participants;
    private String agendaPoints;
    private int participantCount;
    private String status;

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