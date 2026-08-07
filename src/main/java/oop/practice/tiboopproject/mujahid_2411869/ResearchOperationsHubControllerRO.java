package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mujahid_2411869.ResearchOfficer;
import oop.practice.tiboopproject.HelloApplication;

public class ResearchOperationsHubControllerRO
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    private ResearchOfficer loggedInUser;
    public void receivedUserObject(ResearchOfficer user) {
        loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void manuallyRecordSingleFieldObservationButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.FieldOperationControllerDashboardRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            FieldOperationControllerDashboardRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }


    @javafx.fxml.FXML
    public void createManageProjectMilestoneTimelineButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.TimelineManagerDashboardControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            TimelineManagerDashboardControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void createNewResearchProjectButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.ResearchDashboardControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            ResearchDashboardControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }

    }

    @javafx.fxml.FXML
    public void addEntryToLiteratureReviewTrackerButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.LiteratureEntryDashboardControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            LiteratureEntryDashboardControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void searchPendingResearchDraftsRepositoryButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitResearchDraftForApprovalButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.DraftDashboardControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            DraftDashboardControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void designDigitalResearchSurveyQuestionnaireButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.DigitalResearchSurveyDashboardControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            DigitalResearchSurveyDashboardControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void writeMaintainPersonalFieldResearchNotesButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.PersonalNotesDashboardControllerRO"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("");
            newStage.setScene(scene);
            PersonalNotesDashboardControllerRO nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ResearchOfficer) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }

    }
}