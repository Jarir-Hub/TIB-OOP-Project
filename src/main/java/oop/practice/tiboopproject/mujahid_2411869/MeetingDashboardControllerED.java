package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mujahid_2411869.Announcement;
import mujahid_2411869.ExecutiveDirector;
import mujahid_2411869.Meeting;
import oop.practice.tiboopproject.HelloApplication;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class MeetingDashboardControllerED
{
    @javafx.fxml.FXML
    private TableView<Meeting> meetingTV;
    @javafx.fxml.FXML
    private TableColumn<Meeting, LocalDate> scheduledDateTC;
    @javafx.fxml.FXML
    private TableColumn<Meeting,String> authorNameTC;
    @javafx.fxml.FXML
    private TableColumn<Meeting,Integer> meetingIdTC;
    @javafx.fxml.FXML
    private TableColumn<Meeting,Integer> participantCountTC;
    @javafx.fxml.FXML
    private TableColumn<Meeting,String> agendaPointsTc;
    @javafx.fxml.FXML
    private TableColumn<Meeting,String> meetingTitleTC;

    @javafx.fxml.FXML
    public void initialize() {
        meetingIdTC.setCellValueFactory(new PropertyValueFactory<>("meetingId"));
        meetingTitleTC.setCellValueFactory(new PropertyValueFactory<>("meetingTitle"));
        agendaPointsTc.setCellValueFactory(new PropertyValueFactory<>("agendaPoints"));
        participantCountTC.setCellValueFactory(new PropertyValueFactory<>("participantCount"));
        scheduledDateTC.setCellValueFactory(new PropertyValueFactory<>("scheduledDate"));
    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
        loadTable();
    }

    public void loadTable(){
        ArrayList<Meeting> dataToLoad= loggedInUser.readMeetingObject();

        for (Meeting a: dataToLoad){
            meetingTV.getItems().add(a);
        }
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
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.ScheduleNewMeetingControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("New Meeting");
            newStage.setScene(scene);
            ScheduleNewMeetingControllerED nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ExecutiveDirector) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }

    }
}