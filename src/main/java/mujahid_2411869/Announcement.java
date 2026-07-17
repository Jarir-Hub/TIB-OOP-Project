package mujahid_2411869;
import java.time.LocalDate;

public class Announcement {
        private String announcementId; // {unique}
        private String announcementTitle;
        private String targetAudience;
        private String messageBody;
        private LocalDate announcementDate;
        private String authorName;

        public boolean createAnnouncement(String title, String audience, String body) {
            // TODO: Implement logic
            return false;
        }

        public boolean saveToDatabase() {
            // TODO: Implement logic
            return false;
        }

        public boolean checkTitleNotEmpty(String title) {
            // TODO: Implement logic
            return false;
        }

        public boolean verifyBodyLengthGreaterThanTen(String bodyText) {
            // TODO: Implement logic
            return false;
        }
}
