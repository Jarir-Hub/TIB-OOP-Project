package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mujahid_2411869.ExecutiveDirector;
import oop.practice.tiboopproject.HelloApplication;

import java.time.LocalDate;

public class PolicyCreationControllerED
{
    @javafx.fxml.FXML
    private ComboBox <String> categoryCMB;
    @javafx.fxml.FXML
    private TextField policyNameTF;
    @javafx.fxml.FXML
    private TextField policyDescriptionTF;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private DatePicker effectiveDateDP;

    @javafx.fxml.FXML
    public void initialize() {
        categoryCMB.getItems().addAll("Executive","HR","Finance","Logistic");
    }

    private ExecutiveDirector loggedInUser;
    public void receivedUserObject(ExecutiveDirector user) {
        loggedInUser = user;
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
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    @javafx.fxml.FXML
    public void publishPolicyButtonOA(ActionEvent actionEvent) {
        if (effectiveDateDP.getValue().isBefore(LocalDate.now())){
            alert.setContentText("Effective Date can't be Past Date");
            alert.showAndWait();
            return;
        }

        loggedInUser.createPolicy(policyNameTF.getText(),
                categoryCMB.getValue(),policyDescriptionTF.getText(),effectiveDateDP.getValue());

    }
}