package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
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

    private int volunteerID;

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
                if (cmp.getAvailableSlots()>0){
                    selectACampaignToJoin.getItems().add(cmp.getCampaignTitle());
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



    private Volunteer volunteer;
    public void receiveVolunteerIdFromDashboardController(int id){
        this.volunteerID=id;
        this.volunteer=getVolunteerInfo(volunteerID);
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


    public boolean isRequestAlreadyExist(int id,String title ){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File f=new File("CampaignRequestInfo.bin");
            if (f.exists()){
                fis=new FileInputStream(f);
                ois=new ObjectInputStream(fis);
            }
            else {
                //
            }
            while (true){
                VolunteerCampaignRequest request=(VolunteerCampaignRequest) ois.readObject();
                if (request.getVolunteerId()==id && request.getCampaignTitle().equals(title)&&
                request.getStatus().equals("pending")){
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
    public void submitRequestButton(ActionEvent actionEvent) {
        String campaignTitle=selectACampaignToJoin.getValue();

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


        if (isRequestAlreadyExist(volunteerID,campaignTitle)){
            alert.setContentText("You have already requested to join this campaign.");
            alert.showAndWait();
            return;
        }

        VolunteerCampaignRequest request=new VolunteerCampaignRequest(
                volunteerID,
                volunteer.getFullName(),
                selectACampaignToJoin.getValue(),
                requestMessageTextArea.getText(),
                "pending",
                LocalDate.now()
        );
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            File file = new File("CampaignRequestInfo.bin");
            if (file.exists()){
                fos=new FileOutputStream(file,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(request);
            oos.close();
            requestMessageTextArea.clear();
            selectACampaignToJoin.setValue(null);
        }
        catch (Exception e){
            //
        }





    }
}