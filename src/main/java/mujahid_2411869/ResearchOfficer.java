package mujahid_2411869;

public class ResearchOfficer {
    private final String role = "Research Officer";
    private String researchDomain;
    private int publicationCount;

    public ResearchOfficer(String researchDomain, int publicationCount) {
        this.researchDomain = researchDomain;
        this.publicationCount = publicationCount;
    }

    public String getRole() {
        return role;
    }

    public String getResearchDomain() {
        return researchDomain;
    }

    public int getPublicationCount() {
        return publicationCount;
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

