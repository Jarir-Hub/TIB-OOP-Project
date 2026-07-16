package mujahid_2411869;

import java.time.LocalDate;

public class ExecutiveDirector {
    private final String role = "Executive Director";
    private LocalDate appointmentDate;
    private String digitalSignature;

    public ExecutiveDirector(LocalDate appointmentDate, String digitalSignature) {
        this.appointmentDate = appointmentDate;
        this.digitalSignature = digitalSignature;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }


    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    /*
    public boolean sendAnnouncement(Announcement announcementData){
    }

    public boolean scheduleNewMeeting(Meeting meetingData){
    }

    public boolean publishPolicy(Policy policyData){
    }

    public boolean executeAgreement(MoU mouData){
    }

    public boolean broadcastStatement(PressStatement statementData){
    }

    public boolean lockAndFinalizeRoadmap(StrategicRoadmap roadmapData){
    }

    public boolean postReviewEvaluation(DraftEvaluation evalData){
    }

    public boolean saveTask(ExecutiveTask taskData){
    }
     */
}
