package oop.practice.tiboopproject.prianka_2412456;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import oop.practice.tiboopproject.User;
import prianka_2412456.Asset;
import prianka_2412456.AssetManager;
import utility.SceneSwitchingHelper;
import utility.UserReceiver;

import java.io.IOException;

public class NewAssetController implements UserReceiver {
    @javafx.fxml.FXML
    private DatePicker purchaseDate;
    @javafx.fxml.FXML
    private TextField serialNameTF;
    @javafx.fxml.FXML
    private TextField AssetNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> catagoryCB;
    @javafx.fxml.FXML
    private TextField costTF;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextField locationnewAsset;
    @javafx.fxml.FXML
    private AnchorPane mainpaneNEWasset;

    private User loggedInUser;   // received from the previous screen
    private final AssetManager assetManager = new AssetManager(0, "", "Asset Manager", "System");

    @Override
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    @javafx.fxml.FXML
    public void initialize() {
        catagoryCB.getItems().addAll("Laptop", "Monitor", "Printer", "Furniture", "Other");
    }

    @javafx.fxml.FXML
    public void registerOA(ActionEvent actionEvent) {
        String name = AssetNameTF.getText();
        String serialNumber = serialNameTF.getText();
        String catagory = catagoryCB.getValue();
        String location = locationnewAsset.getText();

        double cost;
        try {
            cost = Double.parseDouble(costTF.getText());
        } catch (NumberFormatException e) {
            confirmationLabel.setText("Please enter a valid purchase cost.");
            return;
        }

        if (purchaseDate.getValue() == null) {
            confirmationLabel.setText("Please select a purchase date.");
            return;
        }

        Asset newAsset = assetManager.addAsset(name, serialNumber, cost,
                purchaseDate.getValue(), catagory, location);

        if (newAsset == null) {
            confirmationLabel.setText("Could not add asset. Check that all fields are filled and the serial number is unique.");
            return;
        }

        confirmationLabel.setText("Asset added successfully: " + newAsset.getAssetID());
    }

    @javafx.fxml.FXML
    public void backNEWassetOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/demo_tib/assetManager.fxml", loggedInUser);
    }
}