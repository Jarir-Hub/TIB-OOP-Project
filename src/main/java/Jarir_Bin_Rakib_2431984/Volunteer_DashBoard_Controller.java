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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("volunteer_update_profile.fxml"));
            dasboardBorderPane.setCenter(fxmlLoader.load());
            Volunteer_Update_Profile_Controller nextController=fxmlLoader.getController();
            nextController.receiveVolunteerId(volunteerLoggedID);
        }
        catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void joinRequestForCampaignButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("volunteer_joinRequest_campaign.fxml"));
            dasboardBorderPane.setCenter(fxmlLoader.load());
            Volunteer_JoinRequest_Campaign_Controller nextController=fxmlLoader.getController();
            nextController.receiveVolunteerIdFromDashboardController(volunteerLoggedID);
        }
        catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void submitCampaignFeedbackButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewAssignedCampaignActivitiesButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("volunteer_ViewAssigned_activities.fxml"));
            dasboardBorderPane.setCenter(fxmlLoader.load());
            Volunteer_ViewAssigned_Activities_Controller nextController=fxmlLoader.getController();
            nextController.receiveVolunteerId(volunteerLoggedID);
        }
        catch (Exception e){
            //
        }

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