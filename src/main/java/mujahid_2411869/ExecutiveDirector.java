package mujahid_2411869;
import Jarir_Bin_Rakib_2431984.AppendableObjectOutputStream;
import oop.practice.tiboopproject.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public Announcement createAnnouncement(String authorName, String title, String targetAudience, String messageBody ){
        Announcement newAnnouncement= new Announcement(
                LocalDate.now(),
                authorName,
                title,
                targetAudience,
                messageBody
        );
        sendAnnouncement(newAnnouncement);
        return newAnnouncement;
    }


    public boolean sendAnnouncement(Announcement announcementData){
        File file= new File("Announcement.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try{
            if (file.exists()){
                fos= new FileOutputStream(file,true);
                oos= new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }

            oos.writeObject(announcementData);
            oos.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    public ArrayList<Announcement> readAnnouncementObject(){
        ArrayList<Announcement> announcementList = new ArrayList<>();
        File file= new File("Announcement.bin");

        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Announcement a= (Announcement) ois.readObject();
                    announcementList.add(a);

                }
                catch (Exception e) {
                    e.printStackTrace();
                    ois.close();
                    break;
                }
            }
        }
        catch (Exception e) {
            //
        }
        return announcementList;
    }




    public Meeting createNewMeeting(String meetingTitle, LocalDate scheduledDate, String agendaPoints, int participantCount){
        Meeting newMeeting = new Meeting(
                meetingTitle, scheduledDate,agendaPoints,participantCount);
        scheduleNewMeeting(newMeeting);
        return newMeeting;
    }

    public boolean scheduleNewMeeting(Meeting meetingData){
        File file= new File("MeetingData.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try{
            if (file.exists()){
                fos= new FileOutputStream(file,true);
                oos= new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }

            oos.writeObject(meetingData);
            oos.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<Meeting> readMeetingObject(){
        ArrayList<Meeting> meetingList = new ArrayList<>();
        File file= new File("MeetingData.bin");

        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Meeting a= (Meeting) ois.readObject();
                    meetingList.add(a);

                }
                catch (Exception e) {
                    e.printStackTrace();
                    ois.close();
                    break;
                }
            }
        }
        catch (Exception e) {
            //
        }
        return meetingList;
    }



    public Policy createPolicy(String policyName, String category, String policyText, LocalDate effectiveDate){
        Policy newPolicy= new Policy(policyName,category,policyText,effectiveDate);
        publishPolicy(newPolicy);
        return newPolicy;
    }

    public boolean publishPolicy(Policy policyData){
        File file= new File("PolicyData.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try{
            if (file.exists()){
                fos= new FileOutputStream(file,true);
                oos= new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }

            oos.writeObject(policyData);
            oos.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<Policy> readPolicyObject(){
        ArrayList<Policy> policyList = new ArrayList<>();
        File file= new File("PolicyData.bin");

        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                try{
                    Policy a= (Policy) ois.readObject();
                    policyList.add(a);

                }
                catch (Exception e) {
                    e.printStackTrace();
                    ois.close();
                    break;
                }
            }
        }
        catch (Exception e) {
            //
        }
        return policyList;
    }
    /*
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
