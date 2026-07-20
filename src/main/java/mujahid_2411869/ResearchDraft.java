package mujahid_2411869;

import java.time.LocalDate;

public class ResearchDraft {
    private String draftID; // {unique}
    private String parentProjectTitle;
    private String draftTitle;
    private String summaryAbstract;
    private String attachmentLink;
    private LocalDate submissionDate;
    private String status;

    public boolean validateTitleNotEmpty(String title) {
        // TODO: Implement logic
        return false;
    }

    public boolean validateAbstractLengthGreaterThanFifty(String summary) {
        // TODO: Implement logic
        return false;
    }

    public String saveDraftSubmission() {
        // TODO: Implement logic
        return "";
    }
}
