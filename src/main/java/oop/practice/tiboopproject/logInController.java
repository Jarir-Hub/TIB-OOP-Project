package oop.practice.tiboopproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class logInController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField passwordTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void registerAsCitizen(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void registerAsVolunteer(ActionEvent actionEvent) {
    }

    private User searchUser(String filename,int id,String password){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File afile=new File(filename);
            if (afile.exists()){
                fis=new FileInputStream(afile);
                ois=new ObjectInputStream(fis);
            }
            else {
                return null;
            }
            while (true){
                User user=(User) ois.readObject();
                if (user.getUserID()==id && user.getPassword().equals(password)){
                    ois.close();
                    return user;
                }
            }
        }
        catch (Exception e){
            //
        }
        return null;
    }

    private User authenticateUser(int id,String password){
        User user;
        user=searchUser("VolunteerInfo.bin",id,password);
        if (user!=null){
            return user;
        }
        user = searchUser("CitizenInfo.bin", id, password);
        if(user != null) return user;

        user = searchUser("ComplaintOfficerInfo.bin", id, password);
        if(user != null) return user;

        user = searchUser("CampaignCoordinatorInfo.bin", id, password);
        if(user != null) return user;

        user = searchUser("FinanceHRManagerInfo.bin", id, password);
        if(user != null) return user;

        user = searchUser("StrategicDirectorInfo.bin", id, password);
        if(user != null) return user;

        user = searchUser("ITSupportOfficerInfo.bin", id, password);
        if(user != null) return user;

        user = searchUser("EventCoordinatorInfo.bin", id, password);
        if(user != null) return user;

        return null;
    }
    Alert al=new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) {

        //Validation
        //------do the validation

        //If Validation fails show proper message....

        String password=passwordTextField.getText();
        int id=Integer.parseInt(idTextField.getText());

        User user=authenticateUser(id,password);
        if (user==null){
            al.setContentText("Invalid Password or username");
            al.showAndWait();
        }
        else if (user.getUserType().equals("Volunteer")){
            //volunteer fxml
        }
        else if (user.getUserType().equals("Write your user here")){
            //show your user fxml
        }


    }

}