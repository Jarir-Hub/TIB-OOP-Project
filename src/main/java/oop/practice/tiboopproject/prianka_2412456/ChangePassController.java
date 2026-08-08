package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import oop.practice.tiboopproject.User;
import prianka_2412456.Account;
import prianka_2412456.ITSupportOfficer;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.util.ArrayList;

public class ChangePassController implements UserReceiver {
    @FXML
    private Label confirmationTF;

    private User loggedInUser;

    private final ITSupportOfficer itSupportOfficer = new ITSupportOfficer(0, "", "IT Support Officer");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @FXML
    public void confirmOA(ActionEvent actionEvent) {
        if (loggedInUser == null) {
            confirmationTF.setText("No user is currently logged in.");
            return;
        }

        ArrayList<Account> allAccounts = itSupportOfficer.viewAllAccount();
        Account matchingAccount = null;
        for (Account account : allAccounts) {
            if (account.getAccountId().equals(String.valueOf(loggedInUser.getUserID()))) {
                matchingAccount = account;
                break;
            }
        }

        if (matchingAccount == null) {
            confirmationTF.setText("Could not find your account.");
            return;
        }

        String tempPassword = itSupportOfficer.resetPassword(matchingAccount.getAccountId());

        if (tempPassword == null) {
            confirmationTF.setText("Password reset failed.");
            return;
        }

        confirmationTF.setText("Your new temporary password is: " + tempPassword);
    }
}