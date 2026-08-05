package mohona_2431026;
import java.io.Serializable;
public class submitfeedbackclass implements Serializable{

    private int complaintId;
    private String complaintTitle;
    private String feedback;
    private int rating;



    public submitfeedbackclass() {
    }

    public submitfeedbackclass(int complaintId, String complaintTitle, String feedback, int rating) {
        this.complaintId = complaintId;
        this.complaintTitle = complaintTitle;
        this.feedback = feedback;
        this.rating = rating;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "submitfeedbackclass{" +
                "complaintId=" + complaintId +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}
