package mohona_2431026;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class ViewComplaintStatus {

    @FXML
    private TableView<complaintstatusclass> complaintTable;

    @FXML
    private TableColumn<complaintstatusclass, Integer> complaintIdColumn;

    @FXML
    private TableColumn<complaintstatusclass, String> titleColumn;

    @FXML
    private TableColumn<complaintstatusclass, LocalDate> dateColumn;

    @FXML
    private TableColumn<complaintstatusclass, String> statusColumn;

    @FXML
    private TextArea detailsTextArea;

    ObservableList<complaintstatusclass> complaintList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        complaintIdColumn.setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        complaintIdColumn.setCellValueFactory(new PropertyValueFactory<>("ComplaintID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("complaint title"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("submissiondate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("current status"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("submissionDate"));

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        loadComplaints();

        complaintTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, selectedComplaint) -> {

                    if (selectedComplaint != null) {

                        detailsTextArea.setText(

                                "Complaint ID : "
                                        + selectedComplaint.getComplaintId()

                                        + "\n\nTitle : "
                                        + selectedComplaint.getTitle()

                                        + "\n\nDescription : "
                                        + selectedComplaint.getDescription()

                                        + "\n\nLocation : "
                                        + selectedComplaint.getLocation()

                                        + "\n\nCitizen Name : "
                                        + selectedComplaint.getCitizenName()

                                        + "\n\nSubmission Date : "
                                        + selectedComplaint.getSubmissionDate()

                                        + "\n\nStatus : "
                                        + selectedComplaint.getStatus()

                        );

                    }

                });

    }

    private void loadComplaints() {

        complaintList.clear();

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("Complaint.bin"));

            while (true) {

                complaintstatusclass complaint =
                        (complaintstatusclass) ois.readObject();

                complaintList.add(complaint);

            }

        } catch (EOFException e) {

        } catch (Exception e) {

            e.printStackTrace();

        }

        complaintTable.setItems(complaintList);

    }

    @FXML
    public void refreshButton(ActionEvent actionEvent) {

        loadComplaints();

    }

    @FXML
    public void backButton(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ComplaintOfficerDashboard.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}