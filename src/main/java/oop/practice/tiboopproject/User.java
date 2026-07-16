package oop.practice.tiboopproject;

public abstract class User {
    protected String userId, name, email, password, designation;

    public User(String userId, String name, String email, String password, String designation) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.designation = designation;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDesignation() {
        return designation;
    }

    /*
    public User login(String username,String pass){
        //
        return User;
    }
    */

    public void logout(){
        //
    }

    public abstract void updateProfile();
}
