package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mujahid_2411869.Announcement;
import mujahid_2411869.ExecutiveDirector;
import oop.practice.tiboopproject.HelloApplication;

import java.time.LocalDate;

public class AnnouncementCreationControllerED
{
    @javafx.fxml.FXML
    private ComboBox<String> targetAudienceCMB;
    @javafx.fxml.FXML
    private TextField messageBodyTF;
    @javafx.fxml.FXML
    private TextField announcementTitleTF;
    @javafx.fxml.FXML
    private TextField authorNameTF;
    @javafx.fxml.FXML
    private Label confirmationLabel;

    Alert alert= new Alert(Alert.AlertType.INFORMATION);

    @javafx.fxml.FXML
    public void initialize() {
        targetAudienceCMB.getItems().addAll("Research Officer","Volunteer");
    }

    private int directorId;
    public void receiveObjectFromAnnouncementDashboardControllerED(int id){this.directorId=id;}

    @javafx.fxml.FXML
    public void sendAnnouncementButtonOA(ActionEvent actionEvent) {
        if (announcementTitleTF.getText().isBlank()){
            alert.setContentText("Announcement Title is Empty");
            alert.showAndWait();
            return;
        }
        if ((messageBodyTF.getText().length() <= 10)){
            alert.setContentText("Provide a Large Message Body");
            alert.showAndWait();
            return;
        }

        String title = announcementTitleTF.getText();
        String authorName =authorNameTF.getText();
        String targetAudience=targetAudienceCMB.getValue();
        String messageBody= messageBodyTF.getText();

        Announcement newAnnouncement= new Announcement(
                LocalDate.now(),
                authorName,
                title,
                targetAudience,
                messageBody
        );

        //ExecutiveDirector director = new ExecutiveDirector();
        //boolean success = director.sendAnnouncement(newAnnouncement);





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
            nextController.receiveObjectFromLoginController(directorId);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }
}