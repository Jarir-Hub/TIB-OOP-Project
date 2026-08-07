package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mujahid_2411869.ExecutiveDirector;
import mujahid_2411869.Meeting;
import mujahid_2411869.Policy;
import oop.practice.tiboopproject.HelloApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class PolicyDashboardControllerED
{
    @javafx.fxml.FXML
    private TableColumn<Policy,String> policyNameTC;
    @javafx.fxml.FXML
    private TableColumn<Policy,Long> policyIdTC;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> categoryTC;
    @javafx.fxml.FXML
    private TableView<Policy> policyTV;
    @javafx.fxml.FXML
    private TableColumn<Policy, LocalDate> effectiveDateTC;
    @javafx.fxml.FXML
    private AnchorPane policyDashboardAP;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> descriptionTC;

    @javafx.fxml.FXML
    public void initialize() {
        policyNameTC.setCellValueFactory(new PropertyValueFactory<>("policyName"));
        policyIdTC.setCellValueFactory(new PropertyValueFactory<>("policyId"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        effectiveDateTC.setCellValueFactory(new PropertyValueFactory<>("policyText"));
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("effectiveDate"));


    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
        loadTable();
    }

    public void loadTable(){
        ArrayList<Policy> dataToLoad= loggedInUser.readPolicyObject();

        for (Policy a: dataToLoad){
            policyTV.getItems().add(a);
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
    public void createNewPolicyButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oop.practice.tiboopproject.mujahid_2411869.PolicyCreationControllerED"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("New Policy");
            newStage.setScene(scene);
            PolicyCreationControllerED nextController = fxmlLoader.getController();
            nextController.receivedUserObject((ExecutiveDirector) loggedInUser);
            newStage.show();

        } catch (Exception e) {
            //
        }

    }
}