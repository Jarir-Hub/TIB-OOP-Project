package mujahid_2411869;

import java.time.LocalDate;

public class SurveyQuestionnaire {
    private String surveyID; // {unique}
    private String surveyTitle;
    private String targetDemographic;
    private String questionnaireContent;
    private LocalDate surveyExpiryDate;
    private String status;

    public boolean ensureMinimumCharacterLengths(String content) {
        // TODO: Implement logic
        return false;
    }

    public boolean ensureNonEmptyTitles(String title) {
        // TODO: Implement logic
        return false;
    }

    public String commitSurveyToTable() {
        // TODO: Implement logic
        return "";
    }
}
