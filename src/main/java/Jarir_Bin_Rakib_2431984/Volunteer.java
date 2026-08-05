package Jarir_Bin_Rakib_2431984;

import java.io.Serializable;

public class Volunteer extends User implements Serializable {

    private int volunteerId;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String district;

    private String password;


    public Volunteer() {
    }

    public Volunteer(int volunteerId, String fullName, String phoneNumber, String email, String district, String password) {
        this.volunteerId = volunteerId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.district = district;
        this.password = password;
    }


    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerId=" + volunteerId +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", district='" + district + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}
