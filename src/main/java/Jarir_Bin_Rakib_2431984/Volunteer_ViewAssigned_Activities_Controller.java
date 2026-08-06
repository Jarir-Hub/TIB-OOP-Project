package Jarir_Bin_Rakib_2431984;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Volunteer_ViewAssigned_Activities_Controller
{
    @javafx.fxml.FXML
    private TableColumn<AssignedActivities,String> locationColumn;
    @javafx.fxml.FXML
    private TableColumn<AssignedActivities,String> statusColumn;
    @javafx.fxml.FXML
    private TableView<AssignedActivities> activityTableView;
    @javafx.fxml.FXML
    private TableColumn<AssignedActivities,LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<AssignedActivities,String> campaignColumn;
    @javafx.fxml.FXML
    private TableColumn<AssignedActivities,String> activityColumn;

//String campaignTitle, String activity, String location, LocalDate dateOfCampaign, String status

    @javafx.fxml.FXML
    public void initialize() {
        campaignColumn.setCellValueFactory(new PropertyValueFactory<AssignedActivities,String>("campaignTitle"));
        activityColumn.setCellValueFactory(new PropertyValueFactory<AssignedActivities,String>("activity"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<AssignedActivities,String>("location"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<AssignedActivities,LocalDate>("dateOfCampaign"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<AssignedActivities,String>("status"));

    }

    private int volunteerID;
    private AssignedActivities activities;
    public void receiveVolunteerId(int id){
        this.volunteerID=id;
       // this.activities=getActivityInfo(volunteerID);
    }
   // public AssignedActivities getActivityInfo(int volunteerID) {



    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    @javafx.fxml.FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
        activityTableView.getItems().clear();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File("AssignedActivitiesInfo.bin");
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

            }
            else {
                //
            }
            while (true){
                AssignedActivities activities=(AssignedActivities) ois.readObject();
                if (activities.getVolunteerID()==volunteerID){
                    activityTableView.getItems().add(activities);
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
