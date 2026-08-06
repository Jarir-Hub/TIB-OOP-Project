package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TimelineManagerDashboardControllerRO
{
    @javafx.fxml.FXML
    private TableColumn associatedProjectTC;
    @javafx.fxml.FXML
    private TableColumn milestoneNameTC;
    @javafx.fxml.FXML
    private TableColumn projectTimelineTC;
    @javafx.fxml.FXML
    private TableColumn milestoneIdTC;
    @javafx.fxml.FXML
    private TableView timelineManagerTV;
    @javafx.fxml.FXML
    private TableColumn targetDeadlineTC;

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
    public void addProjectMilestoneButtonOA(ActionEvent actionEvent) {
    }
}