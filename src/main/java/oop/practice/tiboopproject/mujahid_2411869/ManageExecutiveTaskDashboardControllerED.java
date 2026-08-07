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

public class ManageExecutiveTaskDashboardControllerED
{
    @javafx.fxml.FXML
    private TableColumn priorityLevelTC;
    @javafx.fxml.FXML
    private TableView executiveTaskTV;
    @javafx.fxml.FXML
    private TableColumn dueDateTC;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn taskIdTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private AnchorPane manageExecutiveTaskAP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void addNewTaskButtonOA(ActionEvent actionEvent) {
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

}