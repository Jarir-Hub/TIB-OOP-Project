package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class FieldOperationControllerDashboardRO
{
    @javafx.fxml.FXML
    private TableColumn associatedProjectTC;
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private TableView fieldOperationTV;
    @javafx.fxml.FXML
    private TableColumn locationTC;
    @javafx.fxml.FXML
    private TableColumn incidentTypeTC;
    @javafx.fxml.FXML
    private DatePicker observationDateDP;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableColumn notesTC;
    @javafx.fxml.FXML
    private TableColumn observationIdTC;
    @javafx.fxml.FXML
    private TextField fieldNotesTF;
    @javafx.fxml.FXML
    private ComboBox incidentTypeCMB;
    @javafx.fxml.FXML
    private ComboBox selectProjectCMB;

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
    public void saveEntryButtonOA(ActionEvent actionEvent) {
    }
}