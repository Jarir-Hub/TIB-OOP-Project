package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mujahid_2411869.ExecutiveDirector;
import oop.practice.tiboopproject.HelloApplication;

public class NewRoadmapControllerED
{
    @javafx.fxml.FXML
    private TextField jeyMilestonesTF;
    @javafx.fxml.FXML
    private TextField focusAreaTF;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox fiscalYearCMB;
    @javafx.fxml.FXML
    private DatePicker completionDateDP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void finalizeRoadmapButtonOA(ActionEvent actionEvent) {
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
}