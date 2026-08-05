package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import prianka_2412456.Asset;

public class ReturnAssetController {

    @javafx.fxml.FXML
    private TableColumn serialTFF;
    @javafx.fxml.FXML
    private Label outputLocationSummary;
    @javafx.fxml.FXML
    private TableColumn catagoryTF;
    @javafx.fxml.FXML
    private TableColumn assetNAmeTF;
    @javafx.fxml.FXML
    private TableColumn assignTF;
    @javafx.fxml.FXML
    private TableView<Asset> tablecolLocation;
    @javafx.fxml.FXML
    private TableColumn<Asset, Integer> assetIDTF;
    @javafx.fxml.FXML
    private TableColumn<Asset, Boolean> statusTF;

    @Deprecated
    public void confirmReturnOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFilterLocationOA(ActionEvent actionEvent) {
    }
}
