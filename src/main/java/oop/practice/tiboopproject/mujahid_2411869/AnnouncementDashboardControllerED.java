package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import mujahid_2411869.Announcement;

import java.time.LocalDate;

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
    }

    private int directorId;
    public void receiveObjectFromExecutiveDirectoryDashboardControllerED(int id){this.directorId=id;}

    @javafx.fxml.FXML
    public void executiveDirectoryButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void newAnnouncementButtonOA(ActionEvent actionEvent) {
    }
}