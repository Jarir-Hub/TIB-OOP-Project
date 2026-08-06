package mohona_2431026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class ComplaintSubmission {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField attachmentTextField;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private DatePicker submissionDatePicker;

    @FXML
    private TextArea locationarea;

    File file = new File("Complaint.bin");

    @FXML
    public void initialize() {

        categoryComboBox.getItems().addAll(
                "Road",
                "Water",
                "Electricity",
                "Garbage",
                "Environment",
                "Others"
        );

        submissionDatePicker.setValue(LocalDate.now());

    }

    @FXML
    public void browsebutton(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("File browsing can be implemented later.");
        alert.showAndWait();

    }

    @FXML
    public void backButton(ActionEvent actionEvent) {

    }

    @FXML
    public void submitbutton(ActionEvent actionEvent) {

        // Validation

        if(titleTextField.getText().isEmpty()
                || categoryComboBox.getValue()==null
                || descriptionTextArea.getText().isEmpty()
                || locationarea.getText().isEmpty()
                || submissionDatePicker.getValue()==null){

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all mandatory fields.");
            alert.showAndWait();
            return;
        }

        int complaintID = new Random().nextInt(900000)+100000;

        Complaint complaint = new Complaint(

                complaintID,
                titleTextField.getText(),
                categoryComboBox.getValue(),
                descriptionTextArea.getText(),
                locationarea.getText(),
                attachmentTextField.getText(),
                submissionDatePicker.getValue(),
                "Pending"

        );

        saveComplaint(complaint);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Complaint Submitted Successfully");
        alert.setContentText("Complaint ID : " + complaintID);
        alert.showAndWait();

        resetbutton(null);

    }

    private void saveComplaint(Complaint complaint){

        try{

            ObjectOutputStream oos;

            if(file.exists()){

                oos=new AppendableObjectOutputStream(new FileOutputStream(file,true));

            }
            else{

                oos=new ObjectOutputStream(new FileOutputStream(file));

            }

            oos.writeObject(complaint);

            oos.close();

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    public void resetbutton(ActionEvent actionEvent) {

        titleTextField.clear();
        attachmentTextField.clear();
        descriptionTextArea.clear();
        locationarea.clear();
        categoryComboBox.setValue(null);
        submissionDatePicker.setValue(LocalDate.now());

    }

}