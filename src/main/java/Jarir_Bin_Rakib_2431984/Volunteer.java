package Jarir_Bin_Rakib_2431984;

import oop.practice.tiboopproject.User;

import java.io.Serializable;

public class Volunteer extends User implements Serializable {



    private String fullName;

    private String phoneNumber;

    private String email;

    private String district;


    public Volunteer(int userID, String password, String fullName, String phoneNumber, String email, String district) {
        super(userID, password, "Volunteer");
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.district = district;
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


    @Override
    public String toString() {
        return "Volunteer{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
