package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mujahid_2411869.ExecutiveDirector;
import mujahid_2411869.Meeting;
import oop.practice.tiboopproject.HelloApplication;

import java.time.LocalDate;

public class ScheduleNewMeetingControllerED
{
    @javafx.fxml.FXML
    private DatePicker meetingDateDP;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextField meetingTitleTF;
    @javafx.fxml.FXML
    private TextField agendaPointsTF;

    Alert alert= new Alert(Alert.AlertType.INFORMATION);
    @javafx.fxml.FXML
    private TextField participantsCountTF;

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
    public void saveMeetingButtonOA(ActionEvent actionEvent) {
        if (meetingTitleTF.getText().isBlank()){
            alert.setContentText("Meeting Title is Empty");
            alert.showAndWait();
            return;
        }
        if ((meetingDateDP.getValue()).isBefore(LocalDate.now())){
            alert.setContentText("Schedule Date Can't be Past Date");
            alert.showAndWait();
            return;
        }

        loggedInUser.createNewMeeting(meetingTitleTF.getText(),
                meetingDateDP.getValue(),agendaPointsTF.getText(),
                Integer.parseInt(participantsCountTF.getText()));





    }
}