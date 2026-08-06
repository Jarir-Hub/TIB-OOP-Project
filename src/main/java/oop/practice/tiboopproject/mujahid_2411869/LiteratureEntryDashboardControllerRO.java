package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LiteratureEntryDashboardControllerRO
{
    @javafx.fxml.FXML
    private TableView literatureEntryTV;
    @javafx.fxml.FXML
    private TableColumn leadAuthorTC;
    @javafx.fxml.FXML
    private TableColumn articleTitleTC;
    @javafx.fxml.FXML
    private TableColumn dateAddedTC;
    @javafx.fxml.FXML
    private TableColumn entryID;

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
    public void addNewLiteratureButtonOA(ActionEvent actionEvent) {
    }
}