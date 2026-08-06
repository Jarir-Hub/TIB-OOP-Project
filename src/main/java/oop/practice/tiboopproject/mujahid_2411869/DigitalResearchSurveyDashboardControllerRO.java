package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DigitalResearchSurveyDashboardControllerRO
{
    @javafx.fxml.FXML
    private TableView digitalSurveyTV;
    @javafx.fxml.FXML
    private TableColumn targetDemographicTC;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn expiaryDateTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TableColumn surveyIdTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private int researchOfficerId;
    public void receiveObjectFromResearchOperationsHubControllerRO(int id){
        this.researchOfficerId=id;
    }

    @javafx.fxml.FXML
    public void researchOperationsHubButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void craeateNewSurveyButtonOA(ActionEvent actionEvent) {
    }
}