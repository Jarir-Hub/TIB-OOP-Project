package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.practice.tiboopproject.HelloApplication;

public class ExecutiveDirectoryDashboardControllerED
{

    @javafx.fxml.FXML
    public void initialize() {
    }

    private int directorId;
    public void receiveObjectFromLoginController(int id){
        this.directorId=id;
    }

    @javafx.fxml.FXML
    public void ReviewAndApproveOrRejectAResearchDraftButtonOA(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void CreateAndScheduleExecutiveMeetingAgendaButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.MeetingDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("Meeting Dashboard");
            newStage.setScene(scene);
            MeetingDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void CreateAndManageOrganisationalPoliciesButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.PolicyDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("Policy Dashboard");
            newStage.setScene(scene);
            PolicyDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void ManagePersonalExecutiveTasksButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.ManageExecutiveTaskDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("Manage Executive Task Dashboard");
            newStage.setScene(scene);
            ManageExecutiveTaskDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void FinalizeAnnualStrategicRoadmapButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.StrategicRoadmapDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("Strategic Roadmap Dashboard");
            newStage.setScene(scene);
            StrategicRoadmapDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void ReleaseOfficialPressStatementsButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.PressStatementDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("Press Statement Dashboard");
            newStage.setScene(scene);
            PressStatementDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void SignStrategicInstitutionalMoUsButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.MoUDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("MoU Dashboard");
            newStage.setScene(scene);
            MoUDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void SendAnOrganizationalAnnouncementButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.AnnouncementDashboardControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage=new Stage();
            newStage.setTitle("Announcement Dashboard");
            newStage.setScene(scene);
            AnnouncementDashboardControllerED nextController = fxmlLoader.getController();
            nextController.receiveObjectFromExecutiveDirectoryDashboardControllerED(directorId);
            newStage.show();
        }
        catch (Exception e){
            //
        }
    }
}