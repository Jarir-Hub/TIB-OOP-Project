package mujahid_2411869;

import oop.practice.tiboopproject.User;

import java.io.Serializable;

public class ResearchOfficer extends User implements Serializable {
    private String researchDomain;
    private int publicationCount;

    public ResearchOfficer(int userID, String password, String userType, String researchDomain, int publicationCount) {
        super(userID, password, userType="Research Officer");
        this.researchDomain = researchDomain;
        this.publicationCount = publicationCount;
    }

    public String getResearchDomain() {return researchDomain;}

    public void setResearchDomain(String researchDomain) {
        this.researchDomain = researchDomain;
    }

    public int getPublicationCount() {return publicationCount;}

    public void setPublicationCount(int publicationCount) {
        this.publicationCount = publicationCount;
    }

    @Override
    public String toString() {
        return "ResearchOfficer{" +
                "researchDomain='" + researchDomain + '\'' +
                ", publicationCount=" + publicationCount +
                ", userID=" + userID +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    /*
    public String  createProject(String title,String sector, LocalDate startDate, double budget, String lead){
    }

    public String submitForApproval(String projectID,String title, String summary, String link) {
    }

    public ArrayList<ResearchPublicationRepository> searchRepository(String keyword,String sector){
    }

    public String uploadFile(String projectID, String name, File file){
    }

    public String saveObservation(String projectID,String type, LocalDate date,String location,String notes){
    }

    public String saveSurveyDesign(String title, String demographic, String content, LocalDate expiry){
    }

    public String saveMilestone(String projectID,String name,String desc, LocalDate deadline ){
    }

    public String archiveNote(String subject,String location, String observations){
    }
     */

}

