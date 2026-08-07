package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class Volunteer_Campaign_Feedback_Controller
{
    @javafx.fxml.FXML
    private TableColumn<Attendance,String> campaignTitleColumn;
    @javafx.fxml.FXML
    private TextArea feedbackTextArea;
    @javafx.fxml.FXML
    private TableColumn<Attendance,LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableView<Attendance> completedCampaignTableView;

    private int volunteerID;
    @javafx.fxml.FXML
    private ComboBox<String> selectCampaignComboBox;
    @javafx.fxml.FXML
    private TableColumn locationColumn;

    public void receiveVolunteerIdFromDashboardController(int id){
        this.volunteerID=id;
    }

    public int getTotalAttendance(String title){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        int count=0;
        try {
            File file=new File("AttendanceInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);

            }
            else{
                //
            }
            while (true){
                Attendance attendance=(Attendance) ois.readObject();
                if (attendance.getCampaignTitle().equals(title)

                        &&attendance.getAttendanceStatus().equals("Marked")){
                    count++;
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
        return count;
    }
    @javafx.fxml.FXML
    public void initialize() {

        //int volunteerID, String campaignTitle, LocalDate campaignDate, String location
        campaignTitleColumn.setCellValueFactory(new PropertyValueFactory<Attendance,String>("campaignTitle"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Attendance,LocalDate>("campaignDate"));
        //totalAttendanceColumn.setCellValueFactory(new PropertyValueFactory<Attendance,Integer>("total_Attendance"));

        FileInputStream fis=null;
        ObjectInputStream ois=null;


        try {
            File file=new File("AttendanceInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);

            }
            else{
                //
            }
            while (true){
                Attendance attendance=(Attendance) ois.readObject();
                if (attendance.getVolunteerID()==volunteerID
                        &&attendance.getAttendanceStatus().equals("Marked")
                        &&attendance.getCampaignDate().isBefore(LocalDate.now())){
                    selectCampaignComboBox.getItems().add(attendance.getCampaignTitle());
                }
            }
        }
        catch (Exception e){
            //
        }



        try {
            File file=new File("AttendanceInfo.bin");
            if (file.exists()){
                fis=new FileInputStream(file);
                ois=new ObjectInputStream(fis);

            }
            else{
                //
            }
            while (true){
                Attendance attendance=(Attendance) ois.readObject();
                if (attendance.getCampaignTitle().equals(campaignTitle)
                        &&attendance.getVolunteerID()==volunteerID
                        &&attendance.getAttendanceStatus().equals("Marked")
                        &&attendance.getCampaignDate().isBefore(LocalDate.now())){
                    //attendance.setTotal_Attendance(getTotalAttendance(campaignTitle));
                    completedCampaignTableView.getItems().add(attendance);
                }
            }
        }
        catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
    }

    String campaignTitle=selectCampaignComboBox.getValue();
    @javafx.fxml.FXML
    public void submitFeedbackButton(ActionEvent actionEvent) {

    }
}