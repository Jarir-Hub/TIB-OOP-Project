package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class Volunteer_Registration_Controller
{
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> districtComboBox;
    @javafx.fxml.FXML
    private TextField idTextField;

    @javafx.fxml.FXML
    public void initialize() {
        districtComboBox.getItems().addAll( "Dhaka","Chattogram","Rajshahi","Khulna","Barishal","Sylhet","Rangpur","Mymensingh");


    }
    Alert alert=new Alert(Alert.AlertType.ERROR);
    Alert alert2=new Alert(Alert.AlertType.CONFIRMATION);

    public boolean mailAlreadyExist(String mail){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File file1=new File("VolunteerInfo.bin");
            if (file1.exists()){
                fis=new FileInputStream(file1);
                ois=new ObjectInputStream(fis);
            }
            else {
                return false;
            }
            while (true){
                Volunteer vObj=(Volunteer)ois.readObject();
                if (vObj.getEmail().equals(mail)){
                    ois.close();
                    return true;
                }
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
        return false;

    }

    public boolean idAlreadyExist(int id){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File file=new File("VolunteerInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);

            }
            else {
                return false;
            }
            while (true){
                Volunteer volunteerObj=(Volunteer) ois.readObject();
                if (volunteerObj.getUserID()==id){
                    ois.close();
                    return true;
                }
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

        return false;


    }

    @javafx.fxml.FXML
    public void SubmitButton(ActionEvent actionEvent) {
        boolean digiFound=false;
        for (int i=0; i<nameTextField.getText().length();i++){
            if (nameTextField.getText().charAt(i)>='0' && nameTextField.getText().charAt(i)<='9'){
                digiFound=true;
            }
        }
        boolean invalidPhone=false;
        for (int i=0; i<phoneNumberTextField.getText().length();i++){
            if (phoneNumberTextField.getText().charAt(0)!='0' && phoneNumberTextField.getText().charAt(1)!='1'&&phoneNumberTextField.getText().length()!=11){
                invalidPhone=true;
            }

        }
        boolean invalidId=false;
        if (idTextField.getText().length()!=6){
            invalidId=true;
        }

        boolean invalidMail=false;
        if (!emailTextField.getText().endsWith("@gmail.com")){
            invalidMail=true;
        }
        boolean invalidPassword=false;
        if (passwordTextField.getText().length()<6){
            invalidPassword=true;
        }
        if (digiFound){
            alert.setContentText("Digit found in your name");
            alert.showAndWait();
            return;
        }
        if (invalidPhone){
            alert.setContentText("Phone number must start with 0 and 1 and 11 character long");
            alert.showAndWait();
            return;
        }
        if (invalidMail){
            alert.setContentText("Your mail must end with @gmail.com");
            alert.showAndWait();
            return;
        }
        if (invalidPassword){
            alert.setContentText("Password Must be at least 6 character long");
            alert.showAndWait();
            return;
        }
        if (invalidId){
            alert.setContentText("Id must be 6 digit long");
            alert.showAndWait();
            return;
        }
        int id=Integer.parseInt(idTextField.getText());
        if (idAlreadyExist(id)){
            alert.setContentText("This id is already used");
            alert.showAndWait();
            return;
        }
        String mail=emailTextField.getText();
        if (mailAlreadyExist(mail)){
            alert.setContentText("This mail is already used");
            alert.showAndWait();
            return;
        }

        Volunteer volunteerInfo=new Volunteer(
                Integer.parseInt(idTextField.getText()),
                nameTextField.getText(),
                phoneNumberTextField.getText(),
                emailTextField.getText(),
                districtComboBox.getValue(),
                passwordTextField.getText()
        );
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            File file=new File("VolunteerInfo.bin");
            if (file.exists()){
                fos=new FileOutputStream(file,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(volunteerInfo);
            oos.close();

            nameTextField.clear();
            idTextField.clear();
            phoneNumberTextField.clear();
            emailTextField.clear();
            districtComboBox.setValue(null);
            passwordTextField.clear();

            alert2.setContentText("Information Successfully Saved");
            alert2.showAndWait();
        }
        catch (Exception e){
            //
        }


    }
}