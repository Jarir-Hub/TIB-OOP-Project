package oop.practice.tiboopproject;

public abstract class User {
    protected int userID;
    protected String password;
    protected String userType;


    public User(int userID, String password, String userType) {
        this.userID = userID;
        this.password = password;
        this.userType = userType;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
