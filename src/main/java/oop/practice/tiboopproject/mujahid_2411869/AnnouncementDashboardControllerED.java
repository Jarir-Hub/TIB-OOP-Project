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
import mujahid_2411869.ResearchOfficer;
import oop.practice.tiboopproject.HelloApplication;
import oop.practice.tiboopproject.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class AnnouncementDashboardControllerED
{
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> targetAudienceTC;
    @javafx.fxml.FXML
    private TableView<Announcement> executiveAnnouncementTV;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> authorNameTC;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> announcementIdTC;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> announcementTitleTC;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> announcementDateTC;

    @javafx.fxml.FXML
    public void initialize() {
        targetAudienceTC.setCellValueFactory(new PropertyValueFactory<>("targetAudience"));
        authorNameTC.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        announcementIdTC.setCellValueFactory(new PropertyValueFactory<>("announcementId"));
        announcementTitleTC.setCellValueFactory(new PropertyValueFactory<>("announcementTitle"));
        announcementDateTC.setCellValueFactory(new PropertyValueFactory<>("announcementDate"));
    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
        loadTable();
    }

    public void loadTable(){
        ArrayList<Announcement> dataToLoad= loggedInUser.readAnnouncementObject();

        for (Announcement a: dataToLoad){
            executiveAnnouncementTV.getItems().add(a);
        }
    }

    @javafx.fxml.FXML
    public void executiveDirectoryButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.ExecutiveDirectoryDashboardControllerED"));
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
    public void newAnnouncementButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.AnnouncementCreationControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("New Announcement");
            newStage.setScene(scene);
            AnnouncementCreationControllerED nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ExecutiveDirector) loggedInUser);
            newStage.show();
        } catch (Exception e) {
            //
        }
    }
}