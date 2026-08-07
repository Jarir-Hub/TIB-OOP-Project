package mujahid_2411869;
import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    final private long announcementId;
    final private LocalDate announcementDate;
    final private String authorName;
    private String announcementTitle;
    private String targetAudience;
    private String messageBody;

    public Announcement( LocalDate announcementDate, String authorName, String announcementTitle, String targetAudience, String messageBody) {
        this.announcementId = System.currentTimeMillis();
        this.announcementDate = announcementDate;
        this.authorName = authorName;
        this.announcementTitle = announcementTitle;
        this.targetAudience = targetAudience;
        this.messageBody = messageBody;
    }

    public long getAnnouncementId() {
        return announcementId;
    }

    public LocalDate getAnnouncementDate() {
        return announcementDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }


}
