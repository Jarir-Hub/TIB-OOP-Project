package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import oop.practice.tiboopproject.HelloApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Volunteer_DashBoard_Controller
{
    @javafx.fxml.FXML
    private BorderPane dasboardBorderPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateVolunteerProfileButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void joinRequestForCampaignButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitCampaignFeedbackButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewAssignedCampaignActivitiesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewAwairnessCampaignButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markCampaignAttendanceButton(ActionEvent actionEvent) {
    }
    private int volunteerLoggedID;

    public void receiveObjectFromLoginController(int id){
        this.volunteerLoggedID=id;
    }


    @javafx.fxml.FXML
    public void viewVolunteerProfileButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view_volunteer_profile.fxml"));
            dasboardBorderPane.setCenter(fxmlLoader.load());
            View_Volunteer_Profile_Controller nextController=fxmlLoader.getController();
            nextController.receiveLoggedIdFromVolunteerDashBoard(volunteerLoggedID);
        }
        catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void signOutButton(ActionEvent actionEvent) {
    }
}