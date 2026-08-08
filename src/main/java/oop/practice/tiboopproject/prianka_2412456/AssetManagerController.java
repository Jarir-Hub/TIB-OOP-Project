package oop.practice.tiboopproject.prianka_2412456;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.practice.tiboopproject.User;
import prianka_2412456.Asset;
import prianka_2412456.AssetManager;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.io.IOException;
import java.util.ArrayList;

public class AssetManagerController implements UserReceiver {

    @FXML
    private AnchorPane mainpaneAssetManager;
    @FXML
    private TableView<Asset> tablecolAM;
    @FXML
    private TableColumn<Asset, String> nameCol;
    @FXML
    private TableColumn<Asset, String> serialCol;
    @FXML
    private TableColumn<Asset, Double> costCol;
    @FXML
    private TableColumn<Asset, String> catagoryCol;
    @FXML
    private TableColumn<Asset, String> dateCol;
    @FXML
    private TableColumn<Asset, String> statusCol;

    @FXML
    private TextField searchTF;
    @FXML
    private TextField locationSearchTF;
    @FXML
    private ComboBox<String> statusCBAssetmanager;

    private User loggedInUser;
    private final AssetManager assetManager = new AssetManager(0, "", "Asset Manager", "System");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        serialCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("purchaseCost"));
        catagoryCol.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusCBAssetmanager.getItems().addAll(
                Asset.STATUS_AVAILABLE, Asset.STATUS_ASSIGNED, Asset.STATUS_UNDER_REPAIR);

        loadAllAssets();
    }

    private void loadAllAssets() {
        ArrayList<Asset> allAssets = assetManager.viewAllAsset();
        tablecolAM.setItems(FXCollections.observableArrayList(allAssets));
    }

    @FXML
    public void logoutOA(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.fullSceneReplacement(actionEvent, "/com/example/demo_tib/loginView.fxml");
    }

    @FXML
    public void addnewassetOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/demo_tib/newasset.fxml", loggedInUser);
    }

    @FXML
    public void filterbyAssetnameOA(ActionEvent actionEvent) {
        String keyword = searchTF.getText();
        ArrayList<Asset> matches = assetManager.searchAsset(keyword);
        tablecolAM.setItems(FXCollections.observableArrayList(matches));
    }

    @FXML
    public void filterbyLocationOA(ActionEvent actionEvent) {
        String location = locationSearchTF.getText();
        if (location == null || location.isBlank()) {
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_tib/viewAssetByLocation.fxml"));
            Parent root = loader.load();

            AssetbyLocationController controller = loader.getController();
            controller.setLoggedInUser(loggedInUser);
            controller.loadAssetsForLocation(location);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deployOA(ActionEvent actionEvent) {
        Asset selected = tablecolAM.getSelectionModel().getSelectedItem();
        if (selected == null || !Asset.STATUS_AVAILABLE.equalsIgnoreCase(selected.getStatus())) {
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_tib/newAssetDeploy.fxml"));
            Parent root = loader.load();

            NewAssetDeployController controller = loader.getController();
            controller.setLoggedInUser(loggedInUser);
            controller.setAssetToDeploy(selected);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void returnOA(ActionEvent actionEvent) {
        Asset selected = tablecolAM.getSelectionModel().getSelectedItem();
        if (selected == null || !Asset.STATUS_ASSIGNED.equalsIgnoreCase(selected.getStatus())) {
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_tib/returnAsset.fxml"));
            Parent root = loader.load();

            ReturnAssetController controller = loader.getController();
            controller.setLoggedInUser(loggedInUser);
            controller.setAssetToReturn(selected);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void damageOA(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_tib/damageLog.fxml"));
            Parent root = loader.load();

            DamageLogController controller = loader.getController();
            controller.setLoggedInUser(loggedInUser);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toggleOA(ActionEvent actionEvent) {
        Asset selected = tablecolAM.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        String current = selected.getStatus();
        String next;
        if (Asset.STATUS_AVAILABLE.equalsIgnoreCase(current)) {
            next = Asset.STATUS_UNDER_REPAIR;
        } else if (Asset.STATUS_UNDER_REPAIR.equalsIgnoreCase(current)) {
            next = Asset.STATUS_AVAILABLE;
        } else {
            return; // Assigned assets must go through Return first
        }
        applyStatus(selected, next);
    }

    @FXML
    public void statusConfirm(ActionEvent actionEvent) {
        Asset selected = tablecolAM.getSelectionModel().getSelectedItem();
        String newStatus = statusCBAssetmanager.getValue();
        if (selected == null || newStatus == null) {
            return;
        }
        applyStatus(selected, newStatus);
    }

    private void applyStatus(Asset selected, String newStatus) {
        ArrayList<Asset> allAssets = assetManager.viewAllAsset();
        for (Asset asset : allAssets) {
            if (asset.getAssetID().equals(selected.getAssetID())) {
                asset.setStatus(newStatus);
                break;
            }
        }
        utility.BinaryFileUtility.overwriteObjects("asset.bin", new ArrayList<Object>(allAssets));
        loadAllAssets();
    }
}