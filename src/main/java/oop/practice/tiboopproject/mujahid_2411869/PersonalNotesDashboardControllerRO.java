package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import mujahid_2411869.ResearchOfficer;
import oop.practice.tiboopproject.HelloApplication;

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

    private ResearchOfficer loggedInUser;
    public void receivedUserObject(ResearchOfficer user) {
        loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void researchOperationsHubButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.ResearchOperationsHubControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("Research Operations Hub Dashboard");
            newStage.setScene(scene);
            ResearchOperationsHubControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void draftNewNoteButtonOA(ActionEvent actionEvent) {
    }
}