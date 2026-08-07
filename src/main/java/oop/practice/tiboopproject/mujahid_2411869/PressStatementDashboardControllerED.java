package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mujahid_2411869.ExecutiveDirector;
import oop.practice.tiboopproject.HelloApplication;

public class PressStatementDashboardControllerED
{
    @javafx.fxml.FXML
    private TableColumn statementIdTC;
    @javafx.fxml.FXML
    private TableColumn authorTC;
    @javafx.fxml.FXML
    private TableView pressStatementTV;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn associatedIssueTC;
    @javafx.fxml.FXML
    private TableColumn dateReleasedTC;
    @javafx.fxml.FXML
    private AnchorPane pressStatementDashboardAP;

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
    public void createPressStatementButtonOA(ActionEvent actionEvent) {
    }
}