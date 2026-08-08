package prianka_2412456;

import oop.practice.tiboopproject.User;
import utility.BinaryFileUtility;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ITSupportOfficer extends User implements Serializable {

    private static final String ACCOUNT_FILE = "Account.bin";
    private static final String AUDIT_LOG_FILE = "Auditlog.bin";

    public ITSupportOfficer(int userID, String password, String userType) {
        super(userID, password, userType);
    }


    public Account createAccount(String name, String username, String password, String role) {
        List<Account> existingAccounts = viewAllAccount();

        if (!Account.validateUsernameUnique(username, existingAccounts)) {
            return null;
        }
        if (!Account.validateRoleSelected(role)) {
            return null;
        }

        String newAccountId = "ACC-" + (existingAccounts.size() + 1);
        Account account = new Account(newAccountId, name, username, password, role,
                "Active", LocalDate.now(), true);

        if (!account.validatePasswordStrength()) {
            return null;
        }

        boolean saved = BinaryFileUtility.writeObjects(ACCOUNT_FILE, account);
        return saved ? account : null;
    }

    //  READ

    public ArrayList<Account> viewAllAccount() {
        return BinaryFileUtility.readObjects(ACCOUNT_FILE);
    }

    // DELETE

    public boolean deleteAccount(String accountId, String currentlyLoggedInAccountId) {
        ArrayList<Account> existingAccounts = viewAllAccount();

        Account toDelete = null;
        for (Account account : existingAccounts) {
            if (account.getAccountId().equals(accountId)) {
                toDelete = account;
                break;
            }
        }

        if (toDelete == null || !toDelete.verifyNotSelfAccount(currentlyLoggedInAccountId)) {
            return false;
        }

        existingAccounts.remove(toDelete);
        return BinaryFileUtility.overwriteObjects(ACCOUNT_FILE, existingAccounts);
    }

    //  RESET PASSWORD

    public String resetPassword(String accountId) {
        ArrayList<Account> existingAccounts = viewAllAccount();

        for (Account account : existingAccounts) {
            if (account.getAccountId().equals(accountId)) {
                String tempPassword = Account.generatePassword();
                account.setPassword(tempPassword);
                account.setMustChangePassword(true);
                BinaryFileUtility.overwriteObjects(ACCOUNT_FILE, existingAccounts);
                return tempPassword;
            }
        }
        return null;
    }

    //  SEARCH

    public ArrayList<Account> searchAccount(String keyword) {
        ArrayList<Account> allAccounts = viewAllAccount();
        ArrayList<Account> matches = new ArrayList<>();
        for (Account account : allAccounts) {
            if (account.matchesSearchKeyword(keyword)) {
                matches.add(account);
            }
        }
        return matches;
    }

    //   CHANGE ROLE

    public boolean changeRole(String accountId, String newRole) {
        if (!Account.validateRoleSelected(newRole)) {
            return false;
        }

        ArrayList<Account> existingAccounts = viewAllAccount();
        for (Account account : existingAccounts) {
            if (account.getAccountId().equals(accountId)) {
                account.setRole(newRole);
                return BinaryFileUtility.overwriteObjects(ACCOUNT_FILE, existingAccounts);
            }
        }
        return false;
    }

    //   TOGGLE STATUS

    public String toggleStatus(String accountId) {
        ArrayList<Account> existingAccounts = viewAllAccount();
        for (Account account : existingAccounts) {
            if (account.getAccountId().equals(accountId)) {
                String newStatus = "Active".equalsIgnoreCase(account.getStatus()) ? "Inactive" : "Active";
                account.setStatus(newStatus);
                BinaryFileUtility.overwriteObjects(ACCOUNT_FILE, existingAccounts);
                return newStatus;
            }
        }
        return null;
    }

    // AUDIT LOG

    public ArrayList<Auditlog> viewAuditLog() {
        return BinaryFileUtility.readObjects(AUDIT_LOG_FILE);
    }
}