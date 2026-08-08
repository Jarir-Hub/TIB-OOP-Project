package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import oop.practice.tiboopproject.User;
import prianka_2412456.Account;
import prianka_2412456.ITSupportOfficer;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

public class AddNewUserController implements UserReceiver {
    @FXML
    private TextField nameTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private ComboBox<String> roleCB;
    @FXML
    private TextField accTF;
    @FXML
    private ComboBox<String> statusCB;
    @FXML
    private TextField passTF;
    @FXML
    private DatePicker loginn;

    private User loggedInUser;

    private final ITSupportOfficer itSupportOfficer = new ITSupportOfficer(0, "", "IT Support Officer");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @FXML
    public void initialize() {
        roleCB.getItems().addAll("Asset Manager", "IT Support Officer", "Executive Director");
        statusCB.getItems().addAll("Active", "Inactive");
    }

    @FXML
    public void newOA(ActionEvent actionEvent) {
        String name = nameTF.getText();
        String username = usernameTF.getText();
        String password = passTF.getText();
        String role = roleCB.getValue();

        Account newAccount = itSupportOfficer.createAccount(name, username, password, role);

        if (newAccount == null) {
            accTF.setText("Failed to create account. Check username uniqueness and password length.");
            return;
        }

        accTF.setText("Account created: " + newAccount.getAccountId());
    }
}