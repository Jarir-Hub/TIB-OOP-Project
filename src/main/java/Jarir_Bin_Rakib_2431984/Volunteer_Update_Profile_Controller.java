package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class Volunteer_Update_Profile_Controller
{
    @javafx.fxml.FXML
    private Label volunteerIdLabel;
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField newPasswordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> districtComboBox;

    @javafx.fxml.FXML
    private int volunteerID;
    public void receiveVolunteerId(int id) {
        this.volunteerID = id;
    }
    public void initialize() {
        districtComboBox.getItems().addAll( "Dhaka","Chattogram","Rajshahi","Khulna","Barishal","Sylhet","Rangpur","Mymensingh");

    }
    Alert alert=new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    ArrayList<Volunteer> volList=new ArrayList<>();

    public void updateProfileButton(ActionEvent actionEvent) {
        if (nameTextField.getText().isEmpty()||phoneNumberTextField.getText().isEmpty()
                ||emailTextField.getText().isEmpty()
                ||districtComboBox.getValue()==null
                ||newPasswordTextField.getText().isEmpty()){
            alert.setContentText("Please fill every field");
            alert.showAndWait();
            return;
        }

        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File file =new File("VolunteerInfo");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);
            }
            else {
                //
            }
            while (true){
               Volunteer volunteer=(Volunteer) ois.readObject();
               if (volunteer.getUserID()==volunteerID){
                   volunteer.setFullName(nameTextField.getText());
                   volunteer.setPhoneNumber(phoneNumberTextField.getText());
                   volunteer.setEmail(emailTextField.getText());
                   volunteer.setDistrict(districtComboBox.getValue());
                   volunteer.setPassword(newPasswordTextField.getText());
               }
               volList.add(volunteer);
            }

        }
        catch (Exception e){
            try {
                if (ois!=null){
                    ois.close();
                }
            }
            catch (Exception e1){
                //
            }
        }
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            File file=new File("VolunteerInfo.bin");
            if (file.exists()){
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }
            for (Volunteer v:volList){
                oos.writeObject(v);
            }
            oos.close();
        }
        catch (Exception e){
            //
        }
    }
}