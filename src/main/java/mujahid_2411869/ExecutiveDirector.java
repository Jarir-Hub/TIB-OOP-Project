package mujahid_2411869;
import oop.practice.tiboopproject.User;
import java.io.Serializable;
import java.time.LocalDate;

public class ExecutiveDirector extends User implements Serializable {
    private  String name,email;
    private  LocalDate appointmentDate;

    public ExecutiveDirector(int userID, String password, String userType, String name, String email, LocalDate appointmentDate) {
        super(userID, password, userType="Executive Director");
        this.name = name;
        this.email = email;
        this.appointmentDate = appointmentDate;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAppointmentDate() {return appointmentDate;}

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "ExecutiveDirector{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", userID=" + userID +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
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
