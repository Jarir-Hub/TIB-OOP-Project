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
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextArea locationarea;

    @FXML
    private DatePicker submissionDatePicker;

    @FXML
    private TextField attachmentTextField;

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
    public void browsebutton(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Browse option will be added later.");
        alert.showAndWait();

    }

    @FXML
    public void submitbutton(ActionEvent event) {

        if(titleTextField.getText().isEmpty()
                || categoryComboBox.getValue()==null
                || descriptionTextArea.getText().isEmpty()
                || locationarea.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
            return;

        }

        int id = new Random().nextInt(900000)+100000;

        SubmissionModel complaint = new SubmissionModel();

        complaint.setComplaintId(id);
        complaint.setTitle(titleTextField.getText());
        complaint.setCategory(categoryComboBox.getValue());
        complaint.setDescription(descriptionTextArea.getText());
        complaint.setLocation(locationarea.getText());
        complaint.setSubmissionDate(submissionDatePicker.getValue());
        complaint.setAttachment(attachmentTextField.getText());
        complaint.setStatus("Pending");

        saveComplaint(complaint);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Success");
        alert.setContentText("Complaint Submitted.\nComplaint ID : " + id);
        alert.showAndWait();

        resetbutton(null);

    }

    private void saveComplaint(SubmissionModel complaint){

        try{

            ObjectOutputStream oos;

            if(file.exists()){

                oos = new AppendableObjectOutputStream(
                        new FileOutputStream(file,true));

            }

            else{

                oos = new ObjectOutputStream(
                        new FileOutputStream(file));

            }

            oos.writeObject(complaint);
            oos.close();

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    public void resetbutton(ActionEvent event){

        titleTextField.clear();
        categoryComboBox.setValue(null);
        descriptionTextArea.clear();
        locationarea.clear();
        attachmentTextField.clear();
        submissionDatePicker.setValue(LocalDate.now());

    }

    @FXML
    public void backButton(ActionEvent event){

        System.out.println("Back Button Clicked");

    }

}