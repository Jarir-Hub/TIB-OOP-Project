package mohona_2431026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

public class SubmitComplaint {

    @FXML
    private TextField attachmentTextField;

    @FXML
    private TextField titletextfield;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField locationTextField;

    @FXML
    public void initialize() {

        categoryComboBox.getItems().addAll(
                "Road",
                "Water",
                "Electricity",
                "Garbage",
                "Others"
        );
    }

    @FXML
    public void submitButton(ActionEvent event) {

        Complaint complaint = new Complaint(

                UUID.randomUUID().toString(),

                titletextfield.getText(),

                categoryComboBox.getValue(),

                descriptionTextArea.getText(),

                locationTextField.getText(),

                attachmentTextField.getText(),

                "Citizen",

                LocalDate.now(),

                "Pending"
        );

        try {

            File file = new File("Complaint.bin");

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

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Complaint Submitted Successfully");
            alert.show();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}