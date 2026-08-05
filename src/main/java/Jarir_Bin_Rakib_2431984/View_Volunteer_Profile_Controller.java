package Jarir_Bin_Rakib_2431984;

import javafx.scene.control.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class View_Volunteer_Profile_Controller
{
    @javafx.fxml.FXML
    private Label volunteerIdLabel;
    @javafx.fxml.FXML
    private Label phoneNumberLabel;
    @javafx.fxml.FXML
    private Label emailLabel;
    @javafx.fxml.FXML
    private Label districtLabel;
    @javafx.fxml.FXML
    private Label nameLabel;

    public void receiveLoggedIdFromVolunteerDashBoard(int id){
        volunteerIdLabel.setText(Integer.toString(id));
        Volunteer vol=getVolunteerInfoFromDashboard(id);
        nameLabel.setText(vol.getFullName());
        phoneNumberLabel.setText(vol.getPhoneNumber());
        emailLabel.setText(vol.getEmail());
        districtLabel.setText(vol.getDistrict());
    }


    public Volunteer getVolunteerInfoFromDashboard(int id){
        ArrayList<Volunteer> volList=new ArrayList<>();

        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File file=new File("VolunteerInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);

            }
            else{
                //
            }
            while (true){
                volList.add((Volunteer)ois.readObject());
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
            //
        }
        Volunteer targetVolunteer=null;
        for (Volunteer v:volList){
            if (v.getUserID()==id){
                targetVolunteer=v;
            }
        }
        return targetVolunteer;


    }




    @javafx.fxml.FXML
    public void initialize() {



    }}