package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import prianka_2412456.Asset;

public class DamageLogController
{
    @javafx.fxml.FXML
    private TextField damageIDTF;
    @javafx.fxml.FXML
    private TextField damageDescriptionOA;
    @javafx.fxml.FXML
    private DatePicker reportdate;
    @javafx.fxml.FXML
    private TextField assetIDdamageTF;
    @javafx.fxml.FXML
    private AnchorPane mainpaneDAMAGE;
    @javafx.fxml.FXML
    private ComboBox<String> repairCB;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void confirmdamageOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backdamageOA(ActionEvent actionEvent) {
    }
}