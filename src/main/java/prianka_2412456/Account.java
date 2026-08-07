package prianka_2412456;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Account implements Serializable {

    private String accountId;
    private String name;
    private String username;
    private String password;
    private String role;
    private String status;
    private  LocalDate lastLogin;
    private boolean mustChangePassword;

    // constructor

    public Account(String accountId, String name, String username, String password, String role, String status, LocalDate lastLogin, boolean mustChangePassword) {

        this.accountId = accountId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.lastLogin = lastLogin;
        this.mustChangePassword = mustChangePassword;
    }

    // getter and setter

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isMustChangePassword() {
        return mustChangePassword;
    }

    public void setMustChangePassword(boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }



    public boolean validatePasswordStrength() {

        return password != null && password.length() >= 6;

    }

    public boolean validateUsernameUnique(String username, List<Account> existingAccount){
        if(username != null || username.isBlank()){
            return false;
        }

        for (Account account: existingAccount){
            if(account.getUsername() != null && account.getUsername().equalsIgnoreCase(username)){
                return false;
            }

        }

        return true;
    }

    // need to checkk
    public boolean verifyNotSelfAccount(String currentlyLoggedInAccountId) {
        return currentlyLoggedInAccountId == null || !currentlyLoggedInAccountId.equals(this.accountId);
    }



    //
    public boolean roleCheck(){
        return role!= null;
    }

    public boolean matchesSearchKeyword(String keyword){
        if(keyword != null && keyword.isBlank()){
            return false;
        }

        String lowerKeyword = keyword.toLowerCase();
        return (name != null && name.toLowerCase().contains(lowerKeyword))
                || (username != null && username.toLowerCase().contains(lowerKeyword));


    }


    public static String generatePassword(){

        String allow = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++){
            sb.append(allow.charAt(random.nextInt(allow.length())));

        }
        return sb.toString();

    }
    @Override
    public String toString() {
        return name + " (" + username + ")";
    }




}
