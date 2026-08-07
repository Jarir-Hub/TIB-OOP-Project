package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mujahid_2411869.ExecutiveDirector;
import oop.practice.tiboopproject.HelloApplication;

public class MeetingDashboardControllerED
{
    @javafx.fxml.FXML
    private TableView meetingTV;
    @javafx.fxml.FXML
    private TableColumn scheduledDateTC;
    @javafx.fxml.FXML
    private TableColumn authorNameTC;
    @javafx.fxml.FXML
    private TableColumn meetingIdTC;
    @javafx.fxml.FXML
    private TableColumn participantCountTC;
    @javafx.fxml.FXML
    private TableColumn scheduledTimeTC;
    @javafx.fxml.FXML
    private TableColumn meetingTimeTC;
    @javafx.fxml.FXML
    private AnchorPane meetingDashboardAP;
    @javafx.fxml.FXML
    private TableColumn announcementDateTC21;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void executiveDirectoryButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.executiveDirectoryDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("Executive Directory Dashboard");
            newStage.setScene(scene);
            ExecutiveDirectoryDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ExecutiveDirector) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void scheduleNewMeetingButtonOA(ActionEvent actionEvent) {
    }
}