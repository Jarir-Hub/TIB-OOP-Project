package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Locale;

public class Volunteer_ViewAvailable_Campaigns_Controller
{
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> locationColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> campaignTitleColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,Integer> availableSlotsColumn;
    @javafx.fxml.FXML
    private TableView<Campaign> campaignTableView;
    @javafx.fxml.FXML
    private TableColumn<Campaign,Integer> participantLimitColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> selectCampaignComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        campaignTitleColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("campaignTitle"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("location"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Campaign,LocalDate>("campaignDate"));
        participantLimitColumn.setCellValueFactory(new PropertyValueFactory<Campaign,Integer>("participantLimit"));
        availableSlotsColumn.setCellValueFactory(new PropertyValueFactory<Campaign,Integer>("availableSlots"));

        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File file=new File("CampaignInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);
            }
            else {
                return;
            }
            while (true){
                Campaign cmp=(Campaign) ois.readObject();
                selectCampaignComboBox.getItems().add(cmp.getCampaignTitle());

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

    }
    Alert alert=new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
        String selectedTitle=selectCampaignComboBox.getValue();
        if (selectedTitle==null){
            return;
        }
        campaignTableView.getItems().clear();
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File file=new File("CampaignInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);
            }
            else {
                alert.setContentText("“No Campaign Available");
                alert.showAndWait();
                return;
            }
            while (true){
                Campaign cmp=(Campaign) ois.readObject();
                if (selectedTitle.equals(cmp.getCampaignTitle()) && cmp.getAvailableSlots()>0){
                    campaignTableView.getItems().add(cmp);
                    break;
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


    }


}