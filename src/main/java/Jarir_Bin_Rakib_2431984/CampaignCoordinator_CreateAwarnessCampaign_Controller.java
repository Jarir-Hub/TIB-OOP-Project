package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class CampaignCoordinator_CreateAwarnessCampaign_Controller
{
    @javafx.fxml.FXML
    private DatePicker campaignDatePicker;
    @javafx.fxml.FXML
    private TextField campaignTitleTextField;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private TextField participantLimitTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
    }

    Alert alert=new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    public void createButton(ActionEvent actionEvent) {
        if (campaignDatePicker.getValue().isBefore(LocalDate.now())){
            alert.setContentText("Please Enter Valid Time/Date");
            alert.showAndWait();
            return;
        }

        Campaign campaignToAdd=new Campaign(
                campaignTitleTextField.getText(),
                descriptionTextArea.getText(),
                locationTextField.getText(),
                campaignDatePicker.getValue(),
                Integer.parseInt(participantLimitTextField.getText())

        );

        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            File file=new File("CampaignInfo.bin");
            if (file.exists()){
                fos=new FileOutputStream(file,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(campaignToAdd);
            oos.close();
            campaignTitleTextField.clear();
            descriptionTextArea.clear();
            locationTextField.clear();
            participantLimitTextField.clear();
            campaignDatePicker.setValue(null);

        }
        catch (Exception e){
            //
        }
    }
}