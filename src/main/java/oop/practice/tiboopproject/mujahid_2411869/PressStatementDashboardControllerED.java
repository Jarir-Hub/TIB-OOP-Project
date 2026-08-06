package oop.practice.tiboopproject.mujahid_2411869;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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

    private int directorId;
    public void receiveObjectFromExecutiveDirectoryDashboardControllerED(int id){this.directorId=id;}

    @javafx.fxml.FXML
    public void executiveDirectoryButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createPressStatementButtonOA(ActionEvent actionEvent) {
    }
}