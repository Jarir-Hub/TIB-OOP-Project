package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.practice.tiboopproject.User;
import prianka_2412456.Asset;
import prianka_2412456.AssetManager;
import prianka_2412456.LocationSummary;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.util.ArrayList;

public class AssetbyLocationController implements UserReceiver {

    @FXML
    private TableColumn<Asset, String> serialTFF;
    @FXML
    private Label outputLocationSummary;
    @FXML
    private TableColumn<Asset, String> catagoryTF;
    @FXML
    private TableColumn<Asset, String> assetNAmeTF;
    @FXML
    private TableColumn<Asset, String> assignTF;
    @FXML
    private TableView<Asset> tablecolLocation;
    @FXML
    private TableColumn<Asset, String> assetIDTF;
    @FXML
    private TableColumn<Asset, String> statusTF;

    private User loggedInUser;
    private final AssetManager assetManager = new AssetManager(0, "", "Asset Manager", "System");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @FXML
    public void initialize() {
        assetIDTF.setCellValueFactory(new PropertyValueFactory<>("assetID"));
        assetNAmeTF.setCellValueFactory(new PropertyValueFactory<>("name"));
        serialTFF.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        catagoryTF.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        assignTF.setCellValueFactory(new PropertyValueFactory<>("assignTo"));
        statusTF.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadAllAssets();
    }

    /**
     * Called by the previous screen right after loading this FXML,
     * to filter and display assets at a specific location.
     */
    public void loadAssetsForLocation(String location) {
        ArrayList<Asset> assetsAtLocation = assetManager.viewAssetByLocation(location);
        tablecolLocation.setItems(FXCollections.observableArrayList(assetsAtLocation));

        LocationSummary summary = new LocationSummary(location, 0, 0, 0, 0, 0);
        String summaryText = summary.generateSummary(assetManager.viewAllAsset());
        outputLocationSummary.setText(summaryText);
    }

    private void loadAllAssets() {
        ArrayList<Asset> allAssets = assetManager.viewAllAsset();
        tablecolLocation.setItems(FXCollections.observableArrayList(allAssets));
    }

    @FXML
    public void clearFilterLocationOA(ActionEvent actionEvent) {
        loadAllAssets();
        outputLocationSummary.setText("");
    }
}