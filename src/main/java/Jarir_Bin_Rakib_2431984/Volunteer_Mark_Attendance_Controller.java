package Jarir_Bin_Rakib_2431984;

import com.sun.jdi.connect.AttachingConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.Locale;

public class Volunteer_Mark_Attendance_Controller
{
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> locationColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign,String> campaignTitleColumn;
    @javafx.fxml.FXML
    private TableView<Campaign> joinedCampaignTableView;
    @javafx.fxml.FXML
    private TableColumn<Campaign, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> selectYourCampaignCombobox;

    private int volunteerID;
    public void receiveVolunteerID(int id){
        this.volunteerID=id;
    }

    public Campaign getCampaign(String title){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File f=new File("CampaignInfo.bin");
            if (f.exists()){
                fis=new FileInputStream(f);
                ois=new ObjectInputStream(fis);
            }
            else {
                //
            }
            while (true){
                Campaign campaign=(Campaign) ois.readObject();
                if (campaign.getCampaignTitle().equals(title)){
                    return campaign;
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
        return null;
    }

    Alert alert=new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    public void initialize() {
        //String campaignTitle, LocalDate campaignDate, String location, String attendanceStatus
        campaignTitleColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("campaignTitle"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Campaign,LocalDate>("campaignDate"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("location"));
        //attendanceStatusColumn.setCellValueFactory(new PropertyValueFactory<Attendance,String>("attendanceStatus"));

        joinedCampaignTableView.getItems().clear();
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
                if (request.getVolunteerId()==volunteerID && request.getStatus().equals("Approved") ){
                    Campaign campaignObj=getCampaign(request.getCampaignTitle());
                    joinedCampaignTableView.getItems().add(campaignObj);
                    selectYourCampaignCombobox.getItems().add(request.getCampaignTitle());
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

    public boolean isAlreadyMarked(int id,String title){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            File f=new File("AttendanceInfo.bin");
            if (f.exists()){
                fis=new FileInputStream(f);
                ois=new ObjectInputStream(fis);
            }
            else {
                //
            }
            while (true){
                Attendance attendance=(Attendance) ois.readObject();
                if (attendance.getVolunteerID()==id && attendance.getCampaignTitle().equals(title)){
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



//int volunteerID, String campaignTitle, LocalDate campaignDate, String location, String attendanceStatus


    @javafx.fxml.FXML
    public void markAttendanceButton(ActionEvent actionEvent) {
        String campaignTitle=selectYourCampaignCombobox.getValue();
        if (isAlreadyMarked(volunteerID,campaignTitle)){
            alert.setContentText("Already marked");
            alert.showAndWait();
            return;
        }
        Campaign campaign=getCampaign(campaignTitle);
        Attendance attendance=new Attendance(
                volunteerID,
                campaign.getCampaignTitle(),
                campaign.getCampaignDate(),
                campaign.getLocation(),
                "Marked"

        );

        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            File f=new File("AttendanceInfo.bin");
            if (f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(attendance);
            oos.close();
            selectYourCampaignCombobox.setValue(null);



        }
        catch (Exception e){
            //
        }


    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {

    }
}