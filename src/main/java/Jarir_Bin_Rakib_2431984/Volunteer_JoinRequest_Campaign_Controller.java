package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Volunteer_JoinRequest_Campaign_Controller
{
    @javafx.fxml.FXML
    private TextArea requestMessageTextArea;
    @javafx.fxml.FXML
    private TableColumn<Campaign,Integer> availableSlotsTableColumn;
    @javafx.fxml.FXML
    private TableView<Campaign> CampaignInfoTableView;
    @javafx.fxml.FXML
    private TableColumn<Campaign,Integer> participationLimitTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> locationTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> campaignTitleTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,LocalDate> dateTableColumn;

    Alert alert=new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    private ComboBox<String> selectACampaignToJoin;

    @javafx.fxml.FXML
    public void initialize() {

        campaignTitleTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("campaignTitle"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("location"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign, LocalDate>("campaignDate"));
        participationLimitTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,Integer>("participantLimit"));
        availableSlotsTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,Integer>("availableSlots"));

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
                selectACampaignToJoin.getItems().add(cmp.getCampaignTitle());

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

        CampaignInfoTableView.getItems().clear();

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
               if (cmp.getAvailableSlots()>0){
                   CampaignInfoTableView.getItems().add(cmp);
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


    private int volunteerID;
    public void receiveVolunteerIdFromDashboardController(int id){
        this.volunteerID=id;


    }
    public Volunteer getVolunteerInfo(int volunteerID) {
        ArrayList<Volunteer> volList = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("VolunteerInfo.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

            }
            else {
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
        }
        Volunteer targetVol=null;
        for (Volunteer v:volList){
            if (volunteerID==v.getUserID()){
                targetVol=v;
            }
        }
        return targetVol;
    }



    @javafx.fxml.FXML
    public void submitRequestButton(ActionEvent actionEvent) {

        if (selectACampaignToJoin.getValue() == null) {
            alert.setContentText("Please select a campaign.");
            alert.showAndWait();
            return;
        }
        if (requestMessageTextArea.getText().isEmpty()) {
            alert.setContentText("Please enter a request message.");
            alert.showAndWait();
            return;
        }



    }
}