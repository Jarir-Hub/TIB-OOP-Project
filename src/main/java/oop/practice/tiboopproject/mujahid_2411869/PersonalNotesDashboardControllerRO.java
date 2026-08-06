package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonalNotesDashboardControllerRO
{
    @javafx.fxml.FXML
    private TableColumn dateLoggedTC;
    @javafx.fxml.FXML
    private TableColumn subjectTC;
    @javafx.fxml.FXML
    private TableColumn locationTC;
    @javafx.fxml.FXML
    private TableColumn noteIdTC;
    @javafx.fxml.FXML
    private TableColumn snippetTC;
    @javafx.fxml.FXML
    private TableView personalNotesTV;

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
    public void draftNewNoteButtonOA(ActionEvent actionEvent) {
    }
}