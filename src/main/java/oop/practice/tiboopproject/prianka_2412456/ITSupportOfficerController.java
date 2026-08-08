package oop.practice.tiboopproject.prianka_2412456;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.practice.tiboopproject.User;
import prianka_2412456.Account;
import prianka_2412456.Auditlog;
import prianka_2412456.ITSupportOfficer;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.util.ArrayList;

public class ITSupportOfficerController implements UserReceiver {
    @FXML
    private TableColumn<Account, String> usernameCOL;
    @FXML
    private TableView<Account> tablecol;
    @FXML
    private TableColumn<Account, String> statusCOL;
    @FXML
    private TableColumn<Account, String> nameCOL;
    @FXML
    private TableColumn<Account, String> roleCOL;
    @FXML
    private ComboBox<String> roleeditCB;
    @FXML
    private TableColumn<Auditlog, Boolean> statusAudit;
    @FXML
    private DatePicker datefilter;
    @FXML
    private TableView<Auditlog> auditTAbleCol;
    @FXML
    private TableColumn<Auditlog, Integer> AccountAudit;
    @FXML
    private TableColumn<Auditlog, String> loginAudit;
    @FXML
    private TableColumn<Auditlog, String> nameAduit;
    @FXML
    private TextField searchAccountTF;

    private User loggedInUser;
    private final ITSupportOfficer itSupportOfficer = new ITSupportOfficer(0, "", "IT Support Officer");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @FXML
    public void initialize() {
        nameCOL.setCellValueFactory(new PropertyValueFactory<>("name"));
        usernameCOL.setCellValueFactory(new PropertyValueFactory<>("username"));
        roleCOL.setCellValueFactory(new PropertyValueFactory<>("role"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));

        nameAduit.setCellValueFactory(new PropertyValueFactory<>("username"));
        AccountAudit.setCellValueFactory(new PropertyValueFactory<>("logid"));
        loginAudit.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        statusAudit.setCellValueFactory(new PropertyValueFactory<>("sucessStatus"));

        roleeditCB.getItems().addAll("Asset Manager", "IT Support Officer", "Executive Director");

        loadAllAccounts();
    }

    private void loadAllAccounts() {
        ArrayList<Account> allAccounts = itSupportOfficer.viewAllAccount();
        tablecol.setItems(FXCollections.observableArrayList(allAccounts));
    }

    @FXML
    public void refreshOA(ActionEvent actionEvent) {
        loadAllAccounts();
    }

    @FXML
    public void filterOA(ActionEvent actionEvent) {
        String keyword = searchAccountTF.getText();
        ArrayList<Account> matches = itSupportOfficer.searchAccount(keyword);
        tablecol.setItems(FXCollections.observableArrayList(matches));
    }

    @FXML
    public void addUserOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/demo_tib/newUser.fxml", loggedInUser);
    }

    @FXML
    public void deleteOA(ActionEvent actionEvent) {
        Account selected = tablecol.getSelectionModel().getSelectedItem();
        if (selected == null || loggedInUser == null) {
            return;
        }
        itSupportOfficer.deleteAccount(selected.getAccountId(), String.valueOf(loggedInUser.getUserID()));
        loadAllAccounts();
    }

    @FXML
    public void RoleconfirmOA(ActionEvent actionEvent) {
        Account selected = tablecol.getSelectionModel().getSelectedItem();
        String newRole = roleeditCB.getValue();
        if (selected == null || newRole == null) {
            return;
        }
        itSupportOfficer.changeRole(selected.getAccountId(), newRole);
        loadAllAccounts();
    }

    @FXML
    public void toggleOA(ActionEvent actionEvent) {
        Account selected = tablecol.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        itSupportOfficer.toggleStatus(selected.getAccountId());
        loadAllAccounts();
    }

    @FXML
    public void auditOA(ActionEvent actionEvent) {
        ArrayList<Auditlog> allLogs = itSupportOfficer.viewAuditLog();
        auditTAbleCol.setItems(FXCollections.observableArrayList(allLogs));
    }

    @FXML
    public void filterauditOA(ActionEvent actionEvent) {
        if (datefilter.getValue() == null) {
            return;
        }
        ArrayList<Auditlog> allLogs = itSupportOfficer.viewAuditLog();
        ArrayList<Auditlog> filtered = new ArrayList<>();
        for (Auditlog log : allLogs) {
            if (log.getTimestamp() != null && log.getTimestamp().equals(datefilter.getValue())) {
                filtered.add(log);
            }
        }
        auditTAbleCol.setItems(FXCollections.observableArrayList(filtered));
    }

    @FXML
    public void userManageOA(ActionEvent actionEvent) {
        loadAllAccounts();
    }

    @FXML
    public void logoutOA(ActionEvent actionEvent) throws java.io.IOException {
        SceneSwitchingHelper.fullSceneReplacement(actionEvent, "/com/example/demo_tib/loginView.fxml");
    }
}