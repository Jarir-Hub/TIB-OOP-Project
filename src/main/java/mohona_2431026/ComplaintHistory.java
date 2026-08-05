package mohona_2431026;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.*;

public class ComplaintHistory
{
    @javafx.fxml.FXML
    private TableView historyTable;
    @javafx.fxml.FXML
    private TableColumn titleColumn;
    @javafx.fxml.FXML
    private Label statusComboBox;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TextArea detailsTextArea;
    @javafx.fxml.FXML
    private ComboBox searchcombobox;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TableColumn categoryColumn;
    @javafx.fxml.FXML
    private TableColumn complaintIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
    }
}