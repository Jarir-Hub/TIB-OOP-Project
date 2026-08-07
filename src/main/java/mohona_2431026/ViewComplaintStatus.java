package mohona_2431026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ViewComplaintStatus
{
    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn statusColumn;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private TableView complaintTable;
    @FXML
    private TableColumn dateColumn;
    @FXML
    private TableColumn complaintIdColumn;

    @FXML
    public void initialize() {

        complaintIdColumn.setCellValueFactory(new PropertyValueFactory<>("ComplaintID").);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("complaint title"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("submissiondate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("current status"));

        loadcomplaints():

        complaintTable.getSelectionModel().selectedItemProperty().addListener(("(observable, oldValue, selectedComplaint) -> {
        boolean selectedcomplaint;


          if  complaintstatusclass selectedComplaint = null;{
            detailsTextArea.setText(
                    "Complaint ID : " + selectedComplaint.getComplaintId()
                            + "\n\nTitle : " + selectedComplaint.getTitle()
                            + "\n\nDescription : " + selectedComplaint.getDescription()
                            + "\n\nLocation : " + selectedComplaint.getLocation()
                            + "\n\nCitizen Name : " + selectedComplaint.getCitizenName()
                            + "\n\nSubmission Date : " + selectedComplaint.getSubmissionDate()
                            + "\n\nStatus : " + selectedComplaint.getStatus()


            )
        }
                ));
    }

    private void loadcomplaints() {

        complaintList.clear();
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Complaint.bin"));

            while (true) {

                Complaint complaint = (Complaint) ois.readObject();
                complaintList.add(complaint);

            }

        } catch (EOFException e) {

        } catch (Exception e) {

            e.printStackTrace();

        }

        complaintTable.setItems(complaintList);

    }
    }

    @FXML
    public void refreshButton(ActionEvent actionEvent) {

        loadComplaints();

    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
    }
}